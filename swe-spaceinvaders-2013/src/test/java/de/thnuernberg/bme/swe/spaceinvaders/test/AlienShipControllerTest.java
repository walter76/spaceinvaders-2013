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
				alienShip, 500, 25);

		Assert.assertEquals(alienShip, alienShipController.getAlienShip());
	}

	@Test
	public void laserIsInitiallyNull() {
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 40, 1), 500, 25);

		Assert.assertNull(alienShipController.getLaser());
	}

	@Test
	public void fire() {
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 40, 1), 500, 25);

		alienShipController.fire();

		Assert.assertNotNull(alienShipController.getLaser());
		Assert.assertEquals(10 + (30 - 5) / 2, alienShipController.getLaser()
				.getX());
		Assert.assertEquals(20 + 40, alienShipController.getLaser().getY());
	}

	@Test
	public void updateMovesDown() {
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 40, 1), 500, 25);

		alienShipController.fire();
		alienShipController.update();

		Assert.assertEquals(10 + (30 - 5) / 2, alienShipController.getLaser()
				.getX());
		Assert.assertEquals(20 + 40 + 5, alienShipController.getLaser().getY());
	}

	@Test
	public void updateLaserResetAtLowerBounds() {
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 45, 1), 40, 25);

		alienShipController.fire();

		Assert.assertNotNull(alienShipController.getLaser());

		alienShipController.update();

		Assert.assertNull(alienShipController.getLaser());
	}

	@Test
	public void fireTwice() {
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 45, 1), 40, 25);

		alienShipController.fire();

		Laser laser = alienShipController.getLaser();

		alienShipController.fire();

		Assert.assertEquals(laser, alienShipController.getLaser());
	}

	@Test
	public void updateWithoutFire() {
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 45, 1), 40, 25);

		alienShipController.update();

		Assert.assertNull(alienShipController.getLaser());
	}

}
