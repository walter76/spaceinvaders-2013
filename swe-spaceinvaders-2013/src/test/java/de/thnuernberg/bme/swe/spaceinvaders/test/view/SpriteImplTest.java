package de.thnuernberg.bme.swe.spaceinvaders.test.view;

import java.awt.Graphics;
import java.awt.Image;

import org.junit.Test;
import org.mockito.Mockito;

import de.thnuernberg.bme.swe.spaceinvaders.view.Sprite;
import de.thnuernberg.bme.swe.spaceinvaders.view.SpriteImpl;

public class SpriteImplTest {

	@Test
	public void draw() {
		Image image = Mockito.mock(Image.class);
		Sprite sprite = new SpriteImpl(image);
		Graphics graphicsContext = Mockito.mock(Graphics.class);

		sprite.draw(graphicsContext, 4, 7);

		Mockito.verify(graphicsContext).drawImage(image, 4, 7, null);
	}

}
