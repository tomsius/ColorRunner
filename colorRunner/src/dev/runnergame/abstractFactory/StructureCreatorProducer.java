package dev.runnergame.abstractFactory;

public class StructureCreatorProducer {

  public static AbstractStructureCreator getFactory(boolean isPlatform) {
    if (isPlatform) {
      return new PlatformCreator();
    } else {
      return new ObstacleCreator();
    }
  }

}
