class TestRubrica {
	public static void main(String[] args) {
		// Li metto qui ma si potrebbero mettere in una classe e restituirli
		// tramite metodi statici...
		// Questa situazione comunque non ti capiterà in una situazione reale, in quanto
		// la rubrica sarà riempita dall'utente
		String[] nomi = {"Giovanni","Marco","Vincenzo","Rootkit"};
		String[] cognome = {"Capuano","Sirianni","Guarino","Neo"};
		String[] telefono = {"00000000","11111111","22222222","33333333"};
	
		Rubrica rubrica = new Rubrica();
	
		String nome = "";
		if(args.length == 1) {
			nome = args[0];
		} else {
			System.out.println("Usage: java TestRubrica <name>");
			System.exit(1);
		}
	
		for(int i=0; i<nomi.length; i++) {
			rubrica.inserisciPersona(nomi[i],cognome[i],telefono[i]);
		}
	
		System.out.println("Nome trovato per '"+nome+"':\n\n"+rubrica.getInfo(nome));
	}
}
