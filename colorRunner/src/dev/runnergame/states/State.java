package dev.runnergame.states;

import java.awt.Graphics;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;

public abstract class State {
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected SingletonController controller;
	
	public State(SingletonController controller) {
		this.controller = controller;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract Player getPlayer();
}
