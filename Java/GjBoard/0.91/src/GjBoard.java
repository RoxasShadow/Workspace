import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
Text: Definisce le proprietà di ogni appunto;
Date: Mette a disposizione i metodi per la gestione delle date tramite GregorianCalendar;
Core: Permette di gestire l'arraylist di Text, la connessione al database e l'inserimento/visualizzazione dei record;
GUI: Definisce la GUI e permette l'interazione con l'utente;
GjBoard: Istanzia GUI e avvia GjBoard.
*/

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
	private Connection connessione;
	private Statement query;
	private ResultSet result;
	private StringBuffer clipboard;
	
	Core() {
		try {
			elenco = new ArrayList<Text>();
			clipboard = new StringBuffer("");
			Class.forName("org.sqlite.JDBC");
			connessione = DriverManager.getConnection("jdbc:sqlite:test.db");
	   		query = connessione.createStatement();
	   	}
	   	catch(ClassNotFoundException ex) {
	   		System.out.println("Inizializzazione fallita.");
	   		System.exit(1);
	   	}
		catch(SQLException ex) {
	   		System.out.println("Inizializzazione fallita.");
	   		System.exit(1);
	   	}
	}
	
	public void newText(Text text) {
		elenco.add(text);
	}
	
	public boolean creaDB() {
		try {
			query.executeUpdate("CREATE TABLE IF NOT EXISTS gjboard(importanza, giorno, mese, anno, ora, minuto, categoria, appunto)");
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	public boolean deleteDB() {
		try {
			query.executeUpdate("DROP TABLE IF EXISTS gjboard");
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	public boolean disconnettiDB() {
		try {
			result.close();
			connessione.close();
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	public boolean addTexts() {
		try {
			for(Text t:elenco) {
				query.executeUpdate("INSERT INTO gjboard(importanza, giorno, mese, anno, ora, minuto, categoria, appunto) VALUES ('"+t.getImportanza()+"','"+t.getGiorno()+"','"+t.getMese()+"','"+t.getAnno()+"','"+t.getOra()+"','"+t.getMinuto()+"','"+t.getCategoria()+"','"+t.getAppunto()+"')");
			}
			elenco.clear(); // Svuoto l'arraylist
			return true;
		}
		catch(SQLException ex) {
			return false;
		}
	}
	
	public int contaAppunti() {
		try {
			result = query.executeQuery("SELECT COUNT(*) AS alias FROM gjboard");
			clipboard.setLength(0); // Svuoto lo StringBuffer
			int appunti = 0;
			while (result.next()) {
				appunti = result.getInt("alias");
			}
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
			result = query.executeQuery("SELECT * FROM gjboard");
			clipboard.setLength(0);
			while (result.next()) {
				clipboard.append("\nImportanza: "+result.getString("importanza")+"\nCreato il "+result.getString("giorno")+"/"+result.getString("mese")+"/"+result.getString("anno")+" alle ore "+result.getString("ora")+":"+result.getString("minuto")+"\nCategoria: "+result.getString("categoria")+"\nAppunto: "+result.getString("appunto")+"\n");
			}
			
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
	
	public String readAllTexts() {
		try {
			result = query.executeQuery("SELECT * FROM gjboard");
			clipboard.setLength(0); // Svuoto lo StringBuffer
			while (result.next()) {
				clipboard.append("\nImportanza: "+result.getString("importanza")+"\nCreato il "+result.getString("giorno")+"/"+result.getString("mese")+"/"+result.getString("anno")+" alle ore "+result.getString("ora")+":"+result.getString("minuto")+"\nCategoria: "+result.getString("categoria")+"\nAppunto: "+result.getString("appunto")+"\n");
			}
			return clipboard.toString();
		}
		catch(SQLException ex) {
			return "";
		}
	}
	
	public String readWithFilter(String campo, String valore) {
		try {
			clipboard.setLength(0); // Svuoto lo StringBuffer
			result = query.executeQuery("SELECT DISTINCT * FROM gjboard WHERE "+campo+"='"+valore+"'");
			while (result.next()) {
				clipboard.append("\nImportanza: "+result.getString("importanza")+"\nCreato il "+result.getString("giorno")+"/"+result.getString("mese")+"/"+result.getString("anno")+" alle ore "+result.getString("ora")+":"+result.getString("minuto")+"\nCategoria: "+result.getString("categoria")+"\nAppunto: "+result.getString("appunto")+"\n");
			}
			return clipboard.toString();
		}
		catch(SQLException ex) {
			return "";
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
	JScrollPane scrollbar;
		
	GUI() {
		super("GjBoard 0.90");
		
		/* Istanzazioni */
		date = new Date();
		core = new Core();
  		frame = new JFrame("GjBoard 0.90");
  		panel = new JPanel();
  		ta = new JTextArea();
		
		/* Textarea */
		ta.append("Benvenuto in GjBoard 0.90\nControlla aggiornamenti: http://www.giovannicapuano.net");
		
		/* Bottoni */
		JButton button1 = new JButton("Nuovo appunto");
		button1.setToolTipText("Crea un nuovo appunto");
		JButton button2 = new JButton("Leggi gli appunti");
		button2.setToolTipText("Legge tutti gli appunti inseriti nel database");
		JButton button3 = new JButton("Filtra appunti");
		button3.setToolTipText("Legge tutti gli appunti inseriti nel database filtrandoli per campo");
		JButton button4 = new JButton("Conta appunti");
		button4.setToolTipText("Ritorna il numero di appunti presenti nel database");
		JButton button5 = new JButton("Esporta appunti");
		button5.setToolTipText("Esporta gli appunti in un file di testo");
		JButton button6 = new JButton("Elimina il database");
		button6.setToolTipText("Elimina il database");
		JButton button7 = new JButton("About");
		button7.setToolTipText("Chi è il creatore, la licenza e il TODO");
		JButton button8 = new JButton("Esci");
		button8.setToolTipText("Chiude GjBoard");
		
		/* Eventi dei bottoni */
		button1.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
				core.creaDB();
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
				
				if(core.addTexts()) {
					if(testi == 1) {
						ta.append("\nL'appunto è stato inserito nel database.");
					}
					else {
						ta.append("\nGli appunti sono stati inseriti nel database.");
					}
				}
				else {
					if(testi == 1) {
						ta.append("\nErrore durante l'inserimento dell' appunto nel database.");
					}
					else {
						ta.append("\nErrore durante l'inserimento degli appunti nel database.");
					}
				}
		        }
		});
		
		button2.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	if(core.readAllTexts().isEmpty()) {
		        		ta.append("\nIl database risulta vuoto.");
		        	}
		        	else {
					ta.append("\n"+core.readAllTexts());
				}
		        }
		});
		
		button3.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
					String filtro = JOptionPane.showInputDialog(null, "Campo (ex: categoria):");
					String valore = JOptionPane.showInputDialog(null, "Valore (ex: Cose da fare):");
					String result = core.readWithFilter(filtro, valore);
					
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
		        	if((core.contaAppunti() == 0) || (core.contaAppunti() == -1)) {
					ta.append("\nAttualmente non è presente nessun appunto.");
				}
				else if(core.contaAppunti() == 1) {
					ta.append("\nAttualmente è presente un solo appunto.");
				}
				else {
					ta.append("\nAttualmente sono presenti "+core.contaAppunti()+" appunti.");
				}
		        }
		});
		
		button5.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		     		String nome = JOptionPane.showInputDialog(null, "Nome del file da creare");
		     		
				if(core.esportaAppunti(nome) == true) {
					ta.append("\nIl file è stato creato.");
				}
				else {
					ta.append("\nErrore durante la creazione del file.");
				}
		        }
		});
		
		button6.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
				if(core.deleteDB() == true) {
					ta.append("\nIl database è stato cancellato.");
				}
				else {
					ta.append("\nErrore durante la cancellazione del database.");
				}
				
				if(core.creaDB() == false) {
					ta.append("\nErrore durante la ricreazione del database.");
				}
		        }
		});
		
		button7.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	ta.append("\nVuoi contattarmi? Invia una email a webmaster@giovannicapuano.net\n\nGjBoard è rilasciato sotto licenza GNU/GPLv3 (http://www.gnu.org/licenses/gpl-3.0.txt).\nSQLite è rilasciato sotto licenza BSD (http://www.zentus.com/sqlitejdbc/)");
		        }
		});
		
		button8.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	if(core.disconnettiDB()) {
		        		ta.append("\nChiusura database...");
		        		System.exit(0);
		        	}
		        	else {
		        		ta.append("\nIl database non è stato chiuso con successo.");
		        		System.exit(1);
		        	}
		        }
		});
           
           
           	/* Grafica */
           	this.getContentPane().add(ta);
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Scrollbar */
		scrollbar = new JScrollPane(ta);
		setPreferredSize(new Dimension(450, 110));
		add(scrollbar, BorderLayout.CENTER);
		
  		panel.setSize(800, 800);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
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
