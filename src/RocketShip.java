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
public boolean TDhasBall;

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

	}

	void update() {
		
		rX = this.x;     //used for locating the rocket
			rY = this.y;
		
			
			//ObjectManager.getAlienX();
			if(ObjectManager.aX > rX) {
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

	
	
	int checkTD(){
		if(x > 1600 && TDhasBall == true) {
			System.out.println("touchdown");
			panel.currentState = 2;
			return checkTd = 1;
			
		}else {
		return checkTd = 0;
	}
		
		
		
		
		
	}
	
	
	
	void checkBoundries(){
		
		if(x < 0) {
			panel.currentState = panel.END_STATE;
			
			
		}
		
		else if(y<0 || y> 1000) {
			panel.currentState = panel.END_STATE;
		}
		
		
		
	}
	
	
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
		
		
		if(ObjectManager.hasBall == true) {
		
		g.setColor(new Color( 169, 110, 52));
		g.fillRect(x+ 40, y, 20, 20);
		
		ballAlive = false;
		
		TDhasBall = true;
		
		}
	}

}
