package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.Laser;

public class AlienShip {

	private final int panelHeight;
	private final int spacing;

	private int x;
	private int y;
	private int width;
	private int height;
	private int row;
	private Laser laser;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getRow() {
		return row;
	}

	public Laser getLaser() {
		return laser;
	}

	public AlienShip(int x, int y, int width, int height, int row, int panelHeight, int spacing) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.row = row;
		this.panelHeight = panelHeight;
		this.spacing = spacing;
	}

	public void fire() {
		if (laser == null) {
			laser = new Laser(x + (width - 5) / 2, y + height);
		}
	}

	public void update() {
		if (laser != null) {
			new LaserController(laser).moveDown();
			if (laser.getY() > (panelHeight - spacing)) {
				laser = null;
			}
		}
	}

}
