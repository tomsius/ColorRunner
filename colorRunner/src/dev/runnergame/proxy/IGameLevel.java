package dev.runnergame.proxy;

import dev.runnergame.composite.Score;
import dev.runnergame.entities.Effect;
import java.awt.Graphics;
import java.util.List;

public interface IGameLevel {
  void update();
  void render(Graphics g);
  List<Effect> getLevelEffects();
  List<Score> getLevelScores();
}
