import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Background {
	
	BufferedImage bi;
	
	public Background() {
		try{bi = ImageIO.read(new File("images/background.png"));}catch(Exception e){}
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(bi, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
	}
}
