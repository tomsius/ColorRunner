package dev.runnergame.entities;

import dev.runnergame.bridge.IStructureType;

public abstract class Obstacle extends Structure {

  public Obstacle(float x, float y, int width, int height, IStructureType type) {
    super(x, y, width, height, type);
  }
}
