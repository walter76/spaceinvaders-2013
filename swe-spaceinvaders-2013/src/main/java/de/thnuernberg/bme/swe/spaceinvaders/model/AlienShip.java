package de.thnuernberg.bme.swe.spaceinvaders.model;

public class AlienShip {

	private int x;
	private int y;
	private int width;
	private int height;
	private int row;

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

	public AlienShip(int x, int y, int width, int height, int row) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.row = row;
	}

}
