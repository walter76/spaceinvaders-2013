package de.thnuernberg.bme.swe.spaceinvaders.test.model;

import org.junit.Assert;
import org.junit.Test;

import de.thnuernberg.bme.swe.spaceinvaders.model.MoveableGameObject;
import de.thnuernberg.bme.swe.spaceinvaders.model.PlayerShip;

public class PlayerShipTest {

	@Test
	public void getX() {
		MoveableGameObject playerShip = new PlayerShip();

		playerShip.setX(10);

		Assert.assertEquals(10, playerShip.getX());
	}

	@Test
	public void getY() {
		MoveableGameObject playerShip = new PlayerShip();

		playerShip.setY(20);

		Assert.assertEquals(20, playerShip.getY());
	}

}
