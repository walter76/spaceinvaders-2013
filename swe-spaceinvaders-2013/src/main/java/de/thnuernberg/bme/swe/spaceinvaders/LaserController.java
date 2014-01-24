package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class LaserController {

	public enum Direction {
		UP, DOWN
	}

	public static final int VELOCITY = 5;

	private final Laser laser;
	private final Direction direction;

	public Laser getLaser() {
		return laser;
	}

	public Direction getDirection() {
		return direction;
	}

	public LaserController(final Laser laser, final Direction direction) {
		this.laser = laser;
		this.direction = direction;
	}

	public void update() {
		switch (direction) {
		case UP:
			moveUp();
			break;
		case DOWN:
			moveDown();
			break;
		}
	}

	private void moveUp() {
		laser.setY(laser.getY() - VELOCITY);
	}

	private void moveDown() {
		laser.setY(laser.getY() + VELOCITY);
	}

}
