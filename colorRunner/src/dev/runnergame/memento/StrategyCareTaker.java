package dev.runnergame.memento;

import java.util.ArrayList;
import java.util.List;

public class StrategyCareTaker {
    private List<StrategyMemento> mementoList = new ArrayList<StrategyMemento>();

    public void add(StrategyMemento state){
        mementoList.add(state);
    }

    public StrategyMemento get(int index){
        return mementoList.get(index);
    }
    public StrategyMemento getLast(){
        if(mementoList.size() > 0) {
            return mementoList.get(mementoList.size() - 1);
        } else {
            return mementoList.get(0);
        }
    }

    public void getAllMoves(){
        System.out.println("Player move order:");
        for(int i = 0; i < mementoList.size(); i++){
            System.out.print(mementoList.get(i).getState() + " ");
        }

    }
}
