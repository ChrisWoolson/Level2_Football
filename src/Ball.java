import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Ball extends GameObject {
	public boolean upa;
	
	public Random rand = new Random();
	public double speeda = 1;
int slope;
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		int random = rand.nextInt(40);
		System.out.println(random);
		slope =360/random ;
	}

	void update() {
		super.update();
		
		

		
		
		
		
	}

	void draw(Graphics g) {
		g.setColor(new Color (139,69,  19));
		g.fillRect(x, y, width, height);
		

	}

}
