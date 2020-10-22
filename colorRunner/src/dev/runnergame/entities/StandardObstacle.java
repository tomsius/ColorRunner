package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class StandardObstacle extends Obstacle {

  public StandardObstacle(float x, float y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void onCollision(Player p) {

  }

  @Override
  public void update() {
  }

  @Override
  public void render(Graphics g, int newX) {
    g.setColor(Color.BLUE);
    g.fillRect(newX, (int) y, width, height);
  }

  @Override
  public void modifySpeed() {

  }
}
