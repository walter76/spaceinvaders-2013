package de.thnuernberg.bme.swe.spaceinvaders.model;

public class AlienShip implements GameObject {

	private int x;
	private int y;
	private int width;
	private int height;

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	public AlienShip(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}
