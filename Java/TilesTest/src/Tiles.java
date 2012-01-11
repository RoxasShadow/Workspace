import java.awt.*;
import java.util.HashMap;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

class Tiles {
	public static enum Types {
		CAVE,
		METAL,
		SEA,
		VOID
	}
	
	public static BufferedImage getTile(Types type) throws IOException {
		BufferedImage tile;
		switch(type) {
			case CAVE:
				tile = getCave();
				break;
			case METAL:
				tile = getMetal();
				break;
			case SEA:
				tile = getSea();
				break;
			case VOID:
				tile = getVoid();
				break;
			default:
				tile = getVoid();
		}
		return tile;
	}
	
	public static BufferedImage getCave() throws IOException {
		return ImageIO.read(new File("res/cave.png"));
	}
	
	public static BufferedImage getMetal() throws IOException {
		return ImageIO.read(new File("res/metal.png"));
	}
	
	public static BufferedImage getSea() throws IOException {
		return ImageIO.read(new File("res/sea.png"));
	}
	
	public static BufferedImage getVoid() throws IOException {
		return ImageIO.read(new File("res/void.png"));
	}
}
