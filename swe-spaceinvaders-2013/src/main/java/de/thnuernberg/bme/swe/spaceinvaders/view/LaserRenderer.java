package de.thnuernberg.bme.swe.spaceinvaders.view;

import java.awt.Color;
import java.awt.Graphics;

import de.thnuernberg.bme.swe.spaceinvaders.model.GameObject;

public class LaserRenderer implements Renderer {

	@Override
	public void render(Graphics graphicsContext, GameObject gameObject) {
		Color saveColor = graphicsContext.getColor();

		graphicsContext.setColor(Color.WHITE);
		graphicsContext.fillOval(gameObject.getX(), gameObject.getY(),
				gameObject.getWidth(), gameObject.getHeight());

		graphicsContext.setColor(saveColor);
	}

}
