import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Canvas extends JPanel {
	private Graphics2D canvas;
	
	public void paint(Graphics graphics) {
		canvas = (Graphics2D)graphics;
		canvas.setColor(Color.red);
		//                             x    y    x   y
		canvas.draw(new Line2D.Double(600, 300,  0, 300)); // Orizzontale
		canvas.draw(new Line2D.Double(300,  10,  300, 600)); // Verticale
	}
}
