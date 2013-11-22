package de.thnuernberg.bme.swe.spaceinvaders;

import javax.swing.JFrame;

public class SpaceInvaders {

	public static void main(String[] args) {
		// create a new instance of the application window
		JFrame spaceInvadersWindow = new JFrame();
		
		// exit the application if the main window is closed
		spaceInvadersWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// hier ist eine Änderung
		
		// set the window title to "Space Invaders"
		spaceInvadersWindow.setTitle("Space Invaders");
		
		// add the Game Panel to the application window
		spaceInvadersWindow.add(new GamePanel());
		
		// resize the application window to fit all added components
		spaceInvadersWindow.pack();
		
		// show the application window
		spaceInvadersWindow.setVisible(true);
	}

}
