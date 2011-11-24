#That's not mine, so gtfo
module Destroyable
  def call_destructor(id)
    @destructors[id].each do |o|
      o.__destroy(id) if o.respond_to? :__destroy
    end
    @destructors.delete(id)
  end
  
  def is_destroyable
    @destructors = {}
    include InstanceMethods
  end
  
  def set_resources(id, res)
    @destructors[id] = res
  end
  
  module InstanceMethods
    def initialize
      ObjectSpace.define_finalizer(self, self.class.method(:call_destructor).to_proc)
    end

    def declare_resources(res)
      self.class.set_resources(object_id, res)
    end
  end
end

class Destroyer
  extend Destroyable
end
