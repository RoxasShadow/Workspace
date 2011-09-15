#!/bin/bash
echo "Compilazione in corso...";
javac *.java
echo "Creazione jar eseguibile in corso...";
jar cfm HowManyRowsAreThere.jar Manifest.txt *.class
echo "Pulizia in corso...";
rm *.class
echo "Fatto.";
