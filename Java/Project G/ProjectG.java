/**
	ProjectG.java
	(C) Giovanni Capuano 2011
*/
import java.util.Map;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectG extends JFrame implements ProjectGUI {
	private	Utils utils;
	private	Pokemon pokemon;
	private	Moves moves;
	private JPanel jPanel1;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	
	public ProjectG() {
		super("Project G - Development version");
		setSize(400, 300);
		setVisible(true);
		setFocusable(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
	
	private void damage() {
		new DamageCalculator();
	}
	
	private void hiddenpower() {}
	private void ivs() {}
	private void stats() {}
	
	private void initComponents() {
		jPanel1 = new JPanel();
		jButton1 = new JButton("Damage calculator");
		jButton2 = new JButton("Hidden Power");
		jButton3 = new JButton("IVs");
		jButton4 = new JButton("Stats");

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				damage();
			}
		});

		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				hiddenpower();
			}
		});

		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ivs();
			}
		});

		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				stats();
			}
		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
		    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addContainerGap()
		        .addComponent(jButton1)
		        .addGap(18, 18, 18)
		        .addComponent(jButton2)
		        .addGap(18, 18, 18)
		        .addComponent(jButton3)
		        .addGap(18, 18, 18)
		        .addComponent(jButton4)
		        .addContainerGap(20, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
		    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(jPanel1Layout.createSequentialGroup()
		        .addContainerGap()
		        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		            .addComponent(jButton1)
		            .addComponent(jButton2)
		            .addComponent(jButton3)
		            .addComponent(jButton4))
		        .addContainerGap(235, Short.MAX_VALUE))
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
	
	public static void main(String[] args) {
		try {
			for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels())
				if("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
		}
		catch(Exception e) {
			System.out.println("Look & feel loading failed.");
		}
		new ProjectG();
	}
}
