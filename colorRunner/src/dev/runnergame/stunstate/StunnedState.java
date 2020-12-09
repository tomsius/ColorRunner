package dev.runnergame.stunstate;

import dev.runnergame.entities.Player;

public interface StunnedState {
    void move(StateContext context, Player player);
}
