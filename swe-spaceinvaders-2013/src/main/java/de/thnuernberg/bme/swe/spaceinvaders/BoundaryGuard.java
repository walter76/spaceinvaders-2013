package de.thnuernberg.bme.swe.spaceinvaders;

import de.thnuernberg.bme.swe.spaceinvaders.model.MoveableGameObject;

public interface BoundaryGuard {

	public void checkBoundaries(MoveableGameObject guardedObject);

	public boolean isOutOfBounds(MoveableGameObject guardedObject);

}