package dev.runnergame.bridge;

import java.awt.*;

public class Stone implements IStructureType{
    @Override
    public void fill(Graphics g) {
        g.setColor(Color.decode("#808080"));
    }
}
