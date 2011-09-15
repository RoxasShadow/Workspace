/**
    Costruisce la GUI, dichiara i listener e contiene il main.
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
	private JSpinner jSpinner1;
	private JTextArea jTextArea1;
	private JTextField jTextField0;
	private JTextField jTextField1;
	private JScrollPane jScrollPane1;
    
/* <------ TAB 2 ------> */
	private JPanel jPanel2;
	private JList jList1;
	private JTextArea jTextArea2;
	private JSplitPane jSplitPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	
    
/* <------ GJBOARD ------>*/
	private int giorno, mese, anno, ora, minuto, importanza;
	private String appunto, categoria, titolo;
	private Text text, defaultText;
	private Core core;
	private Date date;

	public GjBoard() {
		super("GjBoard 0.96"); // Il nome dell'applicazione
        	core = new Core(); // Istanzio la classe Core
        	
/* <------ COMPONENTI GUI ------> */
		jTabbedPane1 = new JTabbedPane();
		jPanel1 = new JPanel(new BorderLayout());
		jPanel2 = new JPanel(new BorderLayout());
		jTabbedPane1.addTab("Crea", jPanel1);
		jTabbedPane1.addTab("Leggi", jPanel2);
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
		
		jScrollPane1.setViewportView(jTextArea1);
		
		/* Al click del bottone prende i dati dai textfield e dagli spinner e li invia al database. Poi avverte con un alert. */
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					
					if((categoria.isEmpty()) || (appunto.isEmpty()) || (titolo.isEmpty())) {
						JOptionPane.showMessageDialog(null, "Devi compilare tutti i campi per creare un nuovo appunto.");
					}
					else {
						text = new Text(giorno, mese, anno, ora, minuto, importanza, appunto, categoria, titolo);
						if(core.newText(text) == false) {
							JOptionPane.showMessageDialog(null, "Esiste già un appunto con lo stesso titolo.");
						}
						else {
							if(core.addTexts()) {
								JOptionPane.showMessageDialog(null, "L'appunto è stato inserito nel database.");
							}
							else {
								JOptionPane.showMessageDialog(null, "Errore durante l'inserimento dell' appunto nel database.");
							}
						}
					}
				}
				catch(NumberFormatException n) {
					JOptionPane.showMessageDialog(null, "Errore nell'invio dell'input.");
				}
			}
		});
		
/* <----- TAB 2 -----> */
		final DefaultListModel model = new DefaultListModel();
		jList1 = new JList(model);
		jTextArea2 = new JTextArea();
		jSplitPane1 = new JSplitPane();
		jScrollPane2 = new JScrollPane();
		jScrollPane3 = new JScrollPane();
		jButton2 = new JButton("Esporta");
		jButton3 = new JButton("Elimina");
		jButton4 = new JButton("Elimina tutto");
		jButton5 = new JButton("About");
		
		jScrollPane2.setViewportView(jList1);
		jScrollPane3.setViewportView(jTextArea2);
		
		jSplitPane1.setLeftComponent(jScrollPane2);
		jSplitPane1.setRightComponent(jScrollPane3);
		
		/* Al click del bottone richiede il nome del file da creare e ci copia gli appunti */
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomefile = JOptionPane.showInputDialog(null, "Nome del file da creare");
				if(core.esportaAppunti(nomefile) == true) {
					JOptionPane.showMessageDialog(null, "Il file è stato creato.");
				}
				else {
					JOptionPane.showMessageDialog(null, "È accaduto un errore nella creazione del file.");
				}
			}
		});
				jTextArea2.setText("");
				model.clear();
				for(String titoli:core.buildMenu()) {
					model.addElement(titoli.toString());
				}
		
		/* Al click del bottone elimina l'appunto selezionato e aggiorna il tab */
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titolo = (String)jList1.getSelectedValue();
				core.eliminaAppunto(titolo);
				JOptionPane.showMessageDialog(null, "L'appunto è stato cancellato.");
				jTextArea2.setText("");
				model.clear();
				for(String titoli:core.buildMenu()) {
					model.addElement(titoli.toString());
				}
			}
		});
		
		/* Al click del bottone elimina tutto il contenuto del database e aggiorna il tab */
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titolo = (String)jList1.getSelectedValue();
				core.eliminaAppunti();
				JOptionPane.showMessageDialog(null, "Tutti gli appunti sono stati cancellati");
				jTextArea2.setText("");
				model.clear();
				for(String titoli:core.buildMenu()) {
					model.addElement(titoli.toString());
				}
			}
		});
		
		/* Al click del bottone apre la finestra con l'about */
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "GjBoard v0.96 (C) 2011.\nScritto da Giovanni 'Roxas Shadow' Capuano con Marco RootkitNeo.\nRilasciato sotto licenza GNU/GPLv3.\nSito web: http://www.giovannicapuano.net.");
			}
		});		
		
		/* Ad ogni scambio di tab rimuove gli elementi dal menù e li rimette prendendoli dall'arraylist di appunti */
		jTabbedPane1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				jTextArea2.setText("");
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
					jTextArea2.setText("");
					jTextArea2.setText(core.readText(titolo));
				}
			}
		});
		
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
		                        .addGap(24)
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                            .addComponent(jLabel0)
		                            .addComponent(jTextField0, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
		                        .addGap(24)
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
		                    .addComponent(jLabel0)
		                    .addComponent(jLabel2))
		                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jTextField0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		        .addContainerGap()
		        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addComponent(jSplitPane1, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
		            .addGroup(jPanel2Layout.createSequentialGroup()
		                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
		                    .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                .addGap(156, 156, 156)
		                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
		                    .addComponent(jButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    .addComponent(jButton4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
		        .addContainerGap())
		);
		jPanel2Layout.setVerticalGroup(
		    jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel2Layout.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jSplitPane1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
		        .addGap(12, 12, 12)
		        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jButton3)
		            .addComponent(jButton4))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jButton2)
		            .addComponent(jButton5))
		        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		GroupLayout layout2 = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout2);
		layout2.setHorizontalGroup(
		    layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout2.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
		        .addContainerGap())
		);
		layout2.setVerticalGroup(
		    layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout2.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
		        .addContainerGap())
		);
        
	}
    
	public static void makeGUI() {
		GjBoard GjBoard = new GjBoard();
		GjBoard.setSize(450,500);
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
