import java.awt.Color;

import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;


import com.sun.glass.ui.Timer;
import java.util.Random;
public class Ball extends GameObject {
	public boolean upa;
	Timer tball;
	//public Random rand = new Random();
	public double speeda = 1;
	public boolean kicked = false;
	
	Random rand = new Random();

	int  n = rand.nextInt(100) ;
	
	
	Random r = new Random();

	int  na = rand.nextInt(2) ;
	
	Random r3 = new Random();

	int  na2 = rand.nextInt(8) ;
	
	
	
	double slope = 360/n ;
	int kick;
	
	int time2;

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		//int random = rand.nextInt(40);
		
		
		System.out.println("random"+n);
	}

	void update() {
		
		super.update();
		
		
		Kickoff();
		kick++;
		
		time2++;
		
		
	}

	void draw(Graphics g) {
		g.setColor(new Color (139,69,  19));
		g.fillRect(x, y, width, height);
		

	}

	
	
	public void Kickoff() {
		
		if(kick<360) {
		
			
			x = x - 3;
			
			if(na == 2) {
				if(time2 % 4 == 0) {
					y =  (int) (y-na2);
				}
			}
			
			
			if(na == 1) {
			
			if(time2 % 4 == 0) {
				y =  (int) (y+na2);
			}
			
			}
			
		}
		
		
		
	}
	
	
	
	
	
}
