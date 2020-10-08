package dev.runnergame.entities;

import java.awt.*;

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
	public abstract void onCollision(Player p);
	
	public void move() {
		x += xMove;
		y += yMove;
	}
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, width, height);
	}

	public void checkCollision(Player player){
		Rectangle structureBounds = this.getBounds();
		Rectangle playerBounds = player.getBounds();
		if(structureBounds.intersects(playerBounds)){
			onCollision(player);
		}
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

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
}
