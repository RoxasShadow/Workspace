##########################################################################
#    Giovanni Capuano <webmaster@giovannicapuano.net>
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
##########################################################################
require 'net/pop'
require 'mail'
include ObjectSpace

class Oneroi
	attr_accessor :server, :username, :password, :inbox
	
	def initialize(server=nil, username=nil, password=nil, inbox=nil)
		@server = server
		@username = username
		@password = password
		@inbox = inbox||'inbox/'
		
		if server != nil && username != nil && password != nil
			@pop = Net::POP3.new(@server)
			@pop.start(@username, @password)
			ObjectSpace.define_finalizer(self, self.class.method(:finalize).to_proc)
		end
	end
	
	def started?
		@pop.started?
	end
		alias :active? :started?
	
	def Oneroi.finalize
		@pop.finish
	end
	
	def reset
		delete_local
		Dir.delete @inbox
	end
		alias :clear :reset
	
	def fetch(delete=false)
		Dir.mkdir(@inbox) unless File.directory? @inbox
		i = 0
		@pop.each_mail { |m|
			File.open("#{@inbox}#{i}", 'w') { |f|
				f.write m.pop
			}
			m.delete if delete
			i += 1
		}
	end
	
	def count_remote
		@pop.n_mails
	end
	
	def count_local
		i = 0
		Dir["#{@inbox}*"].each { |file|
			i += 1
		}
		i
	end
	
	def is_empty?
		@pop.mails.empty?
	end
	
	def exists_remote?(id)
		i = 0
		@pop.each_mail { |m|
			return true if id == 1
			i += 1
		}
		false
	end
	
	def exists_local?(id)
		File.exists? @inbox+id.to_s 
	end
	
	def delete_remote(id=nil)
		if id == nil
			@pop.delete_all
		else
			i = 0
			@pop.each_mail { |m|
				m.delete if id == i
				i += 1
			}
		end
	end
	
	def delete_local(id=nil)
		if id != nil
			File.delete(@inbox+id.to_s) if exists_local?(id)
		else
			Dir["#{@inbox}*"].each { |file|
				File.delete(file)
			}
		end
	end
	
	def read(id=nil)
		if id != nil
			return File.read(@inbox+id.to_s) if exists_local?(id)
		else
			emails = []
			Dir["#{@inbox}*"].each { |file|
				emails << File.read(file)
			}
			return emails
		end
		nil
	end
	
	def Oneroi.parse(shitmail)
		if shitmail.is_a? Array
			parsed = []
			shitmail.each { |m|
				res = {}
				mail = Mail.new(m)
				res['from'] = mail.from
				res['to'] = mail.to
				res['cc'] = mail.cc
				res['subject'] = mail.subject
				res['date'] = mail.date.to_s
				res['body'] = mail.body.decoded
				parsed << res
			}
			return parsed
		else
			res = {}
			mail = Mail.new(shitmail)
			res['from'] = mail.from
			res['to'] = mail.to
			res['cc'] = mail.cc
			res['subject'] = mail.subject
			res['date'] = mail.date.to_s
			res['body'] = mail.body.decoded
			return res
		end
		nil
	end
	
	def new_mail?
		count_remote > count_local ? true : false
	end
end
