package dev.runnergame.strategy;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;

public class Run implements IMoveStrategy {

	@Override
	public void move(Player player) {
		// Gali begti i sonus ir pasokti

		SingletonController controller = SingletonController.getInstance("ColorRunner", 640, 360);
		
		player.setxMove(0);
		player.setyMove(0);
		
		if(controller.getKeyManager().left) {
			player.setxMove(-player.getSpeed());
		}
		if(controller.getKeyManager().right) {
			player.setxMove(player.getSpeed());
		}
		if(controller.getKeyManager().up && !player.isJumping) {
			player.speedY = -2;
			player.jumpY = (int) player.getY() - 50;
			player.isJumping = true;
		}
	}

}
