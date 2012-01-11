#!/bin/bash
echo "Compilazione in corso...";
javac -classpath jl1.0.1.jar *.java
echo "Creazione jar eseguibile in corso...";
jar cfm Mantis.jar Manifest.txt *.class
echo "Pulizia in corso...";
rm *.class
echo "Fatto.";
