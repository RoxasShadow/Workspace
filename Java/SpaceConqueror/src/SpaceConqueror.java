/**
	SpaceConqueror.java
	(C) Giovanni Capuano 2011
*/
import com.golden.gamedev.*;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.background.ImageBackground;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import com.golden.gamedev.object.GameFont;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

public class SpaceConqueror extends Game {
	{
		distribute = true;
	}
	public PlayField playfield;
	private AnimatedSprite player;
	private SpriteGroup playerGroup;
	private SpriteGroup opponent;
	private SpriteGroup playerShots;
	private SpriteGroup opponentShots;
	private Sprite[] sprites;
	private Timer oppoTimer;
	private Timer oppoShot;
	private CollisionManager collision;
	private ImageBackground background;
	private Hashtable<String, String> spriteDatabase = new Hashtable<String, String>();
	private GameFont font;
	private String message; // Testo del menu
	private boolean gameover = false;
	private boolean gameOverForYou; //true=hai perso; false=prossimo livello
	private boolean show = false; // Mostra il menu
	private int lifes;
	
	/* Configurazione */
	private boolean fullscreen = false; // Schermo intero?
	private boolean sound = false; // Suono
	private boolean pause = true; // Avvio immediato della partita
	private double playerSpeed = 10.0; // Velocità di movimento del giocatore
	private double oppoSpeed = 0.04; // Velocità di movimento dei nemici
	private double shotSpeed = 0.2; // Velocità del colpo
	private int width = 640; // Larghezza video
	private int height = 480; // Altezza video
	private int opponentColumns = 2; // Colonne di nemici
	private int opponentRows = 3; // Righe di nemici
	private int oppoJourney = 2000; // Il tempo dopo il quale i nemici cambiano direzione (ms)
	private int oppoShotDelay = 2000; // La frequenza con cui i nemici sparano (ms)
	private int defaultLifes = 3; // Vite a disposizione
	private int points = 0; // Punteggio di partenza
	private int increaseScoreValue = 30; // Punteggio per ogni nemico ucciso
	private int newLevelColumns = 1; // L'aumento delle colonne di nemici ad ogni nuovo livello
	private int newLevelRows = 1; // L'aumento delle righe di nemici ad ogni nuovo livello
	private int newLevelLifes = 1; // L'aumento di vite ad ogni nuovo livello
	
	/* Crea il database con le risorse all'avvio. */
	public SpaceConqueror() {
		// Questo è il database delle risorse più che degli sprite in realtà...
		addSprite("background", "resources/background.jpg");
		addSprite("player", "resources/player.png");
		addSprite("opponent", "resources/opponent.png");
		addSprite("shot", "resources/shot.png");
		addSprite("explosion", "resources/explosion.png");
		addSprite("font", "resources/font.png");
		addSprite("soundShot", "resources/shot.wav");
		addSprite("music", "resources/music.mp3"); // "Fragments Of Sorrow", credits to Yoko Shimomura - Kingdom Hearts II
		addSprite("gameoverforyou", "Game over. You lose. Type ESC to exit or type ENTER to restart the game.");
		addSprite("gameoverforenemy", "Game over. You win. Type ESC to exit or type ENTER to restart the game.");
		addSprite("resume", "Press ENTER to resume the game or ESC to exit.");
		addSprite("start", "Press ENTER to start the game or ESC to exit.");
		addSprite("points", "Points: ");
		addSprite("lifes", "Lifes: ");
		addSprite("pause", "Pause: SHIFT");
	}		
	
	/* Inizializza le rirose. */
	public void initResources() {
		playfield = new PlayField(); // Crea un campo da gioco
		background = new ImageBackground(getImage(getSprite("background"))); // Crea uno sfondo
		playfield.setBackground(background); // Imposta lo sfondo
		playerShots = new SpriteGroup("playerShots"); // Gruppo dei colpi del giocatore
		opponentShots = new SpriteGroup("opponentShots"); // Gruppo dei colpi nemici
		opponent = new SpriteGroup("Opponents"); // Gruppo dei nemici
		playfield.addGroup(opponent); // Aggiunge il gruppo dei nemici al campo da gioco
		playfield.addGroup(playerShots); // Aggiunge il gruppo dei colpi del giocatore al campo da gioco
		playfield.addGroup(opponentShots); // Aggiunge il gruppo dei colpi nemici al campo da gioco
		addPlayer();
		addOpponents(getOpponentColumns(), getOpponentRows()); // Crea i nemici
		playfield.addCollisionGroup(opponentShots, playerGroup, new CollisionManager(this, false)); // Gestore collisioni per i nemici
		playfield.addCollisionGroup(playerShots, opponent, new CollisionManager(this, true)); // Gestore collisioni per il giocatore
		setLifes(getDefaultLifes()); // Imposta la vita come di default
		if(isSound())
			playMusic(getSprite("music"));
        	font = fontManager.getFont(getImages(getSprite("font"), 8, 12), " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~~");
        	setFPS(100);
	}
	
	public void update(long elapsedTime) {
		if(isGameover()) {
			if(isGameOverForYou())
				draw(getSprite("gameoverforyou"));
			else
				draw(getSprite("gameoverforenemy"));
			if(keyPressed(KeyEvent.VK_ENTER))
				if(!isGameOverForYou())
					restart(true); // Aumenta di livello
				else
					restart(false); // Riavvia
			if(keyPressed(KeyEvent.VK_ESCAPE))
				finish(); // Termina
		}
		else if(isPause()) {
			draw(getSprite("resume"));
			if(keyPressed(KeyEvent.VK_ENTER))
				setPause(false); // Riprendi
			if(keyPressed(KeyEvent.VK_ESCAPE))
				finish(); // Termina
		}
		if((!isPause()) && (isObjectActive(playerGroup, 0))) {
			playfield.update(elapsedTime); // Aggiorna il campo da gioco
			background.setToCenter(player); // Imposta lo sfondo al centro del giocatore
			if(keyPressed(KeyEvent.VK_UP))
				player.move(0, -playerSpeed); // Sopra
			if(keyPressed(KeyEvent.VK_DOWN))
				player.move(0, playerSpeed); // Sotto
			if(keyPressed(KeyEvent.VK_LEFT))
				player.move(-playerSpeed, 0); // Sinistra
			if(keyPressed(KeyEvent.VK_RIGHT))
				player.move(playerSpeed, 0); // Destra
			if(keyPressed(KeyEvent.VK_SHIFT))
				setPause(true); // Pausa
			if(keyPressed(KeyEvent.VK_SPACE))
				playerShot(); // Spara
			if(oppoTimer.action(elapsedTime)) { // Ogni oppoTimer
				sprites = opponent.getSprites(); // Copia gli sprite dei nemici
				for(int i=0, size=opponent.getSize(); i<size; ++i) // E ogni nemico
					sprites[i].setHorizontalSpeed(-sprites[i].getHorizontalSpeed()); // Torna a muoversi nel senso contrario
			}
		
			if((oppoShot == null) || (oppoShot.action(elapsedTime))) // Ogni oppoShot e all'avvio del gioco
				opponentShot(); // Il nemico spara
			
			/* Controllo gameover per il player */
			if(!isObjectActive(playerGroup, 0)) // Se è stato distrutto dal collision manager
				if(getLifes()-1 > 0) {
					setLifes(getLifes()-1);
					setObjectActive(playerGroup, true, 0);
				}
				else
					gameover(true); // Gioco finito: hai perso
			
			/* Controllo gameover per i nemici */
			boolean died = true;
			for(int i=0, size=opponent.getSize(); i<size; ++i)
				if(isObjectActive(opponent, i)) {
					died = false;
					break;
				}
			if(died) // Se nessun nemico è vivo 
				gameover(false); // Prossimo livello
		}
	}
	
	public void restart(boolean nextLevel) {
		if(nextLevel) {
			setLifes(getLifes()+getNewLevelLifes()); // Aumenta la vita
			for(int i=0, size=opponent.getSize(); i<size; ++i)
				setObjectActive(opponent, false, i); // Uccide tutti i nemici
			for(int i=0, size=opponentShots.getSize(); i<size; ++i)
				setObjectActive(opponentShots, false, i); // Elimina tutti i colpi nemici
			for(int i=0, size=playerShots.getSize(); i<size; ++i)
				setObjectActive(playerShots, false, i); // Elimina tutti i colpi del giocatore
			setOpponentRows(getOpponentRows()+getNewLevelRows()); // Aumenta il numero di righe di nemici
			setOpponentColumns(getOpponentColumns()+getNewLevelColumns()); // Aumenta il numero di colonne di nemici
			addOpponents(getOpponentColumns(), getOpponentRows()); // Ricrea i nemici
			setObjectActive(playerGroup, true, 0); // Ti fa vivere
			setGameover(false); // Game over terminato, si gioca!
		}
		else {
			setPoints(0); // Azzera i punti
			setLifes(getDefaultLifes()); // Imposta la vita di default
			for(int i=0, size=opponent.getSize(); i<size; ++i)
				setObjectActive(opponent, false, i); // Uccide tutti i nemici
			for(int i=0, size=opponentShots.getSize(); i<size; ++i)
				setObjectActive(opponentShots, false, i); // Elimina tutti i colpi nemici
			for(int i=0, size=playerShots.getSize(); i<size; ++i)
				setObjectActive(playerShots, false, i); // Elimina tutti i colpi del giocatore
			addOpponents(getOpponentColumns(), getOpponentRows()); // Ricrea i nemici
			setObjectActive(playerGroup, true, 0); // Ti fa vivere
			setGameover(false); // Game over terminato, si gioca!
		}
	}
	
	public void addOpponents(int col, int rows) {
		for(int j=0; j<col; ++j) {
			for(int i=0; i<rows; ++i) {
				Sprite oppo = new Sprite(getImage(getSprite("opponent")));
				oppo.setLocation(i*250, j*70);
				oppo.setHorizontalSpeed(oppoSpeed); // Velocità di movimento orizzontale
				opponent.add(oppo);
			}
		}
		oppoTimer = new Timer(oppoJourney); // Dopo ogni oppoJourney i nemici cambiano direzione
	}
	
	public void addPlayer() {
		playerGroup = new SpriteGroup("Player"); // Gruppo del giocatore
		player = new AnimatedSprite(getImages(getSprite("player"), 3, 1), getWidth()/2-50, 300); // Sprite del giocatore
		player.setAnimate(true); // Animazione del giocatore
		player.setLoopAnim(true); // Loop dell'animazione del giocatore
		playerGroup.add(player); // Aggiunge il giocatore al suo gruppo
		playfield.addGroup(playerGroup); // Aggiunge il gruppo del giocatore al campo da gioco
	}
	
	public void playerShot() {
		Sprite shot = new Sprite(getImage(getSprite("shot"))); // Colpo
		shot.setLocation(player.getX()+16.5, player.getY()-16); // Locazione colpo
		shot.setVerticalSpeed(-shotSpeed); // Velocità colpo negativa: sale
		playerShots.add(shot); // Aggiunge al gruppo dei colpi del giocatore
		if(isSound())
			playSound(getSprite("soundShot")); // Suono
	}
	
	public void opponentShot() {
		Sprite[] sprites = opponent.getSprites(); // Copio gli sprite dei nemici
		for(int i=0, size=opponent.getSize(); i<size; ++i) {
			if(isObjectActive(opponent, i)) { // Se il nemico è vivo
				Sprite shot = new Sprite(getImage(getSprite("shot"))); // Colpo
				shot.setLocation(sprites[i].getX()+16.5, sprites[i].getY()-16); // Locazione colpo
				shot.setVerticalSpeed(shotSpeed); // Velocità colpo positiva: scende
				opponentShots.add(shot); // Aggiunge al gruppo dei colpi nemici
			}
		}
		oppoShot = new Timer(oppoShotDelay); // Velocità del colpo
	}

	public void render(Graphics2D g) {
		playfield.render(g); // Renderizza il campo da gioco
		font.drawString(g, getSprite("points")+getPoints(), getWidth()-100, 10);
		font.drawString(g, getSprite("lifes")+getLifes(), getWidth()-100, 30);
		font.drawString(g, getSprite("pause"), getWidth()-100, 50);
		font.drawString(g, "2011 (C) Giovanni Capuano", getWidth()-200, getHeight()-10);
		if(isPause()) {
			draw(getSprite("start"));
			if(keyPressed(KeyEvent.VK_ENTER))
				setPause(false);
		}
		if((show) && (message != null)) {
			//playfield.setBackground(new com.golden.gamedev.object.background.ColorBackgroundColorBackground(java.awt.Color.RED));
			font.drawString(g, message, 10, getHeight()/2);
			show = false;
			message = null;
		}
	}
	
	public void draw(String message) {
		this.message = new String(message);
		show = true;
	}
	
	public void gameover(boolean gameOverForYou) {
		this.gameOverForYou = gameOverForYou;
		setGameover(true); // Fallo finire :D
	}
		
	public void addSprite(String name, String value) {
		spriteDatabase.put(name, value);
	}
	
	public boolean isObjectActive(SpriteGroup gm, int index) {
		sprites = gm.getSprites();
		return sprites[index].isActive();
	}
	
	public void setObjectActive(SpriteGroup group, boolean active, int index) {
		sprites = group.getSprites();
		sprites[index].setActive(active);
	}
	
	public boolean isGameOverForYou() {
		return gameOverForYou;
	}
	
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	public boolean isPause() {
		return pause;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean isFullscreen() {
		return fullscreen;
	}
	
	public String getSprite(String name) {
		return spriteDatabase.get(name);
	}
	
	public boolean isGameover() {
		return gameover;
	}
	
	public boolean isSound() {
		return sound;
	}
	
	public void setGameover(boolean gameover) {
		this.gameover = gameover;
	}
	
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
	
	public int getLifes() {
		return lifes;
	}
	
	public int getDefaultLifes() {
		return defaultLifes;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getIncreaseScoreValue() {
		return increaseScoreValue;
	}
	
	public int getOpponentColumns() {
		return opponentColumns;
	}
	
	public void setOpponentColumns(int opponentColumns) {
		this.opponentColumns = opponentColumns;
	}
	
	public int getOpponentRows() {
		return opponentRows;
	}
	
	public void setOpponentRows(int opponentRows) {
		this.opponentRows = opponentRows;
	}
	
	public int getNewLevelColumns() {
		return newLevelColumns;
	}
	
	public int getNewLevelRows() {
		return newLevelRows;
	}
	
	public int getNewLevelLifes() {
		return newLevelLifes;
	}
	
	public void setNewLevelColumns(int newLevelColumns) {
		this.newLevelColumns = newLevelColumns;
	}
	
	public void setNewLevelRows(int newLevelRows) {
		this.newLevelRows = newLevelRows;
	}
	
	public void setNewLevelLifes(int newLevelLifes) {
		this.newLevelLifes = newLevelLifes;
	}

	public static void main(String[] args) {
		GameLoader game = new GameLoader();
		SpaceConqueror space = new SpaceConqueror();
		game.setup(space, new Dimension(space.getWidth(), space.getHeight()), space.isFullscreen());
		game.start();
	}
}

class CollisionManager extends BasicCollisionGroup {
	private SpaceConqueror game;
	private boolean areYou;
	
	public CollisionManager(SpaceConqueror game, boolean areYou) {
		this.game = game;
		this.areYou = areYou;
	}
	
	public void collided(Sprite shot, Sprite object) {
		shot.setActive(false); // Uccide il colpo
		object.setActive(false); // Uccide l'oggetto colpito
		BufferedImage[] images = game.getImages(game.getSprite("explosion"), 7, 1); // Il frame dell'esplosione
		VolatileSprite explosion = new VolatileSprite(images, object.getX(), object.getY()); // Esplode e scompare
		game.playfield.add(explosion); // Aggiugne l'esplosione al campo da gioco
		if(areYou) // Se sei tu il mittente del colpo
			game.setPoints(game.getPoints()+game.getIncreaseScoreValue()); // Aumenta il punteggio
	}
}
