import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class GUI extends JFrame {
	JTextArea ta = new JTextArea("Welcome in ClipManager 0.02.\nContact me, webmaster@giovannicapuano.net\n\n[1]Create a new text\n[2]Copy a text in the clipboard\n[3]Clean the clipboard\n[4]View the TODO\n[5]Exit");
	
	GUI() {
		Text text;
		Writer writer;
		ClipboardManager clipboard = new ClipboardManager();
		clipboard.getForm();
		String string, id2, scelta2;
		int id, scelta;
		writer = new Writer();
		
		this.getContentPane().add(ta);
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		do {
			scelta2 = JOptionPane.showInputDialog(null, "Choice");
			scelta = Integer.parseInt(scelta2);
		
			switch(scelta) {
				case 1:
					id2 = JOptionPane.showInputDialog(null, "Id");
					string = JOptionPane.showInputDialog(null, "Text");
					id = Integer.parseInt(id2);

					text = new Text(string, id);
					writer.newText(text);
					ta.append("\nThe text has been successfully uploaded.");
					break;
				case 2:
					id2 = JOptionPane.showInputDialog(null, "Id");
					id = Integer.parseInt(id2);
					
					clipboard.toClipboard(writer.getText(id));
					ta.append("\n\""+writer.getText(id)+"\" has been copied in the clipboard.\nType \"Ctrl\" + \"V\" for paste.");
					break;
				case 3:
					writer.cleanText();
					ta.append("\nCleaned.");
					break;
				case 4:
					ta.append("\nImplement the detection of the pressing Ctrl + V\nAutomate the Id's checking\nWrite a method wich output the number of Ids\nImprove the graphic");
				case 5:
					ta.append("\nSee you soon :)");
					break;
				default:	
					ta.append("\nType a number from 1 to 3 on the action you want to play.");
				}
		}while(scelta != 5);
	}
}
