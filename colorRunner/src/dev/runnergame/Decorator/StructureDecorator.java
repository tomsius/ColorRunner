package dev.runnergame.Decorator;

import dev.runnergame.entities.Structure;

public abstract class StructureDecorator extends Structure {
    protected Structure decoratedStructure;
    public StructureDecorator(float x, float y, int width, int height, Structure decoratedStructure) {
        super(x, y, width, height);
        this.decoratedStructure = decoratedStructure;
    }
}
