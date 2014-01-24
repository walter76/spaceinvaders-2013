package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class PlayerShip {

	public static final int VELOCITY = 5;
	public static final int WIDTH = 25;
	public static final int HEIGHT = 20;
	
	private final int panelWidth;
	private final int panelHeight;
	private final int spacing;
	
	private int x;
	private int y;
	private Laser laser;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Laser getLaser() {
		return laser;
	}
	
	public PlayerShip(final int panelWidth, final int panelHeight, final int spacing) {
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		this.spacing = spacing;
	}
	
	public void resetToStartPosition() {
		x = (panelWidth - WIDTH) / 2 - spacing;
		if (x < 0) {
			x = 0;
		}
		
		y = panelHeight - HEIGHT - spacing;
		if (y < 0) {
			y = 0;
		}
	}
	
	public void moveRight() {
		x += VELOCITY;
		if (x > (panelWidth - WIDTH - spacing)) {
			x = panelWidth - WIDTH - spacing;
		}
	}

	public void moveLeft() {
		x -= VELOCITY;
		if (x < spacing) {
			x = spacing;
		}
	}

	public void fire() {
		if (laser == null) {
			laser = new Laser(x + (WIDTH - 5) / 2, y - 5);
		}
	}

	public void update() {
		if (laser != null) {
			new LaserController(laser).moveUp();
			if (laser.getY() < spacing) {
				laser = null;
			}
		}
	}
	
}
