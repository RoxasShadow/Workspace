/**
Questa classe gestisce Potenza e Tipo e viene istanziata dal main.
Prima di tutto vengono dichiarati due oggetti Tipo e Potenza.
Il costruttore si occupa di assegnare le IVs in entrata alle variabili d'istanza.
Si hanno a disposizione poi 3 metodi: i primi due si occupano di istanziare gli oggetti
dichiarati prima passando loro le IVs, e la terza stampa il risultato del calcolo dell'Introforza.
*/

class Introforza {
	private Tipo type;
	private Potenza power;
	private int ps, atk, dif, atksp, difsp, vel;
  
	Introforza(int ps, int atk, int dif, int atksp, int difsp, int vel) {
		this.ps = ps;
		this.atk = atk;
		this.dif = dif;
		this.atksp = atksp;
		this.difsp = difsp;
		this.vel = vel;
	}
  
	// Chiamati solamente all'avvio del programma
	public void inserisciPotenza() {
		power = new Potenza(ps, atk, dif, atksp, difsp, vel);
	}
  
	public void inserisciTipo() {
		type = new Tipo(ps, atk, dif, atksp, difsp, vel);
	}

	public void getIntroforza() {
		System.out.println("IVs: "+ps+" "+atk+" "+dif+" "+atksp+" "+difsp+" "+vel+"\nPotenza: "+power.getPotenza()+"\nTipo: "+type.getTipo());
	}
}
