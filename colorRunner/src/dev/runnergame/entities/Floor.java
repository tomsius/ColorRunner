package dev.runnergame.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Floor {
    private float x, y;
    private int width, height;
    private Color color;

    public Floor(float x, float y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(this.color);
        g.fillRect((int) x, (int) y, width, height);
    }
}
