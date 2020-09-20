package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.runnergame.Controller;

public class Player extends Entity {
	private Controller controller;
	
	public Player(Controller controller, float x, float y) {
		super(x, y);
		this.controller = controller;
	}

	@Override
	public void update() {
		if(controller.getKeyManager().up) {
			y -= 3;
		}
		if(controller.getKeyManager().down) {
			y += 3;
		}
		if(controller.getKeyManager().left) {
			x -= 3;
		}
		if(controller.getKeyManager().right) {
			x += 3;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 20, 35);
	}
}
