import java.awt.Color;

import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;

import com.sun.glass.ui.Timer;
import java.util.Random;

public class Ball extends GameObject {
	public boolean upa;
	Timer tball;
	// public Random rand = new Random();
	public double speeda = 1;
	public boolean kicked = false;

	Random r3 = new Random();

	int na2 = r3.nextInt(8);

	Random rp = new Random();

	int positive = (rp.nextInt(6) - 3);

	// GamePanel panel = new GamePanel();

	// double slope = 360/na2 ;
	int kick;

	int time2;

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// int random = rand.nextInt(40);

	}

	void update() {

		super.update();

		Kickoff();

		kick++;

		time2++;

		ballLife();

		
		
		
		
		
		
	}

	void draw(Graphics g) {
		g.setColor(new Color(139, 69, 19));
		g.fillRect(x, y, width, height);

	}

	public void Kickoff() {

		if (kick < 360) {
			x = x - 4;
			if (y > 900) {
				y = 900;
				System.out.println("ballGreater");
			} else if (y < 100) {
				y = 50;
			} else {
				// x = x - 4;
				/*
				 * if(positive % 2 == 0) {
				 * 
				 * y = (int) (y-na2); System.out.println("positive");
				 * 
				 * }
				 * 
				 * 
				 * if(positive % 2 == 1) {
				 * 
				 * 
				 * y = (int) (y+na2); System.out.println("negative");
				 * 
				 * }
				 * 
				 * }
				 */

				y = y - positive;

			}
		}

	}

	void ballLife() {

		if (RocketShip.ballAlive == false) {
			width = 0;
			height = 0;
		}
	}

	
	
	
	
	
	
	
	
}