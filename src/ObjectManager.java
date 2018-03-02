import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip rocket;
	Long enemyTimer = (long) 0;
	int enemySpawnTime = 400;
	int score = 0;

	public static int aX;
	public static int aY;
	
	
	public ObjectManager(RocketShip rockets) {
		rocket = rockets;
		enemyTimer = (Long) System.currentTimeMillis();
	}

	void update() {
		rocket.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();

		}

		for (int i = 0; i < alien.size(); i++) {
			alien.get(i).update();

		}
		manageEnemies();

		if (rocket.isAlive == false) {
			alien.isEmpty();
		}

	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);

		}
		for (int i1 = 0; i1 < alien.size(); i1++) {
			alien.get(i1).draw(g);

		}
		
	}

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	static ArrayList<Alien> alien = new ArrayList<Alien>();

	void addAlien(Alien aliens) {

		alien.add(aliens);

	}

	void addProjectile(Projectile proj) {
		projectiles.add(proj);
	}

	void manageEnemies() {

		for (int i = 0; i < 2; i++) {
			addAlien(new Alien(1400, 275, 50, 50));
			addAlien(new Alien(1400, 475, 50, 50));
			addAlien(new Alien(1400, 675, 50, 50));
		}

		/*
		 * if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
		 * 
		 * 
		 * for (int i = 0; i < 2; i++) { addAlien(new Alien(200, 200, 50, 50)); }
		 * System.out.println("made an alien"); addAlien(new Alien(new
		 * Random().nextInt(LeagueInvaders.width), 0, 50, 50));
		 * 
		 * 
		 * 
		 * 
		 * enemyTimer = (Long) System.currentTimeMillis();
		 * 
		 * 
		 * 
		 * }
		 */
	}

	void purgeObjects() {
		for (int i1 = 0; i1 < alien.size(); i1++) {
			Alien aliena = alien.get(i1);

			if (aliena.isAlive == false) {
				this.alien.remove(aliena);

			}

		}

		for (int i1 = 0; i1 < projectiles.size(); i1++) {
			Projectile aliena = projectiles.get(i1);

			if (aliena.isAlive == false) {
				this.projectiles.remove(aliena);

			}

		}

	}

	void checkCollison() {
		for (Alien a : alien) {

			if (rocket.collisionBox.intersects(a.collisionBox)) {

				rocket.isAlive = false;
				score++;

			}

			
			
			

			
			
			
			
			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					p.isAlive = false;
					a.isAlive = false;
				}
			}

		}

	}

	int getScore() {
		return score;

	}

	
	
	public static void getAlienX(){
		
		for (Alien a1: alien) {
			aX = a1.x;
			aY = a1.y;
			
			
			
			
			
													}
		
		
	}
	
public static void getAlienY(){
		
		for (Alien a1: alien) {
			aY = a1.y;
			
													}
		
		
	}
	
	
	
}
