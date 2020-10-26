package dev.runnergame;

import dev.runnergame.Decorator.SlowingStructureDecorator;
import dev.runnergame.abstractFactory.AbstractStructureFactory;
import dev.runnergame.abstractFactory.StructureFactoryProducer;
import dev.runnergame.bridge.Stone;
import dev.runnergame.bridge.Wood;
import dev.runnergame.display.GameCamera;
import dev.runnergame.entities.*;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import dev.runnergame.display.Display;
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
	private EffectCreator effectFactory;
	private List<Effect> effectList;

	private PlatformAccelerationEffect platformAccelerationEffect1;
	private PlatformAccelerationEffect platformAccelerationEffect2;

	//Structure abstract factory
	private AbstractStructureFactory platformFactory;
	private AbstractStructureFactory obstacleFactory;

	private List<Structure> allStructures;

	public String title;
	private int width, height;

	// States
	private State gameState;
	private State menuState;

	// Input
	private KeyManager keyManager;

	//Camera
	private GameCamera gameCamera;

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

		effectFactory = new EffectCreator();
		allStructures = new ArrayList<Structure>();

		//positive = effectFactory.createEffect("positive", 10, 10);
		//negative = effectFactory.createEffect("negative", 100, 100);

		platformAccelerationEffect1 = new PlatformAccelerationEffect(200,200);
		platformAccelerationEffect2 = new PlatformAccelerationEffect(500,200);

		platformFactory = StructureFactoryProducer.getPlatform();
		obstacleFactory = StructureFactoryProducer.getObstacle();
//		allStructures.add(obstacleFactory.getStructure("standard", 290, 200));
//		allStructures.add(obstacleFactory.getStructure("disappearing", 390, 200));
//		allStructures.add(platformFactory.getStructure("standard", 300, 300));
//		allStructures.add(platformFactory.getStructure("disappearing", 200, 300));
		allStructures.add(new SlowingStructureDecorator(obstacleFactory.getStructure("standard", 250, 100),new Stone()));
		allStructures.add(new SlowingStructureDecorator(platformFactory.getStructure("standard",300, 100), new Stone()));
		allStructures.add(new AccelerationPlatform(10,10,50 ,10, new Stone(),platformAccelerationEffect1));
		allStructures.add(new AccelerationPlatform(70,10,50 ,10, new Stone(),platformAccelerationEffect1));
		allStructures.add(new AccelerationPlatform(130,10,50 ,10, new Stone(),platformAccelerationEffect1));
		allStructures.add(new AccelerationPlatform(190,10,50 ,10, new Wood(),platformAccelerationEffect1));
		allStructures.add(new AccelerationPlatform(250,30,50 ,10, new Wood(),platformAccelerationEffect2));
		allStructures.add(new AccelerationPlatform(290,30,50 ,10, new Wood(),platformAccelerationEffect2));

		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);

		gameCamera = new GameCamera(0);

		gameState = new GameState(socket);
		menuState = new MenuState();
		State.setState(gameState);

		effectList = gameState.getLevel().getLevelEffects();

		new Thread(serverConn).start();
	}

	private void update() {
		keyManager.update();

		if(State.getState() != null) {
			State.getState().update();
			Player player = gameState.getPlayer();
			platformAccelerationEffect1.checkCollision(player);
			platformAccelerationEffect2.checkCollision(player);
			for (Structure structure : allStructures) {
				structure.checkCollision(player);
			}

			for (int i = 0; i < effectList.size(); i++) {
				if (effectList.get(i).checkCollision(player, i)) {
					effectList.remove(i);
					i--;
				}
			}

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
		

		//.render(g);
		//negative.render(g);
		platformAccelerationEffect1.render(g, (int) (platformAccelerationEffect1.getX() - gameCamera.getxOffset()));
		platformAccelerationEffect2.render(g, (int) (platformAccelerationEffect2.getX() - gameCamera.getxOffset()));
		for (Structure structure : allStructures) {
			structure.render(g, (int) (structure.getX()-gameCamera.getxOffset()));
		}

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

	public GameCamera getGameCamera() { return gameCamera; }

	public int getWidth() { return width; }

	public int getHeight() { return height; }

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

	public EffectCreator getEffectFactory() {
		return effectFactory;
	}

	public AbstractStructureFactory getPlatformFactory() {
		return platformFactory;
	}

	public AbstractStructureFactory getObstacleFactory() {
		return obstacleFactory;
	}
}
