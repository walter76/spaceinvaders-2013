package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Test;
import org.junit.Assert;

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

}
