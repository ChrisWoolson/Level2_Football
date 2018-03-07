import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	RocketShip rocket;
	Long enemyTimer = (long) 0;
	int enemySpawnTime = 1000;
	int score = 0;

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
		System.out.println(alien.size());
	}

	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> alien = new ArrayList<Alien>();

	void addAlien(Alien aliens) {
		alien.add(aliens);
	}

	void addProjectile(Projectile proj) {
		projectiles.add(proj);
	}

	void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			System.out.println("made an alien");
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

			enemyTimer = (Long) System.currentTimeMillis();
		}
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
			
			for(Projectile p: projectiles) {
				if(p.collisionBox.intersects(a.collisionBox)){
					p.isAlive = false;
					a.isAlive = false;
				}
			}
			
			
		}

	}

	int getScore() {
		return score;

	}

}
