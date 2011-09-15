/**
Questa è la classe principale del programma.
Prima di tutto si controlla se l'array di stringhe è diverso da 6 (il numero di IVs), se lo è manda un messaggio
con l'usage ed esce dal programma, altrimenti prosegue.
Si prende in input l'array di stringhe: ogni valore viene prima convertito in integer e poi
viene assegnato alla relativa variabile, dopodichè si crea l'oggetto Introforza con all'interno gli interi.
Poi vengono invocati i metodi per calcolare, rispettivamente, la potenza e il tipo e infine viene stampato il tutto.
*/

class TestIntroforza {
	public static void main(String args[]) {
		if(args.length != 6) {
			System.out.println("Usage: java TestIntroforza <ps> <attacco> <difesa> <attaccospeciale> <difesaspeciale> <velocità>");
			System.exit(1);
		}
		int ps = Integer.parseInt(args[0]);
		int atk = Integer.parseInt(args[1]);
		int dif = Integer.parseInt(args[2]);;
		int atksp = Integer.parseInt(args[3]);
		int difsp = Integer.parseInt(args[4]);
		int vel = Integer.parseInt(args[5]);
		Introforza introforza = new Introforza(ps,atk,dif,atksp,difsp,vel);

		introforza.inserisciPotenza();
		introforza.inserisciTipo();
		introforza.getIntroforza();
	}
}
