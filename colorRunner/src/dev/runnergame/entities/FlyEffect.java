package dev.runnergame.entities;

import dev.runnergame.states.State;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class FlyEffect extends Effect {

	public FlyEffect(float x, float y) {
		super(x, y);
	}

	@Override
	public void update() {
	
	}

	@Override
	public void render(Graphics g, int newX) {
		g.setColor(Color.ORANGE);
		g.fillRect((int) newX, (int) y, width, height);
	}

	@Override
	public void onCollision(Player p) {
		System.out.println("FLY");
		try {
			State.getState().setPlayerStrategy("fly");
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Timer().schedule(
				new TimerTask() {
					@Override
					public void run() {
						try {
							State.getState().setPlayerStrategy("run");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				},
				5000
		);
	}

	@Override
	public void modifySpeed() {

	}

	@Override
	public void displayScore() {
		System.out.println("Fly effect: " + score);
	}

	@Override
	public void increaseScore() {
		score++;
	}

	@Override
	public int getScore() {
		return score;
	}
}
