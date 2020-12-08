package dev.runnergame.entities;

import dev.runnergame.memento.StrategyCareTaker;
import dev.runnergame.states.State;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import dev.runnergame.SingletonController;
import dev.runnergame.strategy.*;

public class Player extends Entity {
	public static final float DEFAULT_SPEED = 3.0f;
	
	//private final SingletonController controller;
	private final PrintWriter out;
	private final float startX;
	private final float startY;
	private float enemyX = 0.0f, enemyY = 0.0f;
	private int enemyWidth = 0, enemyHeight = 0;
	private float speed;
	private IMoveStrategy movementStrategy;
	public  StrategyCareTaker careTaker;


	// jump
	public int speedY = 0;
	public int jumpY = 0;
	public boolean isJumping = false;
	
	public Player(PlayerBuilder playerBuilder) throws IOException {
		super(playerBuilder.startX, playerBuilder.startY, Entity.DEFAULT_ENTITY_WIDTH, Entity.DEFAULT_ENTITY_HEIGHT);
		this.startX = playerBuilder.startX;
		this.startY = playerBuilder.startY;
		//this.controller = playerBuilder.controller;
		this.speed = DEFAULT_SPEED;
		this.out = playerBuilder.out;
		careTaker = new StrategyCareTaker();
	}
	
	public static class PlayerBuilder {
		private SingletonController controller;
		private PrintWriter out;
		private float startX = 0;
		private float startY = 0;
		
		public PlayerBuilder setController() {
			this.controller = SingletonController.getInstance("ColorRunner", 640, 360);
			return this;
		}
		
		public PlayerBuilder setOutput(Socket socket) throws IOException {
			this.out = new PrintWriter(socket.getOutputStream(), true);
			return this;
		}
		
		public PlayerBuilder setX(float x) {
			this.startX = x;
			return this;
		}
		
		public PlayerBuilder setY(float y) {
			this.startY = y;
			return this;
		}
		
		public Player build() throws IOException {
			return new Player(this);
		}
	}

	@Override
	public void update() {
		getInput();
		move();
		controller.getGameCamera().centerOnEntity(this);

		if(getX() < 0) {
			setX(0);
		}
		if(getX() > 640) {
			setX(640);
			System.out.println("Laimejo / pakeisti apribojima Player.update() metode");
			controller.getScoreWindow().displayScore();
			controller.getFinalScore();
			careTaker.getAllMoves();
		}
		if(getY() < 0) {
			setY(0);
		}
		if(getY() > 300) {
			setY(300);
		}

		if(getY() < jumpY) {
			speedY = 2;
		}

		setY(getY() + speedY);

		if(speedY == 2 && getY() == 300) {
			speedY = 0;
			isJumping = false;
		}
		
		out.println("coordinates " + x + " " + y + " " + width + " " + height);
	}
	
	private void getInput() {
		movementStrategy.move(this);
	}

	@Override
	public void render(Graphics g, int newX) {
		g.setColor(Color.green);
		g.fillRect((int) (x - controller.getGameCamera().getxOffset()), (int) y, width, height);
		
		g.setColor(Color.red);
		g.fillRect((int) (enemyX - controller.getGameCamera().getxOffset()), (int) enemyY, enemyWidth, enemyHeight);
	}

	@Override
	public void onCollision(Player p) {

	}

	public void updateEnemy(float x, float y, int width, int height) {
		this.enemyX = x;
		this.enemyY = y;
		this.enemyWidth = width;
		this.enemyHeight = height;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void setMovementStrategy(IMoveStrategy movementStrategy) {
		this.movementStrategy = movementStrategy;
		careTaker.add(movementStrategy.saveStateToMemento());
	}
}
