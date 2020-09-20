package dev.runnergame.states;

import java.awt.Graphics;

import dev.runnergame.Controller;
import dev.runnergame.entities.Player;

public class GameState extends State {
	private Player player;
	
	public GameState(Controller controller) {
		super(controller);
		player = new Player(controller, 100, 100);
	}
	
	@Override
	public void update() {
		player.update();
	}
	
	@Override
	public void render(Graphics g) {
		player.render(g);
	}
}
