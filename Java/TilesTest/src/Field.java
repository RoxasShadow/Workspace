import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Random;
import java.awt.image.*;
import java.io.*;
import java.awt.event.*;

class Field extends JPanel implements KeyListener {
	private Graphics2D field;
   	private int rows, cols, tileWidth, tileHeight, playerX, playerY, playerSpeed;
   	private char[] map;
   	
   	public Field(int width, int height) {
   		setTileWidth(16);
   		setTileHeight(16);
   		setRows(width/getTileWidth());
   		setCols(height/getTileHeight());
   		setPlayerX(0);
   		setPlayerY(0);
   		setPlayerSpeed(2);
   		setMap(loadMap("res/map.txt"));
   	}
   	
   	private char[] loadMap(String path) {
   		StringBuilder map = new StringBuilder("");
   		try {
   			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
   			String line;
   			while((line = reader.readLine()) != null)
   				map.append(line);
   		}
   		catch(IOException e) {
   			System.out.println("Error while reading the map.");
   		}
   		return map.toString().toCharArray();
   	}
   	
   	private static char[] fillArray(char[] array, int length, char element) {
   		char[] newArray = new char[length];
   		
   		for(int i=0; i<length; ++i)
   			newArray[i] = (i < array.length) ? array[i] : element;
   		return newArray;
   	}
   	
   	public void keyPressed(KeyEvent e) {
   		switch(e.getKeyCode()) {
   			case KeyEvent.VK_LEFT:
   				setPlayerX(getPlayerX()-getPlayerSpeed());
   				repaint();
   				break;
   			case KeyEvent.VK_RIGHT:
   				setPlayerX(getPlayerX()+getPlayerSpeed());
   				repaint();
   				break;
   			case KeyEvent.VK_UP:
   				setPlayerY(getPlayerY()-getPlayerSpeed());
   				repaint();
   				break;
   			case KeyEvent.VK_DOWN:
   				setPlayerY(getPlayerY()+getPlayerSpeed());
   				repaint();
   		}
   	}
   	
   	public void keyReleased(KeyEvent e) {}
   	public void keyTyped(KeyEvent e) {}
   	
	public void paint(Graphics graphics) {
		field = (Graphics2D)graphics;
		field.setColor(Color.black);
		char[] map = getMap();
		if(map.length < getRows())
			map = Field.fillArray(map, getRows(), '0');
		try {
			for(int x=0; x<getRows(); ++x) {
				BufferedImage tile;
				switch(map[x]) {
					case '0':
						tile = Tiles.getTile(Tiles.Types.VOID);
						break;
					case '1':
						tile = Tiles.getTile(Tiles.Types.CAVE);
						break;
					case '2':
						tile = Tiles.getTile(Tiles.Types.METAL);
						break;
					case '3':
						tile = Tiles.getTile(Tiles.Types.SEA);
						break;
					default:
						tile = Tiles.getTile(Tiles.Types.VOID);
				}
				for(int y=0; y<getCols(); ++y)
					field.drawImage(tile, x*getTileWidth(), y*getTileHeight(), null);
			}
			field.drawImage(Actors.getActor(Actors.Types.PLAYER), getPlayerX(), getPlayerY(), null);
		}
		catch(IOException e) {
			System.out.println("Error loading some tiles.");
		}
	}
   	
   	public void setRows(int rows) {
   		this.rows = rows;
   	}
   	
   	public void setCols(int cols) {
   		this.cols = cols;
   	}
   	
   	public void setTileWidth(int tileWidth) {
   		this.tileWidth = tileWidth;
   	}
   	
   	public void setTileHeight(int tileHeight) {
   		this.tileHeight = tileHeight;
   	}
   	
   	public void setPlayerX(int playerX) {
   		this.playerX = playerX;
   	}
   	
   	public void setPlayerY(int playerY) {
   		this.playerY = playerY;
   	}
   	
   	public void setPlayerSpeed(int playerSpeed) {
   		this.playerSpeed = playerSpeed;
   	}
   	
   	public void setMap(char[] map) {
   		this.map = map;
   	}
   	
   	public int getRows() {
   		return rows;
   	}
   	
   	public int getCols() {
   		return cols;
   	}
   	
   	public int getTileWidth() {
   		return tileWidth;
   	}
   	
   	public int getTileHeight() {
   		return tileHeight;
   	}
   	
   	public int getPlayerX() {
   		return playerX;
   	}
   	
   	public int getPlayerY() {
   		return playerY;
   	}
   	
   	public int getPlayerSpeed() {
   		return playerSpeed;
   	}
   	
   	public char[] getMap() {
   		return map;
   	}
}
