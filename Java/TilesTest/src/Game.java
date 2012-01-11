import java.awt.Color;
import javax.swing.*;

public class Game extends JFrame {
	public Game() {
		super("LolGame");
		setSize(500, 500);
		setVisible(true);
		setFocusable(true);
		setBackground(Color.white);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Field field = new Field(490, 470);
		getContentPane().add(field);
		addKeyListener(field);
	}
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					new Game();
				}
			});
		}
		catch(Exception e) {
			System.out.println("Initialization failed.");
		}
	}
}
