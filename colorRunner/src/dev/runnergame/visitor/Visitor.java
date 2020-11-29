package dev.runnergame.visitor;

import dev.runnergame.entities.AccelerationPlatform;
import dev.runnergame.entities.DisappearingPlatform;
import dev.runnergame.entities.StandardPlatform;

public interface Visitor {

  double accelerationPlatformScore(AccelerationPlatform accelerationPlatform);
  double disappearingPlatformScore(DisappearingPlatform disappearingPlatform);
  double standardPlatformScore(StandardPlatform standardPlatform);
}
