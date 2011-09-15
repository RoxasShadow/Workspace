import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Opponent extends Panel implements ActionListener {
	int lato; // Il lato del quadrato
	int x; // La posizione sull'asse x
	int speed; // La velocità di movimento del quadrato
	boolean dx;
	int delay; // I millisecondi che passano ad ogni scatto del timer
	Timer timer;
	Dimension dimension;
	
	public Opponent(int lato, int speed, int delay) {
		this.lato = lato;
		this.speed = speed;
		this.delay = delay;
		x = 0;
		dx = true;
		timer = new Timer(delay, this); // Creo un timer che scatta ad ogni delay ms
		timer.start(); // Avvio il timer
	}
	
	public void actionPerformed(ActionEvent e) { // Ad ogni scatto del timer
		if(dx == true) {
			Dimension dimension = getSize();
			if(x > (dimension.width - (lato * 2))) { // Se x è maggiore del lato*2 significa che si trova sul bordo della finestra
				dx = false;
				x -= speed; // Quindi ritorna indietro
			}
			else {
				x += speed; // Altrimenti va avanti
			}
		}
		else {
			if(x <= 0) { // Se x è minore o uguale a 0 significa che si trova sul bordo della finestra
				dx = true;
				x += speed; // Quindi va avanti
			}
			else {
				x -= speed; // Altrimenti va indietro
			}
		}
		repaint(); // Ridisegna il quadrato
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		dimension = getSize();
		g.setColor(Color.green);
		g.fillRect(x, 0, lato, lato); // Disegno un quadrato (x, y, larghezza, altezza)
	}
}
