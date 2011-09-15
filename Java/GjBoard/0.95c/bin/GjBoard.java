import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GjBoard extends JFrame {
    private JTabbedPane jTabbedPane1;
    
    /* <------ TAB 1 ------> */
    private JPanel jPanel1;
    private JButton jButton1;
    private JLabel jLabel0;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JSpinner jSpinner1;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField0;
    
    /* <------ TAB 2 ------> */
    private JPanel jPanel2;
    private JList jList1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTextArea jTextArea2;
    
    /* <------ App ------>*/
	private int giorno, mese, anno, ora, minuto, importanza;
	private String appunto, categoria, titolo;
	private Text text;
	private Core core;
	private Date date;

	public GjBoard() {
            super("GjBoard 0.95c"); // Il nome dell'applicazione
        	core = new Core(); // Istanzio la classe Core
        	
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
        	
/* <------ COMPONENTI GUI ------> */
        jTabbedPane1 = new JTabbedPane();
        jPanel1 = new JPanel(new BorderLayout());
        jPanel2 = new JPanel(new BorderLayout());
        jTabbedPane1.addTab("tab1", jPanel1);
        jTabbedPane1.addTab("tab2", jPanel2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        /* <------ TAB 1 ------> */
        jLabel0 = new JLabel("Titolo");
        jLabel1 = new JLabel("Categoria");
        jLabel2 = new JLabel("Importanza");
        jLabel3 = new JLabel("Appunto");
        jTextField0 = new JTextField();
        jTextField1 = new JTextField();
        jSpinner1 = new JSpinner();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jButton1 = new JButton("Salva");
        
        jPanel1.add(jLabel0);
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        jPanel1.add(jTextField0);
        jPanel1.add(jTextField1);
        jPanel1.add(jSpinner1);
        jPanel1.add(jScrollPane1);
        jPanel1.add(jButton1);
        jScrollPane1.setViewportView(jTextArea1);
        
        /* Al click del bottone prende i dati dai textfield e dagli spinner e li invia al database. Poi avverte con un alert. */
        jButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		        core.creaDB();
		        try {
				date = new Date();
				giorno = date.getGiorno();
				mese = date.getMese();
				anno = date.getAnno();						
				ora = date.getOra();	
				minuto = date.getMinuto();
					
				importanza = (Integer)jSpinner1.getValue();
				categoria = jTextField1.getText();
				appunto = jTextArea1.getText();
				titolo = jTextField0.getText();
				
				text = new Text(giorno, mese, anno, ora, minuto, importanza, appunto, categoria, titolo);
				core.newText(text);
				
				if(core.addTexts()) {
					JOptionPane.showMessageDialog(null, "L'appunto è stato inserito nel database.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Errore durante l'inserimento dell' appunto nel database.");
				}
			}
			catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Errore nell'invio dell'input.");
			}
		}
	});
        
        /* <----- TAB 2 -----> */
        jScrollPane2 = new JScrollPane();
        jScrollPane3 = new JScrollPane();
        final DefaultListModel model = new DefaultListModel();
        jList1 = new JList(model);
        jTextArea2 = new JTextArea();
        
        /* Ad ogni scambio di tab rimuove gli elementi dal menù e li rimette prendendoli dall'arraylist di appunti */
        jTabbedPane1.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent evt) {
        		model.clear();
			for(String titoli:core.buildMenu()) {
				model.addElement(titoli.toString());
			}
		}
	});
        
        /* Al click di un elemento, lo visualizza nella textarea. Ogni click corrisponde a selezione e rilascio, quindi a due valori true e false. */
        jList1.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent e) {
        		String titolo = (String)jList1.getSelectedValue();
        		if(jList1.getValueIsAdjusting() == true) {
        			jTextArea2.setText(core.readText(titolo));
        		}
        	}
        });
        
        jPanel2.add(jList1);
        jPanel2.add(jTextArea2);
        jScrollPane2.setViewportView(jList1);
        jScrollPane3.setViewportView(jTextArea2);
        
/* <------ LAYOUT ------> */
        /* <------ TAB 1 ------> */
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                /**/.addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel0)
                                    .addComponent(jTextField0, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))/**/
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSpinner1)
                                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            /**/.addComponent(jLabel0)
                            .addComponent(jLabel2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            /**/.addComponent(jTextField0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jButton1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        /* <------ TAB 2 ------> */
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
            .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );

        GroupLayout layout2 = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout2);
        layout2.setHorizontalGroup(
            layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout2.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout2.setVerticalGroup(
            layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout2.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }
    
	public static void makeGUI() {
		GjBoard GjBoard = new GjBoard();
		GjBoard.setSize(300,400);
		GjBoard.setVisible(true);
	}
    
	public static void main(String args[]) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		}
		catch(Exception e) {}
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



class Text {
	private int giorno, mese, anno, ora, minuto, importanza;
	private String appunto, categoria, titolo;
	
	Text(int giorno, int mese, int anno, int ora, int minuto, int importanza, String appunto, String categoria, String titolo) {
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
		this.ora = ora;
		this.minuto = minuto;
		this.importanza = importanza;
		this.appunto = appunto;
		this.categoria = categoria;
		this.titolo = titolo;
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
	
	public String getTitolo() {
		return titolo;
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
	   		System.out.println("\nInizializzazione fallita.");
	   		System.exit(1);
	   	}
		catch(SQLException ex) {
	   		System.out.println("\nInizializzazione fallita.");
	   		System.exit(1);
	   	}
	}
	
	public void newText(Text text) {
		elenco.add(text);
	}
	
	public boolean creaDB() {
		try {
			query.executeUpdate("CREATE TABLE IF NOT EXISTS gjboard(importanza, giorno, mese, anno, ora, minuto, categoria, appunto, titolo)");
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
				query.executeUpdate("INSERT INTO gjboard(importanza, giorno, mese, anno, ora, minuto, categoria, appunto, titolo) VALUES ('"+t.getImportanza()+"','"+t.getGiorno()+"','"+t.getMese()+"','"+t.getAnno()+"','"+t.getOra()+"','"+t.getMinuto()+"','"+t.getCategoria()+"','"+t.getAppunto()+"','"+t.getTitolo()+"')");
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
				clipboard.append("\nTitolo: "+result.getString("titolo")+"\nImportanza: "+result.getString("importanza")+"\nCreato il "+result.getString("giorno")+"/"+result.getString("mese")+"/"+result.getString("anno")+" alle ore "+result.getString("ora")+":"+result.getString("minuto")+"\nCategoria: "+result.getString("categoria")+"\nAppunto: "+result.getString("appunto")+"\n");
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
	
	public String readText(String titolo) {
		try {
			result = query.executeQuery("SELECT * FROM gjboard WHERE titolo='"+titolo+"'");
			clipboard.setLength(0); // Svuoto lo StringBuffer
			while (result.next()) {
				clipboard.append("Titolo: "+result.getString("titolo")+"\nImportanza: "+result.getString("importanza")+"\nCreato il "+result.getString("giorno")+"/"+result.getString("mese")+"/"+result.getString("anno")+" alle ore "+result.getString("ora")+":"+result.getString("minuto")+"\nCategoria: "+result.getString("categoria")+"\nAppunto: "+result.getString("appunto")+"\n");
			}
			return clipboard.toString();
		}
		catch(SQLException ex) {
			return "Appunto non trovato.";
		}
	}
	
	/* Ritorno un arraylist di stringhe contenente il titolo di ogni appunto */
	public ArrayList<String> buildMenu() {
		try {
			result = query.executeQuery("SELECT * FROM gjboard");
			ArrayList<String> titoli = new ArrayList<String>();
			while (result.next()) {
				titoli.add(result.getString("titolo"));
			}
			
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
