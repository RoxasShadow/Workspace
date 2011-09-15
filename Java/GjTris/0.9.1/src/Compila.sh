#!/bin/bash
#####################################
#/Compila.sh
#(C) Giovanni Capuano 2011
#####################################

# Permette di compilare GjTris creando l'archivio jar.
echo "Compilazione in corso...";
javac -classpath gjtris_jl1.0.1.jar GjTris.java
echo "Creazione jar eseguibile in corso...";
jar cfm GjTris.jar Manifest.txt *.class resources/
echo "Pulizia in corso...";
rm *.class
echo "Fatto.";
