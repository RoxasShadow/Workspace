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
require 'destroyer'

class Oneroi < Destroyer
	attr_accessor :server, :username, :password, :inbox
	
	def initialize(server, username, password, inbox=nil)
		@server = server
		@username = username
		@password = password
		@inbox = inbox||'inbox/'
		
		@pop = Net::POP3.new(@server)
		@pop.start(@username, @password)
	end
	
	def __destroy
		@pop.finish
	end
	
	def fetch(delete=false)
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
		i = 0
		@pop.each_mail { |m|
			i += 1
		}
		i
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
			if id == i
				return true
			end
			i += 1
		}
		false
	end
	
	def exists_local?(id)
		File.exists? @inbox+id.to_s 
	end
	
	def delete_remote(id=nil)
		i = 0
		@pop.each_mail { |m|
			if id == nil
				m.delete
			elsif id == i
				m.delete
			end
			i += 1
		}
	end
	
	def delete_local(id=nil)
		if id != nil
			File.delete(@inbox+id.to_s) if exists_local?(id)
		else
			Dir["#{@inbox}*"].each { |file|
				File.delete(@inbox+file)
			}
		end
	end
	
	def read(id=nil)
		if id != nil
			return File.read(@inbox+id.to_s) if exists_local?(id)
		else
			emails = []
			Dir["#{@inbox}*"].each { |file|
				emails << File.read(@inbox+id.to_s)
			}
			return emails
		end
		nil
	end
end
