package de.thnuernberg.bme.swe.spaceinvaders;

import javax.swing.JFrame;

public class SpaceInvaders {

	public static void main(String[] args) {
		JFrame spaceInvadersWindow = new JFrame();
		spaceInvadersWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		spaceInvadersWindow.setTitle("Space Invaders");
		spaceInvadersWindow.add(new GamePanel());
		spaceInvadersWindow.pack();
		spaceInvadersWindow.setVisible(true);
	}

}
