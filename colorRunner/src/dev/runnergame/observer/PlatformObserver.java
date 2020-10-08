package dev.runnergame.observer;

import dev.runnergame.entities.Platform;

import java.awt.*;

public abstract class PlatformObserver extends Platform {
    protected EffectSubject subject;

    public PlatformObserver(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public abstract void updateObserver();
}
