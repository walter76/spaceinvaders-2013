package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.Graphics;
import java.awt.Image;

public class SpriteImpl implements Sprite {

	private Image sprite;
	
	public SpriteImpl(Image sprite) {
		this.sprite = sprite;
	}
	
	/* (non-Javadoc)
	 * @see de.thnuernberg.bme.swe.spaceinvaders.Sprite#draw(java.awt.Graphics, int, int)
	 */
	@Override
	public void draw(Graphics graphicsContext, int x, int y) {
		graphicsContext.drawImage(sprite, x, y, null);
	}
	
	public void hallo() {
		
	}
	
}
