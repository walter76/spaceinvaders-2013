package de.thnuernberg.bme.swe.spaceinvaders.view;

import java.awt.Graphics;

// interface for a sprite
public interface Sprite {

	// a sprite provides a draw method
	public void draw(Graphics graphicsContext, int x, int y);

}