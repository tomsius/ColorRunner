package dev.runnergame.visitor;

import dev.runnergame.entities.AccelerationPlatform;
import dev.runnergame.entities.DisappearingPlatform;
import dev.runnergame.entities.Platform;
import dev.runnergame.entities.StandardPlatform;
import java.util.List;

public class EntityScore implements Visitor {

  @Override
  public double accelerationPlatformScore(AccelerationPlatform accelerationPlatform) {
    return 0.75;
  }

  @Override
  public double disappearingPlatformScore(DisappearingPlatform disappearingPlatform) {
    return 0.55;
  }

  @Override
  public double standardPlatformScore(StandardPlatform standardPlatform) {
    return 0.2;
  }

  public double getFinalScore(List<Platform> platforms){
    double finalScore = 0;
    for(Platform platform : platforms){
      finalScore += platform.accept(this);
    }
    return finalScore;
  }
}
