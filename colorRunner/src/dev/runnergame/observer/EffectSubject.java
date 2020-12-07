package dev.runnergame.observer;

import dev.runnergame.entities.AccelerationPlatform;
import dev.runnergame.entities.Effect;
import dev.runnergame.iterator.PlatformObserverList;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class EffectSubject extends Effect {
    private PlatformObserverList observers = new PlatformObserverList();
    public EffectSubject(float x, float y) {
        super(x, y);
    }

    public void attach(PlatformObserver observer){ observers.addObserver(observer); }
    public void detach(PlatformObserver observer){
        observers.removeObserver(observer);
    }
    public void notifyAllObservers(){
       // ReentrantLock lock = new ReentrantLock();
       // lock.lock();
        System.out.println("Observer notified all");
      /* for(Object obs : observers){
            PlatformObserver observer = (PlatformObserver) obs;
            observer.updateObserver();
            System.out.println("Observer notified 1");
        }*/
      // lock.unlock();

        Iterator iter = observers.getIterator();
        while(iter.hasNext()) {
            PlatformObserver obs = (PlatformObserver) iter.next();
            obs.updateObserver();
            System.out.println("Observer notified iter");
        }
    }
}
