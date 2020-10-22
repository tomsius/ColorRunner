package dev.runnergame.display;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Entity;

public class GameCamera {
    private SingletonController controller;
    private float xOffset;

    public GameCamera(float xOffset) {
        this.controller = SingletonController.getInstance("ColorRunner", 640, 360);
        this.xOffset = xOffset;
    }

    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - controller.getWidth() / 2 + e.getWidth() / 2;
    }

    public void move(float xAmount) {
        this.xOffset += xAmount;
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }
}
