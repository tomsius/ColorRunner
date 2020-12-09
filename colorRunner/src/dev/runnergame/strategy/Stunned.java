package dev.runnergame.strategy;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;
import dev.runnergame.memento.StrategyMemento;
import dev.runnergame.stunstate.StateContext;

public class Stunned implements IMoveStrategy {
	public Stunned(){
		context = new StateContext();
	}
	StateContext context;
	@Override
	public void move(Player player) {
		context.move(player);
	}

	@Override
	public StrategyMemento saveStateToMemento() {
		return new StrategyMemento("Stunned");
	}

}
