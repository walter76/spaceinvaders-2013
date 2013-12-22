package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	// declare constants for the width and height of the game panel
	private static final int PANEL_WIDTH = 335;
	private static final int PANEL_HEIGHT = 300;
	private static final int SPACING = 5;

	// the sprite factory provides the sprites for the game
	private final SpriteFactory spriteFactory = new SpriteFactory();

	// player ship
	private final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT, SPACING);
	
	// flag to indicate whether the game is running or not
	private boolean gameRunning;
	
	public GamePanel() {
		// set the background color to black
		setBackground(Color.BLACK);

		// set the size of the game panel
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

		// make the game panel focusable
		setFocusable(true);
		// set the focus to the game panel, to receive keyboard input
		requestFocus();
		// add the listener for the keyboard input
		addKeyListener();

		playerShip.resetToStartPosition();
	}

	private void addKeyListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					stopGame();
				} else if (e.getKeyChar() == 'a') {
					// move the player to the left on key 'a'
					playerShip.moveLeft();
				} else if (e.getKeyChar() == 'd') {
					// move the player to the right on key 'd'
					playerShip.moveRight();
				} else if (e.getKeyChar() == ' ') {
					// shoot a laser bullet
					playerShip.fire();
				}
				// repaint the panel
				repaint();
			}
		});
	}

	// we override this method to be able to draw in the game panel
	// it is called by swing every time the game panel is redrawn
	@Override
	public void paintComponent(final Graphics graphicsContext) {
		// we extend the behavior of the method in the super class, so we call
		// the super class method first
		super.paintComponent(graphicsContext);

		// set the paint color to white
		graphicsContext.setColor(Color.WHITE);

		// declare width, height and spacing
		final int width = 25;
		final int height = 20;

		// we have five rows of alien ships
		for (int row = 0; row < 5; row++) {
			// for every row we calculate the y-position of the ships
			final int y = SPACING + row * (SPACING + height);

			// we have 11 alien ships per row
			for (int i = 0; i < 11; i++) {
				// for every alien ship we calculate its x-position
				final int x = SPACING + i * (SPACING + width);

				// get the sprite for a certain row
				final Sprite alienSprite = spriteFactory.getAlienSprite(row);
				// draw the alien ship sprite
				alienSprite.draw(graphicsContext, x, y);
			}
		}

		Sprite playerSprite = spriteFactory.getPlayerSprite();
		playerSprite.draw(graphicsContext, playerShip.getX(), playerShip.getY());
		
		// draw the laser bullet (only if fired)
		if(playerShip.hasLaserFired()) {
			graphicsContext.fillOval(playerShip.getLaserX(), playerShip.getLaserY(), 5, 5);
		}
		
		// draw the bullet of the alien ship
		// --- add your code here ---
	}

	// is called as soon as we start the new thread
	// main method of the animator tread
	@Override
	public void run() {
		// as long as gameRunning is true, the game loop is running
		while(gameRunning) {
			// we sleep 100 ms letting other threads do something
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// ignored
			}
			
			// update the game
			playerShip.update();
			
			// if there is no bullet of a alien ship:
			// --- add your code here ---
			
			// randomly select a alien ship to fire back
			Random random = new Random();
			int playerShipNumber = random.nextInt(54);
			
			// calculate the start coordinates for the bullet of the alien ship
			// --- add your code here ---
			
			// if there is a bullet of a alien ship:
			// update the laser bullet coordinates
			// --- add your code here ---
			
			// repaint the panel
			repaint();
		}
	}

	// is called by the framework as soon as the game panel is shown
	// to the user
	@Override
	public void addNotify() {
		super.addNotify();
		
		startGame();
	}

	// starts the animator background thread and therefore the game loop
	private void startGame() {
		Thread animator = new Thread(this);
		gameRunning = true;
		animator.start();
	}

	// stops the game loop and therefore the animator thread
	private void stopGame() {
		gameRunning = false;
	}
	
}
