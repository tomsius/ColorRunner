package dev.runnergame.states;

import java.awt.Graphics;

import dev.runnergame.Controller;

public abstract class State {
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Controller controller;
	
	public State(Controller controller) {
		this.controller = controller;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}
