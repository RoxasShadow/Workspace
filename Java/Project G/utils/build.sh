#!/bin/sh
cd ../src
javac ProjectG.java
jar cmf Manifest.txt ProjectG.jar *.class db/
mv ProjectG.jar ../bin/
rm *.class -f
