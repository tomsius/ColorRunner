package dev.runnergame.entities;

import dev.runnergame.bridge.IStructureType;

import dev.runnergame.visitor.Visitor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DisappearingPlatform extends Platform {

  public DisappearingPlatform(float x, float y, int width, int height, IStructureType type) {
    super(x, y, width, height, type);
  }

  @Override
  public double accept(Visitor visitor) {
    return visitor.disappearingPlatformScore(this);
  }

  @Override
    public void onCollision(Player p) {
    }

    @Override
  public void update() {

  }

  @Override
  public void render(Graphics g, int newX) {
//    if(g instanceof Graphics2D)
//    {
//      Graphics2D g2 = (Graphics2D)g;
//      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//        RenderingHints.VALUE_ANTIALIAS_ON);
//
//      g2.drawString("This is gona be awesome",newX, (int) y);
//    }
    this.type.fill(g);
    g.fillRect(newX, (int) y, width, height);
  }

//  Hierarchical achievments

  @Override
  public void modifySpeed() {

  }
}
