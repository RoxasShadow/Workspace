/**
	JPong.java
	(C) Giovanni Capuano 2011
*/
import com.golden.gamedev.*;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.background.ColorBackground;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

public class JPong extends Game {
	{
		distribute = true;
	}
	private int x = 20; // Iosizione pallina
	private int y = 10;
	private int sx = 1; // Incremento posizione pallina
	private int sy = 1;
	private int p1  = 0;   // Punteggo
	private int p2  = 0;
	private int speed = 3; // Velocità pallina
	private int r1 = 100; // Posizione racchetta 1
	private int r2 = 100; // Posizione racchetta 2
	private int incR = 5; // Incremento posizione racchette
	private int width = 640; // Larghezza
	private int height = 480; // Altezza
	private PlayField playfield; // Campo da gioco
	private boolean fullscreen = false; // Schermo intero?
	private boolean pause = true; // Avvio immediato della partita
	private boolean show = false; // Mostra menù
	private String message; // Testo menù
	
	public void initResources() {
		playfield = new PlayField(new ColorBackground(Color.black, width, height)); // Sfondo nero
        	setFPS(100);
	}

	public void update(long elapsedTime) {
		playfield.update(elapsedTime);
		if(isPause()) {
			draw("Type ENTER to resume or ESCAPE to start the game.");
			if(keyPressed(KeyEvent.VK_ENTER))
				setPause(false); // Riprendi
			if(keyPressed(KeyEvent.VK_ESCAPE))
				finish(); // Termina
		}
		else {
			if(keyPressed(KeyEvent.VK_A))
				setR1(getR1() - getIncR());
			if(keyPressed(KeyEvent.VK_Z))
				setR1(getR1() + getIncR());
			if(keyPressed(KeyEvent.VK_K))
				setR2(getR2() - getIncR());
			if(keyPressed(KeyEvent.VK_M))
				setR2(getR2() + getIncR());
			if(keyPressed(KeyEvent.VK_UP)) {
				setR1(getR1() - getIncR());
				setR2(getR2() - getIncR());
			}
			if(keyPressed(KeyEvent.VK_DOWN)) {
				setR1(getR1() + getIncR());
				setR2(getR2() + getIncR());
			}
			if(keyPressed(KeyEvent.VK_SHIFT))
				setPause(true); // Pausa
		}
	}

	public void render(Graphics2D canvas) {
		playfield.render(canvas);
		canvas.setColor(Color.white);
		canvas.setFont(new Font("Monospaced", Font.PLAIN, 12));
		if(isPause()) {
			draw("Type ENTER to start the game.");
			if(keyPressed(KeyEvent.VK_ENTER))
				setPause(false);
		}
		if((show) && (message != null)) {
			canvas.drawString(message, 10, getHeight()/2);
			setShow(false);
			message = null;
		}
		if(!isPause()) {
			canvas.clearRect(getX(), getY(), 11, 11); // Elimina la vecchia pallina
			canvas.clearRect(10, getR1(), 11, 61); // r1
			canvas.clearRect(getWidth()-20, getR2(), 11, 61); // r2
			setX(getX() + getSx()); // Sposta la pallina
			setY(getY() + getSy()); // Sposta la pallina
			if((getY() < 0) || (getY() > getHeight()))
				setSy(getSy() * -1); // Ritorna indietro
			if(getX() > getWidth()) { // Fail
				setP1(getP1() + 1); // Aumenta il punteggio
				setX(getWidth() / 2); // La pallina parte dal centro
				setY(getHeight() / 2);
			}
			if(getX() < 0) {
				setP2(getP2() + 1);
				setX(getWidth() / 2);
				setY(getHeight() / 2);
			}
			if((getX() <= 20) && (getX() >= 10) && (getY() >= getR1()) && (getY() <= (getR1() +60))) // Collisioni
				setSx(getSx() * -1);
			if(((getX() <= width - 10)) && (getX() >= (getWidth() - 30)) && (getY() >= getR2()) && (getY() <= (getR2() +60)))
				setSx(getSx() * -1);
			canvas.draw(new Line2D.Double(getWidth()/2,  0,  getWidth()/2, getHeight())); // Linea verticale
			canvas.draw(new Rectangle2D.Double(getX(), getY(), 10, 10)); // Pallina
			canvas.draw(new Rectangle2D.Double(10, getR1(), 10, 60)); // r1
			canvas.draw(new Rectangle2D.Double(getWidth()-20, getR2(), 10, 60)); // r2
			canvas.drawString("Points: "+getP1(), getWidth()/2-100, 10); // p1
			canvas.drawString("Points: "+getP1(), getWidth()/2+50, 10); // p2
			canvas.drawString("2011 (C) Giovanni Capuano", getWidth()-180, getHeight()-10); // Credits
			canvas.drawString("Pause: SHIFT", getWidth()-100, getHeight()-30);
			try {
				Thread.sleep(getSpeed()); // Intervallo del movimento della pallina
			}
			catch(Exception e) {}
		}
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getP1() {
		return p1;
	}
	
	public void setP1(int p1) {
		this.p1 = p1;
	}
	
	public int getP2() {
		return p2;
	}
	
	public void setP2(int p2) {
		this.p2 = p2;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getSx() {
		return sx;
	}
	
	public int getSy() {
		return sy;
	}
	
	public void setSx(int sx) {
		this.sx = sx;
	}
	
	public void setSy(int sy) {
		this.sy = sy;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean isPause() {
		return pause;
	}
	
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	public void setShow(boolean show) {
		this.show = show;
	}
	
	public boolean isShow() {
		return show;
	}
	
	public void setR1(int r1) {
		this.r1 = r1;
	}
	
	public void setR2(int r2) {
		this.r2 = r2;
	}
	
	public int getR1() {
		return r1;
	}
	
	public int getR2() {
		return r2;
	}
	
	public int getIncR() {
		return incR;
	}
		
	public boolean isFullscreen() {
		return fullscreen;
	}
	
	public void draw(String message) {
		this.message = new String(message); // Stampa il messaggio nel menù
		setShow(true);
	}

	public static void main(String[] args) {
		GameLoader game = new GameLoader();
		JPong pong = new JPong();
		game.setup(pong, new Dimension(pong.getWidth(), pong.getHeight()), pong.isFullscreen());
		game.start();
	}
}
