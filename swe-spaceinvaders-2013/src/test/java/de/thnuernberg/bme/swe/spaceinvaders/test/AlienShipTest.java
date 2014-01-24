package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Assert;
import org.junit.Test;

import de.thnuernberg.bme.swe.spaceinvaders.AlienShip;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class AlienShipTest {

	@Test
	public void initialParameters() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 40, 1, 500, 25);
		
		Assert.assertEquals(10, alienShip.getX());
		Assert.assertEquals(20, alienShip.getY());
		Assert.assertEquals(30, alienShip.getWidth());
		Assert.assertEquals(40, alienShip.getHeight());
		Assert.assertEquals(1, alienShip.getRow());
	}
	
	@Test
	public void laserIsInitiallyNull() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 40, 1, 500, 25);
		
		Assert.assertNull(alienShip.getLaser());
	}
	
	@Test
	public void fire() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 40, 1, 500, 25);
		
		alienShip.fire();
		
		Assert.assertNotNull(alienShip.getLaser());
		Assert.assertEquals(10 + (30 - 5) / 2, alienShip.getLaser().getX());
		Assert.assertEquals(20 + 40, alienShip.getLaser().getY());
	}
	
	@Test
	public void updateMovesDown() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 40, 1, 500, 25);
		
		alienShip.fire();
		alienShip.update();
		
		Assert.assertEquals(10 + (30 - 5) / 2, alienShip.getLaser().getX());
		Assert.assertEquals(20 + 40 + 5, alienShip.getLaser().getY());
	}
	
	@Test
	public void updateLaserResetAtLowerBounds() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 45, 1, 40, 25);
		
		alienShip.fire();
		
		Assert.assertNotNull(alienShip.getLaser());

		alienShip.update();
		
		Assert.assertNull(alienShip.getLaser());
	}
	
	@Test
	public void fireTwice() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 45, 1, 40, 25);
		
		alienShip.fire();

		Laser laser = alienShip.getLaser();
		
		alienShip.fire();
		
		Assert.assertEquals(laser, alienShip.getLaser());
	}
	
	@Test
	public void updateWithoutFire() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 45, 1, 40, 25);

		alienShip.update();
		
		Assert.assertNull(alienShip.getLaser());
	}
	
}
