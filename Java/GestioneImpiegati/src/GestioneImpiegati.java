public class GestioneImpiegati {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Usage: java GestioneImpiegati <Nome Livello Stipendio OreDiStraordinario>");
			System.exit(1);
		}
		Impiegato impiegato = new Impiegato(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		ImpiegatoConStraordinariPagati impiegatoConStraordinariPagati = new ImpiegatoConStraordinariPagati(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		
		System.out.println("");
		System.out.println("Nome: "+args[0]);
		System.out.println("Livello: "+args[1]);
		System.out.println("Ore di straordinario: "+args[3]);
		System.out.println("");
		System.out.println("Stipendio: "+impiegato.stampaStipendio());
		System.out.println("Stipendio totale: "+impiegatoConStraordinariPagati.stampaStipendio());
	}
}
