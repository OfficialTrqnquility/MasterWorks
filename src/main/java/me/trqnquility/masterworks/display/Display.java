package me.trqnquility.masterworks.display;

import me.trqnquility.masterworks.Game;
import me.trqnquility.masterworks.mouse.MouseManager;
import me.trqnquility.masterworks.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class Display {

	JFrame frame;

	private String title;

	private int width, height;
	private Canvas canvas;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		createJFrame();
	}

	private void createJFrame() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.addMouseListener(Game.getInstance().getMouseManager());

		frame.setIconImage(new ImageIcon(Utils.loadImage("/textures/masterworksLogo.jpg")).getImage());

		canvas = new Canvas();
		Dimension dimension = new Dimension(width, height);

		canvas.setPreferredSize(dimension);
		canvas.setMaximumSize(dimension);
		canvas.setMinimumSize(dimension);
		canvas.setFocusable(false);
		canvas.addMouseListener(Game.getInstance().getMouseManager());

		frame.add(canvas);
		frame.pack();
	}


	public JFrame getFrame() {
		return frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}
}
