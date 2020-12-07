package dev.runnergame.mediator;

import dev.runnergame.entities.Player;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class RedCreature extends Creature {
    public RedCreature(float x, float y, int width, int height, IMediator mediator) {
        super(x, y, width, height, mediator);
    }

    @Override
    public CreatureType getType() {
        return CreatureType.Red;
    }

    @Override
    public void destroy() {
        isDestroyed = true;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g, int newX) {
        if(!isDestroyed){
            g.setColor(Color.RED);
            g.fillOval(newX, (int) y, width, height);
        }
    }

    @Override
    public void onCollision(Player p) {
        if(!isDestroyed) {
            p.setSpeed(Player.DEFAULT_SPEED - 2f);
            mediator.destroyOther(getType());
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            p.setSpeed(Player.DEFAULT_SPEED);
                        }
                    },
                    3000
            );
        }
    }
}
