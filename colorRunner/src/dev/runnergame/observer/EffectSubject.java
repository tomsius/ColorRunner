package dev.runnergame.observer;

import dev.runnergame.entities.Effect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class EffectSubject extends Effect {
    private List<PlatformObserver> observers = new ArrayList<PlatformObserver>();

    public EffectSubject(float x, float y) {
        super(x, y);
    }

    public void attach(PlatformObserver observer){
        observers.add(observer);
    }
    public void detach(PlatformObserver observer){
        observers.remove(observer);
    }
    public void notifyAllObservers(){
        for (PlatformObserver observer : observers) {
            observer.updateObserver();
        }
    }
}
