package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Positive extends Effect {

	public Positive(float x, float y) {
		super(x, y);
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
	public void onCollision(Player p) {

	}

	@Override
	public void modifySpeed() {

	}
}
