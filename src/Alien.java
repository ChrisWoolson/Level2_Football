import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;

public class Alien extends GameObject{
	public boolean upa;
	public static boolean downa;
	public static boolean lefta;
	public static boolean righta;
	
	public  double speeda = 1;
	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
		void update() {
			super.update();
		
			
			
			if(y < RocketShip.rY)
			
				
				y = (int) (y+ speeda);
			
			
			if(x < RocketShip.rX)
				x = (int) (x+ speeda);

			
			if(y > RocketShip.rY)
				y = (int) (y- speeda);
				
				if(x > RocketShip.rX)
					x = (int) (x- speeda);
			
			
				
			
			
			
			
		
		}
		void draw(Graphics g) {
			g.setColor(Color.yellow);
			g.drawRect(x, y, width, height);
		}
		
		
		
		

		
		
	}


