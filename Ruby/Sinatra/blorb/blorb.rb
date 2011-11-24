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

######### CONFIGURATION START
MAX	=	4			# Number of news for each page
DB	=	'public/news.xml'	# Name of the XML database
INDEX	=	'blog/' 		# Relative path of the index page 
TITLE	=	'BloRB' 		# Name of the blog
COOKIE	=	:last 			# Name of the cookie (don't touch the colon `:`)
TPL	=	:ajax			# Name of the template (don't touch the colon `:`)
URL	=	'http://localhost/sinatra/public/blog/'	# URL at the index page 
######### CONFIGURATION END

require 'sinatra'
require 'nokogiri'
require 'json'
set :sessions, true

class News
	attr_accessor :date, :title, :content
	def initialize(date, title, content)
		@date = date
		@title = title
		@content = content
	end
	def News.parse(xml, n=nil, id=nil)
		news = []
		Nokogiri::XML(xml).xpath('repository/news').each_with_index { |e, i|
			return news if n != nil && n == i
			object = News.new(e.xpath('date').inner_text, e.xpath('title').inner_text, e.xpath('content').inner_text)
			return object if id != nil && id == i
			news << object
		}
		news
	end
end

class NewsNotFound < Exception
end
helpers do
	def redirect_home
		redirect to INDEX, 301
	end
	def rm_last_char(str, char)
		str[0..-char.length-1]
	end
	def get_db
		File.read DB
	end
	def get_news(source, id)
		source[id]
	end
	def get_news_as_stream(source, by, to)
		news = []
		(by..to).each { |i|
			news << source[i]
		}
		news
	end
	def count_news(source)
		count = 0
		source.each {
			count += 1
		}
		count
	end
	def get_nav(n, max)
		(1..(n/(max)).ceil).to_a
	end
	def is_numeric?(i)
		i.to_i.to_s == i || i.to_f.to_s == i
	end
end

before do
	@blogname = TITLE
	@url = URL
end

get '/blog/?' do
	@start = Time.now
	@title = 'Home'
	current = params[:p] != nil && params[:p].to_i > 0 ? params[:p].to_i : 1
	min = ((current - 1) * MAX) + (current - 1)
	max = min + MAX
	repository = get_news_as_stream(News.parse(get_db), min, max)
	if repository == nil || !repository.kind_of?(Array) || repository.length == 0
		raise NewsNotFound, 'Nothing to show.'
	else
		@news = []
		repository.each_with_index { |article, i|
			next if article.class != News
			news = {}
			news[:id] = (i + min).to_s
			news[:title] = article.title
			news[:date] = article.date
			news[:content] = article.content
			@news << news
		}
		raise NewsNotFound, 'Nothing to show.' if @news.length == 0
	end
	@nav = get_nav(count_news(News.parse(get_db)), MAX)
	@page = params[:p].to_i
	haml TPL
end

#DEPRECATED
#get '/blog' do
#	redirect_home
#end

get '/blog/lastnews' do
	@start = Time.now
	@title = 'Last news'
	@last = session[COOKIE]||-1
	haml TPL
end

get '/blog/clear' do
	session[COOKIE] = nil
	redirect_home
end

get '/blog/:id' do
	@start = Time.now
	if !is_numeric? params[:id]
		raise NewsNotFound, 'Nothing to show.'
	end
	news = get_news(News.parse(get_db), params[:id].to_i)
	if news == nil
		raise NewsNotFound, 'Nothing to show.'
	else
		@news = {}
		@news[:id] = params[:id]
		@news[:title] = news.title
		@news[:date] = news.date
		@news[:content] = news.content
		@title = "News \##{params[:id]}"
	end
	session[COOKIE] = params[:id]
	haml TPL
end

error NewsNotFound do
	@start = Time.now
	@title = 'Error'
	@error = env['sinatra.error'].message
	haml TPL
end

not_found do
	@start = Time.now
	@title = '404'
	@error = 'Error 404: Not found'
	status 404
	haml TPL
end

### AJAX API ###
get '/blog/ajax/lastnews' do
	content_type :json
	{:title => 'Last news', :last => session[COOKIE]||-1}.to_json
end

get '/blog/ajax/:id' do
	content_type :json
	if !is_numeric? params[:id]
		{:error => 'Nothing to show.'}.to_json
	end
	news = get_news(News.parse(get_db), params[:id].to_i)
	if news == nil
		{:error => 'Nothing to show.'}.to_json
	else
		article = {}
		article[:id] = params[:id]
		article[:title] = news.title
		article[:date] = news.date
		article[:content] = news.content
		title = "News \##{params[:id]}"
		session[COOKIE] = params[:id]
		{:news => article, :title => title}.to_json
	end
end
