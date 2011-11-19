require 'sinatra'
require 'mysql'

class Index
	HOST = 'localhost'
	USER = 'root'
	PASSWD = '******'
	DBNAME = 'webstorage'
	
	get '/' do
		if params.length == 0
			@title = 'Select your way'
			@msg = 'Select your way. <a href="?mode=get">Get</a> | <a href="?mode=post">Post</a>'
			haml :get
		elsif params[:mode] == 'get'
			if params[:p].nil?
				@title = 'No input'
				@msg = 'No input.'
			elsif File.exist?("db/#{params[:p]}")
				@title = params[:p]
				@text = File.read("db/#{params[:p]}")
			elsif
				@title = '404'
				@msg = 'File not found.'
			end
			haml :get
		elsif params[:mode] == 'post'
			@title = 'Welcome'
			@msg = 'Welcome. Select a file giving it by get.'
			haml :post
		end
	end
	
	post '/index.post' do
		if params[:p].nil?
			@title = 'No input'
			@msg = 'No input.'
		elsif File.exist?("db/#{params[:p]}")
			@title = params[:p]
			@text = File.read("db/#{params[:p]}")
		else
			@title = '404'
			@msg = 'File not found.'
		end
		haml :post
	end
	
	get '/webstorage/:user' do
		@title = params[:user]
		begin
			con = Mysql.new(HOST, USER, PASSWD, DBNAME)
			res = con.query("SELECT * FROM ws_utenti WHERE nickname='#{params[:user]}'")
			if res.num_rows > 0
				@msg = '<table><tr><td><b>Id</b></td><td><b>Nickname</b></td><td><b>Email</b></td></tr>'
				res.each_hash do |row|
					@msg += "<tr><td>#{row['id']}</td><td>#{row['nickname']}</td><td>#{row['email']}</td></tr>"
				end
				@msg += '</table>'
			else
				@msg = 'Nothing.'
			end
		rescue MysqlError => e
			@msg = 'MySQL Error: '+e
		ensure
			if con
				con.close
			end
			
			if res
				res.free
			end
		end
		haml :get
	end
	
	not_found do
		status 404
		@title = '404'
		@msg = 'Error 404: Not found'
		haml :get
	end
end
Index.new
