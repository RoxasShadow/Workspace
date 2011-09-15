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
import javax.swing.JLabel;
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

/* NET */
import java.net.URL;
import java.net.URISyntaxException;

/* JL LIBRARY */
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;

/* JYTHON */
import org.python.util.PythonInterpreter;
import org.python.core.PyObject;
import org.python.core.PyException;

public class GjTris extends JFrame {
	private JPanel panel;
	private JButton[] buttons;
	private JButton save, load, restart, about;
	private JLabel labelScore, labelRecord;
	private String yourMark, oppoMark;
	private String propertiesFileName = "GjTris.properties";
	private boolean isEnded = false;
	public ResourceBundle resources;
	private Integer score = 0; // Using an object and not a primitive, I can apply toString() easly.
	private Integer record = 0;
	private String yourSoundTick = "drip.mp3";
	private String oppoSoundTick = "drip.mp3";
	private String endSoundTick = "finished.mp3";
	private boolean enableSound;
	private PythonInterpreter interpreter;
	
	public GjTris() {
		super("GjTris 0.9.2");
		setMarks("X", "O"); // It will be overrided by main method when GjTris will be istanced.
		enableSound = false;
		loadLanguage();
		loadProperties(); // It sets the saved record
		interpreter = new PythonInterpreter();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,3));
		save = new JButton(resources.getString("save"));
		load = new JButton(resources.getString("load"));
		restart = new JButton(resources.getString("restart"));
		about = new JButton("About");
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
					if(!isEnded) {
						if(youMove(tmp)) {
							playTick(yourSoundTick);
							setScore(++score); // Autoboxing powah :P
							updateViewLabels();
							if((!isEnded) && (isTie())) {
								isEnded = true;
								playTick(endSoundTick);
								JOptionPane.showMessageDialog(null, resources.getString("tie"));
							}
							else if(isWinner(yourMark)) {
								isEnded = true;
								playTick(endSoundTick);
								JOptionPane.showMessageDialog(null, resources.getString("win"));
							}
							if(!isEnded) {
								oppoMove();
								//playTick(oppoSoundTick);
							}
							if((!isEnded) && (isTie())) {
								isEnded = true;
								playTick(endSoundTick);
								JOptionPane.showMessageDialog(null, resources.getString("tie"));
							}
							else if((!isEnded) && (isWinner(oppoMark))) {
								isEnded = true;
								playTick(endSoundTick);
								JOptionPane.showMessageDialog(null, resources.getString("lose"));
							}
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
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  		JOptionPane.showMessageDialog(null, "GjTris 0.99.2 (C) Giovanni Capuano 2011\n<http://www.giovannicapuano.net>\n<webmaster@giovannicapuano.net>");
			}
		});
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent winEvt) {
				if(JOptionPane.showConfirmDialog(null, resources.getString("on_close"), resources.getString("title_on_close"), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		  			System.exit(0);
			}
		});
		labelScore = new JLabel(resources.getString("score")+getScore().toString());
		labelRecord = new JLabel(resources.getString("record")+getRecord().toString());
		panel.add(about); // In the truth, It's an alternative wildcard :P
		panel.add(labelRecord);
		panel.add(labelScore);
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
	}
	
	private void updateViewLabels() {
		labelScore.setText(resources.getString("score")+getScore().toString());
		labelRecord.setText(resources.getString("record")+getRecord().toString());
		saveProperties();
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
	
	private void restart() {
		isEnded = false;
		for(int i=0; i<9; ++i)
			buttons[i].setText("");
		panel.setBackground(Color.white);
	}
	
	private void playTick(final String filename) {
		if(enableSound) {
			try {
				new Player(this.getClass().getResourceAsStream("resources/"+filename)).play();
			}
			catch(JavaLayerException e) {}
		}
	}
	
	/* SAVERS */
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
	
	public boolean saveProperties() {
		try {
			if(!fileExists(propertiesFileName))
				new File(propertiesFileName);
			Properties properties = new Properties();
			properties.setProperty("yourMark", (yourMark.equals("")) ? "X" : yourMark);
			properties.setProperty("oppoMark", (oppoMark.equals("")) ? "O" : oppoMark);
			properties.setProperty("enableSound", (getEnableSound()) ? "1" : "0");
			properties.setProperty("record", getRecord().toString());
			properties.store(new FileOutputStream(propertiesFileName), "GjTris PREFERENCES - DO NOT EDIT - (C) Giovanni Capuano 2011");
			loadProperties(); // I have to load the record :X
			return (fileExists(propertiesFileName)) ? true : false;
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, resources.getString("preferences_not_saved"));
		}
		return false;
	}
	
	/* LOADERS */	
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
	
	public boolean loadProperties() {
		try {
			if(!fileExists(propertiesFileName))
				return false;
			else {
				Properties properties = new Properties();
				properties.load(new FileInputStream(propertiesFileName));
				String yourMark = ((properties.getProperty("yourMark") == null) || (properties.getProperty("yourMark").equals(""))) ? "X" : properties.getProperty("yourMark");
				String oppoMark = ((properties.getProperty("oppoMark") == null) || (properties.getProperty("oppoMark").equals(""))) ? "O" : properties.getProperty("oppoMark");
				int enableSound = ((properties.getProperty("enableSound") == null) || (properties.getProperty("enableSound").equals(""))) ? 0 : Integer.parseInt(properties.getProperty("enableSound"));
				String record = ((properties.getProperty("record") == null) || (properties.getProperty("record").equals(""))) ? "0" : properties.getProperty("record");
				/*
				A short story.
				I have passed about 10 minutes under an exception 'cause I have assigned at record "O" and not "0".
				Damn central dot.
				*/
				setMarks(yourMark, oppoMark);
				setEnableSound(enableSound);
				setRecord(Integer.parseInt(record));
				return ((yourMark.equals("")) || (oppoMark.equals("")) || (record.equals(""))) ? false : true;
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
			/* Decomment the follow lines to enable the relative languages (but you have to include the appropiate language file!). */
			//else if(localeLanguage.equals("es"))
			//	resources = ResourceBundle.getBundle("resources.GjTris", Locale.SPANISH);
			//else if(localeLanguage.equals("fr"))
			//	resources = ResourceBundle.getBundle("resources.GjTris", Locale.FRENCH);
			else // Default language
				resources = ResourceBundle.getBundle("resources.GjTris", Locale.ENGLISH);
		}
		catch(MissingResourceException e) {
			JOptionPane.showMessageDialog(null, "Language file not found.\nYou can obtain these on <http://www.giovannicapuano.net>.");
			System.exit(0);
		}
	}
	
	/* CHECKERS */
	private boolean isWinner(String mark) {
		try {
			for(int i=0; i<9; ++i)
				interpreter.set("button"+i, buttons[i].getText());
			interpreter.set("mark", mark);
			interpreter.execfile(this.getClass().getResourceAsStream("plugin/isWinner.py"));
			PyObject res = interpreter.get("response");
			return (res.toString().equals("true")) ? true : false;
		}
		catch(PyException e) {
			JOptionPane.showMessageDialog(null, "An error was occurred during the load or the execution of one or more plugins.\nYou can obtain a new copy of the plugins on <http://www.giovannicapuano.net>.");
			System.exit(0);
		}
		return false;
	}
	
	private boolean isTie() {
		try {
			String[] buttonArray = new String[9];
			for(int i=0; i<9; ++i)
				buttonArray[i] = buttons[i].getText();
			interpreter.set("buttons", buttonArray);
			interpreter.execfile(this.getClass().getResourceAsStream("plugin/isTie.py"));
			PyObject res = interpreter.get("response");
			return (res.toString().equals("true")) ? true : false;
		}
		catch(PyException e) {
			JOptionPane.showMessageDialog(null, "An error was occurred during the load or the execution of one or more plugins.\nYou can obtain a new copy of the plugins on <http://www.giovannicapuano.net>.");
			System.exit(0);
		}
		return false;
	}
	
	private boolean fileExists(String filename) {
		return ((new File(filename)).exists()) ? true : false;
	}
	
	/* ACCESSORS */
	public Integer getRecord() {
		return ((record != null) || (record > 0)) ? record : 0;
	}
	
	public Integer getScore() {
		return ((score != null) || (score > 0)) ? score : 0;
	}
	
	public String[] getMarks() {
		String[] marks = new String[2];
		marks[0] = yourMark;
		marks[1] = oppoMark;
		return marks;
	}
	
	public boolean getEnableSound() {
		return enableSound;
	}
	
	/* MUTATORS */
	public void setScore(Integer score) {
		this.score = score;
		if(this.score > record)
			setRecord(score);
	}
	
	public void setRecord(Integer record) {
		this.record = record;
	}
	
	public void setMarks(String yourMark, String oppoMark) {
		this.yourMark = yourMark.toUpperCase().substring(0,1);
		this.oppoMark = oppoMark.toUpperCase().substring(0,1);
	}
	
	public void setEnableSound(int enableSound) {
		this.enableSound = (enableSound == 1) ? true : false;
	}
	
	public void setEnableSound(boolean enableSound) {
		this.enableSound = enableSound;
	}
	
	/* INITIALIZATORS */
	public static void makeGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {}
		GjTris tris = new GjTris();
		tris.setSize(300,350);
		tris.setVisible(true);
		if(!tris.loadProperties()) {
			String yourMark = JOptionPane.showInputDialog(null, tris.resources.getString("your_mark"));
			if((yourMark == null) || (yourMark.equals("")))
				tris.setMarks("X", "O");
			else {
				String oppoMark = JOptionPane.showInputDialog(null, tris.resources.getString("oppo_mark"));
				tris.setMarks(((yourMark == null) || (yourMark.equals(""))) ? "X" : yourMark, ((oppoMark == null) || (oppoMark.equals(""))) ? "O" : oppoMark);
			}
			String enableSound = JOptionPane.showInputDialog(null, tris.resources.getString("enable_sound"));
			if((enableSound != null) && (Integer.parseInt(enableSound) == 1))
				tris.setEnableSound(true);
			else
				tris.setEnableSound(false);
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
			try {
				JOptionPane.showMessageDialog(null, "Initialization failed.\nYou can obtain another copy or a new version on <http://www.giovannicapuano.net>.");
				JOptionPane.showMessageDialog(null, "In order to view the debug report, run GjTris via terminal/prompt.");
			}
			catch(Exception ex) {
				System.out.println("Initialization failed.\nYou can obtain another copy or a new version on <http://www.giovannicapuano.net>.");
			}			
			System.out.println("\t\t<---- Debug report ---->");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
