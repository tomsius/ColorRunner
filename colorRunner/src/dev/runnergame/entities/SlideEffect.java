package dev.runnergame.entities;

import dev.runnergame.states.State;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class SlideEffect extends Effect {

	public SlideEffect(float x, float y) {
		super(x, y);
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g, int newX) {
		g.setColor(Color.CYAN);
		g.fillRect((int) newX, (int) y, width, height);
	}

	@Override
	public void onCollision(Player p) {
		System.out.println("SLIDE");
		try {
			State.getState().setPlayerStrategy("slide");
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
		System.out.println("Slide effect: " + score);
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
