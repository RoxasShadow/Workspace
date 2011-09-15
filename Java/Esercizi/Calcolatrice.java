import java.util.Scanner; // Importo lo Scanner

class Operazioni {
	int a, b;
	Scanner lettore = new Scanner(System.in);

	public int input() {
		return lettore.nextInt();
	}

	public static int addizione(int a, int b) {
		return a + b;
	}

	public static int sottrazione(int a, int b) {
		return a - b;
	}

	public static int divisione(int a, int b) {
		return a / b;
	}

	public static int moltiplicazione(int a, int b) {
		return a * b;
	}
}

public class Calcolatrice{

	public static void main(String[] args){
		int a, b, operazione, check;
		boolean riprova = true;
		Operazioni operazioni = new Operazioni();

		System.out.print("Ciao, benvenuto nella prima calcolatrice in Java di Giovanni Capuano!\n");
			while(riprova == true) {
				System.out.print("Per iniziare, digita un numero: ");
				a = operazioni.input(); // Prelevo il numero
				System.out.print("\nOra digitane un altro: ");
				b = operazioni.input(); // Prelevo il numero
				System.out.print("\nAdesso scegli quale operazione vuoi svolgere tra addizione[1], sottrazione[2], divisione[3] e moltiplicazione[4]: ");
				operazione = operazioni.input(); // Prelevo il carattere
				switch(operazione) {
					case 1:
						System.out.print("\nRisultato: "+operazioni.addizione(a, b)+".\n");
						break;
					case 2:
						System.out.print("\nRisultato: "+operazioni.sottrazione(a, b)+".\n");
						break;
					case 3:
						System.out.print("\nRisultato: "+operazioni.divisione(a, b)+".\n");
						break;
					case 4:
						System.out.print("\nRisultato: "+operazioni.moltiplicazione(a, b)+".\n");
						break;
				}
				System.out.print("\nSe vuoi effettuare un altro calcolo digita 1, altrimenti 0: ");
				check = operazioni.input(); // Prelevo il numero
				switch(check) {
					case 0:
						riprova = false;
						break;
					case 1:
						riprova = true;
						break;
				}
			}
	}
}
