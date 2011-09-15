import java.awt.*;
import java.awt.event.*;

public class Player extends Panel {
	int lato; // Il lato del quadrato
	int x; // La posizione sull'asse x
	int speed; // La velocità di movimento del quadrato
	boolean dx;
	Dimension dimension;
	
	public Player(int lato, int speed) {
		this.lato = lato;
		this.speed = speed;
		x = 0;
		dx = true;
		setFocusable(true);		
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				switch (event.getKeyCode()) {
					case KeyEvent.VK_RIGHT:
						moveDx();
						break;
					case KeyEvent.VK_LEFT:
						moveSx();
						break;
				}
			}
		});
	}
	
	public void moveSx() {			
		if(dx == true) {
			dimension = getSize();
			if(x < (dimension.width - (lato * 2))) {
				dx = false;
			}
			else {
				x -= speed;
			}
		}
		else {
			if(x >= 0) {
				dx = true;
				x -= speed;
			}
		}
		repaint();
	}
	
	public void moveDx() {			
		if(dx == true) {
			dimension = getSize();
			if(x > (dimension.width - (lato * 2))) {
				dx = false;
			}
			else {
				x += speed;
			}
		}
		else {
			if(x <= 0) {
				dx = true;
				x += speed;
			}
		}
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		dimension = getSize();
		g.setColor(Color.green);
		g.fillRect(x, (dimension.height - 61), lato, lato); // Disegno un quadrato (x, y, larghezza, altezza)
	}
}
