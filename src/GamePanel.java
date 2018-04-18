import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;







import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	GameObject object;
	Font titleFont;
	Font enter;
	Font instruct;
	Font gameo;
	Font Kill;
	Font restart;
	public static BufferedImage field;
	RocketShip rocket = new RocketShip(250, 700, 50, 50, this);
	Ball ball = new Ball(100, 100, 50, 50);
	ObjectManager manager = new ObjectManager(rocket, ball);

	public GamePanel() {
		time = new Timer(1000 / 120, this);
		titleFont = new Font("Arial", Font.PLAIN, 40);
		enter = new Font("Arial", Font.PLAIN, 25);
		instruct = new Font("Arial", Font.PLAIN, 25);

		gameo = new Font("Arial", Font.PLAIN, 40);
		Kill = new Font("Arial", Font.PLAIN, 25);
		restart = new Font("Arial", Font.PLAIN, 25);

		try {
			field = ImageIO.read(this.getClass().getResource("Football.jpg"));

		} catch (IOException e) {

		}

	}

	public void startGame() {
		time.start();
		// ball.Kickoff();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else

		if (currentState == GAME_STATE) {
			updateGameState();

		} else

		if (currentState == END_STATE) {
			updateEndState();

		}

	}

	@Override

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else

		if (currentState == GAME_STATE) {
			drawGameState(g);

		} else

		if (currentState == END_STATE) {
			drawEndState(g);

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER &&  currentState != GAME_STATE) {
			currentState++;

			if (currentState == GAME_STATE) {
				manager.createAliens();
				rocket.x = 250;
				rocket.y = 750;

				ObjectManager.hasBall = false;

				ball.y = 475;
				ball.x = 1600;
				System.out.println(ball.x);

				rocket.ballAlive = true;

			}

			if (currentState == END_STATE) {
				currentState = MENU_STATE;
				rocket = new RocketShip(250, 700, 50, 50, this);
				rocket.isAlive = true;

			}
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
			rocket.isAlive = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// rocket.y=rocket.y + rocket.speed;
			rocket.up = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// rocket.y=rocket.y + rocket.speed;
			rocket.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// rocket.y=rocket.y + rocket.speed;
			rocket.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// rocket.y=rocket.y + rocket.speed;
			rocket.right = true;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("release");

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// rocket.y=rocket.y;
			rocket.up = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// rocket.y=rocket.y;
			rocket.down = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// rocket.y=rocket.y;
			rocket.left = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// rocket.y=rocket.y;
			rocket.right = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// manager.addProjectile(new Projectile(rocket.x + 25, rocket.y, 10, 10));
		}

	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.checkCollison();
		manager.purgeObjects();

		if (rocket.isAlive == false) {
			currentState = END_STATE;

		}

	}

	void updateEndState() {

		manager.alien.clear();
		manager.projectiles.clear();
		//rocket.checkTd = 0;
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.WHITE);

		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 50, 100);
		g.setFont(enter);
		g.drawString("PRESS ENTER TO START", 100, 300);

		g.setFont(instruct);
		g.drawString("PRESS SPACE FOR INSTRUCTIONS", 60, 450);
		rocket.checkTd = 0;
	}

	void drawGameState(Graphics g) {
		g.drawImage(field, 0, 0, LeagueInvaders.width, LeagueInvaders.height, null);

		// g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

		manager.draw(g);

	}

	void drawEndState(Graphics g) {

		if (rocket.checkTd == 0) {

			g.setColor(Color.RED);

			g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

			g.setColor(Color.WHITE);

			g.setFont(gameo);
			g.drawString("Game Over", 50, 100);
			g.setFont(Kill);
			g.drawString("You killed + enemies", 100, 300);

			g.setFont(restart);
			g.drawString("Press ENTER to restart", 60, 450);

		} else if (rocket.checkTd == 1) {
			System.out.println("switched 2");
			
			g.setColor(Color.GREEN);

			g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

			g.setColor(Color.yellow);

			g.setFont(gameo);
			g.drawString("Game win", 50, 100);
			g.setFont(Kill);
			

			g.setFont(restart);
			g.drawString("Press ENTER to restart", 60, 450);

		}
	}

	public void renderGame() {
		repaint();
		System.out.println("Hello");
	}
	
	/*
	 * public void addkick(){
	 * 
	 * 
	 * if(currentState == GAME_STATE) { ball.kick++; }else { ball.kick = 0; } }
	 */
}
