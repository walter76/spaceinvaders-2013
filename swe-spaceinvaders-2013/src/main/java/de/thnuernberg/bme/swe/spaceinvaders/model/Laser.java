package de.thnuernberg.bme.swe.spaceinvaders.model;

public class Laser implements MoveableGameObject {

	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;
	
	private int x;
	private int y;

	@Override
	public void setX(final int x) {
		this.x = x;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setY(final int y) {
		this.y = y;
	}

	@Override
	public int getY() {
		return y;
	}

	public Laser(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

}
