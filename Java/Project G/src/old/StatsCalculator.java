/**
	StatsCalculator.java
	(C) Giovanni Capuano 2011
*/
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Map;

public class StatsCalculator extends JFrame implements ProjectGUI {
	private	Utils utils;
	private	Pokemon pokemon;
	private	Moves moves;
	private JPanel jPanel1;
	private JButton jButton1;
	private JButton jButton2;
	private JCheckBox jCheckBox1;
	private JComboBox jComboBox1;
	private JComboBox jComboBox2;
	private JComboBox jComboBox3;
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
	private JFormattedTextField jFormattedTextField1;
	private JFormattedTextField jFormattedTextField2;
	private JFormattedTextField jFormattedTextField3;
	private JFormattedTextField jFormattedTextField4;
	private JFormattedTextField jFormattedTextField5;
	private JFormattedTextField jFormattedTextField6;
	
	public StatsCalculator() {
		super("Statistics Calculator - Project G - Development version");
		setVisible(true);
		setFocusable(true);
		utils = new Utils();
		try {
			pokemon = new Pokemon(utils.getPokemonDb(), utils.getPokemonType1Db(), utils.getPokemonType2Db());
			moves = new Moves(utils.getMovesDb());
		}
		catch(ResourceNotFound e) {
			JOptionPane.showMessageDialog(null, "Database not found.", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		initComponents();
	}
		
	private void initComponents() {
		jPanel1 = new JPanel();
		jLabel1 = new JLabel("Level");
		jLabel2 = new JLabel("Statistic");
		jLabel3 = new JLabel("EV");
		jLabel4 = new JLabel("Nature");
		jLabel5 = new JLabel("Pokémon");
		jLabel6 = new JLabel("Level");
		jLabel7 = new JLabel("IV");
		jLabel8 = new JLabel("EV");
		jLabel9 = new JLabel("Pokémon");
		jLabel10 = new JLabel("");
		jFormattedTextField1 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField2 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField3 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField4 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField5 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField6 = new JFormattedTextField(NumberFormat.getInstance());
		jComboBox1 = new JComboBox();
		jComboBox2 = new JComboBox();
		jComboBox3 = new JComboBox();
		jCheckBox1 = new JCheckBox("HP");
		jButton1 = new JButton("Check IV");
		jButton2 = new JButton("Check Stats");

		Object[] pokemonList = utils.getMapAsArray(pokemon.getPokemon(), "name");
		jComboBox1.setModel(new DefaultComboBoxModel(utils.getNature()));
		jComboBox2.setModel(new DefaultComboBoxModel(pokemonList));
		jComboBox3.setModel(new DefaultComboBoxModel(pokemonList));

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(jFormattedTextField1.getText().equals("") || jFormattedTextField2.getText().equals("") || jFormattedTextField3.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You have to complete all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
				//else
					//calculateIVs();
			}
		});

		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(jFormattedTextField4.getText().equals("") || jFormattedTextField5.getText().equals("") || jFormattedTextField6.getText().equals(""))
					JOptionPane.showMessageDialog(null, "You have to complete all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
				//else
				//	if(jCheckBox1.isSelected())
				//		calculateHP();
				//	else
				//		calculateIVs();
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
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addComponent(jFormattedTextField1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
		                    .addComponent(jFormattedTextField4, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
		                    .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
		                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
		                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                            .addComponent(jFormattedTextField2)
		                            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
		                    .addGroup(jPanel1Layout.createSequentialGroup()
		                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                            .addComponent(jFormattedTextField5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
		                            .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))))
		                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addComponent(jFormattedTextField6)
		                    .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
		                    .addComponent(jFormattedTextField3)
		                    .addGroup(jPanel1Layout.createSequentialGroup()
		                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
		                        .addGap(6, 6, 6)))
		                .addGap(18, 18, 18)
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addGroup(jPanel1Layout.createSequentialGroup()
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                            .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
		                            .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                            .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
		                            .addComponent(jComboBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                            .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                            .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                        .addGap(32, 32, 32))
		                    .addGroup(jPanel1Layout.createSequentialGroup()
		                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
		                            .addComponent(jLabel9, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
		                            .addComponent(jComboBox3, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
		                        .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
		                        .addGap(98, 98, 98))))
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addGap(492, 492, 492)))
		        .addGap(0, 0, 0))
		);
		jPanel1Layout.setVerticalGroup(
		    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addContainerGap()
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel2)
		            .addComponent(jLabel4)
		            .addComponent(jLabel5)
		            .addComponent(jLabel1)
		            .addComponent(jLabel3))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jFormattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jFormattedTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jFormattedTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jButton1))
		        .addGap(18, 18, 18)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel6)
		            .addComponent(jLabel8)
		            .addComponent(jLabel9)
		            .addComponent(jLabel7))
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jFormattedTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jFormattedTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jFormattedTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addComponent(jCheckBox1)
		            .addComponent(jButton2))
		        .addGap(18, 18, 18)
		        .addComponent(jLabel10)
		        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pack();
	}
}
