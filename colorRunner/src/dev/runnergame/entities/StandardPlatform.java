package dev.runnergame.entities;

import dev.runnergame.bridge.IStructureType;

import java.awt.Color;
import java.awt.Graphics;

public class StandardPlatform extends Platform {

  public StandardPlatform(float x, float y, int width, int height, IStructureType type) {
    super(x, y, width, height, type);
    this.DEFAULT_SPEED = 1.2f;
    // TODO make platform moving or not
  }

  @Override
  public void update() {
    move();
  }

  @Override
  public void render(Graphics g, int newX) {
    this.type.fill(g);
    g.fillRect(newX, (int) y, width, height);

  }

  @Override
  public void onCollision(Player p) {

  }

  @Override
  public void modifySpeed() {

  }

}
