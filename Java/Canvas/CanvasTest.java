import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class CanvasTest extends JFrame {
	public CanvasTest() {
		super("CanvasTest");
		this.setSize(300, 300);
		Canvas canvas = new Canvas();
		getContentPane().add(canvas);
	}
	public static void main(String[] args) {
		CanvasTest c = new CanvasTest();
		c.show();
	}
}

class Canvas extends JPanel {
	private Graphics2D canvas;
   	
	public void paint(Graphics graphics) {
		canvas = (Graphics2D)graphics;
		canvas.setColor(Color.red);
		canvas.draw(new Line2D.Double(10,10,250,250));
		canvas.draw(new Rectangle2D.Double(100,100,100,100));
		canvas.draw(new Ellipse2D.Double(100,100,50,50));
		canvas.fill(new Ellipse2D.Double(10,10,50,50));
	}
}
