package dev.runnergame.stunstate;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;
import dev.runnergame.states.State;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class LuckyStunnedState implements StunnedState{
    private int speedMultiplier = 5;
    @Override
    public void move(StateContext context, Player player) {
        SingletonController controller = SingletonController.getInstance("ColorRunner", 640, 360);

        player.setxMove(0);
        player.setyMove(0);

        if(controller.getKeyManager().up) {
            player.setyMove(-player.getSpeed() * speedMultiplier);
        }
        if(controller.getKeyManager().down) {
            player.setyMove(player.getSpeed() * speedMultiplier);
        }
        if(controller.getKeyManager().left) {
            player.setxMove(-player.getSpeed() * speedMultiplier);
        }
        if(controller.getKeyManager().right) {
            player.setxMove(player.getSpeed() * speedMultiplier);
        }
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        context.setState(new NoMoveStunnedState());
                        System.out.println("changed to nomove");
                    }
                },
                5000
        );

    }
}
