package dev.runnergame.abstractFactory;

import dev.runnergame.entities.DisappearingPlatform;
import dev.runnergame.entities.StandardPlatform;
import dev.runnergame.entities.Structure;

public class PlatformCreator extends AbstractStructureFactory {

  public final int DEFAULT_PLATFORM_WIDTH = 100;
  public final int DEFAULT_PLATFORM_HEIGHT = 10;

  @Override
  public Structure getStructure(String structureType, float x, float y) {
    if (structureType.equalsIgnoreCase("standard")) {
      return new StandardPlatform(x, y, DEFAULT_PLATFORM_WIDTH, DEFAULT_PLATFORM_HEIGHT);
    } else if (structureType.equalsIgnoreCase("disappearing")) {
      return new DisappearingPlatform(x, y, DEFAULT_PLATFORM_WIDTH, DEFAULT_PLATFORM_HEIGHT);
    }
    return null;
  }
}
