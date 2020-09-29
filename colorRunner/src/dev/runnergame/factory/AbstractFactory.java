package dev.runnergame.factory;

public class AbstractFactory {
  public static AbstractFactory getFactory(String choice){
        
//    if(choice.equalsIgnoreCase("Effect")){
//        return new EffectCreator();
//    }
    if(choice.equalsIgnoreCase("Platform")){
        return new PlatformCreator();
    }
    
    return null;
}
}
