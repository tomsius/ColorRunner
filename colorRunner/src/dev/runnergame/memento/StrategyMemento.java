package dev.runnergame.memento;

public class StrategyMemento {
    private String state;

    public StrategyMemento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
