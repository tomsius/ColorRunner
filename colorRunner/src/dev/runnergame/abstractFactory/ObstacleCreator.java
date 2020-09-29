package dev.runnergame.abstractFactory;

import dev.runnergame.entities.DisappearingObstacle;
import dev.runnergame.entities.StandardObstacle;
import dev.runnergame.entities.Structure;

public class ObstacleCreator extends AbstractStructureCreator {

  public final int DEFAULT_OBSTACLE_WIDTH = 10;
  public final int DEFAULT_OBSTACLE_HEIGHT = 100;

  @Override
  public Structure getStructure(String structureType, float x, float y) {
    if (structureType.equalsIgnoreCase("standard")) {
      return new StandardObstacle(x, y, DEFAULT_OBSTACLE_WIDTH, DEFAULT_OBSTACLE_HEIGHT);
    } else if (structureType.equalsIgnoreCase("disappearing")) {
      return new DisappearingObstacle(x, y, DEFAULT_OBSTACLE_WIDTH, DEFAULT_OBSTACLE_HEIGHT);
    }

    return null;
  }
}
