package de.thnuernberg.bme.swe.spaceinvaders.view;

import java.awt.Graphics;
import java.util.Hashtable;
import java.util.Map;

import de.thnuernberg.bme.swe.spaceinvaders.model.GameObject;

public class GameObjectsRenderer {

	private final Hashtable<GameObject, Renderer> gameObjectRenderers;

	public GameObjectsRenderer() {
		gameObjectRenderers = new Hashtable<>();
	}

	public void add(GameObject gameObject, Renderer renderer) {
		gameObjectRenderers.put(gameObject, renderer);
	}

	public void render(Graphics graphicsContext) {
		for (Map.Entry<GameObject, Renderer> entry : gameObjectRenderers
				.entrySet()) {
			GameObject gameObject = entry.getKey();
			Renderer renderer = entry.getValue();
			renderer.render(graphicsContext, gameObject);
		}
	}

	public int registeredRenderersCount() {
		return gameObjectRenderers.size();
	}

	public void remove(GameObject gameObject) {
		gameObjectRenderers.remove(gameObject);
	}

}
