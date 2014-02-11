package de.thnuernberg.bme.swe.spaceinvaders.view;

import java.awt.Graphics;

import de.thnuernberg.bme.swe.spaceinvaders.model.GameObject;

public interface GameObjectsRenderer {

	public void add(GameObject gameObject, Renderer renderer);

	public void render(Graphics graphicsContext);

	public int registeredRenderersCount();

	public void remove(GameObject gameObject);

}