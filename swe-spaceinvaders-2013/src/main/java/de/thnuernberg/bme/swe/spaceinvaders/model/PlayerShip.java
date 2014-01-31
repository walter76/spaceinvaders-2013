package de.thnuernberg.bme.swe.spaceinvaders.model;

public class PlayerShip implements MoveableGameObject {

	private static final int WIDTH = 25;
	private static final int HEIGHT = 20;
	
	private int x;
	private int y;

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(final int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(final int y) {
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
