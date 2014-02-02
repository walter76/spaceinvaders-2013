package de.thnuernberg.bme.swe.spaceinvaders.test.view;

import java.awt.Graphics;

import org.junit.Test;
import org.mockito.Mockito;

import de.thnuernberg.bme.swe.spaceinvaders.model.GameObject;
import de.thnuernberg.bme.swe.spaceinvaders.view.Renderer;
import de.thnuernberg.bme.swe.spaceinvaders.view.Sprite;
import de.thnuernberg.bme.swe.spaceinvaders.view.SpriteRenderer;

public class SpriteRendererTest {

	@Test
	public void render() {
		Graphics graphicsContext = Mockito.mock(Graphics.class);
		Sprite sprite = Mockito.mock(Sprite.class);
		GameObject gameObject = Mockito.mock(GameObject.class);
		Mockito.when(gameObject.getX()).thenReturn(4);
		Mockito.when(gameObject.getY()).thenReturn(7);

		Renderer spriteRenderer = new SpriteRenderer(sprite);
		spriteRenderer.render(graphicsContext, gameObject);

		Mockito.verify(sprite).draw(graphicsContext, 4, 7);
	}

}
