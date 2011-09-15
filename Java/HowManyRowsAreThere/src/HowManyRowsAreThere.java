/**
    HowManyRowsAreThere è un programma scritto in Java che permette di
    contare il numero singolo e totale di righe che ciascun file con una
    data estensione contiene.
    Inviato il percorso di una cartella, HowManyRowsAreThere cerca, inoltre,
    automaticamente tutti i file contenuti nelle eventuali sottocartelle.
    Copyright (C) 2011  Giovanni 'Roxas Shadow' Capuano

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class HowManyRowsAreThere {    
	public static void main(String[] args) {
		Scanner scanner;
		File file;
		File iteratorFile;
		String[] files;
		int i, righe, totRighe;
		BufferedReader readerBuffer;
		FileReader reader;
		ArrayList<String> paths;
		String path, ext;
		
		try {
			scanner = new Scanner(System.in);
			System.out.println("Percorso dove si trovano i file e le cartelle contenenti i sorgenti (ex: /home/nomeutente/Scrivania/Sorgenti/): ");
			path = scanner.next();
			System.out.println("\nEstensione dei file da includere nel calcolo (senza il punto): ");
			ext = scanner.next();
			
			System.out.println("\nRicerca file nelle sottocartelle (scendo di massimo 1 livello dalla cartella di partenza)...");
		
			file = new File(path);
			files = file.list();
			paths = new ArrayList<String>();
			totRighe = 0;
			righe = 0;
		
			System.out.println("\nPreparazione file per il calcolo...");
			for(i=0; i<files.length; i++) {
				iteratorFile = new File(path+files[i]);
				if(iteratorFile.isDirectory()) {
					paths.add(path+files[i]+"/");
				}
				else {
					paths.add(path+files[i]);
				}
	    		}
				
	    		for(String p:paths) { // Per ogni directory
	    			iteratorFile = new File(p);
	    			if(iteratorFile.isDirectory()) {
		    			files = iteratorFile.list(); // Crea la lista dei file contenuti
			    		for(i=0; i<files.length; i++) { // Per ogni file...
			    			if(files[i].endsWith(ext)) {
				    			reader = new FileReader(p+files[i]);
				    			readerBuffer = new BufferedReader(reader);
				    			while(readerBuffer.readLine() != null) {
				    				righe++;
				    			}
							System.out.println("\n"+p+files[i]+" contiene "+righe+" di codice..."); // Mostra il nome del file
							totRighe += righe;
							righe = 0;
						}
			    		}
		    		}
		    		else {
		    			if(iteratorFile.toString().endsWith(ext)) {
						reader = new FileReader(p);
				    		readerBuffer = new BufferedReader(reader);
				    		while(readerBuffer.readLine() != null) {
				    			righe++;
				    		}
						System.out.println("\n"+p+" contiene "+righe+" di codice..."); // Mostra il nome del file
						totRighe += righe;
						righe = 0;
					}
		    		}
	    		}
	    		if(totRighe == 1) {
		    		System.out.println("\nÈ stata registrata solo 1 riga di codice.");
		    	}
		    	else if(totRighe == 0) {
		    		System.out.println("\nNon è stata registrata nemmeno una riga di codice.");
		    	}
		    	else {
		    		System.out.println("\nSono state registrate ben "+totRighe+" di codice.");
		    	}
	    	}
	    	catch(Exception e) {
	    		System.out.println("\nÈ accaduto un errore.");
	    		e.printStackTrace();
	    	}
	}
}
