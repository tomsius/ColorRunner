package dev.runnergame.abstractFactory;

import dev.runnergame.entities.DisappearingPlatform;
import dev.runnergame.entities.StandardPlatform;
import dev.runnergame.entities.Structure;

public class PlatformCreator extends AbstractStructureFactory {

  @Override
  public Structure getStructure(String structureType, float x, float y, int width, int height) {
    if (structureType.equalsIgnoreCase("standard")) {
      return new StandardPlatform(x, y, width, height);
    } else if (structureType.equalsIgnoreCase("disappearing")) {
      return new DisappearingPlatform(x, y, width, height);
    }
    return null;
  }
}
