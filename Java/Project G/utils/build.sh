#!/bin/sh
###
#	build.sh
###	(C) Giovanni Capuano 2011
cd ../src
echo "Compiling..."
javac ProjectG.java
echo "Creating the package..."
jar cmf Manifest.txt ProjectG.jar *.class ../README ../TODO ../LICENSE db
echo "Moving the package..."
mv ProjectG.jar ../bin/
echo "Cleaning..."
rm *.class -f
rm *.jar -f
echo "Done."
