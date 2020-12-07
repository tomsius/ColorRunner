package dev.runnergame.mediator;

import dev.runnergame.entities.Player;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class DarkRedCreature extends Creature {

    public DarkRedCreature(float x, float y, int width, int height, IMediator mediator) {
        super(x, y, width, height, mediator);
    }

    @Override
    public CreatureType getType() {
        return CreatureType.DarkRed;
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
        if (!isDestroyed) {
            Color customColor = new Color(139, 0, 0);
            g.setColor(customColor);
            g.fillOval(newX, (int) y, width, height);
        }
    }

    @Override
    public void onCollision(Player p) {
        if (!isDestroyed) {
            p.setSpeed(Player.DEFAULT_SPEED - 2.8f);
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
