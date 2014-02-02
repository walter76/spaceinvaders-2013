package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.AlienShip;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class AlienShipController {

	private final AlienShip alienShip;

	public AlienShip getAlienShip() {
		return alienShip;
	}

	public AlienShipController(final AlienShip alienShip) {
		this.alienShip = alienShip;
	}

	public Laser fire() {
		return new Laser(alienShip.getX() + (alienShip.getWidth() - 5) / 2,
				alienShip.getY() + alienShip.getHeight());
	}

}
