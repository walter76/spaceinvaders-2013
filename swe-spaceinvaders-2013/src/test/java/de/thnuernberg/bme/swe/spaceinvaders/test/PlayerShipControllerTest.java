package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Assert;
import org.junit.Test;

import de.thnuernberg.bme.swe.spaceinvaders.PlayerShipController;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;
import de.thnuernberg.bme.swe.spaceinvaders.model.PlayerShip;

public class PlayerShipControllerTest {

	private static final int PANEL_WIDTH = 105;
	private static final int PANEL_HEIGHT = 100;
	private static final int SPACING = 5;

	@Test
	public void resetToStartPosition() {
		final PlayerShip playerShip = new PlayerShip();
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, PANEL_WIDTH, PANEL_HEIGHT, SPACING);

		playerShipController.resetToStartPosition();

		Assert.assertEquals(35, playerShip.getX());
		Assert.assertEquals(75, playerShip.getY());
	}

	@Test
	public void resetToStartPositionPanelSizeTooSmall() {
		final int panelWidth = 35;
		final int panelHeight = 20;
		final PlayerShip playerShip = new PlayerShip();
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, panelWidth, panelHeight, SPACING);

		playerShipController.resetToStartPosition();

		Assert.assertEquals(0, playerShip.getX());
		Assert.assertEquals(0, playerShip.getY());
	}

	@Test
	public void moveRight() {
		final PlayerShip playerShip = new PlayerShip();
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, PANEL_WIDTH, PANEL_HEIGHT, SPACING);

		playerShipController.resetToStartPosition();

		final int startX = playerShip.getX();
		final int startY = playerShip.getY();

		playerShipController.moveRight();

		Assert.assertEquals(startX + PlayerShipController.VELOCITY,
				playerShip.getX());
		Assert.assertEquals(startY, playerShip.getY());
	}

	@Test
	public void moveLeft() {
		final PlayerShip playerShip = new PlayerShip();
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, PANEL_WIDTH, PANEL_HEIGHT, SPACING);

		playerShipController.resetToStartPosition();

		final int startX = playerShip.getX();
		final int startY = playerShip.getY();

		playerShipController.moveLeft();

		Assert.assertEquals(startX - PlayerShipController.VELOCITY,
				playerShip.getX());
		Assert.assertEquals(startY, playerShip.getY());
	}

	@Test
	public void moveRightOutOfBounds() {
		final int panelWidth = 30;
		final PlayerShip playerShip = new PlayerShip();
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, panelWidth, PANEL_HEIGHT, SPACING);

		playerShipController.resetToStartPosition();
		final int startX = playerShip.getX();

		playerShipController.moveRight();

		Assert.assertEquals(startX, playerShip.getX());
	}

	@Test
	public void moveLeftOutOfBounds() {
		final int panelWidth = 45;
		final PlayerShip playerShip = new PlayerShip();
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, panelWidth, PANEL_HEIGHT, SPACING);

		playerShipController.resetToStartPosition();
		final int startX = playerShip.getX();

		playerShipController.moveLeft();

		Assert.assertEquals(startX, playerShip.getX());
	}

	@Test
	public void laserNotFired() {
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), PANEL_WIDTH, PANEL_HEIGHT, SPACING);

		Assert.assertNull(playerShipController.getLaser());
	}

	@Test
	public void fireLaser() {
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), PANEL_WIDTH, PANEL_HEIGHT, SPACING);

		playerShipController.fire();

		Assert.assertNotNull(playerShipController.getLaser());
	}

	@Test
	public void fireLaserInitialLaserBulletPosition() {
		final PlayerShip playerShip = new PlayerShip();
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, PANEL_WIDTH, PANEL_HEIGHT, SPACING);

		playerShipController.resetToStartPosition();
		playerShipController.fire();

		Laser laser = playerShipController.getLaser();
		Assert.assertEquals(playerShip.getX()
				+ (PlayerShipController.WIDTH - 5) / 2, laser.getX());
		Assert.assertEquals(playerShip.getY() - 5, laser.getY());
	}

	@Test
	public void updateAfterLaserFired() {
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), PANEL_WIDTH, PANEL_HEIGHT, SPACING);

		playerShipController.resetToStartPosition();
		playerShipController.fire();
		final int startLaserX = playerShipController.getLaser().getX();
		final int startLaserY = playerShipController.getLaser().getY();

		playerShipController.update();

		Laser laser = playerShipController.getLaser();
		Assert.assertEquals(startLaserX, laser.getX());
		Assert.assertEquals(startLaserY - 5, laser.getY());
	}

	@Test
	public void updateLaserNotFired() {
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), PANEL_WIDTH, PANEL_HEIGHT, SPACING);

		playerShipController.resetToStartPosition();

		playerShipController.update();

		Assert.assertNull(playerShipController.getLaser());
	}

	@Test
	public void updateLaserOutOfBounds() {
		final int panelHeight = 20;
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), PANEL_WIDTH, panelHeight, SPACING);

		playerShipController.resetToStartPosition();
		playerShipController.fire();

		Assert.assertNotNull(playerShipController.getLaser());

		playerShipController.update();

		Assert.assertNull(playerShipController.getLaser());
	}

	@Test
	public void fireTwice() {
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), PANEL_WIDTH, PANEL_HEIGHT, SPACING);

		playerShipController.fire();

		Laser laser = playerShipController.getLaser();

		playerShipController.fire();

		Assert.assertEquals(laser, playerShipController.getLaser());
	}

}
