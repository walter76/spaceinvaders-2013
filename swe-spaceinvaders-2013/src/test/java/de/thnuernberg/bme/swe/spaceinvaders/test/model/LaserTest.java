package de.thnuernberg.bme.swe.spaceinvaders.test.model;

import org.junit.Assert;
import org.junit.Test;

import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class LaserTest {

	private static final int LASER_X = 10;
	private static final int LASER_Y = 20;

	@Test
	public void initialCoordinates() {
		Laser laser = new Laser(LASER_X, LASER_Y);

		Assert.assertEquals(LASER_X, laser.getX());
		Assert.assertEquals(LASER_Y, laser.getY());
	}

	@Test
	public void setX() {
		Laser laser = new Laser(LASER_X, LASER_Y);

		laser.setX(LASER_X + 10);

		Assert.assertEquals(LASER_X + 10, laser.getX());
	}

	@Test
	public void setY() {
		Laser laser = new Laser(LASER_X, LASER_Y);

		laser.setY(LASER_Y + 10);

		Assert.assertEquals(LASER_Y + 10, laser.getY());
	}

	@Test
	public void dimensions() {
		Laser laser = new Laser(LASER_X, LASER_Y);

		Assert.assertEquals(Laser.WIDTH, laser.getWidth());
		Assert.assertEquals(Laser.HEIGHT, laser.getHeight());
	}

}
