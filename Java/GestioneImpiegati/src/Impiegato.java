public class Impiegato {
	private String nome;
	private int livello, stipendio;
	
	public Impiegato(String nome, int livello, int stipendio) {
		this.nome = nome;
		this.livello = livello;
		this.stipendio = stipendio;
	}
	
	public int stampaStipendio() {
		return stipendio;
	}
}
