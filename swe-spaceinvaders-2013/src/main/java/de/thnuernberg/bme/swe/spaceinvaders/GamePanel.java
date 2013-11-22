package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// declare constants for the width and height of the game panel
	private static final int PANEL_WIDTH = 455;
	private static final int PANEL_HEIGHT = 500;

	private final SpaceInvadersSpriteSheet spaceInvadersSpriteSheet = new SpaceInvadersSpriteSheet();
	
	public GamePanel() {
		// set the background color to black
		setBackground(Color.BLACK);

		// set the size of the game panel
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
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
		final int width = 28;
		final int height = 20;
		final int spacing = 5;

		// we have four rows of alien ships
		for (int j = 0; j < 5; j++) {
			// for every row we calculate the y-position of the ships
			final int y = spacing + j * (spacing + height);

			// we have 11 alien ships per row
			for (int i = 0; i < 11; i++) {
				// for every alien ship we calculate its x-position
				final int x = spacing + i * (spacing + width);

				// draw the alien ship
				graphicsContext.drawImage(spaceInvadersSpriteSheet.getAlienSprite(), x, y, null);
			}
		}
	}

}
