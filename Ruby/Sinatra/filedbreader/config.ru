require 'public/blorb'

set :environment, ENV['RACK_ENV'].to_sym
disable :run

log = File.new('logs/sinatra.log', ?a)
STDOUT.reopen(log)
STDERR.reopen(log)

run Sinatra::Application
