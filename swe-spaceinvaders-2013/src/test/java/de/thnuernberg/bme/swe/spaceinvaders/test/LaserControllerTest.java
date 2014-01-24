package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Assert;
import org.junit.Test;

import de.thnuernberg.bme.swe.spaceinvaders.LaserController;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class LaserControllerTest {

	private static final int LASER_X = 10;
	private static final int LASER_Y = 20;

	@Test
	public void velocity() {
		Assert.assertEquals(5, LaserController.VELOCITY);
	}

	@Test
	public void initialization() {
		Laser laser = new Laser(LASER_X, LASER_Y);
		LaserController laserController = new LaserController(laser, LaserController.Direction.UP);
		
		Assert.assertEquals(laser, laserController.getLaser());
		Assert.assertEquals(LaserController.Direction.UP, laserController.getDirection());
	}
	
	@Test
	public void updateMoveUp() {
		LaserController laserController = new LaserController(new Laser(LASER_X, LASER_Y), LaserController.Direction.UP);

		laserController.update();

		Assert.assertEquals(LASER_X, laserController.getLaser().getX());
		Assert.assertEquals(LASER_Y - LaserController.VELOCITY, laserController.getLaser().getY());
	}

	@Test
	public void updateMoveDown() {
		LaserController laserController = new LaserController(new Laser(LASER_X, LASER_Y), LaserController.Direction.DOWN);

		laserController.update();

		Assert.assertEquals(LASER_X, laserController.getLaser().getX());
		Assert.assertEquals(LASER_Y + LaserController.VELOCITY, laserController.getLaser().getY());
	}

}
