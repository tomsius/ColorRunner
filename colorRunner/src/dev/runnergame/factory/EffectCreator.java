package dev.runnergame.factory;

import dev.runnergame.entities.Effect;
import dev.runnergame.entities.FlyEffect;
import dev.runnergame.entities.SlideEffect;
import dev.runnergame.entities.StunEffect;
import dev.runnergame.flyweight.EffectColor;

import java.awt.*;
import java.util.HashMap;

public class EffectCreator {
	private static HashMap<String, EffectColor> effectHashmap = new HashMap<String, EffectColor>();

	public Effect createEffect(String effect, float x, float y) {
		Effect result = null;
		Color color;

		switch(effect) {
			case "slide":
				color = Color.CYAN;
				break;
			case "fly":
				color = Color.ORANGE;
				break;
			case "stun":
				color = Color.RED;
				break;
			default:
				color = Color.WHITE;
				break;
		}

		EffectColor effectColor = effectHashmap.get(effect);
		if (effectColor == null) {
			effectColor = new EffectColor(color);
			effectHashmap.put(effect, effectColor);
		}

		switch(effect) {
			case "slide":
				result = new SlideEffect(x, y, effectColor);
				break;
			case "fly":
				result = new FlyEffect(x, y, effectColor);
				break;
			case "stun":
				result = new StunEffect(x, y, effectColor);
				break;
			default:
				break;
		}

		return result;
	}
}
