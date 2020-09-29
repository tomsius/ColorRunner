package dev.runnergame.abstractFactory;

import dev.runnergame.entities.Structure;

public abstract class AbstractStructureCreator {

  public abstract Structure getStructure(String structureType, float x, float y);
}
