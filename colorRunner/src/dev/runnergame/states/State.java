package dev.runnergame.states;

import java.awt.Graphics;
import java.io.IOException;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;
import dev.runnergame.levels.GameLevel;

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
	public abstract GameLevel getLevel();
	public abstract void setPlayerStrategy(String strategy) throws IOException;
}
