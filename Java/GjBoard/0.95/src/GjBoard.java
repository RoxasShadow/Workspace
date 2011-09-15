import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
Text: Definisce le proprietà di ogni appunto;
Date: Mette a disposizione i metodi per la gestione delle date tramite GregorianCalendar;
Core: Permette di gestire l'arraylist di Text, la connessione al database e l'inserimento/visualizzazione dei record;
GjBoard: Costruisce la GUI, dichiara i listener e contiene il main.
*/

class GjBoard extends JFrame {
	JMenuBar jMenuBar1; // Menù
	JMenu jMenu1; // Menù Appunti
    	JMenu jMenu2; // Menù About
	JMenuItem jMenuItem1; // Bottoni del menù
	JMenuItem jMenuItem2;
	JMenuItem jMenuItem3;
	JMenuItem jMenuItem4;
	JMenuItem jMenuItem5;
	JMenuItem jMenuItem6;
	JMenuItem jMenuItem7;
	JMenuItem jMenuItem8;
	JMenuItem jMenuItem9;
	JTextArea textarea; // JTextarea
	int i, scelta, testi;
	int giorno, mese, anno, ora, minuto, importanza;
	String appunto, categoria;
	Text text;
	Core core;
	Date date;
	
	public GjBoard() {
        	super("GjBoard 0.95"); // Il nome dell'applicazione
        	initComponents(); // Inizializza i componenti della GUI
        	core = new Core(); // Istanzio la classe Core...
        	date = new Date(); // ... e Date
	}

	private void initComponents() {
		jMenuBar1 = new JMenuBar(); 
		jMenu1 = new JMenu();
		jMenu2 = new JMenu();
		jMenuItem1 = new JMenuItem();
		jMenuItem2 = new JMenuItem();
		jMenuItem3 = new JMenuItem();
		jMenuItem4 = new JMenuItem();
		jMenuItem5 = new JMenuItem();
		jMenuItem6 = new JMenuItem();
		jMenuItem7 = new JMenuItem();
		jMenuItem8 = new JMenuItem();
		jMenuItem9 = new JMenuItem();
		textarea = new JTextArea("Benvenuto in GjBoard 0.95");
		textarea.setEditable(false); // Textarea di sola lettura
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// Ridefinisco windowClosing()
		this.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        	if(core.disconnettiDB()) {
		        		System.exit(0);
		        	}
		        	else {
		        		System.out.println("\nIl database non è stato chiuso.");
		        		System.exit(1);
		        	}
		      }
		});

		/* Creo il testo e la scorciatoria per ogni bottone e lo aggiungo al menù */
		/* Appunti */
		jMenu1.setText("Appunti");

		jMenuItem1.setText("Crea");
		jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK)); // Scorciatoia Ctrl+C
		jMenu1.add(jMenuItem1);

		jMenuItem2.setText("Leggi");
		jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
		jMenu1.add(jMenuItem2);

		jMenuItem3.setText("Filtra");
		jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
		jMenu1.add(jMenuItem3);

		jMenuItem4.setText("Conta");
		jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
		jMenu1.add(jMenuItem4);

		jMenuItem5.setText("Esporta");
		jMenuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
		jMenu1.add(jMenuItem5);

		jMenuItem6.setText("Elimina");
		jMenuItem6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
		jMenu1.add(jMenuItem6);

		jMenuItem7.setText("Pulisci");
		jMenuItem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
		jMenu1.add(jMenuItem7);

		jMenuItem8.setText("Esci");
		jMenuItem8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
		jMenu1.add(jMenuItem8);

		jMenuBar1.add(jMenu1);

		/* About */
		jMenu2.setText("?");

		jMenuItem9.setText("About");
		jMenuItem9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
		jMenu2.add(jMenuItem9);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		/* Textarea */
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(textarea, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
				.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(textarea, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
				.addContainerGap())
		);
		pack();
	
		/* Listeners */
		/* Crea appunto: Crea il database se non essite, richiede i vari dati e aggiunge ogni appunto creato all'arraylist di Text.
				 Poi aggiunge al database. */
		jMenuItem1.addActionListener(new ActionListener() {
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
						textarea.append("\nL'appunto è stato inserito nel database.");
					}
					else {
						textarea.append("\nGli appunti sono stati inseriti nel database.");
					}
				}
				else {
					if(testi == 1) {
						textarea.append("\nErrore durante l'inserimento dell' appunto nel database.");
					}
					else {
						textarea.append("\nErrore durante l'inserimento degli appunti nel database.");
					}
				}
		        }
		});
		
		/* Leggi appunti */
		jMenuItem2.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	if(core.readAllTexts().isEmpty()) {
		        		textarea.append("\nIl database risulta vuoto.");
		        	}
		        	else {
					textarea.append("\n"+core.readAllTexts());
				}
			}
		});
		
		/* Filtra appunti: Cerca gli appunti che hanno un dato valore ad un dato campo del database */
		jMenuItem3.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
					String filtro = JOptionPane.showInputDialog(null, "Campo (ex: categoria):");
					String valore = JOptionPane.showInputDialog(null, "Valore (ex: Cose da fare):");
					String result = core.readWithFilter(filtro, valore);
					
					if(result.isEmpty()) {
						textarea.append("\nNessun appunto trovato secondo i criteri da te immessi.");
					}
					else {
						textarea.append(result);
					}
			}
		});
		
		/* Conta appunti */
		jMenuItem4.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	if((core.contaAppunti() == 0) || (core.contaAppunti() == -1)) {
					textarea.append("\nAttualmente non è presente nessun appunto.");
				}
				else if(core.contaAppunti() == 1) {
					textarea.append("\nAttualmente è presente un solo appunto.");
				}
				else {
					textarea.append("\nAttualmente sono presenti "+core.contaAppunti()+" appunti.");
				}
			}
		});
		
		/* Esporta appunti: Copia gli appunti in un file di testo dal nome definito dall'utente */
		jMenuItem5.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		     		String nome = JOptionPane.showInputDialog(null, "Nome del file da creare");
		     		
				if(core.esportaAppunti(nome) == true) {
					textarea.append("\nIl file è stato creato.");
				}
				else {
					textarea.append("\nErrore durante la creazione del file.");
				}
			}
		});
		
		/* Elimina appunti: Cancella il database degli appunti */
		jMenuItem6.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
				if(core.deleteDB() == true) {
					textarea.append("\nIl database è stato cancellato.");
				}
				else {
					textarea.append("\nErrore durante la cancellazione del database.");
				}
				
				if(core.creaDB() == false) {
					textarea.append("\nErrore durante la ricreazione del database.");
				}
			}
		});
		
		/* Pulisci schermata: Pulisce la textarea */
		jMenuItem7.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
				textarea.setText("");
			}
		});
		
		/* Esci: Chiude l'applicazione disconnettendosi dal database*/
		jMenuItem8.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	if(core.disconnettiDB()) {
		        		System.exit(0);
		        	}
		        	else {
		        		System.out.println("\nIl database non è stato chiuso.");
		        		System.exit(1);
		        	}
			}
		});
		
		/* About */
		jMenuItem9.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
				textarea.append("\nVuoi contattarmi? Invia una email a webmaster@giovannicapuano.net\n\nGjBoard 0.95 è rilasciato sotto licenza GNU/GPLv3 (http://www.gnu.org/licenses/gpl-3.0.txt).\nSQLite è rilasciato sotto licenza BSD (http://www.zentus.com/sqlitejdbc/)");
			}
		});
	}
	
	public static void lancia() {
		GjBoard gjboard = new GjBoard();
		gjboard.pack();
		gjboard.setVisible(true);
	}
	
	public static void main(String args[]) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					lancia();
				}
			});
		}
		catch(Exception a) {}
	}
}



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
