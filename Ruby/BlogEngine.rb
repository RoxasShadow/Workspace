#!/usr/bin/env ruby
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
class BlogEngine
	attr_accessor :id, :author, :title, :content, :date # creates get_ and set_ methods for each var
	
	def initialize(id, author, title, content, date = nil)
		@date = !date ? Time.now : date
		@id = id
		@author = author
		@title = title
		@content = content
	end
end

first = BlogEngine.new(0, 'Giovanni Capuano', 'Test #1', 'Hi, that\'s a class test #1 in Ruby! :)', Time.now)
second = BlogEngine.new(2, 'Giovanni Capuano', 'Test #2', 'Hi, that\'s a class test #2 in Ruby! :)')
third = BlogEngine.new(3, 'Giovanni Capuano', 'Test #3', 'Hi, that\'s a class test #3 in Ruby! :)', Time.now)
blog = [first, second, third]
print "There #{blog.length} articles.\n\n"
blog.each do |article| # for each article
	print "Id: #{article.id}\nAuthor: #{article.author}\nTitle: #{article.title}\nContent: #{article.content}\nDate: #{article.date}\n\n"
end
