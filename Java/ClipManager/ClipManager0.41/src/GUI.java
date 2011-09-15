import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class GUI extends JFrame {
	Text text;
	Writer writer;
	ClipboardManager clipboard;
	String string, id2, scelta2;
	int id, scelta;
	JFrame frame;
	JPanel panel;
	JTextArea ta;
		
	GUI() {
		super("ClipManager 0.41");
		/* Istanzazioni */
		clipboard = new ClipboardManager();
		writer = new Writer();
  		frame = new JFrame("ClipManager 0.41");
  		panel = new JPanel();
  		ta = new JTextArea();
		
		/* Textarea */
		ta.append("Welcome in ClipManager 0.41.\nWhat's new -> The function \"Clean\" now clean the textarea too");
		
		/* Bottoni */
		JButton button1 = new JButton("New text"); // Label
		button1.setToolTipText("Create a new text"); // Aiuto
		JButton button2 = new JButton("Copy text");
		button2.setToolTipText("Copy a text in the clipboard");
		JButton button3 = new JButton("Clean");
		button3.setToolTipText("Clean the texts");
		JButton button4 = new JButton("Number of texts");
		button4.setToolTipText("Check the number of texts wich you have added");
		JButton button5 = new JButton("About");
		button5.setToolTipText("Who is the maker, the license and the TODO");
		JButton button6 = new JButton("Exit");
		button6.setToolTipText("Close the software");
		
		/* Eventi dei bottoni */
		button1.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) { // Al click
				string = JOptionPane.showInputDialog(null, "Text");
				id = writer.countText() + 1;
				
				text = new Text(string, id);
				writer.newText(text);
				ta.append("\nThe text has been successfully uploaded with id "+id+".");
		        }
		});
		
		button2.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
				id2 = JOptionPane.showInputDialog(null, "Id");
				id = Integer.parseInt(id2);
				
				clipboard.toClipboard(writer.getText(id));
				ta.append("\n\""+writer.getText(id)+"\" has been copied in the clipboard.\nType \"Ctrl\" + \"V\" for paste.");
		        }
		});
		
		button3.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        		writer.cleanText();
		        		ta.setText("Cleaned the textarea and the texts."); // Replace the text with the params
		        }
		});
		
		button4.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	ta.append("\nNumber of texts wich you have added: "+writer.countText());
		        }
		});
		
		button5.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	ta.append("Do you want contact me? Send me an email at webmaster@giovannicapuano.net\n\nTODO:\nDetect the button pressing\nImplement the exception handling\nImprove the graphic\nMinimize in the taskbar\nDetect the button pressing when is minimized in the taskbar\n\nThis software has been released under a GNU/GPLv3 license.\nBelow this link for read it: http://www.gnu.org/licenses/gpl-3.0.txt");
		        }
		});
		
		button6.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	ta.append("\nSee you soon :)");
		        	System.exit(0);
		        }
		});
           
           
           	/* Grafica */
           	this.getContentPane().add(ta);
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
  		panel.setSize(800, 800);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
