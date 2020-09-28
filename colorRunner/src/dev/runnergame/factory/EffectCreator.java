package dev.runnergame.factory;

import dev.runnergame.entities.Effect;
import dev.runnergame.entities.Negative;
import dev.runnergame.entities.Positive;

public class EffectCreator {
	public Effect createEffect(String effect, float x, float y) {
		Effect result = null;
		
		switch(effect) {
		case "positive":
			result = new Positive(x, y);
			break;
		case "negative":
			result = new Negative(x, y);
			break;
		}
		
		return result;
	}
}
