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
	
	public State() {
		this.controller = SingletonController.getInstance("ColorRunner", 640, 360);
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract Player getPlayer();
}
