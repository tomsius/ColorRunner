package dev.runnergame.factory;

import dev.runnergame.entities.Platform;

public class PlatformCreator extends AbstractFactory {
  public Platform createPlatform(String effect, float x, float y) {
    switch(effect) {
    case "moving":
			return new Platform(x, y, true);
			
		case "satic":
			return new Platform(x, y, false);
			
    }
		return null;
  }
}
