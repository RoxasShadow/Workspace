/**
	/GjTris.java
	(C) Giovanni Capuano 2011
*/

/* AWT */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

/* AWT Event */
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* SWING */
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* IO */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/* UTIL */
import java.util.Random;
import java.util.Locale;
import java.util.Properties;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class GjTris extends JFrame {
	private JPanel panel;
	private JButton[] buttons;
	private JButton save, load, restart;
	private String yourMark, oppoMark;
	private String propertiesFileName = "GjTris.properties";
	private boolean isEnded = false;
	public ResourceBundle resources;
	
	public GjTris() {
		super("GjTris 0.9");
		setMarks("X", "O"); // It will be overrided by main method when GjTris will be istanced.
		loadLanguage();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,3));
		save = new JButton(resources.getString("save"));
		load = new JButton(resources.getString("load"));
		restart = new JButton(resources.getString("restart"));
		panel.add(save);
		panel.add(load);
		panel.add(restart);
  		buttons = new JButton[9];
  		for(int i=0; i<9; ++i) {
			buttons[i] = new JButton("");
			buttons[i].setFont(new Font("Verdana", 1, 24));
		}
		for(final JButton tmp:buttons) {
			panel.add(tmp);
			tmp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!isEnded)
						if(youMove(tmp)) {
							if(isWinner(yourMark)) {
								isEnded = true;
								panel.setBackground(Color.red);
								JOptionPane.showMessageDialog(null, "You win. Congratulations!");
							}
							if(!isEnded)
								oppoMove();
							if(isWinner(oppoMark)) {
								isEnded = true;
								panel.setBackground(Color.black);
								JOptionPane.showMessageDialog(null, "You lose. Try again!");
							}
							if(isTie()) {
								panel.setBackground(Color.gray);
								JOptionPane.showMessageDialog(null, "Tie. Rechallange now!");
							}
						}
				}
			});
		}
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = JOptionPane.showInputDialog(null, resources.getString("filename"));
				if((filename == null) || (filename.equals("")))
					JOptionPane.showMessageDialog(null, resources.getString("filename_not_recognized"));
				else
					saveGame(filename);
			}
		});
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = JOptionPane.showInputDialog(null, resources.getString("filename"));
				if((filename == null) || (filename.equals("")))
					JOptionPane.showMessageDialog(null, resources.getString("filename_not_recognized"));
				else
					loadGame(filename);
			}
		});
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  		restart();
			}
		});
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent winEvt) {
				if(JOptionPane.showConfirmDialog(null, resources.getString("on_close"), resources.getString("title_on_close"), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		  			System.exit(0);
			}
		});
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
	}
	
	public void setMarks(String yourMark, String oppoMark) {
		this.yourMark = yourMark.toUpperCase().substring(0,1);
		this.oppoMark = oppoMark.toUpperCase().substring(0,1);
	}
	
	public String[] getMarks() {
		String[] marks = new String[2];
		marks[0] = yourMark;
		marks[1] = oppoMark;
		return marks;
	}
	
	private boolean youMove(JButton tmp) {
		if(tmp.getText().equals("")) {
			tmp.setText(yourMark);
			tmp.setForeground(new Color(255, 20, 147));
			return true;
		}
		return false;
	}
	
	private void oppoMove() {
		Random random = new Random();
		int rand = 0;
		while(true) {
			rand = random.nextInt(9); 
			if(buttons[rand].getText().equals("")) {
				buttons[rand].setText(oppoMark);
				buttons[rand].setForeground(new Color(25, 25, 112));
				break;
			}
		}
	}
	
	private boolean isWinner(String mark) {
		// Orizzontale
		if((buttons[0].getText().equals(mark)) && (buttons[1].getText().equals(mark)) && (buttons[2].getText().equals(mark)))
			return true;
		else if((buttons[3].getText().equals(mark)) && (buttons[4].getText().equals(mark)) && (buttons[5].getText().equals(mark)))
			return true;
		else if((buttons[6].getText().equals(mark)) && (buttons[7].getText().equals(mark)) && (buttons[8].getText().equals(mark)))
			return true;
		// Verticale
		else if((buttons[0].getText().equals(mark)) && (buttons[3].getText().equals(mark)) && (buttons[6].getText().equals(mark)))
			return true;
		else if((buttons[1].getText().equals(mark)) && (buttons[4].getText().equals(mark)) && (buttons[7].getText().equals(mark)))
			return true;
		else if((buttons[2].getText().equals(mark)) && (buttons[5].getText().equals(mark)) && (buttons[8].getText().equals(mark)))
			return true;
		// Diagonale
		else if((buttons[0].getText().equals(mark)) && (buttons[4].getText().equals(mark)) && (buttons[8].getText().equals(mark)))
			return true;
		else if((buttons[2].getText().equals(mark)) && (buttons[4].getText().equals(mark)) && (buttons[6].getText().equals(mark)))
			return true;
		else
			return false;
	}
	
	private boolean isTie() {
		double found = -1;
		for(int i=0; i<9; ++i)
			if(buttons[i].getText().equals(""))
				++found;
		return ((int)found >= 0) ? false : true;
	}
	
	private void restart() {
		isEnded = false;
		for(int i=0; i<9; ++i)
			buttons[i].setText("");
		panel.setBackground(Color.white);
	}
	
	private void saveGame(String filename) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File(filename+".sav")));
			output.writeObject(buttons);
			output.flush();
			output.close();
			JOptionPane.showMessageDialog(null, resources.getString("saved_on")+filename+".");
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, resources.getString("error"));
		}
	}
	
	private void loadGame(String filename) {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File(filename+".sav")));
			JButton[] buttonLoaded = new JButton[9];
			buttonLoaded = (JButton[])input.readObject();
			for(int i=0; i<9; ++i)
				buttons[i].setText(buttonLoaded[i].getText());
			input.close();
			JOptionPane.showMessageDialog(null, resources.getString("loaded_on")+filename+".");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, resources.getString("file_not_exists"));
		}
	}
	
	private boolean fileExists(String filename) {
		return ((new File(filename)).exists()) ? true : false;
	}
	
	public boolean saveProperties() {
		try {
			if(!fileExists(propertiesFileName))
				new File(propertiesFileName);
			Properties properties = new Properties();
			properties.setProperty("yourMark", (yourMark.equals("")) ? "X" : yourMark);
			properties.setProperty("oppoMark", (oppoMark.equals("")) ? "O" : oppoMark);
			properties.store(new FileOutputStream(propertiesFileName), "GjTris PREFERENCES - DO NOT EDIT - (C) Giovanni Capuano 2011");
			return (fileExists(propertiesFileName)) ? true : false;
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, resources.getString("preferences_not_saved"));
		}
		return false;
	}
	
	public boolean loadProperties() {
		try {
			if(!fileExists(propertiesFileName))
				return false;
			else {
				Properties properties = new Properties();
				properties.load(new FileInputStream(propertiesFileName));
				String yourMark = ((properties.getProperty("yourMark") == null) || (properties.getProperty("yourMark").equals(""))) ? "X" : properties.getProperty("yourMark");
				String oppoMark = ((properties.getProperty("oppoMark") == null) || (properties.getProperty("oppoMark").equals(""))) ? "O" : properties.getProperty("oppoMark");
				setMarks(yourMark, oppoMark);
				return ((yourMark.equals("")) || (oppoMark.equals(""))) ? false : true;
			}
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, resources.getString("preferences_not_loaded"));
		}
		return false;
	}
	
	public void loadLanguage() {
		try {
			String localeLanguage = Locale.getDefault().toString().substring(0,2);
			if(localeLanguage.equals("it"))
				resources = ResourceBundle.getBundle("resources.GjTris", Locale.ITALY);
			//else if(localeLanguage.equals("es"))
			//	resources = ResourceBundle.getBundle("resources.GjTris", Locale.SPANISH);
			//else if(localeLanguage.equals("fr"))
			//	resources = ResourceBundle.getBundle("resources.GjTris", Locale.FRENCH);
			else
				resources = ResourceBundle.getBundle("resources.GjTris", Locale.UK);
		}
		catch(MissingResourceException e) {
			JOptionPane.showMessageDialog(null, "Language file not found.");
			System.exit(0);
		}
	}
	
	public static void makeGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {}
		GjTris tris = new GjTris();
		tris.setSize(300,300);
		tris.setVisible(true);
		if(!tris.loadProperties()) {
			String yourMark = JOptionPane.showInputDialog(null, tris.resources.getString("your_mark"));
			if((yourMark == null) || (yourMark.equals("")))
				tris.setMarks("X", "O");
			else {
				String oppoMark = JOptionPane.showInputDialog(null, tris.resources.getString("oppo_mark"));
				tris.setMarks(((yourMark == null) || (yourMark.equals(""))) ? "X" : yourMark, ((oppoMark == null) || (oppoMark.equals(""))) ? "O" : oppoMark);
			}
			tris.saveProperties();
		}
	}
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		}
		catch(Exception e) {
			System.out.println("Initialization failed.");
			System.exit(0);
		}
	}
}
