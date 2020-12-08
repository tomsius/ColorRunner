package dev.runnergame.iterator;

import dev.runnergame.observer.PlatformObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class PlatformObserverList implements Iterable {
    private PlatformObserver[] arrayList;
    private int currentSize;
    private ArrayList<PlatformObserver> myData;
    private ReentrantLock lock = new ReentrantLock();

    public PlatformObserverList(PlatformObserver[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
        this.myData = new ArrayList<>();
    }

    public PlatformObserverList(){
        this.myData = new ArrayList<>();
        this.arrayList = new PlatformObserver[100];
        this.currentSize = 0;

    }

    public void addObserver(PlatformObserver p){
        myData.add(p);
    }

    public void removeObserver(PlatformObserver p){
        myData.remove(p);
    }

    public ArrayList<PlatformObserver> getObservers(){
        return myData;
    }

    public Iterator<PlatformObserver> getIterator(){
        return iterator();
    }

    @Override
    public Iterator<PlatformObserver> iterator() {
        return new PlatformObserverIterator();
    }

    private class PlatformObserverIterator implements Iterator {
        private int position;

        public PlatformObserverIterator(){
            position = 0;
        }


        public boolean hasNext() {
            boolean result = false;
            try {
                result = false;
                if (position < myData.size()) {
                    result = true;
                }
            } finally {
                return result;
            }
        }

        public PlatformObserver next() {
            PlatformObserver result = null;
            try {
                if (this.hasNext()) {
                    System.out.println("Obs posit " + position);
                    result = myData.get(position);
                    position++;
                }
            } finally {
                return result;
            }
        }

            @Override
        public void remove() {

        }
    }
}
