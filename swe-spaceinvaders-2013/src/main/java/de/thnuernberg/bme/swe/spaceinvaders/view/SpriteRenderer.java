package de.thnuernberg.bme.swe.spaceinvaders.view;

import java.awt.Graphics;

import de.thnuernberg.bme.swe.spaceinvaders.model.GameObject;

public class SpriteRenderer implements Renderer {

	private final Sprite sprite;

	public SpriteRenderer(final Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void render(Graphics graphicsContext, GameObject gameObject) {
		sprite.draw(graphicsContext, gameObject.getX(), gameObject.getY());
	}

}
