package de.thnuernberg.bme.swe.spaceinvaders.view;

public interface SpriteFactory {

	public Sprite getAlienSprite(int row);

	public Sprite getPlayerSprite();

}