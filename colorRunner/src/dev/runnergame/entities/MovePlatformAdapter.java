package dev.runnergame.entities;
import dev.runnergame.strategy.*;
import java.awt.Graphics;

public class MovePlatformAdapter implements IMoveStrategy{
	AccelerationPlatform accPlat;
	public MovePlatformAdapter(AccelerationPlatform accelerationPlatform) {
		this.accPlat = accelerationPlatform;
	}

	@Override
	public void move(Player player) {
		accPlat.onCollision(player);
	}
}
