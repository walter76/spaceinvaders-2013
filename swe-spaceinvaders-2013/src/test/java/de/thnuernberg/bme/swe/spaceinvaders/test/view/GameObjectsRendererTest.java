package de.thnuernberg.bme.swe.spaceinvaders.test.view;

import java.awt.Graphics;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import de.thnuernberg.bme.swe.spaceinvaders.model.GameObject;
import de.thnuernberg.bme.swe.spaceinvaders.view.GameObjectsRenderer;
import de.thnuernberg.bme.swe.spaceinvaders.view.GameObjectsRendererImpl;
import de.thnuernberg.bme.swe.spaceinvaders.view.Renderer;

public class GameObjectsRendererTest {

	@Test
	public void addGameObjectRenderer() {
		GameObjectsRenderer gameObjectsRenderer = new GameObjectsRendererImpl();
		GameObject gameObject = Mockito.mock(GameObject.class);
		Renderer renderer = Mockito.mock(Renderer.class);

		gameObjectsRenderer.add(gameObject, renderer);

		Assert.assertEquals(1, gameObjectsRenderer.registeredRenderersCount());
	}

	@Test
	public void render() {
		GameObjectsRenderer gameObjectsRenderer = new GameObjectsRendererImpl();
		GameObject gameObject = Mockito.mock(GameObject.class);
		Renderer renderer = Mockito.mock(Renderer.class);
		Graphics graphicsContext = Mockito.mock(Graphics.class);

		gameObjectsRenderer.add(gameObject, renderer);
		gameObjectsRenderer.render(graphicsContext);

		Mockito.verify(renderer).render(graphicsContext, gameObject);
	}

	@Test
	public void remove() {
		GameObjectsRenderer gameObjectsRenderer = new GameObjectsRendererImpl();
		GameObject gameObject = Mockito.mock(GameObject.class);
		Renderer renderer = Mockito.mock(Renderer.class);

		gameObjectsRenderer.add(gameObject, renderer);
		gameObjectsRenderer.remove(gameObject);

		Assert.assertEquals(0, gameObjectsRenderer.registeredRenderersCount());
	}

}
