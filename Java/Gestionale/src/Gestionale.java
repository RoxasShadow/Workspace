import java.util.Scanner;
class Gestionale {
	public static void main(String[] args) {
		Cellulare cellulare;
		Magazzino magazzino;
		int codiceimei, scelta;
		String marca, modello;
		double prezzo;
		Scanner scanner = new Scanner(System.in);
		magazzino = new Magazzino();
		
		do {
			System.out.println("Digita 1 per inserire un cellulare");
			System.out.println("Digita 2 per vendere un cellulare");
			System.out.println("Digita 3 per modificare il prezzo di un cellulare");
			System.out.println("Digita 4 per calcolare il prezzo medio dei cellulari");
			System.out.println("Digita 5 per visualizzare i cellulari");
			System.out.println("Digita 6 per uscire dal programma");
			scelta = scanner.nextInt();
		
			switch(scelta) {
				case 1:
					System.out.println("\nCodice IMEI:");
					codiceimei = scanner.nextInt();
					System.out.println("Marca:");
					marca = scanner.next();
					System.out.println("Modello:");
					modello = scanner.next();
					System.out.println("Prezzo:");
					prezzo = scanner.nextDouble();

					cellulare = new Cellulare(codiceimei, marca, modello, prezzo);
					magazzino.inserisciCellulare(cellulare);
					System.out.println("\nIl cellulare e' stato inserito con successo.");
					break;
				case 2:
					System.out.println("\nCodice IMEI:");
					codiceimei = scanner.nextInt();
					magazzino.vendiCellulare(codiceimei);
					System.out.println("Il cellulare e' stato venduto.\n");
					break;			
				case 3:
					System.out.println("\nCodice IMEI:");
					codiceimei = scanner.nextInt();
					System.out.println("Nuovo prezzo:");
					prezzo = scanner.nextDouble();
					System.out.println("\n");
					magazzino.modificaPrezzoCellulare(codiceimei, prezzo);
					break;
				case 4:
					System.out.println("\nLa media aritmetica dei prezzi dei cellulari è "+magazzino.calcolaPrezzoMedio()+".");
					break;
				case 5:
					System.out.println(magazzino.stampaCellulari());
					break;
				case 6:
					System.out.println("\nA presto :)");
					System.exit(0);
				default:
					System.out.println("Digita un numero da 1 a 5 relativo all'azione che vuoi svolgere.\n");
			}
		} while(scelta != 6); // Da quanto non lo usavo :3
	}
}
