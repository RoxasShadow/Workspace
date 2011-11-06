/**
	DamageCalculator.java
	(C) Giovanni Capuano 2011
*/
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Map;
import java.util.ArrayList;

public class DamageCalculator extends JFrame implements ProjectGUI {
	private	Utils utils;
	private	Database db;
	private JPanel jPanel1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JButton jButton1;
	private JCheckBox jCheckBox1;
	private JComboBox jComboBox1;
	private JComboBox jComboBox2;
	private JComboBox jComboBox3;
	private JFormattedTextField jFormattedTextField1;
	private JFormattedTextField jFormattedTextField2;
	private JFormattedTextField jFormattedTextField3;
	
	public DamageCalculator(Database db, Utils utils) {
		super("Damage calculator - Project G - Development version");
		setSize(700, 250);
		setVisible(true);
		setFocusable(true);
		this.utils = utils;
		this.db = db;
		initComponents();
	}
	
	public void calculateDamage() {
		try {
			int critical = jCheckBox1.isSelected() ? 2 : 1;
			Map<String, Map<String, String>> pokemonList = db.getPokemon();
			Map<String, String> player = pokemonList.get((String)jComboBox1.getSelectedItem());
			Map<String, String> opponent = pokemonList.get((String)jComboBox3.getSelectedItem());
			Map<String, Map<String, String>> moveList = db.getMoves();
			Map<String, String> moveInfo = moveList.get((String)jComboBox2.getSelectedItem());
			ArrayList<String> type = db.getTypes();
			String moveType = type.get(Integer.parseInt(moveInfo.get("type")));
			String[] playerType = {type.get(Integer.parseInt(player.get("type1"))), type.get(Integer.parseInt(player.get("type2")))};
			String[] opponentType = {type.get(Integer.parseInt(opponent.get("type1"))), type.get(Integer.parseInt(opponent.get("type2")))};
			double stab = ((playerType[0].equals(moveType)) || (playerType[1].equals(moveType))) ? 1.5 : 1.0;
			
			double effective = 0.0;
			String[] weakness = utils.getWeakness(opponentType[0]);
			String[] resistence = utils.getResistence(opponentType[0]);
			String[] immunitance = utils.getImmunitance(opponentType[0]);
			
			for(int i=0, count=weakness.length; i<count; ++i)
				if((weakness[i].equals(moveType)) || (weakness[i].equals(moveType)))
					effective += 2.0;
			for(int i=0, count=resistence.length; i<count; ++i)
				if((resistence[i].equals(moveType)) || (resistence[i].equals(moveType)))
					effective += 0.5;
			for(int i=0, count=immunitance.length; i<count; ++i)
				if((immunitance[i].equals(moveType)) || (immunitance[i].equals(moveType)))
					effective = 0.0;
		
			if(!opponentType[1].equals("???")) {
				weakness = utils.getWeakness(opponentType[1]);
				resistence = utils.getResistence(opponentType[1]);
				immunitance = utils.getImmunitance(opponentType[1]);
				for(int i=0, count=weakness.length; i<count; ++i)
					if((weakness[i].equals(moveType)) || (weakness[i].equals(moveType)))
						effective += 2.0;
				for(int i=0, count=resistence.length; i<count; ++i)
					if((resistence[i].equals(moveType)) || (resistence[i].equals(moveType)))
						effective += 0.5;
				for(int i=0, count=immunitance.length; i<count; ++i)
					if((immunitance[i].equals(moveType)) || (immunitance[i].equals(moveType)))
						effective = 0.0;
			}
		
			int basepower = Integer.parseInt(moveInfo.get("power"));
			double min = utils.getDamage(Integer.parseInt(jFormattedTextField1.getText()), basepower, Integer.parseInt(jFormattedTextField2.getText()), Integer.parseInt(jFormattedTextField3.getText()), critical, stab, effective, true);
			double max = utils.getDamage(Integer.parseInt(jFormattedTextField1.getText()), basepower, Integer.parseInt(jFormattedTextField2.getText()), Integer.parseInt(jFormattedTextField3.getText()), critical, stab, effective, false);
			jLabel7.setText("Damage average: "+utils.approximate(min, 2)+" ~ "+utils.approximate(max, 2)+" (the damage is x"+effective+" and is "+((stab == 1.5) ? "STABbed" : "not STABbed")+").");
		}
		catch(NotOffensiveMoveException e) {
			JOptionPane.showMessageDialog(null, "This is not a offensive move.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch(ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "An arithmetic exception has occurred.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Datas not found.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
		
	private void initComponents() {
		jPanel1 = new JPanel();
		jLabel1 = new JLabel("Level");
		jLabel2 = new JLabel("Attack");
		jLabel3 = new JLabel("Defense");
		jLabel4 = new JLabel("Player");
		jLabel5 = new JLabel("Move");
		jLabel6 = new JLabel("Opponent");
		jLabel7 = new JLabel("");
		jFormattedTextField1 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField2 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField3 = new JFormattedTextField(NumberFormat.getInstance());
		jCheckBox1 = new JCheckBox("Critical");
		jComboBox1 = new JComboBox();
		jComboBox2 = new JComboBox();
		jComboBox3 = new JComboBox();
		jButton1 = new JButton("Calculate");

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(jFormattedTextField1.getText().equals("") || jFormattedTextField2.getText().equals("") || jFormattedTextField3.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You have to complete all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
				else
					calculateDamage();
			}
		});
		
		Object[] pokemonList = utils.getMapAsArray(db.getPokemon(), "name");
		Object[] moveList = utils.getMapAsArray(db.getMoves(), "name");
		jComboBox1.setModel(new DefaultComboBoxModel(pokemonList));
		jComboBox2.setModel(new DefaultComboBoxModel(moveList));
		jComboBox3.setModel(new DefaultComboBoxModel(pokemonList));

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
		    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
		            .addComponent(jLabel7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addGap(18, 18, 18)))
		        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
		            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addGroup(jPanel1Layout.createSequentialGroup()
		                        .addComponent(jLabel4)
		                        .addGap(18, 18, 18))
		                    .addGroup(jPanel1Layout.createSequentialGroup()
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
		                            .addComponent(jLabel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
		                            .addComponent(jFormattedTextField1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
		                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                            .addComponent(jLabel2)
		                            .addComponent(jFormattedTextField2, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))))
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
		                    .addComponent(jComboBox1, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                .addGap(18, 18, 18)))
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
		                    .addComponent(jFormattedTextField3)
		                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		                .addComponent(jCheckBox1)
		                .addGap(146, 146, 146))
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jLabel6))
		                .addGap(18, 18, 18)
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addComponent(jLabel5)
		                    .addGroup(jPanel1Layout.createSequentialGroup()
		                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                        .addGap(18, 18, 18)
		                        .addComponent(jButton1)))
		                .addGap(32, 32, 32))))
		);
		jPanel1Layout.setVerticalGroup(
		    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel1)
		            .addComponent(jLabel2)
		            .addComponent(jLabel3))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jFormattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jFormattedTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jFormattedTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jCheckBox1))
		        .addGap(18, 18, 18)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel4)
		            .addComponent(jLabel6)
		            .addComponent(jLabel5))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jButton1))
		        .addGap(18, 18, 18)
		        .addComponent(jLabel7)
		        .addContainerGap(130, Short.MAX_VALUE))
		);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
		    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addContainerGap())
		);
		layout.setVerticalGroup(
		    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addContainerGap())
		);
	}
}
