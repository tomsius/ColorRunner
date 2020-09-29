package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Positive extends Effect {

	public Positive(float x, float y) {
		super(x, y, Effect.DEFAULT_EFFECT_WIDTH, Effect.DEFAULT_EFFECT_HEIGHT);
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int) x, (int) y, width, height);
	}

	@Override
	public void modifySpeed() {

	}
}
