package de.thnuernberg.bme.swe.spaceinvaders.view;

import java.awt.Graphics;
import java.awt.Image;

// default implementation for the sprite
public class SpriteImpl implements Sprite {

	// variable to hold the sprite image
	private final Image sprite;
	
	public SpriteImpl(Image sprite) {
		this.sprite = sprite;
	}
	
	// implements the interface method draw from Sprite
	@Override
	public void draw(Graphics graphicsContext, int x, int y) {
		// draw the sprite image to the graphics context
		graphicsContext.drawImage(sprite, x, y, null);
	}
	
}
