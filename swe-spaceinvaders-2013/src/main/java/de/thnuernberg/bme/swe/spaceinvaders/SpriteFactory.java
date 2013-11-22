package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteFactory {

	private BufferedImage spriteSheet;

	public SpriteFactory() {
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
	
	public Sprite getAlienSprite(int row) {
		switch (row) {
		case 0:
			return getLastRowAlienSprite();
		case 1:
		case 2:
			return getMiddleRowAlienSprite();
		case 3:
		case 4:
			return getFirstRowAlienSprite();
		}
		
		return null;
	}
	
	private Sprite getLastRowAlienSprite() {
		return new SpriteImpl(spriteSheet.getSubimage(35, 220, 25, 20));
	}
	
	private Sprite getMiddleRowAlienSprite() {
		return new SpriteImpl(spriteSheet.getSubimage(105, 220, 25, 20));
	}
	
	private Sprite getFirstRowAlienSprite() {
		return new SpriteImpl(spriteSheet.getSubimage(145, 220, 25, 20));
	}

}
