package dev.runnergame.entities;

import java.awt.Graphics;

public abstract class Entity {
	public static final int DEFAULT_ENTITY_WIDTH = 20,
							DEFAULT_ENTITY_HEIGHT = 35;
	
	protected float x, y;
	protected int width, height;
	protected float xMove, yMove;
	
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	
	public void move() {
		x += xMove;
		y += yMove;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
