package de.thnuernberg.bme.swe.spaceinvaders.model;

public class Laser {

	private int x;
	private int y;

	public void setX(final int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}

	public void setY(final int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public Laser(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
