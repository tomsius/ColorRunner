package dev.runnergame.Decorator;

import dev.runnergame.entities.Player;
import dev.runnergame.entities.Structure;

import java.awt.*;

public class SlowingStructureDecorator extends StructureDecorator {

    public SlowingStructureDecorator(Structure decoratedStructure) {
        super(decoratedStructure.getX(), decoratedStructure.getY(), decoratedStructure.getWidth(), decoratedStructure.getHeight(), decoratedStructure);
    }

    @Override
    public void update() {
        decoratedStructure.update();
    }

    @Override
    public void render(Graphics g, int newX) {
        decoratedStructure.render(g, newX);
    }

    @Override
    public void onCollision(Player p) {
        decoratedStructure.onCollision(p);
        p.setSpeed(Player.DEFAULT_SPEED - 1);

        System.out.println("Collided");
    }

    @Override
    public void modifySpeed() {
        decoratedStructure.modifySpeed();
    }
}
