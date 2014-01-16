package de.thnuernberg.bme.swe.spaceinvaders;

public class Laser {

	public static final int VELOCITY = 5;
	
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Laser(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveUp() {
		y -= VELOCITY;
	}
	
	public void moveDown() {
		y += VELOCITY;
	}
	
}
