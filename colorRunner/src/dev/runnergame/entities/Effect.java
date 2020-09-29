package dev.runnergame.entities;

import java.awt.Graphics;

public abstract class Effect extends Entity {
	public static final int DEFAULT_EFFECT_WIDTH = 10,
							DEFAULT_EFFECT_HEIGHT = 10;
	
	public Effect(float x, float y, int width, int height) {
		super(x, y, width, height);
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract void modifySpeed();
	
}
