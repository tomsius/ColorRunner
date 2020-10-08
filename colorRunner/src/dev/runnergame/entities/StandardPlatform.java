package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class StandardPlatform extends Platform {

  public StandardPlatform(float x, float y, int width, int height) {
    super(x, y, width, height);
    // TODO make platform moving or not
  }

  @Override
  public void update() {

  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.ORANGE);
    g.fillRect((int) x, (int) y, width, height);
  }

  @Override
  public void onCollision(Player p) {

  }

  @Override
  public void modifySpeed() {

  }

}
