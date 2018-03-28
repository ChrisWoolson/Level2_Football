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

	public static boolean ballAlive = true;

	public int slope;
	public int sx;
	public int sy;
	public GamePanel panel;

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

		g.drawImage(subImage, x, y, width, height, null);

	}

}
