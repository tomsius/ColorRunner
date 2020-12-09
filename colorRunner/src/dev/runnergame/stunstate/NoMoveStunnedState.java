package dev.runnergame.stunstate;

import dev.runnergame.entities.Player;

public class NoMoveStunnedState implements StunnedState{
    private int counter = 0;
    @Override
    public void move(StateContext context, Player player) {
        // Negali judeti
        player.setxMove(0);
        player.setyMove(0);
        if (player.careTaker.get(1) == player.careTaker.getLast()) {
            context.setState(new LuckyStunnedState());
            System.out.println("changed to lucky");

        }
    }
}
