package dev.runnergame.entities;

import dev.runnergame.states.State;

import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class StunEffect extends Effect {

	public StunEffect(float x, float y) {
		super(x, y);
	}

	@Override
	public void update() {
	
	}

	@Override
	public void render(Graphics g, int newX) {
		g.setColor(Color.RED);
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

}