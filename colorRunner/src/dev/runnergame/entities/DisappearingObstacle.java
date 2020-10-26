package dev.runnergame.entities;

import dev.runnergame.bridge.IStructureType;

import java.awt.Color;
import java.awt.Graphics;

public class DisappearingObstacle extends Obstacle {

  public DisappearingObstacle(float x, float y, int width, int height, IStructureType type) {
    super(x, y, width, height, type);
  }

  @Override
  public void onCollision(Player p) {
  }

  @Override
  public void update() {

  }

  @Override
  public void render(Graphics g, int newX) {
    this.type.fill(g);
    g.fillRect(newX, (int) y, width, height);
  }

  @Override
  public void modifySpeed() {

  }
}
