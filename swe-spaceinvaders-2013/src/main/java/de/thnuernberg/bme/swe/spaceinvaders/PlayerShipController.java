package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;
import de.thnuernberg.bme.swe.spaceinvaders.model.PlayerShip;

public class PlayerShipController {

	public static final int VELOCITY = 5;
	public static final int WIDTH = 25;
	public static final int HEIGHT = 20;

	private final PlayerShip playerShip;
	private final int panelWidth;
	private final int panelHeight;
	private final int spacing;

	private Laser laser;

	public Laser getLaser() {
		return laser;
	}

	public PlayerShip getPlayerShip() {
		return playerShip;
	}

	public PlayerShipController(final PlayerShip playerShip,
			final int panelWidth, final int panelHeight, final int spacing) {
		this.playerShip = playerShip;
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		this.spacing = spacing;
	}

	public void resetToStartPosition() {
		playerShip.setX((panelWidth - WIDTH) / 2 - spacing);
		if (playerShip.getX() < 0) {
			playerShip.setX(0);
		}

		playerShip.setY(panelHeight - HEIGHT - spacing);
		if (playerShip.getY() < 0) {
			playerShip.setY(0);
		}
	}

	public void moveRight() {
		int x = playerShip.getX();
		x += VELOCITY;
		if (x > (panelWidth - WIDTH - spacing)) {
			x = panelWidth - WIDTH - spacing;
		}
		playerShip.setX(x);
	}

	public void moveLeft() {
		int x = playerShip.getX();
		x -= VELOCITY;
		if (x < spacing) {
			x = spacing;
		}
		playerShip.setX(x);
	}

	public void fire() {
		if (laser == null) {
			laser = new Laser(playerShip.getX() + (WIDTH - 5) / 2,
					playerShip.getY() - 5);
		}
	}

	public void update() {
		if (laser != null) {
			new LaserController(laser, LaserController.Direction.UP).update();
			if (laser.getY() < spacing) {
				laser = null;
			}
		}
	}

}
