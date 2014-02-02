package de.thnuernberg.bme.swe.spaceinvaders.test.view;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import de.thnuernberg.bme.swe.spaceinvaders.model.GameObject;
import de.thnuernberg.bme.swe.spaceinvaders.view.LaserRenderer;
import de.thnuernberg.bme.swe.spaceinvaders.view.Renderer;

public class LaserRendererTest {

	@Test
	public void saveAndRestoreColor() {
		Graphics graphicsContext = Mockito.mock(Graphics.class);
		Mockito.when(graphicsContext.getColor()).thenReturn(Color.BLACK);
		GameObject gameObject = Mockito.mock(GameObject.class);
		Renderer laserRenderer = new LaserRenderer();

		laserRenderer.render(graphicsContext, gameObject);

		InOrder inOrder = Mockito.inOrder(graphicsContext);
		inOrder.verify(graphicsContext, Mockito.times(1)).getColor();
		inOrder.verify(graphicsContext, Mockito.times(1)).setColor(Color.WHITE);
		inOrder.verify(graphicsContext, Mockito.times(1)).setColor(Color.BLACK);
	}

	@Test
	public void renderDrawsOval() {
		Graphics graphicsContext = Mockito.mock(Graphics.class);
		GameObject gameObject = Mockito.mock(GameObject.class);
		Mockito.when(gameObject.getX()).thenReturn(4);
		Mockito.when(gameObject.getY()).thenReturn(7);
		Mockito.when(gameObject.getWidth()).thenReturn(1);
		Mockito.when(gameObject.getHeight()).thenReturn(5);

		Renderer laserRenderer = new LaserRenderer();

		laserRenderer.render(graphicsContext, gameObject);

		Mockito.verify(graphicsContext).fillOval(4, 7, 1, 5);
	}

}
