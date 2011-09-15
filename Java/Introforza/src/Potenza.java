/**
Questa classe si occupa di ricevere le IVs in entrata e ritornare la potenza dell'Introforza.
Il costruttore dopo aver assegnato il giusto valore alle variabili di istanza le elabora e ne registra la potenza.
Se il resto di una IVs divisa per 4 è uguale a 2 o a 3, Px avrà un intero dipendente dalla statistica in questione,
altrimenti Px a sarà dato il valore 0.
Dopo aver fatto ciò, si procede all'esecuzione della formula della potenza dell'Introforza.
Il risultato, poi, viene registrato nella variabile d'istanza "potenza".
Una volta che il costruttore ha fatto il suo lavoro, basterà invocare il metodo getPotenza() per ottenere l'intero
calcolato poc'anzi.
*/

class Potenza {
	private int P1, P2, P3, P4, P5, P6, potenza;
	private int ps, atk, dif, atksp, difsp, vel;

	Potenza(int ps, int atk, int dif, int atksp, int difsp, int vel) {
		this.ps = ps;
		this.atk = atk;
		this.dif = dif;
		this.atksp = atksp;
		this.difsp = difsp;
		this.vel = vel;
		potenza = setPotenza();
	}

	private int setPotenza() {
		if((ps % 4 == 2) || (ps % 4 == 3)) {
			P1 = 1;
		}

		if((atk % 4 == 2) || (atk % 4 == 3)) {
			P2 = 2;
		}

		if((dif % 4 == 2) || (dif % 4 == 3)) {
			P3 = 4;
		}

		if((vel % 4 == 2) || (vel % 4 == 3)) {
			P4 = 8;
		}

		if((atksp % 4 == 2) || (atksp % 4 == 3)) {
			P5 = 16;
		}

		if((difsp % 4 == 2) || (difsp % 4 == 3)) {
			P6 = 32;
		}
		return ((((P1 + P2 + P3 + P4 + P5 + P6) * 40) / 63) + 30);
	}

	public int getPotenza() {
		return potenza;
	}
}
