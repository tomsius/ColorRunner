package dev.runnergame.observer;

import dev.runnergame.bridge.IStructureType;
import dev.runnergame.entities.Platform;

import java.awt.*;

public abstract class PlatformObserver extends Platform {
    protected EffectSubject subject;

    public PlatformObserver(float x, float y, int width, int height, IStructureType type) {
        super(x, y, width, height, type);
    }

    public abstract void updateObserver();
}
