package dev.runnergame.entities;

import dev.runnergame.composite.Score;
import java.awt.Graphics;

public abstract class Effect extends Entity implements Score {

	public static final int DEFAULT_EFFECT_WIDTH = 10,
							DEFAULT_EFFECT_HEIGHT = 10;

	protected int score = 0;

	public Effect(float x, float y){
		super(x, y, DEFAULT_EFFECT_WIDTH, DEFAULT_EFFECT_HEIGHT);
	}

	public Effect(float x, float y, int width, int height) {
		super(x, y, width, height);
	}
	
	public abstract void update();
	public abstract void render(Graphics g, int newX);
	public abstract void modifySpeed();

}
