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
	
	int x;
	
	private void update() {
		x += 1;
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
		g.fillRect(x, 50, 50, 70);

		// piesti iki cia
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		// inicializacija
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;	// 1 s = 1b ns
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		//long timer = 0;
		//int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			//timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				// atnaujinti kintamuosius, pozicijas, objektus, busenas ir t.t.
				update();
				
				// viska nupiesti
				render();
				
				//ticks++;
				delta--;
			}
/*			
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}*/
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
