/**
    Anagrafica v1.0
    Copyright (C) 2010  Giovanni Capuano

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.util.Scanner;
class Anagrafica {
	public static void main(String[] args) {
		Persona persona;
		Anagrafe anagrafe;
		int scelta;
		String nome, cognome, luogodinascita, sesso, statocivile, residenza, professione;
		Scanner scanner = new Scanner(System.in);
		anagrafe = new Anagrafe();
		System.out.println("Benvenuto in Anagrafica v1.0 (c)2010 Giovanni Capuano");
		
		do {
			System.out.println("\nDigita 1 per inserire una persona");
			System.out.println("Digita 2 per visualizzare le persone registrate");
			System.out.println("Digita 3 per visualizzare una persona conoscendo il suo nome e cognome");
			System.out.println("Digita 4 per conoscere il numero degli abitanti");
			System.out.println("Digita 5 per conoscere le percentuali degli stati civili degli abitanti");
			System.out.println("Digita 6 per conoscere la prevalenza dei sessi");
			System.out.println("Digita 7 per uscire");
			scelta = scanner.nextInt();
		
			switch(scelta) {
				case 1:
					System.out.println("\nNome:");
					nome = scanner.next();
					System.out.println("\nCognome:");
					cognome = scanner.next();
					System.out.println("\nLuogo di nascita:");
					luogodinascita = scanner.next();
					System.out.println("\nSesso (Maschio/Femmina):");
					sesso = scanner.next();
					System.out.println("\nStato civile (Libero/Coniugato/Vedovo):");
					statocivile = scanner.next();
					System.out.println("\nResidenza:");
					residenza = scanner.next();
					System.out.println("\nProfessione:");
					professione = scanner.next();

					if((!statocivile.equals("Libero")) && (!statocivile.equals("Coniugato")) && (!statocivile.equals("Vedovo"))) {
						System.out.println("\nErrore nell'invio dello stato civile.");
						break;
					}

					if((!sesso.equals("Maschio")) && (!sesso.equals("Femmina"))) {
						System.out.println("\nErrore nell'invio del sesso.");
						break;
					}
					
					persona = new Persona(nome, cognome, luogodinascita, sesso, statocivile, residenza, professione);
					anagrafe.inserisciPersona(persona);
					
					if(sesso.equals("Maschio")) {
						System.out.println("\n"+nome+" è stato registrato all'anagrafe.");
					}
					else {
						System.out.println("\n"+nome+" è stata registrata all'anagrafe.");
					}
					
					break;
				case 2:
					System.out.println("\nPersone registrate all'anagrafe:\n\n");
					System.out.println(anagrafe.stampaPersone());
					break;
				case 3:
					System.out.println("\nNome della persona da ricercare:");
					nome = scanner.next();
					System.out.println("\nCognome della persona da ricercare:");
					cognome = scanner.next();
					System.out.println(anagrafe.ricercaPersona(nome, cognome));
					break;
				case 4:
					System.out.println("\nIl numero di abitanti registrati risulta essere di "+anagrafe.totalePersona()+".");
					break;
				case 5:
					System.out.println(anagrafe.percentualeStatiCivili());
					break;
				case 6:
					System.out.println(anagrafe.percentualeSesso());
					break;
				case 7:
					System.out.println("\nA presto :)");
					System.exit(0);
				default:
					System.out.println("\nDigita un numero da 1 a 7 relativo all'azione che vuoi svolgere.\n");
			}
		} while(scelta != 7);
	}
}
