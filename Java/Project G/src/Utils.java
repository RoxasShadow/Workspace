/**
	Utils.java
	(C) Giovanni Capuano 2011
*/
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;

/* Provvede a fornire metodi per comunicare online e effettuare i calcoli per le formule. */
public class Utils {
	private int maxEvPokemon = 255;
	private int maxEvStat = 85;
	private String dbOnlineName = "db.projg";
	private String dbOnlineURL = "http://www.doomdesire.it/project-g/db.projg";
	
	/* Controlla se un file esiste. */
	private boolean fileExists(String filename) {
		return (new File(filename)).exists();
	}
	
	/* Salva un file di testo da una stringa. */
	private boolean saveFile(String filename, String text) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			writer.write(text);
			writer.close();
			return (fileExists(filename));
		}
		catch(MalformedURLException e) {}
		catch(IOException e) {}
		return false;
	}
	
	/* Elimina un file. */
	private boolean deleteFile(String filename) {
		(new File(filename)).delete();
		return (!fileExists(filename));
	}
	
	/* Ritorna una stringa contenente il database. */
	private String getOnlineDatabase() {
		try {
			URL url = new URL(getDatabaseOnlineURL());
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer("");
			String line;
			while((line = reader.readLine()) != null)
				buffer.append(line);
			reader.close();
			return buffer.toString();
		}
		catch(MalformedURLException e) {}
		catch(IOException e) {}
		return "";
	}
	
	/* Ritorna una stringa contenente il database in locale. */
	private String getOnlineDatabaseLocal() {
		try {
			URL url = new File(getDatabaseOnlineName()).toURI().toURL();
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer("");
			String line;
			while((line = reader.readLine()) != null)
				buffer.append(line);
			reader.close();
			return buffer.toString();
		}
		catch(MalformedURLException e) {}
		catch(IOException e) {}
		return "";
	}
	
	public double approximate(double d, int n) {
		return Math.round(d*Math.pow(10, n))/Math.pow(10, n);
	}
	
	public Object[] getMapAsArray(Map<String, Map<String, String>> map, String value) {
		ArrayList<String> list = new ArrayList<String>();
		String key = null;
		Map<String, String> obj = null;
		for(Iterator i = map.keySet().iterator(); i.hasNext();) {
			key = (String)(i.next());
			obj = map.get(key);
			list.add(obj.get(value));
		}
		Object[] result = list.toArray();
		Arrays.sort(result);
		return result;
	}
	
	private String idToPokemon(int id) {
		String pokemon = Integer.toString(id);
		switch(pokemon.length()) {
			case 1:
				return new String("00"+pokemon);
			case 2:
				return new String("0"+pokemon);
			default:
				return new String(pokemon);
		}
	}
	
	public ImageIcon getArtwork(int id) {
		return new ImageIcon(getClass().getClassLoader().getResource("db/artworks/"+idToPokemon(id)+".png"));
	}
	
	public boolean isArtwork(int id) {
		return (getClass().getClassLoader().getResource("db/artworks/"+idToPokemon(id)+".png") == null) ? false : true;
	}
	
	public ImageIcon getArtwork(String pokemon) {
		return new ImageIcon(getClass().getClassLoader().getResource("db/artworks/"+pokemon+".png"));
	}
	
	public boolean isArtwork(String pokemon) {
		return (getClass().getClassLoader().getResource("db/artworks/"+pokemon+".png") == null) ? false : true;
	}
	
	public String getOnlinePattern(String pokemon) {
		return "http://www.doomdesire.it/index.php?act=pokedex/"+pokemon+".html";
	}
	
	public int getMaxEvPokemon() {
		return maxEvPokemon;
	}
	
	public int getMaxEvStat() {
		return maxEvStat;
	}
	
	public String getDatabaseOnlineURL() {
		return dbOnlineURL;
	}
	
	public String getDatabaseOnlineName() {
		return dbOnlineName;
	}
	
	public void setMaxEvPokemon(int maxEvPokemon) {
		this.maxEvPokemon = maxEvPokemon;
	}
	
	public void setMaxEvStat(int maxEvStat) {
		this.maxEvStat = maxEvStat;
	}
	
	public void setDatabaseOnlineURL(String dbOnlineURL) {
		this.dbOnlineURL = dbOnlineURL;
	}
	
	public void setDatabaseOnlineName(String dbOnlineName) {
		this.dbOnlineName = dbOnlineName;
	}
	
	/* Calcola la potenza dell'Hidden Power. */
	public int getHiddenPower(int ps, int atk, int dif, int atksp, int difsp, int vel) throws ArithmeticException {
		try {
			int result = 0;
			if((ps % 4 == 2) || (ps % 4 == 3))
				result += 1;
			if((atk % 4 == 2) || (atk % 4 == 3))
				result += 2;
			if((dif % 4 == 2) || (dif % 4 == 3))
				result += 4;
			if((vel % 4 == 2) || (vel % 4 == 3))
				result += 8;
			if((atksp % 4 == 2) || (atksp % 4 == 3))
				result += 16;
			if((difsp % 4 == 2) || (difsp % 4 == 3))
				result += 32;
			return (((result * 40) / 63) + 30);
		}
		catch(ArithmeticException e) {
			throw new ArithmeticException();
		}
	}
	
	/* Calcola la potenza dell'Hidden Power. */
	public int getHiddenPower(int[] stats) throws ArithmeticException, ArrayIndexOutOfBoundsException {
		try {
			int result = 0;
			if((stats[0] % 4 == 2) || (stats[0] % 4 == 3))
				result += 1;
			if((stats[1] % 4 == 2) || (stats[1] % 4 == 3))
				result += 2;
			if((stats[2] % 4 == 2) || (stats[2] % 4 == 3))
				result += 4;
			if((stats[5] % 4 == 2) || (stats[5] % 4 == 3))
				result += 8;
			if((stats[3] % 4 == 2) || (stats[3] % 4 == 3))
				result += 16;
			if((stats[4] % 4 == 2) || (stats[4] % 4 == 3))
				result += 32;
			return (((result * 40) / 63) + 30);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException();
		}
		catch(ArithmeticException e) {
			throw new ArithmeticException();
		}
	}
	
	/* Calcola il tipo dell'Hidden Power. */
	public String getHiddenPowerType(int ps, int atk, int dif, int atksp, int difsp, int vel) {
		int result = 0;
		String type;
		if(ps % 2 == 1)
			result += 1;
		if(atk % 2 == 1)
			result += 2;
		if(dif % 2 == 1)
			result += 4;
		if(vel % 2 == 1)
			result += 8;
		if(atksp % 2 == 1)
			result += 16;
		if(difsp % 2 == 1)
			result += 32;
		switch((result * 15) / 63) {
			case 0:
				type = new String("Fighting");
				break;
			case 1:
				type = new String("Flying");
				break;
			case 2:
				type = new String("Fighting");
				break;
			case 3:
				type = new String("Ground");
				break;
			case 4:
				type = new String("Rock");
				break;
			case 5:
				type = new String("Bug");
				break;
			case 6:
				type = new String("Ghost");
				break;
			case 7:
				type = new String("Steel");
				break;
			case 8:
				type = new String("Fire");
				break;
			case 9:
				type = new String("Water");
				break;
			case 10:
				type = new String("Grass");
				break;
			case 11:
				type = new String("Electric");
				break;
			case 12:
				type = new String("Psychic");
				break;
			case 13:
				type = new String("Ice");
				break;
			case 14:
				type = new String("Dragon");
				break;
			case 15:
				type = new String("Dragon");
				break;
			default:
				type = new String("???");
		}
		return type;
	}
	
	/* Calcola il tipo dell'Hidden Power. */
	public String getHiddenPowerType(int[] stats) throws ArrayIndexOutOfBoundsException, ArithmeticException {
		try {
			int result = 0;
			String type;
			if(stats[0] % 2 == 1)
				result += 1;
			if(stats[1] % 2 == 1)
				result += 2;
			if(stats[2] % 2 == 1)
				result += 4;
			if(stats[5] % 2 == 1)
				result += 8;
			if(stats[3] % 2 == 1)
				result += 16;
			if(stats[4] % 2 == 1)
				result += 32;
			switch((result * 15) / 63) {
				case 0:
					type = new String("Fighting");
					break;
				case 1:
					type = new String("Flying");
					break;
				case 2:
					type = new String("Fighting");
					break;
				case 3:
					type = new String("Ground");
					break;
				case 4:
					type = new String("Rock");
					break;
				case 5:
					type = new String("Bug");
					break;
				case 6:
					type = new String("Ghost");
					break;
				case 7:
					type = new String("Steel");
					break;
				case 8:
					type = new String("Fire");
					break;
				case 9:
					type = new String("Water");
					break;
				case 10:
					type = new String("Grass");
					break;
				case 11:
					type = new String("Electric");
					break;
				case 12:
					type = new String("Psychic");
					break;
				case 13:
					type = new String("Ice");
					break;
				case 14:
					type = new String("Dragon");
					break;
				case 15:
					type = new String("Dragon");
					break;
				default:
					type = new String("???");
			}
			return type;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException();
		}
		catch(ArithmeticException e) {
			throw new ArithmeticException();
		}
	}
	
	/* Ritorna l'iv di una statistica. */
	public int getIV(int stat, double nature, int level, int baseStat, int ev) throws ArithmeticException {
		try {
			return (int)((((stat/nature)-5)*100/level)-2*baseStat-ev/4);
		}
		catch(ArithmeticException e) {
			throw new ArithmeticException();
		}
	}
	
	/* Ritorna la statistica per gli HP. */
	public int getHP(int iv, int level, int baseStat, int ev) throws ArithmeticException {
		try {
			return (int)(((iv+2*baseStat+(ev/4))*(level/100))+10+level);
		}
		catch(ArithmeticException e) {
			throw new ArithmeticException();
		}
	}
	
	/* Ritorna la statistica massima di una statistica. */
	public int getStat(int iv, double nature, int level, int baseStat, int ev) throws ArithmeticException {
		try {
			return (int)((((iv+(2*baseStat)+(ev/4))*level)/100+5)*nature);
		}
		catch(ArithmeticException e) {
			throw new ArithmeticException();
		}
	}
	
	/* Effettua il calcolo danni. */
	/**
	critical = 1 o 2
	stab = 1 o 1.5 
	effective: 0, 0.25, 0.5, 1, 2, 4
	*/
	public double getDamage(int level, int basePower, int s_atk, int s_def, int critical, double stab, double effective, boolean min) throws ArithmeticException, NotOffensiveMoveException {
		if(basePower == 0)
			throw new NotOffensiveMoveException();
		double rand = (min) ? 0.85 : 1;
		try {
			return ((((2*level+10)*s_atk*basePower)/(250*s_def))+2)*effective*stab*critical*rand;
		}
		catch(ArithmeticException e) {
			throw new ArithmeticException();
		}
	}
	
	/* Dato un tipo ritorna le sue debolezze (x2). */
	public String[] getWeakness(String type) {
		ArrayList<String> weakness = new ArrayList<String>();
		if(type.equals("Normal"))
			weakness.add("Fighting");
		else if(type.equals("Fire")) {
			weakness.add("Fighting");
			weakness.add("Rock");
		}
		else if(type.equals("Water")) {
			weakness.add("Grass");
			weakness.add("Electric");
		}
		else if(type.equals("Grass")) {
			weakness.add("Fire");
			weakness.add("Ice");
			weakness.add("Poison");
			weakness.add("Flying");
			weakness.add("Bug");
		}
		else if(type.equals("Electric"))
			weakness.add("Ground");
		else if(type.equals("Ice")) {
			weakness.add("Fire");
			weakness.add("Fighting");
			weakness.add("Rock");
			weakness.add("Steel");
		}
		else if(type.equals("Fighting")) {
			weakness.add("Flying");
			weakness.add("Psychic");
		}
		else if(type.equals("Poison")) {
			weakness.add("Ground");
			weakness.add("Psychic");
		}
		else if(type.equals("Ground")) {
			weakness.add("Water");
			weakness.add("Grass");
			weakness.add("Ice");
		}
		else if(type.equals("Flying")) {
			weakness.add("Electric");
			weakness.add("Ice");
			weakness.add("Rock");
		}
		else if(type.equals("Psychic")) {
			weakness.add("Bug");
			weakness.add("Ghost");
			weakness.add("Dark");
		}
		else if(type.equals("Bug")) {
			weakness.add("Fire");
			weakness.add("Flying");
			weakness.add("Rock");
		}
		else if(type.equals("Rock")) {
			weakness.add("Water");
			weakness.add("Grass");
			weakness.add("Fighting");
			weakness.add("Ground");
		}
		else if(type.equals("Ghost")) {
			weakness.add("Ghost");
			weakness.add("Dark");
		}
		else if(type.equals("Dragon")) {
			weakness.add("Ice");
			weakness.add("Dragon");
		}
		else if(type.equals("Dark")) {
			weakness.add("Fighting");
			weakness.add("Bug");
		}
		else if(type.equals("Steel")) {
			weakness.add("Fire");
			weakness.add("Fighting");
			weakness.add("Ground");
		}
		return weakness.toArray(new String[weakness.size()]);
	}
	
	/* Dato un tipo ritorna le sue resistenze (x0.5) */
	public String[] getResistence(String type) {
		ArrayList<String> resistence = new ArrayList<String>();
		if(type.equals("Fire")) {
			resistence.add("Fire");
			resistence.add("Grass");
			resistence.add("Ice");
			resistence.add("Bug");
			resistence.add("Steel");
		}
		else if(type.equals("Water")) {
			resistence.add("Fire");
			resistence.add("Water");
			resistence.add("Ice");
			resistence.add("Steel");
		}
		else if(type.equals("Grass")) {
			resistence.add("Water");
			resistence.add("Grass");
			resistence.add("Electric");
			resistence.add("Ground");
		}
		else if(type.equals("Electric")) {
			resistence.add("Electric");
			resistence.add("Flying");
			resistence.add("Steel");
		}
		else if(type.equals("Ice"))
			resistence.add("Ice");
		else if(type.equals("Fighting")) {
			resistence.add("Bug");
			resistence.add("Rock");
			resistence.add("Dark");
		}
		else if(type.equals("Poison")) {
			resistence.add("Grass");
			resistence.add("Fighting");
			resistence.add("Poison");
			resistence.add("Bug");
		}
		else if(type.equals("Ground")) {
			resistence.add("Poison");
			resistence.add("Rock");
		}
		else if(type.equals("Flying")) {
			resistence.add("Grass");
			resistence.add("Fighting");
			resistence.add("Bug");
		}
		else if(type.equals("Psychic")) {
			resistence.add("Fighting");
			resistence.add("Psychic");
		}
		else if(type.equals("Bug")) {
			resistence.add("Grass");
			resistence.add("Fighting");
			resistence.add("Bug");
		}
		else if(type.equals("Rock")) {
			resistence.add("Normal");
			resistence.add("Fire");
			resistence.add("Poison");
			resistence.add("Flying");
		}
		else if(type.equals("Ghost")) {
			resistence.add("Poison");
			resistence.add("Bug");
		}
		else if(type.equals("Dragon")) {
			resistence.add("Fire");
			resistence.add("Water");
			resistence.add("Grass");
			resistence.add("Electric");
		}
		else if(type.equals("Dark")) {
			resistence.add("Ghost");
			resistence.add("Dark");
		}
		else if(type.equals("Steel")) {
			resistence.add("Normal");
			resistence.add("Grass");
			resistence.add("Ice");
			resistence.add("Flying");
			resistence.add("Psychic");
			resistence.add("Bug");
			resistence.add("Rock");
			resistence.add("Ghost");
			resistence.add("Dragon");
			resistence.add("Dark");
			resistence.add("Steel");
		}
		return resistence.toArray(new String[resistence.size()]);
	}
	
	/* Dato un tipo ritorna le sue immunità (x0). */
	public String[] getImmunitance(String type) {
		ArrayList<String> immunitance = new ArrayList<String>();
		if(type.equals("Normal"))
			immunitance.add("Ghost");
		else if(type.equals("Ground"))
			immunitance.add("Electric");
		else if(type.equals("Flying"))
			immunitance.add("Ground");
		else if(type.equals("Ghost")) {
			immunitance.add("Normal");
			immunitance.add("Fighting");
		}
		else if(type.equals("Dark"))
			immunitance.add("Psychic");
		else if(type.equals("Steel"))
			immunitance.add("Poison");
		return immunitance.toArray(new String[immunitance.size()]);
	}
	
	/* Inizializza l'online scaricando il database online. */
	public boolean initOnline() {
		if(!fileExists(getDatabaseOnlineName()))
			return saveFile(getDatabaseOnlineName(), getOnlineDatabase());
		return fileExists(getDatabaseOnlineName());
	}
	
	/* Rimuove il database online scaricato durante l'init. */
	public boolean cleanOnline() {
		if(fileExists(getDatabaseOnlineName()))
			return deleteFile(getDatabaseOnlineName());
		return !fileExists(getDatabaseOnlineName());
	}
	
	/* Controlla se un Pokémon è presente nel database locale. */
	public boolean isOnline(String name) {
		String db = getOnlineDatabaseLocal();
		if(db.equals(""))
			return false;
		return (db.indexOf(name) != -1) ? true : false;
	}
	
	/* Apre una pagina web nel browser predefinito dell'utente. */
	public void openURL(String url) throws Exception {
		String osName = System.getProperty("os.name");
		try {
			if(osName.startsWith("Windows"))
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+url);
			else {
				String[] browsers = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"};
				String browser = null;
				for(int count=0; count<browsers.length && browser == null; ++count)
					if(Runtime.getRuntime().exec(new String[] {"which", browsers[count]}).waitFor() == 0)
						browser = browsers[count];
				Runtime.getRuntime().exec(new String[] {browser, url});
			}
		}
		catch(Exception e) {
			throw new Exception();
		}
	}
}
