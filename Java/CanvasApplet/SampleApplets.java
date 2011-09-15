import java.applet.*;
import java.awt.*;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class SampleApplets extends Applet {
	String color;
	public void init() {
		color = getParameter("color");
	}
	public void start() {}
	public void stop() {}
	public void destroy() {}
	public void paint(Graphics graphics) {
		Graphics2D canvas = (Graphics2D)graphics;
		if(color.equals("red"))
			canvas.setColor(Color.red);
		else if(color.equals("green"))
			canvas.setColor(Color.green);
		else if(color.equals("black"))
			canvas.setColor(Color.black);
		else if(color.equals("gray"))
			canvas.setColor(Color.gray);
		else if(color.equals("pink"))
			canvas.setColor(Color.pink);
		else
			canvas.setColor(Color.blue);
		canvas.draw(new Line2D.Double(10,10,250,250));
		canvas.draw(new Rectangle2D.Double(100,100,100,100));
		canvas.draw(new Ellipse2D.Double(100,100,50,50));
		canvas.fill(new Ellipse2D.Double(10,10,50,50));
	}
}
