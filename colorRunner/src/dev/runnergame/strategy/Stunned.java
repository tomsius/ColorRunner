package dev.runnergame.strategy;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;
import dev.runnergame.memento.StrategyMemento;

public class Stunned implements IMoveStrategy {

	@Override
	public void move(Player player) {
		// Negali judeti
		player.setxMove(0);
		player.setyMove(0);
	}

	@Override
	public StrategyMemento saveStateToMemento() {
		return new StrategyMemento("Stunned");
	}

}
