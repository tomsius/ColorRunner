package dev.runnergame.bridge;

import java.awt.*;

public class Wood implements IStructureType{
    @Override
    public void fill(Graphics g) {
        g.setColor(Color.decode("#654321"));
    }
}
