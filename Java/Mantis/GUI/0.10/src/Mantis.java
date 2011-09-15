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
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

public class Mantis extends JFrame {
	private JSplitPane jSplitPane1;
	private final DefaultListModel model1;
	private JList jList1;
	private JPanel jPanel1;
	private JButton jButton1;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JLabel jLabel1;
	private JProgressBar jProgressBar1;
	private JSlider jSlider1;
	private JScrollPane jScrollPane1;
	
	private File file, iteratorFile;
	private String[] files;
	private int i;
	private int running = 0;
	private	ArrayList<String> paths;
	private	String path, active;
	private Core core;
	
	public Mantis() {
		super("Mantis 0.10");
		
/* <------ COMPONENTI GUI ------> */
		jSplitPane1 = new JSplitPane();
		model1 = new DefaultListModel();
		jList1 = new JList(model1);
		jPanel1 = new JPanel();
		jButton1 = new JButton("Play");
		jButton3 = new JButton("Ferma");
		jButton4 = new JButton("About");
		jButton5 = new JButton("File");
		jLabel1 = new JLabel("In attesa.");
		jProgressBar1 = new JProgressBar();
		jSlider1 = new JSlider();
		jScrollPane1 = new JScrollPane();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jSplitPane1.setRightComponent(jPanel1);
		jSplitPane1.setLeftComponent(jScrollPane1);
		jScrollPane1.setViewportView(jList1);
		
		/* Al click del bottone avvia il file inizializzato da jList */
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(running == 0) {
						core.play();
						jLabel1.setText(active+" in riproduzione...");
						running = 1;
					}
					else {
						jLabel1.setText("Già c'è un file in riproduzione, ferma quello prima di avviarne un altro.");
					}
				}
				catch(Exception a) {
					jLabel1.setText("Non è stato possibile riprodurre "+active+".");
					a.printStackTrace();
				}
					
			}
		});
		
		/* Al click del bottone stoppa il file in riproduzione */
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(running == 1) {
						core.stop();
						jLabel1.setText(active+" fermato.");
						running = 0;
					}
					else {
						jLabel1.setText("Non c'è nessun file in riproduzione.");
					}						
				}
				catch(Exception b) {
					jLabel1.setText("Non è stato possibile fermare la riproduzione di "+active+".");
					b.printStackTrace();
				}
			}
		});
		
		/* Al click di un file, lo inizializza. Ogni click corrisponde a selezione e rilascio, quindi a due valori true e false. */
		jList1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(running == 0) {
					active = (String)jList1.getSelectedValue();
					if(jList1.getValueIsAdjusting() == true) {
						core = new Core(active);		
					}
				}
			}
		});
		
		/* Al click del bottone apre un finestra dove richiede la cartella, dopodichè carica il contenuto nella jlist */
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				path = JOptionPane.showInputDialog(null, "Cartella in cui si trovano le sottocartelle con i file MP3");
				file = new File(path);
				files = file.list();
				paths = new ArrayList<String>();
				
				for(i=0; i<files.length; i++) {
					iteratorFile = new File(path+files[i]);
					if(iteratorFile.isDirectory()) {
						paths.add(path+files[i]+"/");
					}
					else {
						paths.add(path+files[i]);
					}
				}
				
				Collections.shuffle(paths); // Mischio gli elementi dell'arraylist
				Collections.shuffle(paths); // Mischio gli elementi dell'arraylist
				
				for(String p:paths) { // Per ogni directory
					iteratorFile = new File(p);
					if(iteratorFile.isDirectory()) {
						files = iteratorFile.list(); // Crea la lista dei file contenuti
						for(i=0; i<files.length; i++) { // Per ogni file...
							if(files[i].endsWith("mp3")) {
								model1.addElement(p+files[i]);
							}
						}
					}
					else {
						if(iteratorFile.toString().endsWith("mp3")) {
							model1.addElement(p);
						}
					}
				}
			}
		});
		
		/* Al click del bottone apre la finestra con l'about */
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mantis 0.10 (C) 2011\nAutore: Giovanni 'Roxas Shadow' Capuano\nDa un'idea di: Marco 'Sirius' Sirianni\nLicenza: GNU/GPLv3\nSito web: http://www.giovannicapuano.net\nChangelog: Implementazione GUI");
			}
		});

/* <------ LAYOUT ------> */
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(jPanel1Layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addComponent(jProgressBar1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
					.addComponent(jSlider1, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
					.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addGap(123, 123, 123)
						.addComponent(jButton5, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(jPanel1Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jButton1)
					.addComponent(jButton3)
					.addComponent(jLabel1))
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(jButton4)
					.addComponent(jButton5))
				.addContainerGap())
		);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jSplitPane1, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
				.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jSplitPane1, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
				.addContainerGap())
		);
	}
	
	public static void makeGUI() {
		Mantis mantis = new Mantis();
		mantis.setSize(475,475);
		mantis.setVisible(true);
	}
    
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		}
		catch(Exception e) {
			System.out.println("Inizializzazione fallita.");
		}
	}
}
