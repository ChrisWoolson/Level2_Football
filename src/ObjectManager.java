import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	RocketShip rocket;
	Ball ball;
	Long enemyTimer = (long) 0;
	int enemySpawnTime = 400;
	int score = 0;

	public static int aX;
	public static int aY;
	public static boolean hasBall;
	
	public ObjectManager(RocketShip rockets, Ball ball) {
		
			this.ball = ball;
		
		rocket = rockets;
		enemyTimer = (Long) System.currentTimeMillis();
	}

	void update() {
		rocket.update();
		ball.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();

		}

		for (int i = 0; i < alien.size(); i++) {
			alien.get(i).update();

		}
		for(int i = 0; i < allies.size(); i++) {
			allies.get(i).update();
		}
		
		manageEnemies();

		if (rocket.isAlive == false) {
			alien.isEmpty();
		}

	}

	void draw(Graphics g) {
		rocket.draw(g);
		ball.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);

		}
		for (int i1 = 0; i1 < alien.size(); i1++) {
			alien.get(i1).draw(g);

		}
		
		System.out.println("There are " + allies.size() + " allies.");
		
		for(int i = 0; i < allies.size(); i++) {
			allies.get(i).draw(g);
		}
		
	}

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> alien = new ArrayList<Alien>();
	ArrayList<Ally> allies = new ArrayList<Ally>();

	void addAlien(Alien aliens) {

		alien.add(aliens);

	}
	
	void addAlly(Ally a) {
		allies.add(a);
	}

	void addProjectile(Projectile proj) {
		projectiles.add(proj);
	}

	void manageEnemies() {

		

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
		
//		for(int i = 0; i < allies.size(); i++) {
//			this.allies.remove(i);
//		}
		
		for (int i1 = 0; i1 < allies.size(); i1++) {
			Ally aliena = allies.get(i1);

			if (aliena.isAlive == false) {
				this.allies.remove(aliena);
			}

		}
	}

	void checkCollison() {
		for (Alien a : alien) {

			if (rocket.collisionBox.intersects(a.collisionBox)) {

				rocket.isAlive = false;
				score++;

			}

			
			if (rocket.collisionBox.intersects(ball.collisionBox)) {

				hasBall = true ;
System.out.println(hasBall);
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


	
	public void createAliens() {
		addAlien(new Alien(1400, 275, 50, 50, 5));
		addAlien(new Alien(1400, 475, 50, 50, 3));
		addAlien(new Alien(1400, 75, 50, 50, 4));
		addAlien(new Alien(1400, 675, 50, 50, 1));
		addAlien(new Alien(1600, 475, 50, 50, 2));
		
		addAlly(new Ally(600,675,50,50,6,1, this));
		addAlly(new Ally(600,675,50,50,6,2, this));
		addAlly(new Ally(600,675,50,50,6,3, this));
		addAlly(new Ally(600,675,50,50,6,4, this));
		
		ball = new Ball(1600, 475, 20, 20);
	}
	
	
	
	
	
	
	
	
}
