package dev.runnergame.mediator;

public interface IMediator {
    public void addCreature(Creature creature);
    public void destroyOther(CreatureType creatureType);
}
