#!/bin/sh
filename="list.html"
newfilename="newlist.html"
sed -n -r '/<li>\s*<a\s+href="(.+?)"/s/^.*?<li>\s*<a\s+href="(.+?)".*$/\1/p' $filename >> $newfilename
while read line
	do
		wget "${line}";
	done < $newfilename
