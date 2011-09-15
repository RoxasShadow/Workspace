/**
Questa classe si occupa di ricevere le IVs in entrata e ritornare il tipo dell'Introforza.
Il costruttore dopo aver assegnato il giusto valore alle variabili di istanza le elabora e ne registra il tipo.
Se il resto di una IVs divisa per 4 è uguale a 2 o a 3, Px avrà un intero dipendente dalla statistica in questione,
altrimenti Px a sarà dato il valore 0.
Dopo aver fatto ciò, si procede all'esecuzione della formula del tipo dell'Introforza.
Il risultato, poi, viene registrato nella variabile d'istanza "tipo".
Una volta che il costruttore ha fatto il suo lavoro, basterà invocare il metodo getTipo() per ottenere la stringa
calcolata poc'anzi.
*/


class Tipo {
	private String tipo;
	private int T1, T2, T3, T4, T5, T6;
	private int ps, atk, dif, atksp, difsp, vel;

	Tipo(int ps, int atk, int dif, int atksp, int difsp, int vel) {
		this.ps = ps;
		this.atk = atk;
		this.dif = dif;
		this.atksp = atksp;
		this.difsp = difsp;
		this.vel = vel;
		tipo = setTipo();
	}

	private String setTipo() {
		if(ps % 2 == 1) {
			T1 = 1;
		}

		if(atk % 2 == 1) {
			T2 = 2;
		}

		if(dif % 2 == 1) {
			T3 = 4;
		}

		if(vel % 2 == 1) {
			T4 = 8;
		}

		if(atksp % 2 == 1) {
			T5 = 16;
		}

		if(difsp % 2 == 1) {
			T6 = 32;
		}

		int formula = ((T1 + T2 + T3 + T4 + T5 + T6) * 15) / 63;
		switch(formula) {
			case 0:
				tipo = "Lotta";
				break;
			case 1:
				tipo = "Volante";
				break;
			case 2:
				tipo = "Volante";
				break;
			case 3:
				tipo = "Terra";
				break;
			case 4:
				tipo = "Roccia";
				break;
			case 5:
				tipo = "Coleottero";
				break;
			case 6:
				tipo = "Spettro";
				break;
			case 7:
				tipo = "Acciaio";
				break;
			case 8:
				tipo = "Fuoco";
				break;
			case 9:
				tipo = "Acqua";
				break;
			case 10:
				tipo = "Erba";
				break;
			case 11:
				tipo = "Elettro";
				break;
			case 12:/**
Questa classe si occupa di ricevere le IVs in entrata e ritornare la potenza dell'Introforza.
Il costruttore dopo aver assegnato il giusto valore alle variabili di istanza le elabora e ne registra la potenza.
Se il resto di una IVs divisa per 4 è uguale a 2 o a 3, Px avrà un intero dipendente dalla statistica in questione,
altrimenti Px a sarà dato il valore 0.
Dopo aver fatto ciò, si procede all'esecuzione della formula della potenza dell'Introforza.
Il risultato, poi, viene registrato nella variabile "potenza" accennata prima.
Una volta che il costrutto ha fatto il suo lavoro, basterà invocare il metodo getPotenza() per ottenere l'intero
ottenuta poc'anzi.
*/
				tipo = "Psico";
				break;
			case 13:
				tipo = "Ghiaccio";
				break;
			case 14:
				tipo = "Buio";
				break;
			case 15:
				tipo = "Buio";
				break;
			default:			
				tipo = "È accaduto un errore nel calcolare il tipo dell'Introforza."+formula;
		}
		return tipo;
	}

	public String getTipo() {
		return tipo;
	}
}	
