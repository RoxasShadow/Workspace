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

public class DamageCalculator extends JFrame implements ProjectGUI {
	private	Utils utils;
	private	Pokemon pokemon;
	private	Moves moves;
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
	
	public DamageCalculator() {
		super("Damage calculator - Project G - Development version");
		setSize(400, 300);
		setVisible(true);
		setFocusable(true);
		utils = new Utils();
		try {
			pokemon = new Pokemon("db/pokemon.xml");
			moves = new Moves("db/moves.xml");
		}
		catch(ResourceNotFound e) {
			System.out.println("Resource not found.");
		}
		initComponents();
	}
	
	public void calculateDamage() {
		int critical = jCheckBox1.isSelected() ? 2 : 1;
		Map<String, Map<String, String>> pokemonList = pokemon.getPokemon();
		Map<String, String> player = pokemonList.get((String)jComboBox1.getSelectedItem());
		Map<String, String> opponent = pokemonList.get((String)jComboBox3.getSelectedItem());
		String type1 = player.get("type1");
		String type2 = player.get("type2");
		
		Map<String, Map<String, String>> moveList = moves.getMovesByName();
		Map<String, String> moveInfo = moveList.get((String)jComboBox2.getSelectedItem());
		String moveType = utils.getType(Integer.parseInt(moveInfo.get("type")));
		double stab = ((type1.equals(moveType)) || (type2.equals(moveType))) ? 1.5 : 1.0;
		String[] weakness = utils.getWeakness(moveType);
		String[] resistence = utils.getResistence(moveType);
		String[] immunitance = utils.getImmunitance(moveType);
		double effective = 0.0;
		for(int i=0, count=weakness.length; i<count; ++i)
			if((weakness[i].equals(type1)) || (weakness[i].equals(type2)))
				effective += 0.5;
		for(int i=0, count=resistence.length; i<count; ++i)
			if((resistence[i].equals(type1)) || (resistence[i].equals(type2)))
				effective += 2.0;
		if(effective == 0.0)
			effective = 1.0;
		for(int i=0, count=immunitance.length; i<count; ++i)
			if((immunitance[i].equals(type1)) || (immunitance[i].equals(type2))) {
				effective = 0.0;
				break;
			}
			
		int basepower = Integer.parseInt(moveInfo.get("power"));
		double min = utils.getDamage(Integer.parseInt(jFormattedTextField1.getText()), basepower, Integer.parseInt(jFormattedTextField2.getText()), Integer.parseInt(jFormattedTextField3.getText()), critical, stab, effective, true);
		double max = utils.getDamage(Integer.parseInt(jFormattedTextField1.getText()), basepower, Integer.parseInt(jFormattedTextField2.getText()), Integer.parseInt(jFormattedTextField3.getText()), critical, stab, effective, false);
		jLabel7.setText("Damage average: "+min+" ~ "+max+"."); 
	}
		
	private void initComponents() {
		jPanel1 = new JPanel(); 
		jLabel1 = new JLabel("Level");
		jLabel2 = new JLabel("Attack");
		jLabel3 = new JLabel("Defense");
		jLabel4 = new JLabel("Player");
		jLabel5 = new JLabel("Move");
		jLabel6 = new JLabel("Opponent");
		jLabel7 = new JLabel(""); // The result is hidden
		jFormattedTextField1 = new JFormattedTextField(NumberFormat.getInstance()); // Only numbers
		jFormattedTextField2 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField3 = new JFormattedTextField(NumberFormat.getInstance());
		jCheckBox1 = new JCheckBox("Critical");
		jComboBox1 = new JComboBox();
		jComboBox2 = new JComboBox();
		jComboBox3 = new JComboBox();
		jButton1 = new JButton("Calculate");

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculateDamage();
			}
		});
		
		Object[] pokemonList = utils.getMapAsArray(pokemon.getPokemon(), "name");
		Object[] moveList = utils.getMapAsArray(moves.getMoves(), "name");
		jComboBox1.setModel(new DefaultComboBoxModel(pokemonList));
		jComboBox2.setModel(new DefaultComboBoxModel(moveList));
		jComboBox3.setModel(new DefaultComboBoxModel(pokemonList));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
		    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
		        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                .addGroup(jPanel1Layout.createSequentialGroup()
		                    .addComponent(jLabel4)
		                    .addGap(18, 18, 18))
		                .addGroup(jPanel1Layout.createSequentialGroup()
		                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
		                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
		                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
		                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                        .addComponent(jLabel2)
		                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))))
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
		                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                .addGap(18, 18, 18)))
		        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
		                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
		                    .addComponent(jFormattedTextField3)
		                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                .addComponent(jCheckBox1)
		                .addGap(146, 146, 146))
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                    .addComponent(jLabel6))
		                .addGap(18, 18, 18)
		                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		                    .addComponent(jLabel5)
		                    .addGroup(jPanel1Layout.createSequentialGroup()
		                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addGap(18, 18, 18)
		                        .addComponent(jButton1)))
		                .addGap(32, 32, 32))))
		);
		jPanel1Layout.setVerticalGroup(
		    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel1)
		            .addComponent(jLabel2)
		            .addComponent(jLabel3))
		        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addComponent(jCheckBox1))
		        .addGap(18, 18, 18)
		        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel4)
		            .addComponent(jLabel6)
		            .addComponent(jLabel5))
		        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
		            .addComponent(jButton1))
		        .addGap(18, 18, 18)
		        .addComponent(jLabel7)
		        .addContainerGap(130, Short.MAX_VALUE))
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
		    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addContainerGap())
		);
		layout.setVerticalGroup(
		    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addContainerGap())
		);
		pack();
	}
}
