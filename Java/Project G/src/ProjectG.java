import java.awt.Container;
import java.awt.event.*;
import java.io.PrintStream;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class ProjectG extends JFrame implements ProjectGUI {
	private Utils utils;
	private Database db;
	private JPanel jPanel1;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;

	public ProjectG() {
		super("Project G - Development version");
		utils = new Utils();
		try {
			db = new Database();
			db.addObserver(new LoaderObserver());
			db.init(utils);
		}
		catch(ResourceNotFound rnf) {
			JOptionPane.showMessageDialog(null, "Database not found.", "Error", 0);
			try {
				utils.cleanOnline();
			}
			catch(Exception e) {}
			System.exit(1);
		}
		setSize(400, 300);
		setVisible(true);
		setFocusable(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				utils.cleanOnline();
				System.exit(0);
			}
		});
		initComponents();
	}

	private void initComponents() {
		jPanel1 = new JPanel();
		jButton1 = new JButton("Damage calculator");
		jButton2 = new JButton("Hidden Power");
		jButton3 = new JButton("Pokédex");
		jButton4 = new JButton("Abilitydex");
		jButton5 = new JButton("Movedex");

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				new DamageCalculator(db, utils);
			}
		});
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				new HiddenPowerCalculator(db, utils);
			}
		});
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				new Pokedex(db, utils);
			}
		});
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				new Abilitydex(db, utils);
			}
		});
		jButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				new Movedex(db, utils);
			}
		});
		
		GroupLayout localGroupLayout1 = new GroupLayout(jPanel1);
		jPanel1.setLayout(localGroupLayout1);
		localGroupLayout1.setHorizontalGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout1.createSequentialGroup().addContainerGap().addComponent(jButton1).addGap(18, 18, 18).addComponent(jButton2).addGap(18, 18, 18).addComponent(jButton3).addGap(18, 18, 18).addComponent(jButton4).addGap(18, 18, 18).addComponent(jButton5).addContainerGap(20, 32767)));
		localGroupLayout1.setVerticalGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout1.createSequentialGroup().addContainerGap().addGroup(localGroupLayout1.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jButton1).addComponent(jButton2).addComponent(jButton3).addComponent(jButton4).addComponent(jButton5)).addContainerGap(235, 32767)));
		GroupLayout localGroupLayout2 = new GroupLayout(getContentPane());
		getContentPane().setLayout(localGroupLayout2);
		localGroupLayout2.setHorizontalGroup(localGroupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout2.createSequentialGroup().addContainerGap().addComponent(jPanel1, -1, -1, 32767).addContainerGap()));
		localGroupLayout2.setVerticalGroup(localGroupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout2.createSequentialGroup().addContainerGap().addComponent(jPanel1, -1, -1, 32767).addContainerGap()));
		pack();
	}

	public static void main(String[] args) {
		try {
			for(UIManager.LookAndFeelInfo lookAndFeel : UIManager.getInstalledLookAndFeels())
				if("Nimbus".equals(lookAndFeel.getName())) {
					UIManager.setLookAndFeel(lookAndFeel.getClassName());
					break;
				}
		}
		catch(Exception e) {
			System.out.println("Look & feel loading failed.");
		}
		new ProjectG();
	}
}
