package dev.runnergame.entities;

import dev.runnergame.bridge.IStructureType;

import java.awt.*;

public abstract class Structure extends Entity {

  public static final int DEFAULT_STRUCTURE_WIDTH = 100;
  public static final int DEFAULT_STRUCTURE_HEIGHT = 10;
  public float DEFAULT_SPEED = 1.0f;
  protected IStructureType type;

  public Structure(float x, float y, IStructureType type){
    super(x, y, DEFAULT_STRUCTURE_WIDTH, DEFAULT_STRUCTURE_HEIGHT);
    this.type = type;
  }

  public Structure(float x, float y, int width, int height, IStructureType type){
    super(x, y, width, height);
    this.type = type;
  }
  
  public Structure(float x, float y) {
	  super(x, y);
  }

  public abstract void update();
  public abstract void render(Graphics g, int newX);
  public abstract void modifySpeed();

  public IStructureType getType(){
    return  this.type;
  }
  
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
