import java.io.*;
import org.jdom.*;
import org.jdom.output.*;
import org.jdom.input.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


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
			java.util.List children = root.getChildren(); // Estraggo i figli dalla root utilizzando la list di util
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
			java.util.List children = root.getChildren(); // Estraggo i figli dalla root utilizzando la list di util
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


class GUI extends JFrame {
	int i, scelta, testi;
	int giorno, mese, anno, ora, minuto, importanza;
	String appunto, categoria;
	Text text;
	Core core;
	Date date;
	JFrame frame;
	JPanel panel;
	JTextArea ta;
		
	GUI() {
		super("GjBoard");
		
		/* Istanzazioni */
		date = new Date();
		core = new Core();
  		frame = new JFrame("GjBoard");
  		panel = new JPanel();
  		ta = new JTextArea();
		
		/* Textarea */
		ta.append("Welcome in GjBoard.");
		
		/* Bottoni */
		JButton button1 = new JButton("Nuovo appunto"); // Label
		button1.setToolTipText("Crea un nuovo appunto"); // Aiuto
		JButton button2 = new JButton("Leggi gli appunti");
		button2.setToolTipText("Legge tutti gli appunti inseriti nel database");
		JButton button3 = new JButton("Filtra per importanza");
		button3.setToolTipText("Legge tutti gli appunti inseriti nel database che hanno una data importanza");
		JButton button4 = new JButton("Elimina il database");
		button4.setToolTipText("Elimina il database");
		JButton button5 = new JButton("About");
		button5.setToolTipText("Chi è il creatore, la licenza e il TODO");
		JButton button6 = new JButton("Esci");
		button6.setToolTipText("Chiude GjBoard");
		
		/* Eventi dei bottoni */
		button1.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) { // Al click
				testi = Integer.parseInt(JOptionPane.showInputDialog(null, "Appunti da creare"));
				i = 0;
				
				while(i < testi) {
					giorno = date.getGiorno();
					mese = date.getMese();
					anno = date.getAnno();						
					ora = date.getOra();	
					minuto = date.getMinuto();	
						
					importanza = Integer.parseInt(JOptionPane.showInputDialog(null, "Importanza:"));
					categoria = JOptionPane.showInputDialog(null, "Categoria");
					appunto = JOptionPane.showInputDialog(null, "Appunto");
					
					text = new Text(giorno, mese, anno, ora, minuto, importanza, appunto, categoria);
					core.newText(text);
					i++;
				}
				if(core.newXML()) {
					ta.append("\nI testi sono stati creati.");
				}
				else {
					ta.append("\nErrore durante la scrittura del database.");
				}
		        }
		});
		
		button2.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
				ta.append("\n"+core.readAllTexts());
		        }
		});
		
		button3.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
					importanza = Integer.parseInt(JOptionPane.showInputDialog(null, "Importanza:"));
					String result = core.readWithImportance(importanza);
					
					if(result.isEmpty()) {
						ta.append("\nNessun appunto trovato secondo i criteri da te immessi.");
					}
					else {
						ta.append(result);
					}
		        }
		});
		
		button4.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
				if(core.deleteXML() == true) {
					ta.append("\nIl database è stato cancellato.");
				}
				else {
					ta.append("\nErrore durante la cancellazione del database.");
				}
		        }
		});
		
		button5.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	ta.append("\nVuoi contattarmi? Inviami una email a webmaster@giovannicapuano.net\n\nTODO:\n\nGjBoard è rilasciato sotto licenza GNU/GPLv3 (http://www.gnu.org/licenses/gpl-3.0.txt)");
		        }
		});
		
		button6.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	ta.append("\nSee you soon :)");
		        	System.exit(0);
		        }
		});
           
           
           	/* Grafica */
           	this.getContentPane().add(ta);
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
  		panel.setSize(800, 800);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}


class GjBoard {
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
}
