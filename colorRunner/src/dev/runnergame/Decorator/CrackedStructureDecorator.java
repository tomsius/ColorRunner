package dev.runnergame.Decorator;

import dev.runnergame.bridge.IStructureType;
import dev.runnergame.entities.Player;
import dev.runnergame.entities.Structure;

import java.awt.*;

public class CrackedStructureDecorator extends StructureDecorator{
    public CrackedStructureDecorator(Structure decoratedStructure) {
        super(
                decoratedStructure.getX(),
                decoratedStructure.getY(),
                decoratedStructure.getWidth(),
                decoratedStructure.getHeight(),
                decoratedStructure.getType(),
                decoratedStructure
        );
    }

    @Override
    public void update() {
        decoratedStructure.update();
    }

    @Override
    public void render(Graphics g, int newX) {
        decoratedStructure.render(g,newX);
        g.setColor(Color.BLACK);
        g.drawLine((int)newX, (int)y, (int)newX + width, (int)y+ height);
    }

    @Override
    public void onCollision(Player p) {
        decoratedStructure.onCollision(p);
    }

    @Override
    public void modifySpeed() {
        decoratedStructure.modifySpeed();
    }
}
