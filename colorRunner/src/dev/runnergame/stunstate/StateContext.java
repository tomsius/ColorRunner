package dev.runnergame.stunstate;

import dev.runnergame.entities.Player;

public class StateContext {
    private StunnedState state;

    public StateContext() {
        state = new NoMoveStunnedState();
        System.out.println("changed to newone");
    }

    void setState(StunnedState newState) {
        state = newState;
    }

    public void move(Player player) {
        state.move(this, player);
    }
}
