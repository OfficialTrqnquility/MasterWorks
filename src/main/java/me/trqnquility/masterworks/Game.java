package me.trqnquility.masterworks;

import lombok.SneakyThrows;
import me.trqnquility.masterworks.display.Display;
import me.trqnquility.masterworks.exceptions.NoStateException;
import me.trqnquility.masterworks.gfx.Assets;
import me.trqnquility.masterworks.keymanager.KeyManager;
import me.trqnquility.masterworks.mouse.MouseManager;
import me.trqnquility.masterworks.state.MenuState;
import me.trqnquility.masterworks.state.State;
import me.trqnquility.masterworks.worlds.World;
import me.trqnquility.masterworks.worlds.WorldManager;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

	private static Game instance;

	private Display display;
	public final int width, height;
	public final String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bufferStrategy;
	private Graphics graphics;

	private KeyManager keyManager;
	private MouseManager mouseManager;
	private boolean devMode = false;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		devMode = true;
	}

	private void init() {

		Assets.init();

		display = new Display(title, width, height);

		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		State.setState(new MenuState());
		WorldManager.getInstance().loadWorld(new World("worlds/overworld.txt"));
		WorldManager.getInstance().loadWorld(new World("worlds/house.txt"));
		WorldManager.getInstance().loadWorld(new World("worlds/bossworld.txt"));

	}

	private void tick() throws NoStateException {

		State state = State.getState();

		if (state == null) throw new NoStateException("State is null");

		state.tick();

	}

	@SneakyThrows
	private void render(int ticks) {
		bufferStrategy = display.getCanvas().getBufferStrategy();

		State state = State.getState();

		if (bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		if (state == null) throw new NoStateException("State is null");

		graphics = bufferStrategy.getDrawGraphics();
		//Clear Screen
		graphics.clearRect(0, 0, width, height); // Resets the screen
		//Draw Here!
		State.getState().render(graphics);

		if (devMode) {
			graphics.setColor(Color.WHITE);
			graphics.drawString("FPS: " + ticks, 10, 20);
		}
		//End Drawing!
		bufferStrategy.show();
		graphics.dispose();
	}

	public void run() {

		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		int tick = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				try {
					tick(); // Updates everything
					render(tick); // Renders everything
				} catch (NoStateException e) {
					e.printStackTrace();
				}
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				tick = ticks;
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}


	public synchronized void start() {

		instance = this;

		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() { return mouseManager; }

	public static Game getInstance() { return instance; }

	public boolean inDevMode() { return devMode; }
}
