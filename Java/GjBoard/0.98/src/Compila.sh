#!/bin/bash
echo "Compilazione in corso...";
javac -classpath sqlite.jar *.java
echo "Creazione jar eseguibile in corso...";
jar cfm GjBoard.jar Manifest.txt *.class
echo "Pulizia in corso...";
rm *.class
echo "Fatto.";
