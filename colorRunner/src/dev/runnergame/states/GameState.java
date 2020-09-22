package dev.runnergame.states;

import java.awt.Graphics;
import java.io.IOException;
import java.net.Socket;

import dev.runnergame.Controller;
import dev.runnergame.entities.Player;

public class GameState extends State {
	private Player player;
	
	public GameState(Controller controller, Socket socket) throws IOException {
		super(controller);
		player = new Player(controller, 100, 100, socket);
	}
	
	@Override
	public void update() {
		player.update();
	}
	
	@Override
	public void render(Graphics g) {
		player.render(g);
	}
	
	public Player getPlayer() {
		return player;
	}
}
