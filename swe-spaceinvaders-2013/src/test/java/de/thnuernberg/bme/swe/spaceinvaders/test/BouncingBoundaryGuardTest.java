package de.thnuernberg.bme.swe.spaceinvaders.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import de.thnuernberg.bme.swe.spaceinvaders.BouncingBoundaryGuard;
import de.thnuernberg.bme.swe.spaceinvaders.BoundaryGuard;
import de.thnuernberg.bme.swe.spaceinvaders.model.MoveableGameObject;

public class BouncingBoundaryGuardTest {

	@Test
	public void checkBoundariesleftOutOfBounds() {
		MoveableGameObject guardedObject = Mockito
				.mock(MoveableGameObject.class);
		Mockito.when(guardedObject.getX()).thenReturn(4);
		Mockito.when(guardedObject.getY()).thenReturn(0);
		BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(5, 0, 500, 500);

		boundaryGuard.checkBoundaries(guardedObject);

		Mockito.verify(guardedObject).setX(5);
		Mockito.verify(guardedObject, Mockito.never()).setY(0);
	}

	@Test
	public void checkBoundariesRightOutOfBounds() {
		MoveableGameObject guardedObject = Mockito
				.mock(MoveableGameObject.class);
		Mockito.when(guardedObject.getX()).thenReturn(476);
		Mockito.when(guardedObject.getY()).thenReturn(0);
		Mockito.when(guardedObject.getWidth()).thenReturn(25);
		BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(0, 0, 500, 500);

		boundaryGuard.checkBoundaries(guardedObject);

		Mockito.verify(guardedObject).setX(475);
		Mockito.verify(guardedObject, Mockito.never()).setY(500);
	}

	@Test
	public void checkBoundariesTopOutOfBounds() {
		MoveableGameObject guardedObject = Mockito
				.mock(MoveableGameObject.class);
		Mockito.when(guardedObject.getX()).thenReturn(0);
		Mockito.when(guardedObject.getY()).thenReturn(4);
		BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(0, 5, 500, 500);

		boundaryGuard.checkBoundaries(guardedObject);

		Mockito.verify(guardedObject, Mockito.never()).setX(5);
		Mockito.verify(guardedObject).setY(5);
	}

	@Test
	public void checkBoundariesBottomOutOfBounds() {
		MoveableGameObject guardedObject = Mockito
				.mock(MoveableGameObject.class);
		Mockito.when(guardedObject.getX()).thenReturn(0);
		Mockito.when(guardedObject.getY()).thenReturn(481);
		Mockito.when(guardedObject.getHeight()).thenReturn(20);
		BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(0, 0, 500, 500);

		boundaryGuard.checkBoundaries(guardedObject);

		Mockito.verify(guardedObject, Mockito.never()).setX(500);
		Mockito.verify(guardedObject).setY(480);
	}

	@Test
	public void leftIsOutOfBounds() {
		MoveableGameObject guardedObject = Mockito
				.mock(MoveableGameObject.class);
		Mockito.when(guardedObject.getX()).thenReturn(4);
		Mockito.when(guardedObject.getY()).thenReturn(0);
		BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(5, 0, 500, 500);

		Assert.assertTrue(boundaryGuard.isOutOfBounds(guardedObject));
	}

	@Test
	public void rightIsOutOfBounds() {
		MoveableGameObject guardedObject = Mockito
				.mock(MoveableGameObject.class);
		Mockito.when(guardedObject.getX()).thenReturn(476);
		Mockito.when(guardedObject.getY()).thenReturn(0);
		Mockito.when(guardedObject.getWidth()).thenReturn(25);
		BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(0, 0, 500, 500);

		Assert.assertTrue(boundaryGuard.isOutOfBounds(guardedObject));
	}

	@Test
	public void topIsOutOfBounds() {
		MoveableGameObject guardedObject = Mockito
				.mock(MoveableGameObject.class);
		Mockito.when(guardedObject.getX()).thenReturn(0);
		Mockito.when(guardedObject.getY()).thenReturn(4);
		BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(0, 5, 500, 500);

		Assert.assertTrue(boundaryGuard.isOutOfBounds(guardedObject));
	}

	@Test
	public void bottomIsOutOfBounds() {
		MoveableGameObject guardedObject = Mockito
				.mock(MoveableGameObject.class);
		Mockito.when(guardedObject.getX()).thenReturn(0);
		Mockito.when(guardedObject.getY()).thenReturn(481);
		Mockito.when(guardedObject.getHeight()).thenReturn(20);
		BoundaryGuard boundaryGuard = new BouncingBoundaryGuard(0, 0, 500, 500);

		Assert.assertTrue(boundaryGuard.isOutOfBounds(guardedObject));
	}

}
