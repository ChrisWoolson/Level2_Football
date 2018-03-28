import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class Alien extends GameObject {
	public boolean upa;

	public static boolean downa;
	public static boolean lefta;
	public static boolean righta;

	public double baseSpeed = 1;
public double currentSpeed;
	
	
	
	public int speed2Timer;

	public Alien(int x, int y, int width, int height, int baseSpeed) {
		super(x, y, width, height);
		this.baseSpeed = baseSpeed;
currentSpeed = baseSpeed;
	}

	void update() {
		super.update();

		speed2Timer++;

		if (speed2Timer % 4 == 0) {

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
			}

			
			
			
			
			if ( Math.abs(RocketShip.rX - x) < 400 && Math.abs(RocketShip.rY - y ) < 400) {
				currentSpeed = baseSpeed +2;
			}else 
			{
				currentSpeed = baseSpeed;
				
				if(x > 1400) {
					y++;
				}
				
			}
			
			
			
			
			
		}

	}

	void draw(Graphics g) {
		g.setColor(Color.yellow);
		g.drawRect(x, y, width, height);

	}

}
