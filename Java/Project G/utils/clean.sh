#!/bin/sh
###
#	clean.sh
###	(C) Giovanni Capuano 2011
echo "Cleaning..."
cd ../src
rm *.class -f
rm *.jar -f
cd ../bin
rm * -f
echo "Done."
