package de.thnuernberg.bme.swe.spaceinvaders.view;

import java.awt.Graphics;
import java.util.Hashtable;
import java.util.Map;

import de.thnuernberg.bme.swe.spaceinvaders.model.GameObject;

public class GameObjectsRendererImpl implements GameObjectsRenderer {

	private final Hashtable<GameObject, Renderer> gameObjectRenderers;

	public GameObjectsRendererImpl() {
		gameObjectRenderers = new Hashtable<>();
	}

	@Override
	public void add(GameObject gameObject, Renderer renderer) {
		gameObjectRenderers.put(gameObject, renderer);
	}

	@Override
	public void render(Graphics graphicsContext) {
		for (Map.Entry<GameObject, Renderer> entry : gameObjectRenderers
				.entrySet()) {
			GameObject gameObject = entry.getKey();
			Renderer renderer = entry.getValue();
			renderer.render(graphicsContext, gameObject);
		}
	}

	@Override
	public int registeredRenderersCount() {
		return gameObjectRenderers.size();
	}

	@Override
	public void remove(GameObject gameObject) {
		gameObjectRenderers.remove(gameObject);
	}

}
