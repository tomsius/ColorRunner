package dev.runnergame.entities;

import java.awt.*;

public abstract class Structure extends Entity {

  public static final int DEFAULT_STRUCTURE_WIDTH = 100;
  public static final int DEFAULT_STRUCTURE_HEIGHT = 10;
  public float DEFAULT_SPEED = 1.0f;

  public Structure(float x, float y){
    super(x, y, DEFAULT_STRUCTURE_WIDTH, DEFAULT_STRUCTURE_HEIGHT);
  }

  public Structure(float x, float y, int width, int height){
    super(x, y, width, height);
  }

  public abstract void update();
  public abstract void render(Graphics g);
  public abstract void modifySpeed();

  public void moveRight(){
    this.setxMove(DEFAULT_SPEED);
  }

  public void moveLeft(){
    this.setxMove(-DEFAULT_SPEED);
  }

  public void moveUp(){
    this.setyMove(DEFAULT_SPEED);
  }

  public void moveDown(){
    this.setyMove(-DEFAULT_SPEED);
  }

}
