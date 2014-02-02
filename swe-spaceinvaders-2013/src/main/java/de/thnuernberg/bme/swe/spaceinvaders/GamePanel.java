package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import de.thnuernberg.bme.swe.spaceinvaders.model.AlienShip;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;
import de.thnuernberg.bme.swe.spaceinvaders.model.PlayerShip;
import de.thnuernberg.bme.swe.spaceinvaders.view.GameObjectsRenderer;
import de.thnuernberg.bme.swe.spaceinvaders.view.Sprite;
import de.thnuernberg.bme.swe.spaceinvaders.view.SpriteFactory;
import de.thnuernberg.bme.swe.spaceinvaders.view.SpriteRenderer;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	// declare constants for the width and height of the game panel
	private static final int PANEL_WIDTH = 335;
	private static final int PANEL_HEIGHT = 300;
	private static final int SPACING = 5;

	// the sprite factory provides the sprites for the game
	private final SpriteFactory spriteFactory = new SpriteFactory();
	private final GameObjectsRenderer gameObjectsRenderer = new GameObjectsRenderer();

	// player ship
	private PlayerShipController playerShipController;

	// flag to indicate whether the game is running or not
	private boolean gameRunning;

	// list of alien ships
	private final List<AlienShipController> alienShips = new ArrayList<AlienShipController>();

	public GamePanel() {

		// set the background color to black
		setBackground(Color.BLACK);

		// set the size of the game panel
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

		// make the game panel focusable
		setFocusable(true);
		// set the focus to the game panel, to receive keyboard input
		requestFocus();

		setUpPlayerShip();
		setUpAlienShips();
		playerShipController.resetToStartPosition(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		// add the listener for the keyboard input
		addKeyListener();
	}

	private void setUpPlayerShip() {
		final PlayerShip playerShip = new PlayerShip();
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		playerShipController = new PlayerShipController(playerShip,
				boundaryGuard);
		gameObjectsRenderer.add(playerShip,
				new SpriteRenderer(spriteFactory.getPlayerSprite()));
	}

	private void setUpAlienShips() {
		BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);

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

				// add the alien ship to the collection
				final AlienShip alienShip = new AlienShip(x, y, width, height,
						row);
				alienShips
						.add(new AlienShipController(alienShip, boundaryGuard));
				final Sprite alienSprite = spriteFactory.getAlienSprite(row);
				gameObjectsRenderer.add(alienShip, new SpriteRenderer(
						alienSprite));
			}
		}
	}

	private void addKeyListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					stopGame();
				} else if (e.getKeyChar() == 'a') {
					// move the player to the left on key 'a'
					playerShipController.moveLeft();
				} else if (e.getKeyChar() == 'd') {
					// move the player to the right on key 'd'
					playerShipController.moveRight();
				} else if (e.getKeyChar() == ' ') {
					// shoot a laser bullet
					playerShipController.fire();
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

		gameObjectsRenderer.render(graphicsContext);

		// draw the laser bullet (only if fired)
		Laser laser = playerShipController.getLaser();
		if (laser != null) {
			graphicsContext.fillOval(laser.getX(), laser.getY(), 5, 5);
		}

		// draw the bullet of the alien ship
		for (AlienShipController alienShipController : alienShips) {
			Laser alienLaser = alienShipController.getLaser();
			if (alienLaser != null) {
				graphicsContext.fillOval(alienLaser.getX(), alienLaser.getY(),
						5, 5);
			}
		}
	}

	// is called as soon as we start the new thread
	// main method of the animator tread
	@Override
	public void run() {
		// as long as gameRunning is true, the game loop is running
		while (gameRunning) {
			// we sleep 100 ms letting other threads do something
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// ignored
			}

			// update the game
			playerShipController.update();

			boolean alienLaserFired = false;
			for (AlienShipController alienShipController : alienShips) {
				alienShipController.update();
				if (alienShipController.getLaser() != null) {
					alienLaserFired = true;
				}
			}

			if (!alienLaserFired) {
				// randomly select a alien ship to fire back
				Random random = new Random();
				int alienShipNumber = random.nextInt(alienShips.size() - 1);
				alienShips.get(alienShipNumber).fire();
			}

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
