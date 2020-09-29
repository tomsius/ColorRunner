package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class DisappearingObstacle extends Obstacle {

  public DisappearingObstacle(float x, float y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void update() {

  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.YELLOW);
    g.fillRect((int) x, (int) y, width, height);
  }

  @Override
  public void modifySpeed() {

  }
}
