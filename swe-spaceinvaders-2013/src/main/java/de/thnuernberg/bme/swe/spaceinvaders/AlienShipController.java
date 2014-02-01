package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.AlienShip;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class AlienShipController {

	private final AlienShip alienShip;
	private final BoundaryGuard boundaryGuard;

	private Laser laser;

	public Laser getLaser() {
		return laser;
	}

	public AlienShip getAlienShip() {
		return alienShip;
	}

	public AlienShipController(final AlienShip alienShip,
			final BoundaryGuard boundaryGuard) {
		this.alienShip = alienShip;
		this.boundaryGuard = boundaryGuard;
	}

	public void fire() {
		if (laser == null) {
			laser = new Laser(
					alienShip.getX() + (alienShip.getWidth() - 5) / 2,
					alienShip.getY() + alienShip.getHeight());
		}
	}

	public void update() {
		if (laser != null) {
			new LaserController(laser, LaserController.Direction.DOWN).update();
			if (boundaryGuard.isOutOfBounds(laser)) {
				laser = null;
			}
		}
	}

}
