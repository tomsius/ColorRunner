package dev.runnergame.mediator;

import dev.runnergame.entities.Entity;

enum CreatureType {
    Red,
    DarkRed,
    Orange
}

public abstract class Creature extends Entity {
    protected IMediator mediator;
    protected Boolean isDestroyed;

    public Creature(float x, float y, int width, int height, IMediator mediator) {
        super(x, y, width, height);
        this.mediator = mediator;
        isDestroyed = false;
    }
    public abstract CreatureType getType();
    public abstract void destroy();
}
