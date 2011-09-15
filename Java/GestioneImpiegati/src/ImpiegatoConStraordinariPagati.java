public class ImpiegatoConStraordinariPagati extends Impiegato {
	private int oreStraordinario;
	private static int retribuzioneOraria = 12;
	
	public ImpiegatoConStraordinariPagati(String nome, int livello, int stipendio, int oreStraordinario) {
		super(nome, livello, stipendio); // Invio le variabili al costruttore della superclasse
		this.oreStraordinario = oreStraordinario;
	}
	
	public int stampaStipendio() { // Override
		return super.stampaStipendio() + (oreStraordinario * retribuzioneOraria); // Richiamo un metodo della superclasse
	}
}
