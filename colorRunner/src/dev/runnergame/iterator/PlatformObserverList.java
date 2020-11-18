package dev.runnergame.iterator;

import dev.runnergame.observer.PlatformObserver;

import java.util.ArrayList;
import java.util.Iterator;

public class PlatformObserverList {
    public PlatformObserverList(){
        list = new ArrayList<PlatformObserver>();
    }

    private ArrayList<PlatformObserver> list;

    public void addObserver(PlatformObserver p){
        list.add(p);
    }

    public void removeObserver(PlatformObserver p){
        list.remove(p);
    }

    public ArrayList<PlatformObserver> getObservers(){
        return list;
    }

    public Iterator<PlatformObserver> getIterator(){
        return list.iterator();
    }
}
