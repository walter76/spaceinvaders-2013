package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpaceInvadersSpriteSheet {

	private BufferedImage spriteSheet;

	public SpaceInvadersSpriteSheet() {
		try {
			// getClass().getResource("space_invader.jpg") locates the image in the
			// namespace de.thnuernberg.bme.swe.spaceinvaders" under src/main/resources
			// see package explorer in eclipse
			// ImageIO.read(...) loads the image from the file
			spriteSheet = ImageIO.read(getClass().getResource(
					"SpaceInvadersSpriteSheet.png"));
		} catch (IOException e) {
			// if the file could not be opened or read a IOException will be thrown
			e.printStackTrace();
		}
	}
	
	public BufferedImage getAlienSprite() {
		return spriteSheet.getSubimage(28, 220, 28, 20);
	}

}
