package dev.runnergame.entities;

import dev.runnergame.flyweight.EffectColor;
import dev.runnergame.states.State;

import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class StunEffect extends Effect {

	public StunEffect(float x, float y, EffectColor ec) {
		super(x, y, ec);
	}

	@Override
	public void update() {
	
	}

	@Override
	public void render(Graphics g, int newX) {
		g.setColor(color.getColor());
		g.fillRect((int) newX, (int) y, width, height);
	}

	@Override
	public void onCollision(Player p) {
		System.out.println("STUNNED");
		try {
			State.getState().setPlayerStrategy("stun");
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
		System.out.println("Stun effect: " + score);
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
