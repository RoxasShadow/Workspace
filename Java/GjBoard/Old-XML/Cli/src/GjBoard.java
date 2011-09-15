import java.util.*;
import java.io.*;
import org.jdom.*;
import org.jdom.output.*;
import org.jdom.input.*; 

class Text {
	private int giorno, mese, anno, ora, minuto, importanza;
	private String appunto, categoria;
	
	Text(int giorno, int mese, int anno, int ora, int minuto, int importanza, String appunto, String categoria) {
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
		this.ora = ora;
		this.minuto = minuto;
		this.importanza = importanza;
		this.appunto = appunto;
		this.categoria = categoria;
	}
	
	public int getGiorno() {
		return giorno;
	}
	
	public int getMese() {
		return mese;
	}
	
	public int getAnno() {
		return anno;
	}
	
	public int getOra() {
		return ora;
	}
	
	public int getMinuto() {
		return minuto;
	}
	
	public int getImportanza() {
		return importanza;
	}
	
	public String getAppunto() {
		return appunto;
	}
	
	public String getCategoria() {
		return categoria;
	}
}


class Date {
	private Calendar calendar;
	
	Date() {
	calendar = new GregorianCalendar();
	}
	
	public int getGiorno() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMese() {
		return (calendar.get(Calendar.MONTH) + 1);
	}
	
	public int getAnno() {
		return calendar.get(Calendar.YEAR);
	}
	
	public int getOra() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getMinuto() {
		return calendar.get(Calendar.MINUTE);
	}
}


class Core {
	private ArrayList<Text> elenco;
	
	Core() {
		elenco = new ArrayList<Text>();
	}
	
	public void newText(Text text) {
		elenco.add(text);
	}
	
	private boolean XMLExists() {
		boolean exists = (new File("database.xml")).exists();
		return exists;
	}
	
	public boolean deleteXML() {
		if(XMLExists() == true) {
			File database = new File("database.xml");
			database.delete();
		}
		else {
			return false;
		}
		
		if(XMLExists() == false) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean newXML() {
		try {
			/* Controllo se esiste il database */
			boolean exists;
			if(XMLExists() == false) {
				exists = false;
			}
			else {
				exists = true;
			}
			
			/* Se esiste elimino il tag </GjBoard> */
			if(exists == true) {
				InputStream dbReader = new FileInputStream("database.xml"); // Leggo
				StringBuffer database = new StringBuffer("");
				int i;
				do {
					i = dbReader.read();
					if(i != -1) {
						database.append((char) i);
					}
				} while(i != -1);
				dbReader.close();
				
				String databaseContents = database.toString();
				String newDatabaseContents = databaseContents.replaceAll("</GjBoard>", ""); // Elimino
				
				FileWriter dbWriter = new FileWriter("database.xml"); // Scrivo
				char buffer[] = new char[newDatabaseContents.length()];
				newDatabaseContents.getChars(0, newDatabaseContents.length(), buffer, 0);
				dbWriter.write(buffer);
				dbWriter.close();
			}
			
			/* Creo/Apro il database */
			FileOutputStream file = new FileOutputStream("database.xml", true); // Accoda
			PrintStream output = new PrintStream(file);			
			
			if(exists == false) { // Se è nuovo aggiungo l'intestazione
				output.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<GjBoard>\n");
			}
			
			/* Scrivo i dati */
			for(Text text:elenco) {
				output.println("<GjBoardContents>\n<Importanza>"+text.getImportanza()+"</Importanza>\n<Giorno>"+text.getGiorno()+"</Giorno>\n<Mese> "+text.getMese()+"</Mese>\n<Anno>"+text.getAnno()+"</Anno>\n<Ora>"+text.getOra()+"</Ora>\n<Minuto>"+text.getMinuto()+"</Minuto>\n<Categoria>"+text.getCategoria()+"</Categoria>\n<Appunto>"+text.getAppunto()+"</Appunto>\n</GjBoardContents>\n");
			}
			
			output.println("</GjBoard>");	
			return true;
		}
		catch (IOException e) {
			return false;
		}
	}
	
	public String readAllTexts() {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(new File("database.xml"));
			Element root = document.getRootElement();
			List children = root.getChildren(); // Estraggo i figli dalla root
			Iterator iterator = children.iterator();
			StringBuffer clipboard = new StringBuffer("");
		
			while(iterator.hasNext()) { // Per ogni figlio ne estraggo il contenuto
				Element GjBoardContents = (Element)iterator.next();
						
				Element xmlImportanza = GjBoardContents.getChild("Importanza");
				Element xmlGiorno = GjBoardContents.getChild("Giorno");
				Element xmlMese = GjBoardContents.getChild("Mese");
				Element xmlAnno = GjBoardContents.getChild("Anno");
				Element xmlOra = GjBoardContents.getChild("Ora");
				Element xmlMinuto = GjBoardContents.getChild("Minuto");
				Element xmlCategoria = GjBoardContents.getChild("Categoria");
				Element xmlAppunto = GjBoardContents.getChild("Appunto");
			
				clipboard.append("\nImportanza: "+xmlImportanza.getText()+"\nCreato il "+xmlGiorno.getText()+"/"+xmlMese.getText()+"/"+xmlAnno.getText()+" alle ore "+xmlOra.getText()+":"+xmlMinuto.getText()+"\nCategoria: "+xmlCategoria.getText()+"\nAppunto: "+xmlAppunto.getText()+"\n");
			}
			return clipboard.toString();
		}
		catch (Exception e) {
			return "Errore durante la lettura dal database.";
		}
	}
	
	public String readWithImportance(int importanza) {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(new File("database.xml"));
			Element root = document.getRootElement();
			List children = root.getChildren(); // Estraggo i figli dalla root
			Iterator iterator = children.iterator();
			StringBuffer clipboard = new StringBuffer("");
		
			while(iterator.hasNext()) { // Per ogni figlio ne estraggo il contenuto
				Element GjBoardContents = (Element)iterator.next();
						
				Element xmlImportanza = GjBoardContents.getChild("Importanza");
				Element xmlGiorno = GjBoardContents.getChild("Giorno");
				Element xmlMese = GjBoardContents.getChild("Mese");
				Element xmlAnno = GjBoardContents.getChild("Anno");
				Element xmlOra = GjBoardContents.getChild("Ora");
				Element xmlMinuto = GjBoardContents.getChild("Minuto");
				Element xmlCategoria = GjBoardContents.getChild("Categoria");
				Element xmlAppunto = GjBoardContents.getChild("Appunto");
				
				if(xmlImportanza.getText().equals(Integer.toString(importanza))) {
					clipboard.append("\nImportanza: "+xmlImportanza.getText()+"\nCreato il "+xmlGiorno.getText()+"/"+xmlMese.getText()+"/"+xmlAnno.getText()+" alle ore "+xmlOra.getText()+":"+xmlMinuto.getText()+"\nCategoria: "+xmlCategoria.getText()+"\nAppunto: "+xmlAppunto.getText()+"\n");
				}
			}
			return clipboard.toString();
		}
		catch (Exception e) {
			return "Errore durante la lettura dal database.";
		}
	}
}


public class GjBoard {
	public static void main(String[] args) {
		int i, scelta, testi;
		int giorno, mese, anno, ora, minuto, importanza;
		String appunto, categoria;
		Text text;
		Core core = new Core();
		Scanner scanner = new Scanner(System.in);
		Date date = new Date();
		
		System.out.println("Benvenuto in GjBoard 0.05");
		
		do {
			System.out.println("----------------------------------");
			System.out.println("\nDigita 1 per creare un testo, 2 per leggerli, 3 per filtrarli per importanza, 4 per eliminare il database e 5 per uscire:");
			scelta = scanner.nextInt();
			
			switch(scelta) {
				case 1:
					System.out.println("\nQuanti testi vuoi creare ?");
					testi = scanner.nextInt();
				
					i = 0;
					while(i < testi) {
						giorno = date.getGiorno();
						mese = date.getMese();
						anno = date.getAnno();						
						ora = date.getOra();	
						minuto =date.getMinuto();	
						
						System.out.println("\nImportanza: ");
						importanza = scanner.nextInt();
						
						System.out.println("\nCategoria: ");
						categoria = scanner.next();
						
						System.out.println("\nTesto: ");
						appunto = scanner.next();
					
						text = new Text(giorno, mese, anno, ora, minuto, importanza, appunto, categoria);
						core.newText(text);
						
						System.out.println("----------------------------------");
						i++;
					}
					if(core.newXML()) {
						System.out.println("I testi sono stati creati.");
					}
					else {
						System.out.println("Errore durante la scrittura del database.");
					}
					break;
				case 2:
					System.out.println("\n"+core.readAllTexts());
					break;
				case 3:
					System.out.println("\nImportanza: ");
					importanza = scanner.nextInt();
					String result = core.readWithImportance(importanza);
					
					if(result.isEmpty()) {
						System.out.println("Nessun appunto trovato secondo i criteri da te immessi.");
					}
					else {
						System.out.println(result);
					}
					break;
				case 4:
					if(core.deleteXML() == true) {
						System.out.println("\nIl database è stato cancellato.");
					}
					else {
						System.out.println("\nErrore durante la cancellazione del database.");
					}
					break;
				case 5:
					System.out.println("\nSee you soon :)");		
			}
		} while(scelta != 5);
	}
}
