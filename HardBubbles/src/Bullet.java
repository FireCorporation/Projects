import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Bullet {
	
	double x;
	double y;
	int r;
	double rdx;
	double rdy;
	int rSpeed;
	
	BufferedImage bi;
	
	public Bullet() {
		x = Player.x;
		y = Player.y;
		
		r = 2;
		
		rSpeed = 15;
		
		try{bi = ImageIO.read(new File("images/bullet.png"));}catch(Exception e){}
		
		double distX = GamePanel.mouseX - Player.x;
		double distY = GamePanel.mouseY - Player.y;
		double dist = Math.sqrt(distX*distX+distY*distY);
		
		rdx = distX/dist*rSpeed;
		rdy = distY/dist*rSpeed;
	}
	
	void move() {
		double dx = 0;
		double dy = 0;
		try{
			dx = rdx*((double)GamePanel.mustFPS/GamePanel.FPS);
			dy = rdy*((double)GamePanel.mustFPS/GamePanel.FPS);
		}catch(Exception e){}
		
		x += dx;
		y += dy;
	}
	
	void destroy(int index) {
		try {
			if(x+r <= 0)
				GamePanel.b.remove(index);
			if(x-r >= GamePanel.WIDTH)
				GamePanel.b.remove(index);
			if(y+r <= 0)
				GamePanel.b.remove(index);
			if(y-r >= GamePanel.HEIGHT)
				GamePanel.b.remove(index);
		}catch(Exception e) {}
	}
	
	void update(int index) {
		move();
		destroy(index);
	}
	
	void draw(Graphics2D g) {
		g.drawImage(bi, (int)x-r, (int)y-r, r*2, r*2, null);
	}
}
