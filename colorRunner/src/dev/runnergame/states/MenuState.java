package dev.runnergame.states;

import java.awt.Graphics;
import java.io.IOException;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;
import dev.runnergame.levels.GameLevel;

public class MenuState extends State {
	public MenuState() {
		super();
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameLevel getLevel() {
		return null;
	}

	@Override
	public void setPlayerStrategy(String strategy) throws IOException {

	}

}
