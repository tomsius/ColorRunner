package dev.runnergame.states;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.FlyEffect;
import dev.runnergame.entities.SlideEffect;
import dev.runnergame.entities.StunEffect;
import dev.runnergame.facade.PlayerManagementFacade;
import dev.runnergame.proxy.IGameLevel;
import dev.runnergame.proxy.LazyGameLevelProxy;
import java.awt.Graphics;
import java.io.IOException;
import java.net.Socket;

import dev.runnergame.entities.Player;
import dev.runnergame.levels.GameLevel;
import dev.runnergame.strategy.*;
import dev.runnergame.template.GameWindowTemplate;

public class GameState extends State {

	private PlayerManagementFacade playerManagementFacade;
	private Player player;
	private IGameLevel level;
	private SingletonController controller;
	
	public GameState(Socket socket) throws IOException {
		super();
		this.controller = SingletonController.getInstance("ColorRunner", 640, 360);

		playerManagementFacade = new PlayerManagementFacade(controller, socket);
		//player = playerManagementFacade.flyingPlayer();
		player = playerManagementFacade.runningPlayer();
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		level = new LazyGameLevelProxy(System.getProperty("user.dir") + "/res/levels/level1.txt");
	}
	
	@Override
	public void update() {
		((LazyGameLevelProxy)level).update();
		player.update();
	}
	
	@Override
	public void render(Graphics g) {
		((LazyGameLevelProxy)level).render(g);;
		player.render(g, (int)player.getX());
	}
	
	public Player getPlayer() {
		return player;
	}

	public IGameLevel getLevel() {
		return (LazyGameLevelProxy)level;
	}

	public void setPlayerStrategy(String strategy) throws IOException {
		switch(strategy) {
			case "slide":
				player = playerManagementFacade.slidingPlayer();
				break;
			case "fly":
				player = playerManagementFacade.flyingPlayer();
				break;
			case "stun":
				player = playerManagementFacade.stunnedPlayer();
				break;
			case "run":
				player = playerManagementFacade.runningPlayer();
				break;
			default:
				break;
		}
	}
}
