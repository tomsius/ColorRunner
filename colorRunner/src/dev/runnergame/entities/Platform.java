package dev.runnergame.entities;

import dev.runnergame.bridge.IStructureType;
import dev.runnergame.visitor.Visitor;

public abstract class Platform extends Structure {

  public Platform(float x, float y, int width, int height, IStructureType type) {
    super(x, y, width, height, type);
  }

  public abstract double accept(Visitor visitor);
}
