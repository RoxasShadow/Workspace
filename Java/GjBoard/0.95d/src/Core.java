/* Permette di gestire l'arraylist di Text, la connessione al database e l'inserimento/visualizzazione dei record. */
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
	   		this.connetti();
	   		this.creaDB();
	   		this.disconnetti();
	   	}
	   	catch(ClassNotFoundException ex) {
	   		System.out.println("\nInizializzazione fallita.");
	   		System.exit(1);
	   	}
	}
	
	public boolean connetti() {
		try {
			connessione = DriverManager.getConnection("jdbc:sqlite:test.db");
	   		query = connessione.createStatement();
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	public boolean disconnetti() {
		try {
			query.close();
			connessione.close();
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
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
	
	public void creaDB() {
		try {
	   		this.connetti();
			query.executeUpdate("CREATE TABLE IF NOT EXISTS gjboard(importanza, giorno, mese, anno, ora, minuto, categoria, appunto, titolo)");
			query.executeUpdate("INSERT INTO gjboard(importanza, giorno, mese, anno, ora, minuto, categoria, appunto, titolo) VALUES ('1', '31', '3', '2011', '23', '59', 'Default', 'Benvenuto in GjBoard!', 'Benvenuto!')");
	   		this.disconnetti();
		}
		catch(SQLException ex) {}
	}
	
	public boolean eliminaAppunti() {
		try {
	   		this.connetti();
			query.executeQuery("DELETE FROM gjboard");
	   		this.disconnetti();
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
			elenco.clear(); // Svuoto l'arraylist
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
			clipboard.setLength(0); // Svuoto lo StringBuffer
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
	
	private boolean fileExists(String nome) {
		boolean exists = (new File(nome)).exists();
		if(exists == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean esportaAppunti(String nome) {
		try {
	   		this.connetti();
			result = query.executeQuery("SELECT * FROM gjboard ORDER by importanza ASC");
			clipboard.setLength(0);
			while (result.next()) {
				clipboard.append("\nTitolo: "+result.getString("titolo")+"\nImportanza: "+result.getString("importanza")+"\nCreato il "+result.getString("giorno")+"/"+result.getString("mese")+"/"+result.getString("anno")+" alle ore "+result.getString("ora")+":"+result.getString("minuto")+"\nCategoria: "+result.getString("categoria")+"\nAppunto: "+result.getString("appunto")+"\n");
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
	
	public String readText(String titolo) {
		try {
	   		this.connetti();
			result = query.executeQuery("SELECT * FROM gjboard WHERE titolo='"+titolo+"' ORDER by importanza ASC");
			clipboard.setLength(0); // Svuoto lo StringBuffer
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
	
	/* Ritorno un arraylist di stringhe contenente il titolo di ogni appunto */
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
}
