package dev.runnergame.strategy;

import dev.runnergame.entities.Player;
import dev.runnergame.memento.StrategyMemento;

public interface IMoveStrategy {
	public void move(Player player);
	public StrategyMemento saveStateToMemento();
}
