import java.awt.*;
import java.util.HashMap;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

class Actors {
	public static enum Types {
		PLAYER
	}
	
	public static BufferedImage getActor(Types type) throws IOException {
		BufferedImage tile;
		switch(type) {
			case PLAYER:
				tile = getPlayer();
				break;
			default:
				tile = getPlayer();
		}
		return tile;
	}
	
	public static BufferedImage getPlayer() throws IOException {
		return ImageIO.read(new File("res/pg.gif"));
	}
}
