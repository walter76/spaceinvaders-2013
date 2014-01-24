package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.AlienShip;
import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class AlienShipController {

	private final AlienShip alienShip;
	private final int panelHeight;
	private final int spacing;
	
	private Laser laser;

	public Laser getLaser() {
		return laser;
	}

	public AlienShip getAlienShip() {
		return alienShip;
	}
	
	public AlienShipController(final AlienShip alienShip, int panelHeight, int spacing) {
		this.alienShip = alienShip;
		this.panelHeight = panelHeight;
		this.spacing = spacing;
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
			if (laser.getY() > (panelHeight - spacing)) {
				laser = null;
			}
		}
	}

}
