package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import de.thnuernberg.bme.swe.spaceinvaders.BouncingBoundaryGuard;
import de.thnuernberg.bme.swe.spaceinvaders.BoundaryGuard;
import de.thnuernberg.bme.swe.spaceinvaders.PlayerShipController;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;
import de.thnuernberg.bme.swe.spaceinvaders.model.MoveableGameObject;
import de.thnuernberg.bme.swe.spaceinvaders.model.PlayerShip;

public class PlayerShipControllerTest {

	private static final int PANEL_WIDTH = 105;
	private static final int PANEL_HEIGHT = 100;
	private static final int SPACING = 5;

	@Test
	public void resetToStartPosition() {
		final MoveableGameObject playerShip = new PlayerShip();
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, boundaryGuard);

		playerShipController.resetToStartPosition(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		Assert.assertEquals(35, playerShip.getX());
		Assert.assertEquals(75, playerShip.getY());
	}

	@Test
	public void resetToStartPositionPanelSizeTooSmall() {
		final int panelWidth = 35;
		final int panelHeight = 20;
		final MoveableGameObject playerShip = new PlayerShip();
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, boundaryGuard);

		playerShipController.resetToStartPosition(panelWidth, panelHeight,
				SPACING);

		Assert.assertEquals(0, playerShip.getX());
		Assert.assertEquals(0, playerShip.getY());
	}

	@Test
	public void moveRight() {
		final MoveableGameObject playerShip = new PlayerShip();
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, boundaryGuard);

		playerShipController.resetToStartPosition(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		final int startX = playerShip.getX();
		final int startY = playerShip.getY();

		playerShipController.moveRight();

		Assert.assertEquals(startX + PlayerShipController.VELOCITY,
				playerShip.getX());
		Assert.assertEquals(startY, playerShip.getY());
	}

	@Test
	public void moveLeft() {
		final MoveableGameObject playerShip = new PlayerShip();
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, boundaryGuard);

		playerShipController.resetToStartPosition(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		final int startX = playerShip.getX();
		final int startY = playerShip.getY();

		playerShipController.moveLeft();

		Assert.assertEquals(startX - PlayerShipController.VELOCITY,
				playerShip.getX());
		Assert.assertEquals(startY, playerShip.getY());
	}

	@Test
	public void moveRightUsesBoundaryGuard() {
		final MoveableGameObject playerShip = new PlayerShip();
		final BoundaryGuard boundaryGuard = Mockito.mock(BoundaryGuard.class);
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, boundaryGuard);

		playerShipController.resetToStartPosition(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShipController.moveRight();

		Mockito.verify(boundaryGuard).checkBoundaries(playerShip);
	}

	@Test
	public void moveLeftUsesBoundaryGuard() {
		final MoveableGameObject playerShip = new PlayerShip();
		final BoundaryGuard boundaryGuard = Mockito.mock(BoundaryGuard.class);
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, boundaryGuard);

		playerShipController.resetToStartPosition(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShipController.moveLeft();

		Mockito.verify(boundaryGuard).checkBoundaries(playerShip);
	}

	@Test
	public void laserNotFired() {
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), boundaryGuard);

		Assert.assertNull(playerShipController.getLaser());
	}

	@Test
	public void fireLaser() {
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), boundaryGuard);

		playerShipController.fire();

		Assert.assertNotNull(playerShipController.getLaser());
	}

	@Test
	public void fireLaserInitialLaserBulletPosition() {
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final MoveableGameObject playerShip = new PlayerShip();
		final PlayerShipController playerShipController = new PlayerShipController(
				playerShip, boundaryGuard);

		playerShipController.resetToStartPosition(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);
		playerShipController.fire();

		Laser laser = playerShipController.getLaser();
		Assert.assertEquals(
				playerShip.getX() + (playerShip.getWidth() - 5) / 2,
				laser.getX());
		Assert.assertEquals(playerShip.getY() - 5, laser.getY());
	}

	@Test
	public void updateAfterLaserFired() {
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), boundaryGuard);

		playerShipController.resetToStartPosition(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);
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
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), boundaryGuard);

		playerShipController.resetToStartPosition(PANEL_WIDTH, PANEL_HEIGHT,
				SPACING);

		playerShipController.update();

		Assert.assertNull(playerShipController.getLaser());
	}

	@Test
	public void updateLaserOutOfBounds() {
		final int panelHeight = 20;
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, panelHeight - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), boundaryGuard);

		playerShipController.resetToStartPosition(PANEL_WIDTH, panelHeight,
				SPACING);
		playerShipController.fire();

		Assert.assertNotNull(playerShipController.getLaser());

		playerShipController.update();

		Assert.assertNull(playerShipController.getLaser());
	}

	@Test
	public void fireTwice() {
		final BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(SPACING,
				SPACING, PANEL_WIDTH - SPACING, PANEL_HEIGHT - SPACING);
		final PlayerShipController playerShipController = new PlayerShipController(
				new PlayerShip(), boundaryGuard);

		playerShipController.fire();

		Laser laser = playerShipController.getLaser();

		playerShipController.fire();

		Assert.assertEquals(laser, playerShipController.getLaser());
	}

}
