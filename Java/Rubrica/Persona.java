class Persona {
	private String nome,cognome,telefono;
	
	Persona(String nome, String cognome, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}
	
	String getNome() {
		return nome;
	}
	
	// Questi li metto solo per rendere "completa"
	// l'implementazione dei metodi getter e setter
	String getCognome() {
		return cognome;
	}
	String getTelefono() {
		return telefono;
	}

	void setNome(String nome) {
		this.nome = nome;
	}
	void setCognome(String cognome) {
		this.cognome = cognome;
	}
	void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	// lo definisce la classe Object
	// viene chiamato quando si concatena l'oggetto ad una
	// stringa o al flusso di output
	public String toString() { // Override
		return "Nome: "+nome+"\nCognome: "+cognome+"\nTelefono "+telefono;
	}
}
