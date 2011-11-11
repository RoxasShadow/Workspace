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
class ArtificialNiggerIntelligence
	attr_accessor :db
	
	def initialize(db = nil)
		@db = !db ? 'db' : db
		if !File.exist?(@db)
			File.new(@db, 'w')
		end
	end
		
	def parse
		hash = Hash.new
		file = File.open(@db, 'r')
		begin
			while(line = file.gets)
				if split != ''
					split = line.split('|')
					hash[split[0]] = split[1]
				end
			end
			file.close
		rescue => e
			puts 'Error reading the database.'
		end
		hash
	end
	
	def learn(question, answer)
		file = File.open(@db, 'a')
		file.write("#{question}|#{answer}") # Why the fucking concatenation with ,/+/<< doesn't work?
		file.close
	end
	
	def clear
		if File.exist?(@db)
			File.delete(@db)
			File.open(@db, 'w')
		end
	end
end

ai = ArtificialNiggerIntelligence.new
puts 'Type `/q` whenever you want to kill this app and `/c` to clear your database.'
begin
	hash = ai.parse
	print '>'
	question = gets.chomp.downcase
	if question == '/q'
		break
	elsif question == '/c'
		ai.clear
		redo
	end
	if hash.has_key?(question)
		puts hash[question]
	else
		print 'I don\'t know what I have to say. Enlighten me: '
		answer = gets.chomp # I need this var whe I do the condition loop
		ai.learn(question, answer)
		puts 'Ok. Thank you very much bro.'
	end
end while true
