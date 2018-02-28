import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	public static final int width =  500;
	public static final int height = 800;
	GamePanel panel = new GamePanel();
	
	
	public static void main(String[] args) {
LeagueInvaders league = new LeagueInvaders();
		league.setup();
		
		
}

	public LeagueInvaders () {
		frame = new JFrame();
		
		
	}
	
	 void setup() {
		frame.add(panel);
		 frame.setSize(width, height);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		panel.startGame();
		frame.addKeyListener(panel);
	}
	
	
}
