package dev.runnergame.abstractFactory;

public class StructureFactoryProducer {

  public static AbstractStructureFactory getFactory(boolean isPlatform) {
    if (isPlatform) {
      return new PlatformCreator();
    } else {
      return new ObstacleCreator();
    }
  }

}