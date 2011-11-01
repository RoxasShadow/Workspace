/**
	HiddenPowerCalculator.java
	(C) Giovanni Capuano 2011
*/
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Map;

public class HiddenPowerCalculator extends JFrame implements ProjectGUI {
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
	private JLabel jLabel8;
	private JFormattedTextField jFormattedTextField1;
	private JFormattedTextField jFormattedTextField2;
	private JFormattedTextField jFormattedTextField3;
	private JFormattedTextField jFormattedTextField4;
	private JFormattedTextField jFormattedTextField5;
	private JFormattedTextField jFormattedTextField6;
	
	public HiddenPowerCalculator(Database db, Utils utils) {
		super("Hidden Power Calculator - Project G - Development version");
		setVisible(true);
		setFocusable(true);
		this.utils = utils;
		this.db = db;
		initComponents();
	}
	
	public void calculateHiddenPower() {
		try {
			int[] stats = {Integer.parseInt(jFormattedTextField1.getText()), Integer.parseInt(jFormattedTextField2.getText()), Integer.parseInt(jFormattedTextField3.getText()), Integer.parseInt(jFormattedTextField4.getText()), Integer.parseInt(jFormattedTextField5.getText()), Integer.parseInt(jFormattedTextField6.getText())};
			jLabel7.setText("Power: "+utils.getHiddenPower(stats));
			jLabel8.setText("Type: "+utils.getHiddenPowerType(stats));
		}
		catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Request failed.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch(ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "An arithmetic exception has occurred.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch(NumberFormatException e) {} // The silence is gold.
	}
		
	private void initComponents() {
		jPanel1 = new JPanel();
		jLabel1 = new JLabel("HP");
		jLabel2 = new JLabel("Attack");
		jLabel3 = new JLabel("Defense");
		jLabel4 = new JLabel("Special Attack");
		jLabel5 = new JLabel("Special Defense");
		jLabel6 = new JLabel("Speed");
		jLabel7 = new JLabel("");
		jLabel8 = new JLabel("");
		jFormattedTextField1 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField2 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField3 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField4 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField5 = new JFormattedTextField(NumberFormat.getInstance());
		jFormattedTextField6 = new JFormattedTextField(NumberFormat.getInstance());
		
	        KeyListener keyListener = new KeyListener() {
	        	public void keyTyped(KeyEvent e) {}
	        	public void keyPressed(KeyEvent e) {}
	        	public void keyReleased(KeyEvent e) {
	        		if(!jFormattedTextField1.getText().equals("") && !jFormattedTextField2.getText().equals("") && !jFormattedTextField3.getText().equals("") && !jFormattedTextField4.getText().equals("") && !jFormattedTextField5.getText().equals("") && !jFormattedTextField6.getText().equals(""))
	        			calculateHiddenPower();
	        	}
	        };
	        jFormattedTextField1.addKeyListener(keyListener);
	        jFormattedTextField2.addKeyListener(keyListener);
	        jFormattedTextField3.addKeyListener(keyListener);
	        jFormattedTextField4.addKeyListener(keyListener);
	        jFormattedTextField5.addKeyListener(keyListener);
	        jFormattedTextField6.addKeyListener(keyListener);


		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
		    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addContainerGap()
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addComponent(jLabel3)
		                    .addComponent(jLabel2)
		                    .addComponent(jLabel1)
		                    .addComponent(jLabel4)
		                    .addComponent(jLabel5))
		                .addGap(18, 18, 18)
		                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addComponent(jFormattedTextField1, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
		                    .addComponent(jFormattedTextField2, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
		                    .addComponent(jFormattedTextField3, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
		                    .addComponent(jFormattedTextField5, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
		                    .addComponent(jFormattedTextField4, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
		            .addGroup(jPanel1Layout.createSequentialGroup()
		                .addComponent(jLabel6)
		                .addGap(76, 76, 76)
		                .addComponent(jFormattedTextField6, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
		            .addComponent(jLabel7)
		            .addComponent(jLabel8))
		        .addContainerGap())
		);
		jPanel1Layout.setVerticalGroup(
		    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addContainerGap()
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel1)
		            .addComponent(jFormattedTextField1))
		        .addGap(18, 18, 18)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel2)
		            .addComponent(jFormattedTextField2))
		        .addGap(18, 18, 18)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel3)
		            .addComponent(jFormattedTextField3))
		        .addGap(18, 18, 18)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel4)
		            .addComponent(jFormattedTextField4))
		        .addGap(18, 18, 18)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel5)
		            .addComponent(jFormattedTextField5))
		        .addGap(18, 18, 18)
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jLabel6)
		            .addComponent(jFormattedTextField6))
		        .addGap(18, 18, 18)
		        .addComponent(jLabel7)
		        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		        .addComponent(jLabel8)
		        .addGap(32, 32, 32))
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
		pack();
	}
}
