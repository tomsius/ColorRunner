package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import dev.runnergame.SingletonController;

public class Player extends Entity {
	public static final float DEFAULT_SPEED = 3.0f;
	
	private SingletonController controller;
	private PrintWriter out;
	private float enemyX = 0.0f, enemyY = 0.0f;
	private int enemyWidth = 0, enemyHeight = 0;
	private float speed;
	
	public Player(SingletonController controller, float x, float y, Socket socket) throws IOException {
		super(x, y, Entity.DEFAULT_ENTITY_WIDTH, Entity.DEFAULT_ENTITY_HEIGHT);
		this.controller = controller; // pakeisti i singleton
		speed = DEFAULT_SPEED;
		out = new PrintWriter(socket.getOutputStream(), true);
	}

	@Override
	public void update() {
		getInput();
		move();
		
		out.println("coordinates " + x + " " + y + " " + width + " " + height);
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(controller.getKeyManager().up) {
			yMove = -speed;
		}
		if(controller.getKeyManager().down) {
			yMove = speed;
		}
		if(controller.getKeyManager().left) {
			xMove = -speed;
		}
		if(controller.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int) x, (int) y, width, height);
		
		g.setColor(Color.red);
		g.fillRect((int) enemyX, (int) enemyY, enemyWidth, enemyHeight);
	}
	
	public void updateEnemy(float x, float y, int width, int height) {
		this.enemyX = x;
		this.enemyY = y;
		this.enemyWidth = width;
		this.enemyHeight = height;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
