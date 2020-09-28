package dev.runnergame.states;

import java.awt.Graphics;
import java.io.IOException;
import java.net.Socket;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;
import dev.runnergame.factory.EffectCreator;

public class GameState extends State {
	private Player player;
	
	public GameState(SingletonController controller, Socket socket) throws IOException {
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
