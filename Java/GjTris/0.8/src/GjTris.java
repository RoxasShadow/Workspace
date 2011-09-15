/**
	/GjTris.java
	(C) Giovanni Capuano 2011
*/
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;
import javax.swing.*;
import java.util.Random;
import java.io.*;

public class GjTris extends JFrame {
	JPanel panel;
	JButton[] buttons;
	JButton save;
	JButton load;
	JButton restart;
	String yourMark;
	String oppoMark;
	
	public GjTris() {
		super("GjTris 0.8");
		this.setSize(300,300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setMarks("X", "O");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,3));
		save = new JButton("Save");
		load = new JButton("Load");
		restart = new JButton("Restart");
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
					if(youMove(tmp)) {
						if(isWinner(yourMark)) {
							panel.setBackground(Color.red);
							JOptionPane.showMessageDialog(null, "You win. Congratulations!");
							restart();
						}
						oppoMove();
						if(isWinner(oppoMark)) {
							panel.setBackground(Color.black);
							JOptionPane.showMessageDialog(null, "You lose. Try again!");
							restart();
						}
						if(isTie()) {
							panel.setBackground(Color.gray);
							JOptionPane.showMessageDialog(null, "Tie. Rechallange now!");
							restart();
						}
					}
				}
			});
		}
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = JOptionPane.showInputDialog(null, "Filename");
				if((filename == null) || (filename.equals("")))
					JOptionPane.showMessageDialog(null, "Filename not recognized.");
				else
					saveGame(filename);
			}
		});
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = JOptionPane.showInputDialog(null, "Filename");
				if((filename == null) || (filename.equals("")))
					JOptionPane.showMessageDialog(null, "Filename not recognized.");
				else
					loadGame(filename);
			}
		});
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  		restart();
			}
		});
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
	
	public void setMarks(String yourMark, String oppoMark) {
		this.yourMark = yourMark.toUpperCase();
		this.oppoMark = oppoMark.toUpperCase();
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
			JOptionPane.showMessageDialog(null, "Saved on "+filename+".");
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "An error was occurred.");
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
			JOptionPane.showMessageDialog(null, "Loaded on "+filename+".");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "File not exists.");
		}
	}
		
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		GjTris tris = new GjTris();
		String yourMark = JOptionPane.showInputDialog(null, "Your mark");
		if((yourMark == null) || (yourMark.equals("")))
			tris.setMarks("X", "O");
		else {
			String oppoMark = JOptionPane.showInputDialog(null, "Opponent mark");
			if((yourMark == null) || (yourMark.equals("")) || (oppoMark == null) || (oppoMark.equals("")) || (yourMark.equals(oppoMark)))
				tris.setMarks("X", "O");
			else
				tris.setMarks(yourMark, oppoMark);
		}
	}
}


/*
	private boolean isWinner(String mark) {
		int found = 0;
		int i;
		
		/* Orizzontale 
		i = 8;
		while((found < 3) && (i >= 0)) {
			if(buttons[i].getText().equals(mark))
				++found;
			System.out.println(i);
			--i;
		}
		if(found == 3) {
			System.out.println("Orizzontale");
			return true;
		}
		else
			found = 0;
			
		/* Verticale 
		i = 8;
		while((found < 3) && (i > 0)) {
			if((i == 8) && (buttons[8].getText().equals(mark)))
				++found;
			else if(buttons[i-1].getText().equals(mark))
				++found;
			--i;
		}
		if(found == 3) {
			System.out.println("Verticale");
			return true;
		}
		else
			found = 0;
		
		/* Diagonale 
		i = 8;
		while((found < 3) && (i > 1)) {
			if((i == 8) && (buttons[8].getText().equals(mark)))
				++found;
			else if(buttons[i-2].getText().equals(mark))
				++found;
			--i;
		}
		if(found == 3) {
			System.out.println("Diagonale");
			return true;
		}
		else
			found = 0;
		return false;
	}
*/
