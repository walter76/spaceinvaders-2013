package de.thnuernberg.bme.swe.spaceinvaders.view;

import java.awt.Graphics;

public class SpriteRenderer implements Renderer {

	private final Sprite sprite;

	public SpriteRenderer(final Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void render(Graphics graphicsContext, int x, int y) {
		sprite.draw(graphicsContext, x, y);
	}

}
