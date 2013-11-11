package de.thnuernberg.bme.swe.spaceinvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static final int PANEL_WIDTH = 455;
	private static final int PANEL_HEIGHT = 500;

	public GamePanel() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	}
	
	@Override
	public void paintComponent(Graphics graphicsContext) {
		super.paintComponent(graphicsContext);
		
		graphicsContext.setColor(Color.WHITE);
		
		final int width = 40;
		final int height = 10;
		final int spacing = 5;
		for (int j = 0; j < 4; j++) {
			final int y = spacing + j * (spacing + height);
			for (int i = 0; i < 10; i++) {
				final int x = spacing + i * (spacing + width);
				graphicsContext.fillRect(x, y, width, height);
			}
		}
	}
	
}
