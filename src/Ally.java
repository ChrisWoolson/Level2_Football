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
	
	int id;

	public static boolean downa;
	public static boolean lefta;
	public static boolean righta;

	public double baseSpeed = 1;
public double currentSpeed;
	
public BufferedImage subImage3;
public BufferedImage subImage4;
	
	public int speed2Timer;

	public Ally(int x, int y, int width, int height, int baseSpeed, int id, ObjectManager p) {
		super(x, y, width, height);
		System.out.println("Added ally");
		this.id = id;
		this.baseSpeed = baseSpeed;
		currentSpeed = baseSpeed;

		parent = p;

		BufferedImage img;
		try {
			img = ImageIO.read(this.getClass().getResourceAsStream("Defence.png"));
			subImage4 = img.getSubimage(198, 66, 66, 66);
			subImage3 = img.getSubimage(0, 66, 66, 66);
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
	}

	void draw(Graphics g) {
		System.out.println("Drew ally");
		long currentMs = System.currentTimeMillis() % 1000;
		System.out.println(currentMs);
		if(currentMs > 500) {		
				g.drawImage(subImage3, x, y, width, height, null);
			}else {
				g.drawImage(subImage4, x, y, width, height, null);
			}
	}
}
