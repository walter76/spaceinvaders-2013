package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// declare constants for the width and height of the game panel
	private static final int PANEL_WIDTH = 335;
	private static final int PANEL_HEIGHT = 300;
	private static final int SPACING = 5;
	private static final int PLAYER_VELOCITY = 5;

	// the sprite factory provides the sprites for the game
	private final SpriteFactory spriteFactory = new SpriteFactory();

	private int playerX;
	private int playerY;

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

		resetPlayerShipToStartPosition();
	}

	private void resetPlayerShipToStartPosition() {
		playerX = (PANEL_WIDTH - 25) / 2 - SPACING;
		playerY = PANEL_HEIGHT - 20 - SPACING;
	}

	private void addKeyListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == 'a') {
					// move the player to the left on key 'a'
					movePlayerShipLeft();
				} else if (e.getKeyChar() == 'd') {
					// move the player to the right on key 'd'
					movePlayerShipRight();
				} else if (e.getKeyChar() == ' ') {
					// shoot a laser bullet
				}
				// repaint the panel
				repaint();
			}
		});
	}

	private void movePlayerShipRight() {
		playerX += PLAYER_VELOCITY;
		if (playerX > (PANEL_WIDTH - 25 - SPACING)) {
			playerX = PANEL_WIDTH - 25 - SPACING;
		}
	}

	private void movePlayerShipLeft() {
		playerX -= PLAYER_VELOCITY;
		if (playerX < SPACING) {
			playerX = SPACING;
		}
	}

	// we override this method to be able to draw in the game panel
	// it is called by swing every time the game panel is redrawn
	@Override
	public void paintComponent(Graphics graphicsContext) {
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
		playerSprite.draw(graphicsContext, playerX, playerY);
	}

}
