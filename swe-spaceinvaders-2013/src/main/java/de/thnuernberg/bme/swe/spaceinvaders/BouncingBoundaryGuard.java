package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.MoveableGameObject;

public class BouncingBoundaryGuard implements BoundaryGuard {

	private final int left;
	private final int top;
	private final int right;
	private final int bottom;

	public BouncingBoundaryGuard(final int left, final int top,
			final int right, final int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	@Override
	public void checkBoundaries(final MoveableGameObject guardedObject) {
		if (guardedObject.getX() < left) {
			guardedObject.setX(left);
		}
		if (guardedObject.getY() < top) {
			guardedObject.setY(top);
		}
		if (guardedObject.getX() > (right - guardedObject.getWidth())) {
			guardedObject.setX(right - guardedObject.getWidth());
		}
		if (guardedObject.getY() > (bottom - guardedObject.getHeight())) {
			guardedObject.setY(bottom - guardedObject.getHeight());
		}
	}

	@Override
	public boolean isOutOfBounds(final MoveableGameObject guardedObject) {
		if (guardedObject.getX() < left || guardedObject.getY() < top
				|| guardedObject.getX() > (right - guardedObject.getWidth())
				|| guardedObject.getY() > (bottom - guardedObject.getHeight())) {
			return true;
		}
		return false;
	}

}
