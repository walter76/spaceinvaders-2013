package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Assert;
import org.junit.Test;

import de.thnuernberg.bme.swe.spaceinvaders.Laser;

public class LaserTest {

	private static final int LASER_X = 10;
	private static final int LASER_Y = 20;

	@Test
	public void velocity() {
		Assert.assertEquals(5, Laser.VELOCITY);
	}

	@Test
	public void initialCoordinates() {
		Laser laser = new Laser(LASER_X, LASER_Y);

		Assert.assertEquals(LASER_X, laser.getX());
		Assert.assertEquals(LASER_Y, laser.getY());
	}

	@Test
	public void moveUp() {
		Laser laser = new Laser(LASER_X, LASER_Y);

		laser.moveUp();

		Assert.assertEquals(LASER_X, laser.getX());
		Assert.assertEquals(LASER_Y - Laser.VELOCITY, laser.getY());
	}

	@Test
	public void moveDown() {
		Laser laser = new Laser(LASER_X, LASER_Y);

		laser.moveDown();

		Assert.assertEquals(LASER_X, laser.getX());
		Assert.assertEquals(LASER_Y + Laser.VELOCITY, laser.getY());
	}

}
