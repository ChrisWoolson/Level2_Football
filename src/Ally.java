import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Ally extends GameObject {
	public boolean upa;
	ObjectManager parent;
	Alien target;
	

public int collidedTimerA;
	public static boolean downa;
	public static boolean lefta;
	public static boolean righta;
	
	int id;
	
	int walkTimer;
	boolean collided2;
	
	
	//public double baseSpeed = 1;
public double currentSpeed;
	
public BufferedImage subImage6;
public BufferedImage subImage5;
	
	public int speed2Timer;

	public Ally(int x, int y, int width, int height, int baseSpeed, int id, ObjectManager p) {
		super(x, y, width, height);
		System.out.println("Added ally");
		this.id = id;
		//this.baseSpeed = baseSpeed;
		currentSpeed = baseSpeed;

		parent = p;

		BufferedImage img;
		try {
			img = ImageIO.read(this.getClass().getResourceAsStream("Allies.png"));
			subImage5 = img.getSubimage(195, 44, 33, 44);
			subImage6 = img.getSubimage(36, 84, 33, 44);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			target = parent.alien.get(id);
		} catch (Exception e) {
			System.out.println("Null Target");
		}
	}

	void update() {
		super.update();
		
		walkTimer++;
		
		
		if(y == target.y && x == target.x && walkTimer % 120 == 0) {
			//Alien.aX = ;
		}
		
		
		
		
		
		
		if (walkTimer % 4 == 0) {

			if (y < target.y) {

				y = (int) (y + currentSpeed);
			}
			if (x < target.x) {
				x = (int) (x + currentSpeed);
			}

			if (y > target.y) {
				y = (int) (y - currentSpeed);
			}
			if (x > target.x) {
				x = (int) (x - currentSpeed);
			}
		}
		
		/*
		if(target != null) {
			if(Math.abs(target.x - x) > 50) {
				if(target.x > x) {
					x+=baseSpeed;
				} else {
					x-=baseSpeed;
				}
			}
			
			if(Math.abs(target.y - y) > 50) {
				if(target.y > y) {
					y+=baseSpeed;
				} else {
					y-=baseSpeed;
				}
			}
		}
		
		*/
		
		
	}

	void draw(Graphics g) {
		System.out.println("Drew ally");
		g.drawRect(50, 50, 50, 50);
		long currentMs = System.currentTimeMillis() % 1000;
		System.out.println(currentMs);
		if(currentMs > 500) {		
				g.drawImage(subImage5, x, y, width, height, null);
			}else {
				g.drawImage(subImage6, x, y, width, height, null);
			}
	}
	
	
	
	
	
	
	
	
	
}
