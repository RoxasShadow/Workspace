import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

class SmallTris extends JPanel {
	private Graphics2D g2d;
	private Rectangle rect;
	private GradientPaint gradient;
	static private int x, y, w, h, limit, score;
	static private boolean speed;

	public static void main(String[] args) {
		SmallTris draw = new SmallTris();
		final JFrame frame = new JFrame();
		frame.setContentPane(draw);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setResizable(false);
		x = frame.getWidth()/2;
		y = 0;
		w = 50;
		h = 50;
		limit = frame.getHeight()-100;
		score = 0;
		speed = false;
	        frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
					if(x <= frame.getWidth()-100)
						x += 10;
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
					if(x >= 30)
						x -= 10;
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
					if(y <= limit-50) // Altrimenti dopo aver superato il punto limite ritorna di nuovo lì
						speed = true;
				/*if(e.getKeyCode() == KeyEvent.VK_DOWN)
					if(y <= frame.getHeight()-100)
						y += 10;
				if(e.getKeyCode() == KeyEvent.VK_UP)
					if(y >= 30)
						y -= 10;*/
			}
	        });
	}
	
	public void paintComponent(Graphics g) {
		clear(g);
		g2d = (Graphics2D)g;
		paintString(g2d, x, y, "SmallTris");
		paintRect(g2d, x, y, w, h, false);
		if(y <= limit)
			try {
				if(speed) {
					y = limit-40;
					speed = false;
				}
				else
					y += 10;
				Thread.sleep(50);
				repaint();
			}
			catch(InterruptedException e) {}
		else
			try {
				y = 0;
				Thread.sleep(50);
				paintRect(g2d, x, y, w, h, false);
				repaint();
				score += 50;
				System.out.println(score+" punti");
				
			}
			catch(InterruptedException e) {}
	}
	
	public void clear(Graphics g) {
		super.paintComponent(g);
	}
	
	public void paintString(Graphics2D g2d, int x, int y, String text) {
		g2d.drawString(text, x, y);
		g2d.setPaint(Color.black);
	}
	
	public void paintRect(Graphics2D g2d, int x, int y, int width, int height, boolean rotate) {
		rect = new Rectangle(x, y, width, height); //x, y, width, height
  		gradient = new GradientPaint(10, 45, Color.blue, 5, 115, Color.red, true); // x1, y1, color1, x2, y2, color2, repetition
  		if(rotate)
  			g2d.rotate(Math.PI/8.0);
  		g2d.setPaint(gradient);
		g2d.fill(rect);
		g2d.draw(rect);
	}
}
