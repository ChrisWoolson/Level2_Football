import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
	public int speed;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;

	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = -5;

	}

	void update() {
<<<<<<< HEAD
=======
		
		rX = this.x;     //used for locating the rocket
			rY = this.y;
		
			
			//ObjectManager.getAlienX();
			if(ObjectManager.aX > rX) {
				Alien.downa = true;
				
			}
			
	
			
			

			
>>>>>>> f4cd9deb9b256498c7b0110b87abc6d7e17cdc74
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

	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

}
