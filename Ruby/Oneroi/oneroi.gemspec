Kernel.load 'lib/oneroi/version.rb'

Gem::Specification.new { |s|
	s.name          = 'oneroi'
	s.version       = Oneroi.version
	s.author        = 'Giovanni Capuano'
	s.email         = 'webmaster@giovannicapuano.net'
	s.homepage      = 'http://www.giovannicapuano.net'
	s.platform      = Gem::Platform::RUBY
	s.summary       = 'A POP3 mail manager.'
	s.description   = 'A simple POP3 mail manager with daemon and client functions.'
	s.require_paths = ['lib']
	s.files         = Dir.glob('lib/**/*.rb')
	s.executables   = 'oneroi'
	s.add_dependency 'mail'
}
