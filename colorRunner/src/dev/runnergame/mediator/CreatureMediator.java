package dev.runnergame.mediator;

import java.util.ArrayList;

public class CreatureMediator implements IMediator {
    ArrayList<Creature> list = new ArrayList<Creature>();

    @Override
    public void addCreature(Creature creature) {
        list.add(creature);
    }

    @Override
    public void destroyOther(CreatureType creatureType) {
        for(Creature creature : list){
            if(creature.getType() == creatureType ){
                creature.destroy();
            }
        }
    }
}
