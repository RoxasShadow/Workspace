# Here's what a type of requests in certain afternoons lead me to write. Obv it's a shit, and it's (almost)? broken.
class String
  def unminify(lang)
    if lang == :css
      gsub(':', ': ').gsub('{', " {\n\t").gsub(/;(?!base64)/, ";#{$1}\n\t").gsub("\t}", '}')
    elsif lang == :html
      gsub('><', ">\n<")
    end
  end
end

puts '#site_title{color:#000;margin:0 auto 1.5% auto;width:100%;background-color:#AFAFAF;display:block;overflow:hidden;}'.unminify(:css)
puts '<!DOCTYPE html><html><head><title>Foo</title></head><body><p>bar</p></body></html>'.unminify(:html)
puts '.test {color:#000;background-image:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFgAAAA4AgMAAAAED9f9AAAACVBMVEUAAABmZmZmZmaO3ZBrAAAAA3RSTlMA5rA5MyM4AAAAJElEQVQ4y2MYOUA1FAEiEMKiSMIheIUxDRkFo9Ew2MFoeBMDAPLUMTllKtkfAAAAAElFTkSuQmCC);}'.unminify(:css)

