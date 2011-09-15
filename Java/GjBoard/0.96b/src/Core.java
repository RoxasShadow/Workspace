/**
    Questa classe è parte di GjBoard.
    Copyright (C) 2011  Giovanni 'Roxas Shadow' Capuano

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

import java.io.*;
import java.sql.*;
import java.util.*;

public class Core {
	private ArrayList<Text> elenco;
	private Connection connessione;
	private Statement query;
	private ResultSet result;
	private StringBuffer clipboard;
	
	Core() {
		try {
			elenco = new ArrayList<Text>();
			clipboard = new StringBuffer("");
			Class.forName("org.sqlite.JDBC");
	   		this.creaDB();
	   	}
	   	catch(ClassNotFoundException ex) {
	   		System.out.println("\nInizializzazione fallita.");
	   		System.exit(1);
	   	}
	}
	
	private boolean connetti() {
		try {
			connessione = DriverManager.getConnection("jdbc:sqlite:database.db");
	   		query = connessione.createStatement();
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	private boolean disconnetti() {
		try {
			query.close();
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	private void creaDB() {
		try {
	   		this.connetti();   			
			query.executeUpdate("CREATE TABLE IF NOT EXISTS gjboard(importanza, giorno, mese, anno, ora, minuto, categoria, appunto, titolo)");
			if(this.contaAppunti() <= 0) {
				query.executeUpdate("INSERT INTO gjboard(importanza, giorno, mese, anno, ora, minuto, categoria, appunto, titolo) VALUES ('1', '31', '3', '2011', '23', '59', 'Default', 'Benvenuto in GjBoard', 'Benvenuto!')");
			}
	   		this.disconnetti();
		}
		catch(SQLException ex) {}
	}
	
	public boolean newText(Text text) {
		try {
			result = query.executeQuery("SELECT * FROM gjboard");
			clipboard.setLength(0);
			while (result.next()) {
				if(result.getString("titolo").equals(text.getTitolo())) {
					return false;
				}
			}
			elenco.add(text);
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	public boolean addTexts() {
		try {
	   		this.connetti();
			for(Text t:elenco) {
				query.executeUpdate("INSERT INTO gjboard(importanza, giorno, mese, anno, ora, minuto, categoria, appunto, titolo) VALUES ('"+t.getImportanza()+"','"+t.getGiorno()+"','"+t.getMese()+"','"+t.getAnno()+"','"+t.getOra()+"','"+t.getMinuto()+"','"+t.getCategoria()+"','"+t.getAppunto()+"','"+t.getTitolo()+"')");
			}
	   		this.disconnetti();
			elenco.clear();
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	public boolean eliminaAppunti() {
		try {
	   		if(fileExists("database.db") == true) {
				File file = new File("database.db");
				file.delete();
				if(fileExists("database.db") == true) {
					return false;
				}
				else {
					this.creaDB();
					return true;
				}
			}
			else {
				return false;
			}
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	public boolean eliminaAppunto(String titolo) {
		try {
	   		this.connetti();
			query.executeQuery("DELETE FROM gjboard WHERE titolo='"+titolo+"'");
	   		this.disconnetti();
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	public int contaAppunti() {
		try {
	   		this.connetti();
			result = query.executeQuery("SELECT COUNT(*) AS alias FROM gjboard");
			clipboard.setLength(0);
			int appunti = 0;
			while (result.next()) {
				appunti = result.getInt("alias");
			}
	   		this.disconnetti();
			return appunti;
		}
		catch(SQLException ex) {
			return -1;
		}
	}
	
	public String readText(String titolo) {
		try {
	   		this.connetti();
			result = query.executeQuery("SELECT * FROM gjboard WHERE titolo='"+titolo+"' ORDER by importanza ASC");
			clipboard.setLength(0);
			while (result.next()) {
				clipboard.append("Titolo: "+result.getString("titolo")+"\nImportanza: "+result.getString("importanza")+"\nCreato il "+result.getString("giorno")+"/"+result.getString("mese")+"/"+result.getString("anno")+" alle ore "+result.getString("ora")+":"+result.getString("minuto")+"\nCategoria: "+result.getString("categoria")+"\nAppunto: "+result.getString("appunto")+"\n");
			}
	   		this.disconnetti();
			return clipboard.toString();
		}
		catch(SQLException ex) {
			return "Appunto non trovato.";
		}
	}
	
	public boolean esportaAppunti(String nome) {
		try {
	   		this.connetti();
			result = query.executeQuery("SELECT * FROM gjboard ORDER by importanza ASC");
			clipboard.setLength(0);
			while (result.next()) {
				clipboard.append("Titolo: "+result.getString("titolo")+"\nImportanza: "+result.getString("importanza")+"\nCreato il "+result.getString("giorno")+"/"+result.getString("mese")+"/"+result.getString("anno")+" alle ore "+result.getString("ora")+":"+result.getString("minuto")+"\nCategoria: "+result.getString("categoria")+"\nAppunto: "+result.getString("appunto")+"\n\n");
			}
	   		this.disconnetti();
			
			File file = new File(nome+".txt");
			FileOutputStream output = new FileOutputStream(file);
			PrintStream input = new PrintStream(output);
			input.println(clipboard.toString());
			output.close();
			
			if(fileExists(nome+".txt") == true) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException ex) {
			return false;
		}
		catch(IOException ex) {
			return false;
		}
	}
	
	public ArrayList<String> buildMenu() {
		try {
	   		this.connetti();
			result = query.executeQuery("SELECT * FROM gjboard ORDER by importanza ASC");
			ArrayList<String> titoli = new ArrayList<String>();
			while (result.next()) {
				titoli.add(result.getString("titolo"));
			}
	   		this.disconnetti();
			
			if(titoli.size() <= 0) {
				for(int i=0; i<titoli.size(); i++) {
					titoli.remove(i);
				}
				titoli.add("");
				return titoli;
			}
			else {
				return titoli;
			}
		}
		catch(SQLException ex) {
			ArrayList<String> titoli = new ArrayList<String>();
			titoli.add("");
			return titoli;
		}
	}
	
	private boolean fileExists(String nome) {
		boolean exists = (new File(nome)).exists();
		if(exists == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/* Non usate */
	private boolean checkTitolo(String titolo) {
		try {
	   		this.connetti();
			result = query.executeQuery("SELECT * FROM gjboard WHERE titolo='"+titolo+"'");
			while (result.next()) {
				if(result.getString("titolo").equals(titolo)) {
					return true;
				}
			}
	   		this.disconnetti();
			return false;
		}
		catch(SQLException ex) {
			return false;
		}
	}
}
