/**
	Pokedex.java
	(C) Giovanni Capuano 2011
*/
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

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
	private Map<String, Map<String, String>> pokemonList;
	
	public Pokedex(Database db, Utils utils) {
		super("Pokédex - Project G - Development version");
		setVisible(true);
		setFocusable(true);
		this.utils = utils;
		this.db = db;
		pokemonList = db.getPokemon();
		initComponents();
	}
	
	private void loadPokemon() {
		final String selectedPokemon = (String)jList1.getSelectedValue();
		Map<String, Map<String, ArrayList<String>>> specialmoves = db.getSpecialMoves();
		ArrayList<String> types = db.getTypes();
		Object[] abilities = db.getAbilitiesById().toArray();
		Map<String, Map<String, String>> moveListById = db.getMovesById();
		Map<String, String> pokemonInfo = pokemonList.get(selectedPokemon);
		
		ArrayList<String> levelupInfo = specialmoves.get("levelup").get(pokemonInfo.get("number"));
		ArrayList<String> dwInfo = specialmoves.get("dw").get(pokemonInfo.get("number"));
		ArrayList<String> eggInfo = specialmoves.get("egg").get(pokemonInfo.get("number"));
		ArrayList<String> preevoInfo = specialmoves.get("preevo").get(pokemonInfo.get("number"));
		ArrayList<String> specialInfo = specialmoves.get("special").get(pokemonInfo.get("number"));
		ArrayList<String> tmhmInfo = specialmoves.get("tmhm").get(pokemonInfo.get("number"));
		ArrayList<String> tutorInfo = specialmoves.get("tutor").get(pokemonInfo.get("number"));
		
		jLabel2.setText(pokemonInfo.get("name"));
		jLabel4.setText(pokemonInfo.get("number"));
		jLabel6.setText(types.get(Integer.parseInt(pokemonInfo.get("type1")))+((types.get(Integer.parseInt(pokemonInfo.get("type2"))).equals("???")) ? "" : "-"+types.get(Integer.parseInt(pokemonInfo.get("type2")))));
		jLabel8.setText(abilities[Integer.parseInt(pokemonInfo.get("ability1"))]+((abilities[Integer.parseInt(pokemonInfo.get("ability2"))].equals("")) ? "" : "-"+abilities[Integer.parseInt(pokemonInfo.get("ability2"))]));
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
		
		ArrayList<String> levelupList = new ArrayList<String>();
		ArrayList<String> dwList = new ArrayList<String>();
		ArrayList<String> eggList = new ArrayList<String>();
		ArrayList<String> preevoList = new ArrayList<String>();
		ArrayList<String> specialList = new ArrayList<String>();
		ArrayList<String> tmhmList = new ArrayList<String>();
		ArrayList<String> tutorList = new ArrayList<String>();
		Map<String, String> tmp;
		if(levelupInfo != null) {
			for(int i=0, count=levelupInfo.size(); i<count; ++i) {
				tmp = moveListById.get(levelupInfo.get(i));
				if(tmp != null)
					levelupList.add(tmp.get("name"));
			}
			Collections.sort(levelupList);
			levelupList.add(0, "<html><font color=\"red\"><right>---Level up---</right></font></html>");
		}
		if(dwInfo != null) {
			for(int i=0, count=dwInfo.size(); i<count; ++i) {
				tmp = moveListById.get(dwInfo.get(i));
				if(tmp != null)
					dwList.add(tmp.get("name"));
			}
			Collections.sort(dwList);
			dwList.add(0, "<html><font color=\"red\">---Dream world---</font></html>");
		}
		if(eggInfo != null) {
			for(int i=0, count=eggInfo.size(); i<count; ++i) {
				tmp = moveListById.get(eggInfo.get(i));
				if(tmp != null)
					eggList.add(tmp.get("name"));
			}
			Collections.sort(eggList);
			eggList.add(0, "<html><font color=\"red\">---By egg---</font></html>");
		}
		if(preevoInfo != null) {
			for(int i=0, count=preevoInfo.size(); i<count; ++i) {
				tmp = moveListById.get(preevoInfo.get(i));
				if(tmp != null)
					preevoList.add(tmp.get("name"));
			}
			Collections.sort(preevoList);
			preevoList.add(0, "<html><font color=\"red\">---Pre-evolution---</font></html>");
		}
		if(specialInfo != null) {
			for(int i=0, count=specialInfo.size(); i<count; ++i) {
				tmp = moveListById.get(specialInfo.get(i));
				if(tmp != null)
					specialList.add(tmp.get("name"));
			}
			Collections.sort(specialList);
			specialList.add(0, "<html><font color=\"red\">---Special---</font></html>");
		}
		if(tmhmInfo != null) {
			for(int i=0, count=tmhmInfo.size(); i<count; ++i) {
				tmp = moveListById.get(tmhmInfo.get(i));
				if(tmp != null)
					tmhmList.add(tmp.get("name"));
			}
			Collections.sort(tmhmList);
			tmhmList.add(0, "<html><font color=\"red\">---TM-HM---</font></html>");
		}
		if(tutorInfo != null) {
			for(int i=0, count=tutorInfo.size(); i<count; ++i) {
				tmp = moveListById.get(tutorInfo.get(i));
				if(tmp != null)
					tutorList.add(tmp.get("name"));
			}
			Collections.sort(tutorList);
			tutorList.add(0, "<html><font color=\"red\">---Tutor---</font></html>");
		}
	
		ArrayList<String> moveList = new ArrayList<String>();
		for(int i=0, count=levelupList.size(); i<count; ++i)
			moveList.add(levelupList.get(i));
		for(int i=0, count=dwList.size(); i<count; ++i)
			moveList.add(dwList.get(i));
		for(int i=0, count=eggList.size(); i<count; ++i)
			moveList.add(eggList.get(i));
		for(int i=0, count=preevoList.size(); i<count; ++i)
			moveList.add(preevoList.get(i));
		for(int i=0, count=specialList.size(); i<count; ++i)
			moveList.add(specialList.get(i));
		for(int i=0, count=tmhmList.size(); i<count; ++i)
			moveList.add(tmhmList.get(i));
		for(int i=0, count=tutorList.size(); i<count; ++i)
			moveList.add(tutorList.get(i));
		
		final Object[] moveArrList = moveList.toArray();			
		jList2.setModel(new AbstractListModel() {
		    public int getSize() {
			return moveArrList.length;
		    }
		    public Object getElementAt(int i) {
		    	return moveArrList[i];
		    }
		});
		pack();
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
		
		final Object[] pokemonArrList = utils.getMapAsArray(pokemonList, "name");
		
		jList1.setModel(new AbstractListModel() {
		    public int getSize() {
		    	return pokemonArrList.length;
		    }
		    
		    public Object getElementAt(int i) {
		    	return pokemonArrList[i];
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
