import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Mantis {    
	public static void main(String[] args) {
		Scanner scanner;
		File file;
		File iteratorFile;
		String[] files;
		int i;
		int count = 0;
		int fail = 0;
		ArrayList<String> paths;
		String path;
		
		try {
			scanner = new Scanner(System.in);
			System.out.println("Percorso dove si trovano i file e le cartelle contenenti gli MP3 (ex: /home/nomeutente/Musica/): ");
			path = scanner.next();
			System.out.println("Ricerca file nelle sottocartelle (scendo di massimo 1 livello dalla cartella di partenza)...");
		
			file = new File(path);
			files = file.list();
			paths = new ArrayList<String>();
		
			System.out.println("Preparazione file per la riproduzione...");
			for(i=0; i<files.length; i++) {
				iteratorFile = new File(path+files[i]);
				if(iteratorFile.isDirectory()) {
					paths.add(path+files[i]+"/");
				}
				else {
					paths.add(path+files[i]);
				}
	    		}
	    		Collections.shuffle(paths); // Mischio gli elementi dell'arraylist
				
	    		for(String p:paths) { // Per ogni directory
	    			iteratorFile = new File(p);
	    			if(iteratorFile.isDirectory()) {
		    			files = iteratorFile.list(); // Crea la lista dei file contenuti
			    		for(i=0; i<files.length; i++) { // Per ogni file...
		    				if(files[i].endsWith("mp3")) {
							System.out.println("Riproduzione di "+p+files[i]+"..."); // Mostra il nome del file
							count++;
				    			new Player(new FileInputStream(p+files[i])).play(); // Lo avvia
			    			}
			    			else {
			    				fail++;
			    			}
			    		}
		    		}
		    		else {
	    				if(iteratorFile.toString().endsWith("mp3")) {
						System.out.println("Riproduzione di "+p+"..."); // Mostra il nome del file
						count++;
			    			new Player(new FileInputStream(p)).play(); // Lo avvia
			    			System.out.println("Riproduzione finita: Sono stati riprodotti "+count+" file.");
			    		}
			    			else {
			    				fail++;
			    			}
		    		}
	    		}
		    	System.out.println("Riproduzione finita: Sono stati riprodotti "+count+" file e "+fail+" non erano mp3 validi.");
	    	}
	    	catch(Exception e) {
	    		System.out.println("È accaduto un errore.");
	    		e.printStackTrace();
	    	}
	}
}
