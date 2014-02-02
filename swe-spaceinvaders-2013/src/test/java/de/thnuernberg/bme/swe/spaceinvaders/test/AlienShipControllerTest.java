package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Assert;
import org.junit.Test;

import de.thnuernberg.bme.swe.spaceinvaders.AlienShipController;
import de.thnuernberg.bme.swe.spaceinvaders.model.AlienShip;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class AlienShipControllerTest {

	@Test
	public void initialParameters() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 40, 1);
		AlienShipController alienShipController = new AlienShipController(
				alienShip);

		Assert.assertEquals(alienShip, alienShipController.getAlienShip());
	}

	@Test
	public void fire() {
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 40, 1));

		Laser laser = alienShipController.fire();

		Assert.assertNotNull(laser);
		Assert.assertEquals(10 + (30 - 5) / 2, laser.getX());
		Assert.assertEquals(20 + 40, laser.getY());
	}

	@Test
	public void fireTwice() {
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 45, 1));

		Laser firstLaser = alienShipController.fire();
		Laser secondLaser = alienShipController.fire();

		Assert.assertNotEquals(firstLaser, secondLaser);
	}

}
