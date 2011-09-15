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

import java.util.ArrayList; 
class Anagrafe {
	private ArrayList<Persona> persone;
	private StringBuffer stringa;
	
	Anagrafe() {
		persone = new ArrayList<Persona>();
		stringa = new StringBuffer("");
	}
	
	/* Inserisce una persona all'anagrafe */
	public void inserisciPersona(Persona persona) {
		persone.add(persona);
	}
	
	/* Stampa tutte le persone presenti all'anagrafe */
	public String stampaPersone() {
		for(Persona p:persone) {
			stringa.append(p);
			stringa.append("\n\n");
		}
		return stringa.toString();
	}
	
	/* Dati nome e cognome, stampa la persona */
	public String ricercaPersona(String nome, String cognome) {
		for(Persona p:persone) {
			if((p.getNome().equals(nome)) && (p.getCognome().equals(cognome))) {
				stringa.append(p);
			}
			return stringa.toString();
		}
		
		stringa.append("Nessuna persona trovata secondo i criteri corrispondenti.");
		return stringa.toString();	
	}
	
	/* Calcolo persone registrate */
	public int totalePersona() {
		return persone.size();
	}
	
	/* Calcolo percentuale degli stati civili */
	public String percentualeStatiCivili() {
		int liberi = 0;
		int coniugati = 0;
		int vedovi = 0;
		double perLiberi, perConiugati, perVedovi;
		int totale;
		
		totale = this.totalePersona();
		
		for(Persona p:persone) {
			if(p.getStatocivile().equals("Libero")) {
				liberi += 1;
			}
			else if(p.getStatocivile().equals("Coniugato")) {
				coniugati += 1;
			}
			else if(p.getStatocivile().equals("Vedovo")) {
				vedovi += 1;
			}
		}
		
		perLiberi = ((liberi * 100) / totale);
		perConiugati = ((coniugati * 100) / totale);
		perVedovi = ((vedovi * 100) / totale);
		
		return "Liberi: "+perLiberi+"%\nConiugati: "+perConiugati+"%\nVedovi: "+perVedovi+"%";
	}
	
	/* Calcolo percentuale dei maschi e delle femmine */
	public String percentualeSesso() {
		int maschi = 0;
		int femmine = 0;
		double perMaschi, perFemmine;
		int totale;
		
		totale = this.totalePersona();
		
		for(Persona p:persone) {
			if(p.getSesso().equals("Maschio")) {
				maschi += 1;
			}
			else {
				femmine += 1;
			}
		}
		
		perMaschi = ((maschi * 100) / totale);
		perFemmine = ((femmine * 100) / totale);
		return "Maschi: "+perMaschi+"%\nFemmine: "+perFemmine+"%";
	}
		
}
