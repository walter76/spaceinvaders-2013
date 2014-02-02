package de.thnuernberg.bme.swe.spaceinvaders.test.model;

import org.junit.Assert;
import org.junit.Test;

import de.thnuernberg.bme.swe.spaceinvaders.model.AlienShip;

public class AlienShipTest {

	@Test
	public void initialParameters() {
		AlienShip alienShip = new AlienShip(10, 20, 30, 40);

		Assert.assertEquals(10, alienShip.getX());
		Assert.assertEquals(20, alienShip.getY());
		Assert.assertEquals(30, alienShip.getWidth());
		Assert.assertEquals(40, alienShip.getHeight());
	}

}
