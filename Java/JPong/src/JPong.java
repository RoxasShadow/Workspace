/**
	SpaceConqueror.java
	(C) Giovanni Capuano 2011
*/
import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.ColorBackground;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import com.golden.gamedev.object.GameFont;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.awt.*;
import java.awt.geom.*;

public class JPong extends Game {
	{
		distribute = true;
	}
	private int x = 20; //posizione pallina
	private int y = 10;
	private int sx = 1; // incremento posizione pallina
	private int sy = 1;
	private int p1  = 0;   // punteggo
	private int p2  = 0;
	private int speed = 3; // velocità pallina
	private int r1 = 100; // posizione racchetta 1
	private int r2 = 100; // posizione racchetta 2
	private int incR = 5; // incremento posizione racchette
	public int width = 640;
	public int height = 480;
	private PlayField playfield;
	private boolean fullscreen = false; // Schermo intero?
	private boolean pause = true; // Avvio immediato della partita
	private boolean show = false;
	private String message;
	
	public void initResources() {
		playfield = new PlayField(new ColorBackground(Color.black, width, height));
        	setFPS(100);
	}

	public void update(long elapsedTime) {
		playfield.update(elapsedTime);
		if(pause) {
			draw("Type ENTER to resume or ESCAPE to start the game.");
			if(keyPressed(KeyEvent.VK_ENTER))
				pause = false; // Riprendi
			if(keyPressed(KeyEvent.VK_ESCAPE))
				finish(); // Termina
		}
		else {
			if(keyPressed(KeyEvent.VK_A))
				r1 -= incR;
			if(keyPressed(KeyEvent.VK_Z))
				r1 += incR;
			if(keyPressed(KeyEvent.VK_K))
				r2 -= incR;
			if(keyPressed(KeyEvent.VK_M))
				r2 += incR;
			if(keyPressed(KeyEvent.VK_SHIFT))
				pause = true; // Pausa
		}
	}

	public void render(Graphics2D canvas) {
		playfield.render(canvas);
		canvas.setColor(Color.white);
		canvas.setFont(new Font("Monospaced", Font.PLAIN, 12));
		if(pause) {
			draw("Type ENTER to start the game.");
			if(keyPressed(KeyEvent.VK_ENTER))
				pause = false;
		}
		if((show) && (message != null)) {
			canvas.drawString(message, 10, getHeight()/2);
			show = false;
			message = null;
		}
		if(!pause) {
			canvas.clearRect(x, y, 11, 11); // palla
			canvas.clearRect(10, r1, 11, 61); // r1
			canvas.clearRect(width-20, r2, 11, 61); // r2
			x += sx;
			y += sy;
			if((y < 0) || (y > height))
				sy *= -1;
			if(x > width) {
				++p1;
				x = width / 2;
				y = height / 2;
			}
			if(x < 0) {
				++p2;
				x = width / 2;
				y = height / 2;
			}
			if((x<= 20) && (x >=10) && (y >= r1) && (y <= (r1 +60)))
				sx *= -1;
			if(((x<= width - 10)) && (x >=(width - 30)) && (y >= r2) && (y <= (r2 +60)))
				sx *= -1;
			canvas.draw(new Line2D.Double(width/2,  0,  width/2, height)); // Linea verticale
			canvas.draw(new Rectangle2D.Double(x, y, 10, 10)); // palla
			canvas.draw(new Rectangle2D.Double(10, r1, 10, 60)); // r1
			canvas.draw(new Rectangle2D.Double(width-20, r2, 10, 60)); // r2
			canvas.drawString("Points: "+p1, width/2-100, 10); // p1
			canvas.drawString("Points: "+p2, width/2+50, 10); // p2
			canvas.drawString("2011 (C) Giovanni Capuano", width-180, height-10);
			canvas.drawString("Pause: SHIFT", width-100, height-30);
			try {
				Thread.sleep(speed);
			}
			catch(Exception e) {}
		}
	}
	
	public void draw(String message) {
		this.message = new String(message);
		show = true;
	}

	public static void main(String[] args) {
		GameLoader game = new GameLoader();
		JPong pong = new JPong();
		game.setup(pong, new Dimension(pong.width, pong.height), false);
		game.start();
	}
}
