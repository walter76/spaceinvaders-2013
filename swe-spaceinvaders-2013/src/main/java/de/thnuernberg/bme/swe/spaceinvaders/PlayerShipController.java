package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;
import de.thnuernberg.bme.swe.spaceinvaders.model.MoveableGameObject;

public class PlayerShipController {

	public static final int VELOCITY = 5;

	private final MoveableGameObject playerShip;
	private final BoundaryGuard boundaryGuard;

	private Laser laser;

	public Laser getLaser() {
		return laser;
	}

	public MoveableGameObject getPlayerShip() {
		return playerShip;
	}

	public PlayerShipController(final MoveableGameObject playerShip,
			final BoundaryGuard boundaryGuard) {
		this.playerShip = playerShip;
		this.boundaryGuard = boundaryGuard;
	}

	public void resetToStartPosition(final int panelWidth,
			final int panelHeight, final int spacing) {
		playerShip.setX((panelWidth - playerShip.getWidth()) / 2 - spacing);
		if (playerShip.getX() < 0) {
			playerShip.setX(0);
		}

		playerShip.setY(panelHeight - playerShip.getHeight() - spacing);
		if (playerShip.getY() < 0) {
			playerShip.setY(0);
		}
	}

	public void moveRight() {
		int x = playerShip.getX();
		x += VELOCITY;
		playerShip.setX(x);
		boundaryGuard.checkBoundaries(playerShip);
	}

	public void moveLeft() {
		int x = playerShip.getX();
		x -= VELOCITY;
		playerShip.setX(x);
		boundaryGuard.checkBoundaries(playerShip);
	}

	public void fire() {
		if (laser == null) {
			laser = new Laser(playerShip.getX() + (playerShip.getWidth() - 5)
					/ 2, playerShip.getY() - 5);
		}
	}

	public void update() {
		if (laser != null) {
			new LaserController(laser, LaserController.Direction.UP).update();
			if (boundaryGuard.isOutOfBounds(laser)) {
				laser = null;
			}
		}
	}

}
