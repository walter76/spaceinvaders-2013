package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class LaserController {

	public static final int VELOCITY = 5;

	private final Laser laser; 

	public Laser getLaser() {
		return laser;
	}

	public LaserController(final Laser laser) {
		this.laser = laser;
	}

	public void moveUp() {
		laser.setY(laser.getY() - VELOCITY);
	}

	public void moveDown() {
		laser.setY(laser.getY() + VELOCITY);
	}

}
