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
	private	Database db;
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
		utils = new Utils();
		try {
			db = new Database();
		}
		catch(ResourceNotFound e) {
			JOptionPane.showMessageDialog(null, "Database not found.", "Error", JOptionPane.ERROR_MESSAGE);
			try {
				utils.cleanOnline();
			}
			catch(Exception ex) {}
			System.exit(1);
		}
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				utils.cleanOnline();
			}
		});
		initComponents();
	}
	
	private void initComponents() {
		jPanel1 = new JPanel();
		jButton1 = new JButton("Damage calculator");
		jButton2 = new JButton("Hidden Power");
		jButton3 = new JButton("Pokédex");
		jButton4 = new JButton("Fill~");

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new DamageCalculator(db, utils);
			}
		});

		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new HiddenPowerCalculator(db, utils);
			}
		});

		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new Pokedex(db, utils);
			}
		});

		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				//
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
		if((args.length > 0) && (!args[0].equals(""))) {
			if(args[0].equals("help")) {
				System.out.println("Project G - Development version");
				System.out.println("java Project [opt] [args]");
				System.out.println("\tclean -> Deletes the temp files downloaded by online server");
				System.out.println("\tgetiv statistic nature level basestatistic ev -> Calculates the IV from its statistic. (Nature: 0.9|1|1.1).");
				System.out.println("\tgethp iv level basestatistic ev -> Calculates the HP.");
				System.out.println("\tgetstat iv nature level basestatistic ev -> Calculates the statistics. (Nature: 0.9|1|1.1).");
				System.out.println("\thelp -> shows this help.");
			}
			else if(args[0].equals("clean"))
				new Utils().cleanOnline();
			else if((args[0].equals("getiv")) && (args.length == 6))
				System.out.println("IV: "+new Utils().getIV(Integer.parseInt(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5])));
			else if((args[0].equals("gethp")) && (args.length == 5))
				System.out.println("HP: "+new Utils().getHP(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])));
			else if((args[0].equals("getstat")) && (args.length == 6))
				System.out.println("Statistic: "+new Utils().getStat(Integer.parseInt(args[1]), Double.parseDouble(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5])));
			System.exit(0);
		}
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
