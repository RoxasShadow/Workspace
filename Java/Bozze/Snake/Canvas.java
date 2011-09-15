import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Canvas extends JPanel {
	private JFrame jframe;
	private Graphics2D canvas;
	private GradientPaint gradient;
	private Rectangle rectangle;
	private Ellipse2D.Double apple, head;
	private int x, y, width, height, limit;
	private boolean eated = false;
	private double randX, randY;
	
	public Canvas(final JFrame jframe) {
		this.jframe = jframe;
		x = 100;
		y = 30;
		width = 30;
		height = 100;
		limit = jframe.getHeight()-100;
		randX = Math.random() * jframe.getWidth()-60;
		randY = Math.random() * jframe.getHeight()-140;
	        jframe.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_RIGHT:
						if(x <= jframe.getWidth()-60)
							x += 20;
						break;
					case KeyEvent.VK_LEFT:
						if(x >= 15)
							x -= 20;
						break;
					case KeyEvent.VK_UP:
						if(y >= 11)
							y -= 20;
						break;
					case KeyEvent.VK_DOWN:
						if(y <= jframe.getHeight()-140)
							y += 20;
				}
				repaint();
			}
	        });
    	}
    	
	public void paintComponent(Graphics graphics) {
		if((!eated) && (x == randX))
			eated = true;
		if(eated) {
			while(randX <= jframe.getWidth()-60)
				randX = Math.random()*100;
			while(randY <= jframe.getHeight()-140)
				randY = Math.random()*100;
			eated = false;
		}
		clear(graphics);
		canvas = (Graphics2D)graphics;
		rectangle = new Rectangle(x, y, width, height);
		head = new Ellipse2D.Double(x,y-15,width,15);
		apple = new Ellipse2D.Double(randX,randY,10,10);
  		canvas.setPaint(Color.green);
		canvas.fill(rectangle);
		canvas.draw(rectangle);
		canvas.fill(head);
		canvas.draw(head);
		canvas.fill(apple);
		canvas.draw(apple);
	}
	
	public void clear(Graphics graphics) {
		super.paintComponent(graphics);
	}
}
