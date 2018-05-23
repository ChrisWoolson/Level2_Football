import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	RocketShip rocket;
	Ball ball;
	Long enemyTimer = (long) 0;
	int enemySpawnTime = 400;
	int score = 0;
GamePanel panel;
	public static int aX;
	public static int aY;
	public static boolean hasBall;
	
	boolean alreadyCollided;
	public int timeR;
	
	public ObjectManager(RocketShip rockets, Ball ball) {
		
			this.ball = ball;
		
		rocket = rockets;
		enemyTimer = (Long) System.currentTimeMillis();
	}

	void update() {
		
		
		
		
		
		
		
		
		
		
		
		
	/*	
for (Alien at : alien) {
				
			
			if(ObjectManager.collided == true) {
				Alien.oX = Alien.oY + 20;
			}
			
			}
		
		*/
		
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
	public ArrayList<Alien> alien = new ArrayList<Alien>();
	public ArrayList<Ally> allies = new ArrayList<Ally>();

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
		
		
		for (int i = 0; i < allies.size(); i++) {
			if(allies.get(i).collided2) {
			allies.remove(i);	
			}
		}
		
		
		
		
		
		
		for (Alien a : alien) {

			if (rocket.collisionBox.intersects(a.collisionBox)) {

				rocket.isAlive = false;
				score++;

			}

			
			if (rocket.collisionBox.intersects(ball.collisionBox)) {

				hasBall = true ;
System.out.println(hasBall);
			}
			

			
			
			for (Alien a1 : alien) {
for( Ally a2 : allies) {
				if (a2.collisionBox.intersects(a1.collisionBox) && alreadyCollided == false) {

					System.out.println("collided");
					a1.collided = true;
					a2.collided2 = true;
					a1.collidedTimer++;
				}else {
					
					
					if(a1.collidedTimer % 10 == 1 && a2.collidedTimerA % 10 == 1) {
						a1.collided = false;
					
					
					
					
					if(a1.collided == true) {
						timeR++;
						if(timeR > 30) {
							a1.collided = false;
						}
					}
				}
					}
					
					
					
					
				
			
			}
			
			
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
		addAlien(new Alien(1400, 275, 50, 50, 5, 1, this ));
		addAlien(new Alien(1400, 475, 50, 50, 3, 2, this ));
		addAlien(new Alien(1400, 75, 50, 50, 4, 3, this ));
		addAlien(new Alien(1400, 675, 50, 50, 1, 4, this ));
		addAlien(new Alien(1600, 475, 50, 50, 2, 5, this));
		
		addAlly(new Ally(600,600,50,50,2,1, this));
		addAlly(new Ally(600,700,50,50,1,2, this));
		addAlly(new Ally(600,750,50,50,2,3, this));
		addAlly(new Ally(600,650,50,50,1,4, this));
		
		ball = new Ball(1600, 475, 20, 20);
	}
	
	
	
	
	
	
}
