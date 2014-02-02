package de.thnuernberg.bme.swe.spaceinvaders.view;

import java.awt.Graphics;

import de.thnuernberg.bme.swe.spaceinvaders.model.GameObject;

public interface Renderer {

	public void render(Graphics graphicsContext, GameObject gameObject);

}