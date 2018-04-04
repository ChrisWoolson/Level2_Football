import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RocketShip extends GameObject {
	public int speed;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public static int rX;
	public static int rY;
	public boolean TDhasBall;
	
	
	
	
	public BufferedImage subImage;
	public BufferedImage subImage2;
	
	public BufferedImage subImageStay;
	
	
	public BufferedImage subImageUp;
	public BufferedImage subImageUp2;
	
	
	public BufferedImage subImageDown;
	public BufferedImage subImageDown2;
	
	
	
	
	
	
	
	int tim = 0;
	public static boolean ballAlive = true;

	public int slope;
	public int sx;
	public int sy;
	public GamePanel panel;
	int count = 0;
	public int checkTd;

	public int ay1;
	public int ay2;

	public RocketShip(int x, int y, int width, int height, GamePanel panel) {
		super(x, y, width, height);
		speed = -5;
		this.panel = panel;

		try {

			BufferedImage img = ImageIO.read(this.getClass().getResourceAsStream("Player.png"));
			subImage = img.getSubimage(48, 16, 16, 16);
			subImage2 = img.getSubimage(48, 32, 16, 16);
			
			subImageStay = img.getSubimage(0, 0, 16, 16);
			
			subImageUp = img.getSubimage(16, 16, 16, 16);
			subImageUp2 = img.getSubimage(16, 48, 16, 16);
			
			
			subImageDown = img.getSubimage(0, 16, 16, 16);
			subImageDown2 = img.getSubimage(0, 48, 16, 16);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void update() {

		rX = this.x; // used for locating the rocket
		rY = this.y;

		// ObjectManager.getAlienX();
		if (ObjectManager.aX > rX) {
			Alien.downa = true;

		}

		super.update();
		if (up) {
			this.y = this.y + speed;
		}

		if (down) {
			this.y = this.y - speed;
		}

		if (left) {
			this.x = this.x + speed;
		}

		if (right) {
			this.x = this.x - speed;
		}

		checkTD();
		checkBoundries();
	}

	void checkTD() {
		if (x > 1600 && TDhasBall == true) {
			System.out.println("touchdown");
			checkTd = 1;
			panel.currentState = 2;

		} else {
			// checkTd = 0;
			System.out.println("noTD");
		}

	}

	void checkBoundries() {

		if (x < 0) {
			panel.currentState = panel.END_STATE;

		}

		else if (y < 0 || y > 900) {
			panel.currentState = panel.END_STATE;
		}

	}

	void draw(Graphics g) {

		if (ObjectManager.hasBall == true) {

			g.setColor(new Color(169, 110, 52));
			g.fillRect(x + 40, y, 20, 20);

			ballAlive = false;

			TDhasBall = true;

		}

		
		long currentMs = System.currentTimeMillis() % 1000;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		if(right  || right && up || right && down) {
		System.out.println(currentMs);
		if (currentMs > 500) {

			g.drawImage(subImage2, x, y, width, height, null);

			count++;

		} else {

			g.drawImage(subImage, x, y, width, height, null);

			count = 0;
		}

		}
		
		
		
		
		else if(up) {
			System.out.println(currentMs);
			if (currentMs > 500) {

				g.drawImage(subImageUp2, x, y, width, height, null);

				count++;

			} else {

				g.drawImage(subImageUp, x, y, width, height, null);

				count = 0;
			}

			}
		
		
		else if(down) {
			System.out.println(currentMs);
			if (currentMs > 500) {

				g.drawImage(subImageDown2, x, y, width, height, null);

				count++;

			} else {

				g.drawImage(subImageDown, x, y, width, height, null);

				count = 0;
			}

			}
		
		else {
			g.drawImage(subImageStay, x, y, width, height, null);
		}
		
		
	}
	
}
