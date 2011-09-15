import java.util.ArrayList; // Importo la classe contenente ArrayList
class Rubrica {
	private ArrayList<Persona> elencoPersone; // Istanzio l'oggetto ArrayList contenente oggetti Persona
  
	Rubrica() { // Costruttore
		elencoPersone = new ArrayList<Persona>(); // Creo l'oggetto ArrayList
	}
  
	// Chiamato solamente all'avvio del programma
	void inserisciPersona(String nome, String cognome, String telefono) {
		elencoPersone.add(new Persona(nome,cognome,telefono));
	}
  
	Persona getInfo(String nome) {
		for(Persona p:elencoPersone) { // Ciclo foreach
			// Attento perchè equals() effettua una distizione tra maiuscole
			// e minuscole; Se vuoi far si che la distinzione non ci sia, e quindi
			// 'A' venga considerata come 'a' utilizza
			// equalsIgnoreCase()
			if(p.getNome().equals(nome)) {
		    		return p;
		  	}
		}
		return null;
	}
}
