package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import dev.runnergame.Controller;

public class Player extends Entity {
	private Controller controller;
	private PrintWriter out;
	private float enemyX = 0.0f, enemyY = 0.0f;
	
	public Player(Controller controller, float x, float y, Socket socket) throws IOException {
		super(x, y);
		this.controller = controller;
		out = new PrintWriter(socket.getOutputStream(), true);
	}

	@Override
	public void update() {
		if(controller.getKeyManager().up) {
			y -= 3;
		}
		if(controller.getKeyManager().down) {
			y += 3;
		}
		if(controller.getKeyManager().left) {
			x -= 3;
		}
		if(controller.getKeyManager().right) {
			x += 3;
		}
		
		out.println("coordinates " + x + " " + y);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int) x, (int) y, 20, 35);
		
		g.setColor(Color.red);
		g.fillRect((int) enemyX, (int) enemyY, 20, 35);
	}
	
	public void updateEnemy(float x, float y) {
		this.enemyX = x;
		this.enemyY = y;
	}
}
