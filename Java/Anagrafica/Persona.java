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

class Persona {
	private String nome;
	private String cognome;
	private String luogodinascita;
	private String sesso;
	private String statocivile; //Libero, coniugato, vedovo
	private String residenza;
	private String professione;
	
	Persona(String nome, String cognome, String luogodinascita, String sesso, String statocivile, String residenza, String professione) {
		this.nome = nome;
		this.cognome = cognome;
		this.luogodinascita = luogodinascita;
		this.sesso = sesso;
		this.statocivile = statocivile;
		this.residenza = residenza;
		this.professione = professione;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getLuogodinascita() {
		return luogodinascita;
	}
	
	public String getSesso() {
		return sesso;
	}
	
	public String getStatocivile() {
		return statocivile;
	}
	
	public String getResidenza() {
		return residenza;
	}
	
	public String getProfessione() {
		return professione;
	}
	
	public String toString() {
		return "Nome: "+getNome()+"\nCognome: "+getCognome()+"\nLuogo di nascita: "+getLuogodinascita()+"\nSesso: "+getSesso()+"\nStato civile: "+getStatocivile()+"\nResidenza: "+getResidenza()+"\nProfessione: "+getProfessione();
	}
}
