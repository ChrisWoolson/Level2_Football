

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Blocker extends GameObject {
	public boolean upa;

	public static boolean downa;
	public static boolean lefta;
	public static boolean righta;

	public double baseSpeed = 1;
public double currentSpeed;
	
public BufferedImage subImage3;
public BufferedImage subImage4;
	
	public int speed2Timer;

	public Blocker(int x, int y, int width, int height, int baseSpeed) {
		//ygmgymmgm
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
		 
		super.update();

		speed2Timer++;

		if (speed2Timer % 4 == 0) {

			if (y < Alien.aY) {

				y = (int) (y + currentSpeed);
			}
			if (x < Alien.aX) {
				x = (int) (x + currentSpeed);
			}

			if (y > Alien.aY) {
				y = (int) (y - currentSpeed);
			}
			if (x > Alien.aX) {
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
		

		
		
		
		
		
		
		
		long currentMs = System.currentTimeMillis() % 1000;
		System.out.println(currentMs);
	if(currentMs >500) {
		
		
			g.drawImage(subImage3, x, y, width, height, null);
		
		
		
		
		
			}else {
				
				
					
				
				g.drawImage(subImage4, x, y, width, height, null);
				
				
				
				
				
			}
			
			
		
		
		
		
	}

}
