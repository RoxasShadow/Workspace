import java.util.ArrayList; 
class Magazzino {
	private ArrayList<Cellulare> Elenco; 
	
	Magazzino() {
		Elenco = new ArrayList<Cellulare>();
	}
	
	public boolean inserisciCellulare(Cellulare cellulare) {
		if(Elenco.size() == 150) { // L'arraylist può contenere massimo 150 cellulari!
			return false;
		}
		else {
			Elenco.add(cellulare); // Aggiunge all'array il cellulare
			return true;
		}
	}
	
	public boolean modificaPrezzoCellulare(int imei, double prezzo) {
		for(Cellulare cellulare:Elenco) {
			if(cellulare.getCodiceImei() == imei) {
				cellulare.setPrezzo(prezzo); // Modifica il prezzo
				return true; // Ritorna un valore, quindi il metodo si interrompe
			}
		}
		return false;
	}
	
	public boolean vendiCellulare(int imei) {
		for(Cellulare cellulare:Elenco) {
			if(cellulare.getCodiceImei() == imei) {
				Elenco.remove(cellulare); // Rimuove l'oggetto
				return true;
			}
		}
		return false;
	}
	
	public double calcolaPrezzoMedio() {
		int cellulari = Elenco.size(); // Numero di valori dell'array
		double prezzi = 0.0;
		for(Cellulare c:Elenco) {
			prezzi += c.getPrezzo(); // Aumenta la variabile del prezzo di ogni valore dell'array
		}
		return prezzi / cellulari;
	}
	
/*		Corretto ma sconsigliato poichè String essendo un oggetto non può essere modificato, pertanto ad ogni
		concatenazione crea un nuovo oggetto String diminuendo le prestazioni.
		public String stampaCellulari() {
		String stringa = "Cellulari presenti in magazzino:\n";
		for(Cellulare c:Elenco) {
			stringa += c; // Utilizza il metodo ridefinito toString()
		}
		return stringa;
	} */
	
		public String stampaCellulari() {
			 StringBuffer stringa = new StringBuffer("\nCellulari presenti in magazzino:\n");
			 for(Cellulare c:Elenco) {
			 	stringa.append(c);
			 	stringa.append("\n");
			 }
			 return stringa.toString(); // Chiama la versione di toString() definita per StringBuffer; in sostanza ritorna un oggetto String
		}
}
