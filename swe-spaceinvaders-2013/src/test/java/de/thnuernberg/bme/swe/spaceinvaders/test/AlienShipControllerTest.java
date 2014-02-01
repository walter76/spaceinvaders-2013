package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import de.thnuernberg.bme.swe.spaceinvaders.AlienShipController;
import de.thnuernberg.bme.swe.spaceinvaders.BoundaryGuard;
import de.thnuernberg.bme.swe.spaceinvaders.model.AlienShip;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;
import de.thnuernberg.bme.swe.spaceinvaders.model.MoveableGameObject;

public class AlienShipControllerTest {

	@Test
	public void initialParameters() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 40, 1);
		BoundaryGuard boundaryGuard = Mockito.mock(BoundaryGuard.class);
		AlienShipController alienShipController = new AlienShipController(
				alienShip, boundaryGuard);

		Assert.assertEquals(alienShip, alienShipController.getAlienShip());
	}

	@Test
	public void laserIsInitiallyNull() {
		BoundaryGuard boundaryGuard = Mockito.mock(BoundaryGuard.class);
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 40, 1), boundaryGuard);

		Assert.assertNull(alienShipController.getLaser());
	}

	@Test
	public void fire() {
		BoundaryGuard boundaryGuard = Mockito.mock(BoundaryGuard.class);
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 40, 1), boundaryGuard);

		alienShipController.fire();

		Assert.assertNotNull(alienShipController.getLaser());
		Assert.assertEquals(10 + (30 - 5) / 2, alienShipController.getLaser()
				.getX());
		Assert.assertEquals(20 + 40, alienShipController.getLaser().getY());
	}

	@Test
	public void updateMovesDown() {
		BoundaryGuard boundaryGuard = Mockito.mock(BoundaryGuard.class);
		Mockito.when(
				boundaryGuard.isOutOfBounds(Mockito
						.any(MoveableGameObject.class))).thenReturn(false);
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 40, 1), boundaryGuard);

		alienShipController.fire();
		alienShipController.update();

		Assert.assertEquals(10 + (30 - 5) / 2, alienShipController.getLaser()
				.getX());
		Assert.assertEquals(20 + 40 + 5, alienShipController.getLaser().getY());
	}

	@Test
	public void updateLaserResetAtLowerBounds() {
		BoundaryGuard boundaryGuard = Mockito.mock(BoundaryGuard.class);
		Mockito.when(
				boundaryGuard.isOutOfBounds(Mockito
						.any(MoveableGameObject.class))).thenReturn(true);
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 45, 1), boundaryGuard);

		alienShipController.fire();

		Assert.assertNotNull(alienShipController.getLaser());

		alienShipController.update();

		Assert.assertNull(alienShipController.getLaser());
	}

	@Test
	public void fireTwice() {
		BoundaryGuard boundaryGuard = Mockito.mock(BoundaryGuard.class);
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 45, 1), boundaryGuard);

		alienShipController.fire();

		Laser laser = alienShipController.getLaser();

		alienShipController.fire();

		Assert.assertEquals(laser, alienShipController.getLaser());
	}

	@Test
	public void updateWithoutFire() {
		BoundaryGuard boundaryGuard = Mockito.mock(BoundaryGuard.class);
		AlienShipController alienShipController = new AlienShipController(
				new AlienShip(10, 20, 30, 45, 1), boundaryGuard);

		alienShipController.update();

		Mockito.verify(boundaryGuard, Mockito.never()).checkBoundaries(
				Mockito.any(MoveableGameObject.class));
		Assert.assertNull(alienShipController.getLaser());
	}

}
