package dev.runnergame.states;

import java.awt.Graphics;
import java.io.IOException;
import java.net.Socket;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;
import dev.runnergame.levels.GameLevel;

public class GameState extends State {
	private Player player;
	private GameLevel level;
	
	public GameState(Socket socket) throws IOException {
		super();
		player = new Player(controller, 100, 100, socket);
		level = new GameLevel("res/levels/level1.txt");
	}
	
	@Override
	public void update() {
		level.update();
		player.update();
	}
	
	@Override
	public void render(Graphics g) {
		level.render(g);;
		player.render(g);
	}
	
	public Player getPlayer() {
		return player;
	}
}
