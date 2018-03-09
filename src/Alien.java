import java.awt.Color;
import java.awt.Graphics;

<<<<<<< HEAD

public class Alien extends GameObject{

	public Alien(int x, int y, int width, int height) {

public class Alien extends GameObject {
	public boolean upa;
	public static boolean downa;
	public static boolean lefta;
	public static boolean righta;

	public double speeda = 1;

	public Alien(int x, int y, int width, int height, int speeda) {

=======
public class Alien extends GameObject{

	public Alien(int x, int y, int width, int height) {
>>>>>>> parent of b5295aa... Merge branch 'master' of https://github.com/ChrisWoolson/Level2_Football
		super(x, y, width, height);
		
	}
<<<<<<< HEAD

=======
>>>>>>> parent of b5295aa... Merge branch 'master' of https://github.com/ChrisWoolson/Level2_Football
		void update() {
			super.update();
			y = y+ 4;
			
		
<<<<<<< HEAD


	void update() {
		super.update();
		
		

		if (y < RocketShip.rY) {
			
			

			y = (int) (y + speeda);

		}
		if (x < RocketShip.rX) {
			x = (int) (x + speeda);
		}



		if (y > RocketShip.rY) {
			y = (int) (y - speeda);
		}
		if (x > RocketShip.rX) {
			x = (int) (x - speeda);
		}
		
		
		

=======
		}
		void draw(Graphics g) {
			g.setColor(Color.yellow);
			g.drawRect(x, y, width, height);
		}
>>>>>>> parent of b5295aa... Merge branch 'master' of https://github.com/ChrisWoolson/Level2_Football
	}


