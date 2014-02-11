package de.thnuernberg.bme.swe.spaceinvaders;

import javax.swing.JFrame;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class SpaceInvaders {

	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();

		// create a new instance of the application window
		JFrame spaceInvadersWindow = new JFrame();

		// exit the application if the main window is closed
		spaceInvadersWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set the window title to "Space Invaders"
		spaceInvadersWindow.setTitle("Space Invaders");

		// add the Game Panel to the application window
		GamePanel gamePanel = container.instance().select(GamePanel.class)
				.get();
		spaceInvadersWindow.add(gamePanel);

		// resize the application window to fit all added components
		spaceInvadersWindow.pack();

		// show the application window
		spaceInvadersWindow.setVisible(true);

		weld.shutdown();
	}

}
