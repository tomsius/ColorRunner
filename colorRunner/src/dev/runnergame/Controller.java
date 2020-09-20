package dev.runnergame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.runnergame.display.Display;

public class Controller implements Runnable {
	private Display display;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	
	public String title;
	public int width, height;
	
	public Controller(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	private void init() {
		display = new Display(title, width, height);
	}
	
	private void update() {
		
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
		
		// piesti nuo cia => (0;0) yra virsuje kaireje
		g.setColor(Color.red);
		g.fillRect(10, 50, 50, 70);
		g.setColor(Color.green);
		g.fillRect(0, 0, 10, 10);
		// piesti iki cia
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		// inicializacija
		init();
		
		while(running) {
			// atnaujinti kintamuosius, pozicijas, objektus, busenas ir t.t.
			update();
			
			// viska nupiesti
			render();
		}
		
		// sustabdyti gija
		stop();
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
