/**
	Pokedex.java
	(C) Giovanni Capuano 2011
*/
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Pokedex extends JFrame implements ProjectGUI {
	private final Utils utils;
	private	Database db;
	private JPanel jPanel1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel jLabel13;
	private JLabel jLabel14;
	private JLabel jLabel15;
	private JLabel jLabel16;
	private JLabel jLabel17;
	private JLabel jLabel18;
	private JLabel jLabel19;
	private JLabel jLabel20;
	private JButton jButton1;
	private JList jList1;
	private JList jList2;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JSplitPane jSplitPane1;
	
	public Pokedex(Database db, Utils utils) {
		super("Pokédex - Project G - Development version");
		setVisible(true);
		setFocusable(true);
		this.utils = utils;
		this.db = db;
		initComponents();
	}
	
	private void loadPokemon() {
		final String selectedPokemon = (String)jList1.getSelectedValue();
		Map<String, Map<String, ArrayList<String>>> specialmoves = db.getSpecialMoves();
		ArrayList<String> types = db.getTypes();
		ArrayList<String> abilities = db.getAbilities();
		
		/* Ottenimento dati */
		Map<String, Map<String, String>> pokemonList = db.getPokemon();
		Map<String, Map<String, String>> moveListById = db.getMovesById();
		
		Map<String, ArrayList<String>> levelupList = specialmoves.get("levelup");
		Map<String, ArrayList<String>> dwList = specialmoves.get("dw");
		Map<String, ArrayList<String>> eggList = specialmoves.get("egg");
		Map<String, ArrayList<String>> preevoList = specialmoves.get("preevo");
		Map<String, ArrayList<String>> specialList = specialmoves.get("special");
		Map<String, ArrayList<String>> tmhmList = specialmoves.get("tmhm");
		Map<String, ArrayList<String>> tutorList = specialmoves.get("tutor");
		
		/* Prelievo selezione */
		Map<String, String> pokemonInfo = pokemonList.get(selectedPokemon);
		
		ArrayList<String> levelupInfo = levelupList.get(pokemonInfo.get("number"));
		ArrayList<String> dwInfo = dwList.get(pokemonInfo.get("number"));
		ArrayList<String> eggInfo = eggList.get(pokemonInfo.get("number"));
		ArrayList<String> preevoInfo = preevoList.get(pokemonInfo.get("number"));
		ArrayList<String> specialInfo = specialList.get(pokemonInfo.get("number"));
		ArrayList<String> tmhmInfo = tmhmList.get(pokemonInfo.get("number"));
		ArrayList<String> tutorInfo = tutorList.get(pokemonInfo.get("number"));
		
		jLabel2.setText(pokemonInfo.get("name"));
		jLabel4.setText(pokemonInfo.get("number"));
		jLabel6.setText(types.get(Integer.parseInt(pokemonInfo.get("type1")))+((types.get(Integer.parseInt(pokemonInfo.get("type2"))).equals("???")) ? "" : "-"+types.get(Integer.parseInt(pokemonInfo.get("type2")))));
		jLabel8.setText(abilities.get(Integer.parseInt(pokemonInfo.get("ability1")))+((abilities.get(Integer.parseInt(pokemonInfo.get("ability2"))).equals("")) ? "" : "-"+abilities.get(Integer.parseInt(pokemonInfo.get("ability2")))));
		jLabel10.setText(pokemonInfo.get("hp"));
		jLabel12.setText(pokemonInfo.get("atk"));
		jLabel14.setText(pokemonInfo.get("def"));
		jLabel16.setText(pokemonInfo.get("spatk"));
		jLabel18.setText(pokemonInfo.get("spdef"));
		jLabel20.setText(pokemonInfo.get("spe"));
		
		/* Button */
		jButton1.setVisible(true);
		if((utils.initOnline()) && (utils.isOnline(selectedPokemon))) {
			jButton1.setText("Check "+selectedPokemon+" out on DoomDesire");
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						utils.openURL(utils.getOnlinePattern(selectedPokemon.toLowerCase()));
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Error in opening browser.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		else {
			jButton1.setText("");
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//
				}
			});
		}
		if(utils.isArtwork(Integer.parseInt(pokemonInfo.get("number"))))
			jButton1.setIcon(utils.getArtwork(Integer.parseInt(pokemonInfo.get("number")))); // Artworks are ordinated for numbers.
		else
			jButton1.setVisible(false);
		/* /Button */
		
		ArrayList<String> moveList = new ArrayList<String>();
		Map<String, String> tmp;
		int i, count;
		if(levelupInfo != null) {
			moveList.add("<html><font color=\"red\"><right>---Level up---</right></font></html>");
			for(i=0, count=levelupInfo.size(); i<count; ++i) {
				tmp = moveListById.get(levelupInfo.get(i));
				if(tmp != null)
					moveList.add(tmp.get("name"));
			}
		}
		if(dwInfo != null) {
			moveList.add("<html><font color=\"red\">---Dream world---</font></html>");
			for(i=0, count=dwInfo.size(); i<count; ++i) {
				tmp = moveListById.get(dwInfo.get(i));
				if(tmp != null)
					moveList.add(tmp.get("name"));
			}
		}
		if(eggInfo != null) {
			moveList.add("<html><font color=\"red\">---By egg---</font></html>");
			for(i=0, count=eggInfo.size(); i<count; ++i) {
				tmp = moveListById.get(eggInfo.get(i));
				if(tmp != null)
					moveList.add(tmp.get("name"));
			}
		}
		if(preevoInfo != null) {
			moveList.add("<html><font color=\"red\">---Pre-evolution---</font></html>");
			for(i=0, count=preevoInfo.size(); i<count; ++i) {
				tmp = moveListById.get(preevoInfo.get(i));
				if(tmp != null)
					moveList.add(tmp.get("name"));
			}
		}
		if(specialInfo != null) {
			moveList.add("<html><font color=\"red\">---Special---</font></html>");
			for(i=0, count=specialInfo.size(); i<count; ++i) {
				tmp = moveListById.get(specialInfo.get(i));
				if(tmp != null)
					moveList.add(tmp.get("name"));
			}
		}
		if(tmhmInfo != null) {
			moveList.add("<html><font color=\"red\">---TM-HM---</font></html>");
			for(i=0, count=tmhmInfo.size(); i<count; ++i) {
				tmp = moveListById.get(tmhmInfo.get(i));
				if(tmp != null)
					moveList.add(tmp.get("name"));
			}
		}
		if(tutorInfo != null) {
			moveList.add("<html><font color=\"red\">---Tutor---</font></html>");
			for(i=0, count=tutorInfo.size(); i<count; ++i) {
				tmp = moveListById.get(tutorInfo.get(i));
				if(tmp != null)
					moveList.add(tmp.get("name"));
			}
		}
			
		final Object[] moveArrList = moveList.toArray();			
		jList2.setModel(new AbstractListModel() {
		    public int getSize() {
			return moveArrList.length;
		    }
		    public Object getElementAt(int i) {
		    	return moveArrList[i];
		    }
		});
		pack(); // jButton1 can be now (un)visible and the GUI must be repacked. 
	}
		
	private void initComponents() {
		jPanel1 = new JPanel();
		jSplitPane1 = new JSplitPane();
		jScrollPane1 = new JScrollPane();
		jList1 = new JList();
		jLabel1 = new JLabel("Name:");
		jLabel2 = new JLabel();
		jLabel3 = new JLabel("Number:");
		jLabel4 = new JLabel();
		jLabel5 = new JLabel("Type:");
		jLabel6 = new JLabel();
		jLabel7 = new JLabel("Ability:");
		jLabel8 = new JLabel();
		jLabel9 = new JLabel("HP:");
		jLabel10 = new JLabel();
		jLabel11 = new JLabel("Attack:");
		jLabel12 = new JLabel();
		jLabel13 = new JLabel("Defense:");
		jLabel14 = new JLabel();
		jLabel15 = new JLabel("Special Attack:");
		jLabel16 = new JLabel();
		jLabel17 = new JLabel("Special Defense:");
		jLabel18 = new JLabel();
		jLabel19 = new JLabel("Speed:");
		jLabel20 = new JLabel();
		jButton1 = new JButton("");
		jScrollPane2 = new JScrollPane();
		jList2 = new JList();

		jButton1.setVisible(false);
		
		jScrollPane1.setViewportView(jList1);
		jSplitPane1.setLeftComponent(jScrollPane1);
		jSplitPane1.setRightComponent(jPanel1);
		jScrollPane2.setViewportView(jList2);
		
		final Object[] pokemonList = utils.getMapAsArray(db.getPokemon(), "name");
		
		jList1.setModel(new AbstractListModel() {
		    public int getSize() {
		    	return pokemonList.length;
		    }
		    
		    public Object getElementAt(int i) {
		    	return pokemonList[i];
		    }
		});
		
		jList1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				loadPokemon();
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
		    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addContainerGap()
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
		                    .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
		                    .addGroup(jPanel1Layout.createSequentialGroup()
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                            .addComponent(jLabel9)
		                            .addComponent(jLabel7)
		                            .addComponent(jLabel11)
		                            .addComponent(jLabel13)
		                            .addComponent(jLabel15)
		                            .addComponent(jLabel17)
		                            .addComponent(jLabel19)
		                            .addComponent(jLabel1)
		                            .addComponent(jLabel3)
		                            .addComponent(jLabel5))
		                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                            .addComponent(jLabel10)
		                            .addComponent(jLabel8)
		                            .addComponent(jLabel6)
		                            .addComponent(jLabel4)
		                            .addComponent(jLabel2)
		                            .addComponent(jLabel20)
		                            .addComponent(jLabel18)
		                            .addComponent(jLabel16)
		                            .addComponent(jLabel14)
		                            .addComponent(jLabel12))))
		                .addGap(204, 204, 204))
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addComponent(jButton1)
		                .addContainerGap(414, Short.MAX_VALUE))))
		);
		jPanel1Layout.setVerticalGroup(
		    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addContainerGap()
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel1)
		            .addComponent(jLabel2))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel3)
		            .addComponent(jLabel4))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel5)
		            .addComponent(jLabel6))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel7)
		            .addComponent(jLabel8))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel9)
		            .addComponent(jLabel10))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel11)
		            .addComponent(jLabel12))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel13)
		            .addComponent(jLabel14))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel15)
		            .addComponent(jLabel16))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel17)
		            .addComponent(jLabel18))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel19)
		            .addComponent(jLabel20))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addComponent(jButton1))
		);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
		    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jSplitPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
		    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jSplitPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pack();
	}
}
