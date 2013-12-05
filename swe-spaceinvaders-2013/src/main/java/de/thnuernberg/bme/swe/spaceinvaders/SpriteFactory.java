package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class SpriteFactory {

	private BufferedImage spriteSheet;

	public SpriteFactory() {
		try {
			// getClass().getResource("space_invader.jpg") locates the image in
			// the
			// namespace de.thnuernberg.bme.swe.spaceinvaders" under
			// src/main/resources
			// see package explorer in eclipse
			URL fileURL = getClass()
					.getResource("SpaceInvadersSpriteSheet.png");
			// loads the image from the file with the provided URL
			spriteSheet = ImageIO.read(fileURL);
		} catch (IOException e) {
			// if the file could not be opened or read a IOException will be
			// thrown
			e.printStackTrace();
		}
	}

	public Sprite getAlienSprite(int row) {
		// this switch-case provides the alien ship sprite for a certain row
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

	public Sprite getPlayerSprite() {
		return new SpriteImpl(spriteSheet.getSubimage(277, 220, 25, 20));
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
