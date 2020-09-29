package dev.runnergame.abstractFactory;

import dev.runnergame.entities.DisappearingObstacle;
import dev.runnergame.entities.StandardObstacle;
import dev.runnergame.entities.Structure;

public class ObstacleCreator extends AbstractStructureFactory {

  @Override
  public Structure getStructure(String structureType, float x, float y, int width, int height) {
    if (structureType.equalsIgnoreCase("standard")) {
      return new StandardObstacle(x, y, width, height);
    } else if (structureType.equalsIgnoreCase("disappearing")) {
      return new DisappearingObstacle(x, y, width, height);
    }

    return null;
  }
}
