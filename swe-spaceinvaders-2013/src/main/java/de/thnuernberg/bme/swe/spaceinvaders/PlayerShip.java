package de.thnuernberg.bme.swe.spaceinvaders;

public class PlayerShip {

	public static final int VELOCITY = 5;
	
	private final int panelWidth;
	private final int panelHeight;
	private final int spacing;
	
	private int x;
	private int y;
	private int laserX;
	private int laserY;
	private boolean laserFired;

	public PlayerShip(final int panelWidth, final int panelHeight, final int spacing) {
		this.panelWidth = panelWidth;
		this.panelHeight = panelHeight;
		this.spacing = spacing;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void resetToStartPosition() {
		x = (panelWidth - 25) / 2 - spacing;
		if (x < 0) {
			x = 0;
		}
		
		y = panelHeight - 20 - spacing;
		if (y < 0) {
			y = 0;
		}
	}
	
	public void moveRight() {
		x += VELOCITY;
		if (x > (panelWidth - 25 - spacing)) {
			x = panelWidth - 25 - spacing;
		}
	}

	public void moveLeft() {
		x -= VELOCITY;
		if (x < spacing) {
			x = spacing;
		}
	}
	
	public void fire() {
		laserFired = true;
		laserX = x;
		laserY = y;
	}
	
	public boolean hasLaserFired() {
		return laserFired;
	}
	
	public int getLaserX() {
		return laserX;
	}
	
	public int getLaserY() {
		return laserY;
	}
	
	public void update() {
		if (laserFired) {
			laserY -= 5;
			if (laserY < 0) {
				laserFired = false;
			}
		}
	}
	
}
