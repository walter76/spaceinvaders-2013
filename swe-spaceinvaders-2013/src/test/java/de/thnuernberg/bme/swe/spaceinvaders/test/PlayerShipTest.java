package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Test;
import org.junit.Assert;

import de.thnuernberg.bme.swe.spaceinvaders.Laser;
import de.thnuernberg.bme.swe.spaceinvaders.PlayerShip;

public class PlayerShipTest {

	private static final int PANEL_WIDTH = 105;
	private static final int PANEL_HEIGHT = 100;
	private static final int SPACING = 5;

	@Test
	public void resetToStartPosition() {
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShip.resetToStartPosition();

		Assert.assertEquals(35, playerShip.getX());
		Assert.assertEquals(75, playerShip.getY());
	}

	@Test
	public void resetToStartPositionPanelSizeTooSmall() {
		final int panelWidth = 35;
		final int panelHeight = 20;
		final PlayerShip playerShip = new PlayerShip(panelWidth, panelHeight,
				SPACING);

		playerShip.resetToStartPosition();

		Assert.assertEquals(0, playerShip.getX());
		Assert.assertEquals(0, playerShip.getY());
	}

	@Test
	public void moveRight() {
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShip.resetToStartPosition();

		final int startX = playerShip.getX();
		final int startY = playerShip.getY();

		playerShip.moveRight();

		Assert.assertEquals(startX + PlayerShip.VELOCITY, playerShip.getX());
		Assert.assertEquals(startY, playerShip.getY());
	}

	@Test
	public void moveLeft() {
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShip.resetToStartPosition();

		final int startX = playerShip.getX();
		final int startY = playerShip.getY();

		playerShip.moveLeft();

		Assert.assertEquals(startX - PlayerShip.VELOCITY, playerShip.getX());
		Assert.assertEquals(startY, playerShip.getY());
	}

	@Test
	public void moveRightOutOfBounds() {
		final int panelWidth = 30;
		final PlayerShip playerShip = new PlayerShip(panelWidth, PANEL_HEIGHT,
				SPACING);

		playerShip.resetToStartPosition();
		final int startX = playerShip.getX();

		playerShip.moveRight();

		Assert.assertEquals(startX, playerShip.getX());
	}

	@Test
	public void moveLeftOutOfBounds() {
		final int panelWidth = 45;
		final PlayerShip playerShip = new PlayerShip(panelWidth, PANEL_HEIGHT,
				SPACING);

		playerShip.resetToStartPosition();
		final int startX = playerShip.getX();

		playerShip.moveLeft();

		Assert.assertEquals(startX, playerShip.getX());
	}

	@Test
	public void laserNotFired() {
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		Assert.assertNull(playerShip.getLaser());
	}

	@Test
	public void fireLaser() {
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShip.fire();

		Assert.assertNotNull(playerShip.getLaser());
	}

	@Test
	public void fireLaserInitialLaserBulletPosition() {
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShip.resetToStartPosition();
		playerShip.fire();

		Laser laser = playerShip.getLaser();
		Assert.assertEquals(playerShip.getX() + (PlayerShip.WIDTH - 5) / 2, laser.getX());
		Assert.assertEquals(playerShip.getY() - 5, laser.getY());
	}

	@Test
	public void updateAfterLaserFired() {
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShip.resetToStartPosition();
		playerShip.fire();
		final int startLaserX = playerShip.getLaser().getX();
		final int startLaserY = playerShip.getLaser().getY();

		playerShip.update();

		Laser laser = playerShip.getLaser();
		Assert.assertEquals(startLaserX, laser.getX());
		Assert.assertEquals(startLaserY - 5, laser.getY());
	}

	@Test
	public void updateLaserNotFired() {
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);
		
		playerShip.resetToStartPosition();
		
		playerShip.update();

		Assert.assertNull(playerShip.getLaser());
	}

	@Test
	public void updateLaserOutOfBounds() {
		final int panelHeight = 20;
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, panelHeight,
				SPACING);

		playerShip.resetToStartPosition();
		playerShip.fire();

		Assert.assertNotNull(playerShip.getLaser());

		playerShip.update();

		Assert.assertNull(playerShip.getLaser());
	}

	@Test
	public void fireTwice() {
		final PlayerShip playerShip = new PlayerShip(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShip.fire();
		
		Laser laser = playerShip.getLaser();
		
		playerShip.fire();

		Assert.assertEquals(laser, playerShip.getLaser());
	}
	
}
