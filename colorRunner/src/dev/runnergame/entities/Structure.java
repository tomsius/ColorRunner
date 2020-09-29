package dev.runnergame.entities;

import java.awt.Graphics;

public abstract class Structure extends Entity {

  public static final int DEFAULT_STRUCTURE_WIDTH = 100;
  public static final int DEFAULT_STRUCTURE_HEIGHT = 10;

  public Structure(float x, float y){
    super(x, y, DEFAULT_STRUCTURE_WIDTH, DEFAULT_STRUCTURE_HEIGHT);
  }

  public Structure(float x, float y, int width, int height){
    super(x, y, width, height);
  }

  public abstract void update();
  public abstract void render(Graphics g);
  public abstract void modifySpeed();

}
