/**
	Movedex.java
	(C) Giovanni Capuano 2011
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Movedex extends JFrame implements ProjectGUI {
	private final Utils utils;
	private Database db;
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
	private JLabel jLabel21;
	private JLabel jLabel22;
	private JLabel jLabel23;
	private JLabel jLabel24;
	private JList jList1;
	private JList jList2;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JSplitPane jSplitPane1;
	private ArrayList<String> types;
	private Map<String, Map<String, ArrayList<String>>> specialmoves;
	private Map<String, Map<String, String>> pokemonbyid;
	private Map<String, ArrayList<String>> levelup, dw, egg, preevo, special, tmhm, tutor;

	public Movedex(Database db, Utils utils) {
		super("Movedex - Project G - Development version");
		setVisible(true);
		setFocusable(true);
		this.utils = utils;
		this.db = db;
		initComponents();
		types = db.getTypes();
		specialmoves = db.getSpecialMoves();
		levelup = specialmoves.get("levelup");
		dw = specialmoves.get("dw");
		egg = specialmoves.get("egg");
		preevo = specialmoves.get("preevo");
		special = specialmoves.get("special");
		tmhm = specialmoves.get("tmhm");
		tutor = specialmoves.get("tutor");
		pokemonbyid = db.getPokemonById();
	}

	private void loadMove() {
		Map<String, String> moves = db.getMoves().get((String)jList1.getSelectedValue());
		ArrayList<String> moveList = new ArrayList<String>();
		ArrayList<String> pokemonList = new ArrayList<String>();

		String moveId = Integer.toString(Integer.parseInt(moves.get("number")) + 1);

		jLabel2.setText(moves.get("name"));
		jLabel4.setText(moves.get("description"));
		jLabel6.setText(moves.get("accuracy"));
		jLabel8.setText(moves.get("criticalhit"));
		jLabel10.setText(moves.get("effect"));
		jLabel12.setText(moves.get("flinch"));
		jLabel14.setText(moves.get("healing"));
		jLabel16.setText(moves.get("power"));
		jLabel18.setText(moves.get("pp"));
		jLabel20.setText(moves.get("priority"));
		jLabel22.setText(moves.get("recoil"));
		jLabel24.setText(types.get(Integer.parseInt(moves.get("type"))));

		for(Iterator i=levelup.keySet().iterator(); i.hasNext();) {
			String key = (String)(i.next());
			ArrayList<String> value = levelup.get(key);
			for(int j=0, k=value.size(); j < k; ++j)
				if(value.get(j).equals(moveId)) {
					moveList.add(key);
					break;
				}
		}
		for(Iterator i=dw.keySet().iterator(); i.hasNext();) {
			String key = (String)(i.next());
			ArrayList<String> value = dw.get(key);
			for(int j=0, k=value.size(); j < k; ++j)
				if(value.get(j).equals(moveId)) {
					moveList.add(key);
					break;
				}
		}
		for(Iterator i=egg.keySet().iterator(); i.hasNext();) {
			String key = (String)(i.next());
			ArrayList<String> value = egg.get(key);
			for(int j=0, k=value.size(); j < k; ++j)
				if(value.get(j).equals(moveId)) {
					moveList.add(key);
					break;
				}
		}
		for(Iterator i=preevo.keySet().iterator(); i.hasNext();) {
			String key = (String)(i.next());
			ArrayList<String> value = preevo.get(key);
			for(int j=0, k=value.size(); j < k; ++j)
				if(value.get(j).equals(moveId)) {
					moveList.add(key);
					break;
				}
		}
		for(Iterator i=special.keySet().iterator(); i.hasNext();) {
			String key = (String)(i.next());
			ArrayList<String> value = special.get(key);
			for(int j=0, k=value.size(); j < k; ++j)
				if(value.get(j).equals(moveId)) {
					moveList.add(key);
					break;
				}
		}
		for(Iterator i=tmhm.keySet().iterator(); i.hasNext();) {
			String key = (String)(i.next());
			ArrayList<String> value = tmhm.get(key);
			for(int j=0, k=value.size(); j < k; ++j)
				if(value.get(j).equals(moveId)) {
					moveList.add(key);
					break;
				}
		}
		for(Iterator i=tutor.keySet().iterator(); i.hasNext();) {
			String key = (String)(i.next());
			ArrayList<String> value = tutor.get(key);
			for(int j=0, k=value.size(); j < k; ++j)
				if(value.get(j).equals(moveId)) {
					moveList.add(key);
					break;
				}
		}
		
		for(int i=0, j=moveList.size(); i<j; ++i) {
			Map<String, String> move = pokemonbyid.get(moveList.get(i));
			if(move != null)
				pokemonList.add(move.get("name"));
		}
		
		final Object[] pokemonArrList = pokemonList.toArray();
		Arrays.sort(pokemonArrList);

		jList2.setModel(new AbstractListModel() {
			public int getSize() {
				return pokemonArrList.length;
			}
			public Object getElementAt(int i) {
				return pokemonArrList[i];
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
		jLabel3 = new JLabel("Description:");
		jLabel4 = new JLabel();
		jLabel5 = new JLabel("Accuracy:");
		jLabel6 = new JLabel();
		jLabel7 = new JLabel("Critical hit rate:");
		jLabel8 = new JLabel();
		jLabel9 = new JLabel("Effect:");
		jLabel10 = new JLabel();
		jLabel11 = new JLabel("Flinch rate:");
		jLabel12 = new JLabel();
		jLabel13 = new JLabel("Healing:");
		jLabel14 = new JLabel();
		jLabel15 = new JLabel("Power:");
		jLabel16 = new JLabel();
		jLabel17 = new JLabel("PP:");
		jLabel18 = new JLabel();
		jLabel19 = new JLabel("Priority:");
		jLabel20 = new JLabel();
		jLabel21 = new JLabel("Recoil:");
		jLabel22 = new JLabel();
		jLabel23 = new JLabel("Type:");
		jLabel24 = new JLabel();
		jScrollPane2 = new JScrollPane();
		jList2 = new JList();

		jScrollPane1.setViewportView(jList1);
		jSplitPane1.setLeftComponent(jScrollPane1);
		jSplitPane1.setRightComponent(jPanel1);
		jScrollPane2.setViewportView(jList2);

		final Object[] moveList = utils.getMapAsArray(db.getMoves(), "name");
		Arrays.sort(moveList);

		jList1.setModel(new AbstractListModel() {
			public int getSize() {
				return moveList.length;
			}

			public Object getElementAt(int i) {
				return moveList[i];
			}
		});
		
		jList1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				loadMove();
			}
		});
		
		GroupLayout localGroupLayout1 = new GroupLayout(jPanel1);
		jPanel1.setLayout(localGroupLayout1);
		localGroupLayout1.setHorizontalGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout1.createSequentialGroup().addContainerGap().addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout1.createSequentialGroup().addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, -1, 276, 32767).addGroup(localGroupLayout1.createSequentialGroup().addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel9).addComponent(jLabel7).addComponent(jLabel11).addComponent(jLabel13).addComponent(jLabel15).addComponent(jLabel17).addComponent(jLabel19).addComponent(jLabel21).addComponent(jLabel23).addComponent(jLabel1).addComponent(jLabel3).addComponent(jLabel5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 167, 32767).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel10).addComponent(jLabel8).addComponent(jLabel6).addComponent(jLabel4).addComponent(jLabel2).addComponent(jLabel20).addComponent(jLabel22).addComponent(jLabel24).addComponent(jLabel18).addComponent(jLabel16).addComponent(jLabel14).addComponent(jLabel12)))).addGap(204, 204, 204)))));
		localGroupLayout1.setVerticalGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout1.createSequentialGroup().addContainerGap().addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(jLabel6)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(jLabel8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel9).addComponent(jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel11).addComponent(jLabel12)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel13).addComponent(jLabel14)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel15).addComponent(jLabel16)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel17).addComponent(jLabel18)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel19).addComponent(jLabel20)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel21).addComponent(jLabel22)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel23).addComponent(jLabel24)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)));
		GroupLayout localGroupLayout2 = new GroupLayout(getContentPane());
		getContentPane().setLayout(localGroupLayout2);
		localGroupLayout2.setHorizontalGroup(localGroupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout2.createSequentialGroup().addContainerGap().addComponent(jSplitPane1, -2, -1, -2).addContainerGap(-1, 32767)));
		localGroupLayout2.setVerticalGroup(localGroupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout2.createSequentialGroup().addContainerGap().addComponent(jSplitPane1, -2, -1, -2).addContainerGap(-1, 32767)));
		pack();
	}
}
