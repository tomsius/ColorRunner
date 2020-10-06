package dev.runnergame.strategy;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;

public class Fly implements IMoveStrategy {

	@Override
	public void move(Player player) {
		SingletonController controller = SingletonController.getInstance("ColorRunner", 640, 360);
		
		player.setxMove(0);
		player.setyMove(0);
		
		if(controller.getKeyManager().up) {
			player.setyMove(-player.getSpeed());
		}
		if(controller.getKeyManager().down) {
			player.setyMove(player.getSpeed());
		}
		if(controller.getKeyManager().left) {
			player.setxMove(-player.getSpeed());
		}
		if(controller.getKeyManager().right) {
			player.setxMove(player.getSpeed());
		}
	}

}
