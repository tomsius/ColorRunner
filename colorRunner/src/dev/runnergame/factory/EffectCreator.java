package dev.runnergame.factory;

import dev.runnergame.entities.Effect;
import dev.runnergame.entities.FlyEffect;
import dev.runnergame.entities.SlideEffect;
import dev.runnergame.entities.StunEffect;

public class EffectCreator {
	public Effect createEffect(String effect, float x, float y) {
		Effect result = null;

		switch(effect) {
		case "slide":
			result = new SlideEffect(x, y);
			break;
		case "fly":
			result = new FlyEffect(x, y);
			break;
		case "stun":
			result = new StunEffect(x, y);
			break;
		default:
			break;
		}

		return result;
	}
}
