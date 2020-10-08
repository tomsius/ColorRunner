package dev.runnergame;

import dev.runnergame.abstractFactory.AbstractStructureFactory;
import dev.runnergame.abstractFactory.StructureFactoryProducer;
import dev.runnergame.entities.AccelerationPlatform;
import dev.runnergame.entities.PlatformAccelerationEffect;
import dev.runnergame.entities.Structure;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import dev.runnergame.display.Display;
import dev.runnergame.entities.Effect;
import dev.runnergame.factory.EffectCreator;
import dev.runnergame.input.KeyManager;
import dev.runnergame.states.GameState;
import dev.runnergame.states.MenuState;
import dev.runnergame.states.State;
import dev.runnergame.client.ServerConnection;

public class SingletonController implements Runnable {
	private volatile static SingletonController controller;

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9090;
	private Socket socket;
	ServerConnection serverConn;

	private Display display;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;

	//Effect factory
	private EffectCreator factory;
	private Effect positive;
	private Effect negative;
	private PlatformAccelerationEffect platformAccelerationEffect1;
	private PlatformAccelerationEffect platformAccelerationEffect2;

	//Structure abstract factory
	private AbstractStructureFactory platformFactory;
	private AbstractStructureFactory obstacleFactory;
	private Structure standardObstacle;
	private Structure disappearingObstacle;
	private Structure standardPlatform;
	private Structure disappearingPlatform;
	private AccelerationPlatform accPlatform1;
	private AccelerationPlatform accPlatform2;
	private AccelerationPlatform accPlatform3;
	private AccelerationPlatform acc4;
	private AccelerationPlatform acc5;
	private AccelerationPlatform acc6;


	public String title;
	public int width, height;

	// States
	private State gameState;
	private State menuState;

	// Input
	private KeyManager keyManager;

	private SingletonController(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}

	public static synchronized SingletonController getInstance(String title, int width, int height) {
		if(controller == null) {
			controller = new SingletonController(title, width, height);
		}

		return controller;
	}

	private void init() throws UnknownHostException, IOException {
		socket = new Socket(SERVER_IP, SERVER_PORT);
		serverConn = new ServerConnection(socket);

		factory = new EffectCreator();
		positive = factory.createEffect("positive", 10, 10);
		negative = factory.createEffect("negative", 100, 100);
		platformAccelerationEffect1 = new PlatformAccelerationEffect(200,200);
		platformAccelerationEffect2 = new PlatformAccelerationEffect(500,200);


		platformFactory = StructureFactoryProducer.getPlatform();
		obstacleFactory = StructureFactoryProducer.getObstacle();
		standardObstacle = obstacleFactory.getStructure("standard", 290, 200);
		disappearingObstacle = obstacleFactory.getStructure("disappearing", 390, 200);
		standardPlatform = platformFactory.getStructure("standard", 300, 300);
		disappearingPlatform = platformFactory.getStructure("disappearing", 200, 300);
		accPlatform1 = new AccelerationPlatform(10,10,50 ,10,platformAccelerationEffect1);
		accPlatform2 = new AccelerationPlatform(70,10,50 ,10,platformAccelerationEffect1);
		accPlatform3 = new AccelerationPlatform(130,10,50 ,10,platformAccelerationEffect1);
		acc4 = new AccelerationPlatform(190,10,50 ,10,platformAccelerationEffect1);
		acc5 = new AccelerationPlatform(250,30,50 ,10,platformAccelerationEffect2);
		acc6 = new AccelerationPlatform(290,30,50 ,10,platformAccelerationEffect2);



		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		gameState = new GameState(socket);
		menuState = new MenuState();
		State.setState(gameState);

		new Thread(serverConn).start();
	}

	private void update() {
		keyManager.update();

		if(State.getState() != null) {
			State.getState().update();
			platformAccelerationEffect1.onCollision(gameState.getPlayer());
			platformAccelerationEffect2.onCollision(gameState.getPlayer());
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		// isvalyti langa
		g.clearRect(0, 0, width, height);

		if(State.getState() != null) {
			State.getState().render(g);
		}

		positive.render(g);
		negative.render(g);
		platformAccelerationEffect1.render(g);
		platformAccelerationEffect2.render(g);

		standardObstacle.render(g);
		disappearingObstacle.render(g);
		standardPlatform.render(g);
		disappearingPlatform.render(g);
		accPlatform1.render(g);
		accPlatform2.render(g);
		accPlatform3.render(g);
		acc4.render(g);
		acc5.render(g);
		acc6.render(g);

		bs.show();
		g.dispose();
	}

	public void run() {
		// inicializacija
		try {
			init();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int fps = 60;
		double timePerTick = 1000000000 / fps;	// 1 s = 1b ns
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if(delta >= 1) {
				// atnaujinti kintamuosius, pozicijas, objektus, busenas ir t.t.
				update();

				// viska nupiesti
				render();

				//ticks++;
				delta--;
			}
		}

		// sustabdyti gija
		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public void drawOpponent(String x, String y, String width, String height) {
		gameState.getPlayer().updateEnemy(Float.parseFloat(x), Float.parseFloat(y), Integer.parseInt(width), Integer.parseInt(height));
	}

	public synchronized void start() {
		if(running) {
			return;
		}

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if(!running) {
			return;
		}

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
