/**
	Abilitydex.java
	(C) Giovanni Capuano 2011
*/
import java.awt.Container;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.*;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.*;

public class Abilitydex extends JFrame implements ProjectGUI {
	private Utils utils;
	private Database db;
	private Map<String, String> abilities;
	private JPanel jPanel1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JList jList1;
	private JScrollPane jScrollPane1;
	private JSplitPane jSplitPane1;

	public Abilitydex(Database db, Utils utils) {
		super("Abilitydex - Project G - Development version");
		setVisible(true);
		setFocusable(true);
		this.utils = utils;
		this.db = db;
		abilities = db.getAbilities();
		initComponents();
	}

	private void loadAbility() {
		String ability = (String)jList1.getSelectedValue();
		jLabel2.setText((String)abilities.get(ability));
		pack();
	}

	private void initComponents() {
		jPanel1 = new JPanel();
		jSplitPane1 = new JSplitPane();
		jScrollPane1 = new JScrollPane();
		jList1 = new JList();
		jLabel1 = new JLabel("Description:");
		jLabel2 = new JLabel("");

		jScrollPane1.setViewportView(jList1);
		jSplitPane1.setLeftComponent(jScrollPane1);
		jSplitPane1.setRightComponent(jPanel1);

		final Object[] abilitiesList = abilities.keySet().toArray();
		Arrays.sort(abilitiesList);

		jList1.setModel(new AbstractListModel() {
			public int getSize() {
				return abilitiesList.length;
			}

			public Object getElementAt(int i) {
				return abilitiesList[i];
			}
		});
		
		jList1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent paramListSelectionEvent) {
				loadAbility();
			}
		});
		
		GroupLayout localGroupLayout1 = new GroupLayout(jPanel1);
		jPanel1.setLayout(localGroupLayout1);
		localGroupLayout1.setHorizontalGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout1.createSequentialGroup().addContainerGap().addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jLabel1).addComponent(jLabel2)).addContainerGap(118, 32767)));
		localGroupLayout1.setVerticalGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout1.createSequentialGroup().addContainerGap().addComponent(jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2).addContainerGap(104, 32767)));
		GroupLayout localGroupLayout2 = new GroupLayout(getContentPane());
		getContentPane().setLayout(localGroupLayout2);
		localGroupLayout2.setHorizontalGroup(localGroupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout2.createSequentialGroup().addContainerGap().addComponent(jSplitPane1, -2, -1, -2).addContainerGap(-1, 32767)));
		localGroupLayout2.setVerticalGroup(localGroupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout2.createSequentialGroup().addContainerGap().addComponent(jSplitPane1, -2, -1, -2).addContainerGap(-1, 32767)));
		pack();
	}
}
