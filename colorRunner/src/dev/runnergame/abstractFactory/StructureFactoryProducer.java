package dev.runnergame.abstractFactory;

public class StructureFactoryProducer {

  public static AbstractStructureFactory getPlatform() {
      return new PlatformFactory();
  }

  public static AbstractStructureFactory getObstacle(){
    return new ObstacleFactory();
  }

}
