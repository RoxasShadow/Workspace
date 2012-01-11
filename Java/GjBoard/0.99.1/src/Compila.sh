#!/bin/bash
#####################################
#/Compila.sh
#(C) Giovanni Capuano 2011
#####################################

# Permette di compilare GjBoard includendo le liberie e creando l'archivio jar.
echo "Compilazione in corso...";
javac -classpath sqlite.jar *.java
echo "Creazione jar eseguibile in corso...";
jar cfm GjBoard.jar Manifest.txt *.class
echo "Pulizia in corso...";
rm *.class
echo "Fatto.";
