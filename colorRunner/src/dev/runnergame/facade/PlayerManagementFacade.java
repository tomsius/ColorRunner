package dev.runnergame.facade;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Entity;
import dev.runnergame.entities.Player;
import dev.runnergame.strategy.Fly;
import dev.runnergame.strategy.IMoveStrategy;
import dev.runnergame.strategy.Run;
import dev.runnergame.strategy.Slide;
import dev.runnergame.strategy.Stunned;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerManagementFacade {

  private Player player;
  //private SingletonController controller;
  //private PrintWriter out;
  Socket socket;

  // Strategijos
  private IMoveStrategy run = new Run();
  private IMoveStrategy fly = new Fly();
  private IMoveStrategy stunned = new Stunned();
  private IMoveStrategy slide = new Slide();

  public PlayerManagementFacade(SingletonController controller, Socket socket) throws IOException {
    //this.controller = SingletonController.getInstance("ColorRunner", 640, 360);
    //out = new PrintWriter(socket.getOutputStream(), true);
	this.socket = socket;
  }

  public Player flyingPlayer() throws IOException {
    player = new Player.Builder().setController().setX(100).setY(100).setOutput(socket).build();
    player.setMovementStrategy(fly);

	return player;
  }

  public Player runningPlayer() throws IOException {
    player = new Player.Builder().setController().setX(100).setY(100).setOutput(socket).build();
    player.setMovementStrategy(run);

    return player;
  }

  public Player stunnedPlayer() throws IOException {
    player = new Player.Builder().setController().setX(100).setY(100).setOutput(socket).build();
    player.setMovementStrategy(stunned);

    return player;
  }

  public Player slidingPlayer() throws IOException {
    player = new Player.Builder().setController().setX(100).setY(100).setOutput(socket).build();
    player.setMovementStrategy(slide);

    return player;
  }

}
