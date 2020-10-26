package dev.runnergame.Decorator;

import dev.runnergame.bridge.IStructureType;
import dev.runnergame.entities.Structure;

public abstract class StructureDecorator extends Structure {
    protected Structure decoratedStructure;
    public StructureDecorator(float x, float y, int width, int height, IStructureType type, Structure decoratedStructure) {
        super(x, y, width, height, type);
        this.decoratedStructure = decoratedStructure;
    }
}
