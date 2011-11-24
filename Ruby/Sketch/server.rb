require 'socket'

class Server
	attr_accessor :host, :port, :socket
	
	def initialize(host=nil, port=nil)
		@host = host||'localhost'
		@port = port||2004
		@socket = TCPServer.new(@host, @port)
	end
	
	def start(socket, log=false)
		loop {
			Thread.start(socket.accept) { |s|
				puts("#{s.peeraddr[2]}:#{s.peeraddr[1]} enter.")
				s.puts("#{s.peeraddr[2]}:#{s.peeraddr[1]} > Hi")
				puts("#{s.peeraddr[2]}:#{s.peeraddr[1]} leave.")
				if log
					puts('-----------------------------')
					while line = s.gets
						puts line
					end
					puts('-----------------------------')
				end
				s.close
			}
		}
	end
end

server = Server.new
server.start(server.socket)
