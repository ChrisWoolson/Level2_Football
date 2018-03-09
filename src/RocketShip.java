import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
	public int speed;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
 public static int rX;
public static int rY;

public int slope;
public int sx;
public int sy;

public int ay1;
public int ay2;
	public RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = -5;

	}

	void update() {
<<<<<<< HEAD

=======
>>>>>>> parent of 3cafadb... /
		
		rX = this.x;     //used for locating the rocket
			rY = this.y;
		
			
<<<<<<< HEAD
			//ObjectManager.getAlienX();
=======
			ObjectManager.getAlienX();
>>>>>>> parent of 3cafadb... /
			if(ObjectManager.aX > rX) {
				Alien.downa = true;
				
			}
			
	
			
			

			
<<<<<<< HEAD

=======
>>>>>>> parent of 3cafadb... /
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
