package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Platform extends Entity{
  public static final int DEFAULT_PLATFORM_WIDTH = 10,
							DEFAULT_PLATFORM_HEIGHT = 10;
	
	public Platform(float x, float y, boolean isMoving) {
    super(x, y, Entity.DEFAULT_ENTITY_WIDTH, Entity.DEFAULT_ENTITY_HEIGHT);
    // TODO make platform moving or not
	}

	@Override
	public void update() {
	
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect((int) x, (int) y, width, height);
	}
  
}
