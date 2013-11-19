package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// declare constants for the width and height of the game panel
	private static final int PANEL_WIDTH = 455;
	private static final int PANEL_HEIGHT = 500;

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
		// we extend the behavior of the method in the super class, so we call the super class method first
		super.paintComponent(graphicsContext);

		// set the paint color to white
		graphicsContext.setColor(Color.WHITE);

		// declare width, height and spacing
		final int width = 40;
		final int height = 10;
		final int spacing = 5;
		
		// we have four rows of alien ships
		for (int j = 0; j < 4; j++) {
			// for every row we calculate the y-position of the ships
			final int y = spacing + j * (spacing + height);
			
			// we have 10 alien ships per row
			for (int i = 0; i < 10; i++) {
				// for every alien ship we calculate its x-position
				final int x = spacing + i * (spacing + width);
				
				// draw the alien ship as rectangle
				graphicsContext.fillRect(x, y, width, height);
			}
		}

		// example: load a image from a resource and draw it on screen
		//-------------------------------------------------------------
		// the variable spaceInvader will hold the image
		BufferedImage spaceInvader = null;
		try {
			// getClass().getResource("space_invader.jpg") locates the image in the
			// namespace de.thnuernberg.bme.swe.spaceinvaders" under src/main/resources
			// see package explorer in eclipse
			// ImageIO.read(...) loads the image from the file
			spaceInvader = ImageIO.read(getClass().getResource(
					"space_invader.jpg"));
		} catch (IOException e) {
			// if the file could not be opened or read a IOException will be thrown
			e.printStackTrace();
		}
		// spaceInvader will be != null if we could load the image
		if (spaceInvader != null) {
			// draw the image on the panel at x=200, y=200 and scale it to w=width, h=width
			graphicsContext.drawImage(spaceInvader, 200, 200, width, width,
					null);
		}
	}

}
