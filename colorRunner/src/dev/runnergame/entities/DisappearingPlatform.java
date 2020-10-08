package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class DisappearingPlatform extends Platform {

  public DisappearingPlatform(float x, float y, int width, int height) {
    super(x, y, width, height);
  }

    @Override
    public void onCollision(Player p) {
    }

    @Override
  public void update() {

  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.MAGENTA);
    g.fillRect((int) x, (int) y, width, height);
  }

  @Override
  public void modifySpeed() {

  }
}
