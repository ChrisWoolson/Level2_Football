import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import com.sun.javafx.font.directwrite.RECT;

public class Alien<aX> extends GameObject {
	public boolean upa;

	public static boolean downa;
	public static boolean lefta;
	public static boolean righta;
	public int collideTimeR2;
	public double baseSpeed = 1;
	public double currentSpeed;
boolean alreadyCollided;
	public static int id;

	public int collidedTimer;
	static int aY;
	static int aX;

	public ObjectManager manager1;

	boolean collided;
	static int oX;
	static int oY;

	public BufferedImage subImage3;
	public BufferedImage subImage4;

	public int speed2Timer;

	public Alien(int x, int y, int width, int height, int baseSpeed, int id, ObjectManager manager1) {
		super(x, y, width, height);
		this.baseSpeed = baseSpeed;
		currentSpeed = baseSpeed;

		BufferedImage img;
		try {
			img = ImageIO.read(this.getClass().getResourceAsStream("Defence.png"));
			subImage4 = img.getSubimage(198, 66, 66, 66);
			subImage3 = img.getSubimage(0, 66, 66, 66);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void update() {
		
		if(collided == true && alreadyCollided == false) {
			x = x + 120;
			currentSpeed = currentSpeed - 2;
			alreadyCollided = true;
			
		}
		
		
		super.update();

		aY = y;
		aX = x;

		speed2Timer++;

		if (speed2Timer % 4 == 0 ) {

			if (y < RocketShip.rY) {

				y = (int) (y + currentSpeed);
			}
			if (x < RocketShip.rX) {
				x = (int) (x + currentSpeed);
			}

			if (y > RocketShip.rY) {

				y = (int) (y - currentSpeed);

			}

			if (x > RocketShip.rX) {

				x = (int) (x - currentSpeed);
/*
				if (collided == true) {
					collideTimeR2++;
					x = (int) (x + currentSpeed);

					if (collideTimeR2 % 2 == 1) {
						
						//x = x - 5;
					}
				}
				/*
				if(x< ally.x) {
					
				}
				*/
				
			}

			/*
			 * for (Alien at : manager.alien) {
			 * 
			 * 
			 * if(ObjectManager.collided == true) { x = x + 20; }
			 * 
			 * }
			 */

			if (Math.abs(RocketShip.rX - x) < 400 && Math.abs(RocketShip.rY - y) < 400) {
				currentSpeed = baseSpeed + 2;
			} else {
				currentSpeed = baseSpeed;
			}}}
				/*
				 * if(x > 1400) { y++; }
				 */
	/*		}

		} else if (collided && speed2Timer %10 == 0) {
			x = x + 20;
			manager1.allies.remove();
		}

	}
*/
	void draw(Graphics g) {

		long currentMs = System.currentTimeMillis() % 1000;
		// System.out.println(currentMs);
		if (currentMs > 500) {

			g.drawImage(subImage3, x, y, width, height, null);

		} else {

			g.drawImage(subImage4, x, y, width, height, null);

		}

	}

}
