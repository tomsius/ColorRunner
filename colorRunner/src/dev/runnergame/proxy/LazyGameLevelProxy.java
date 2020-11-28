package dev.runnergame.proxy;

import dev.runnergame.composite.Score;
import dev.runnergame.entities.Effect;
import dev.runnergame.levels.GameLevel;
import java.awt.Graphics;
import java.util.List;

public class LazyGameLevelProxy implements IGameLevel{
  private GameLevel gameLevel = null;
  private String path;

  public LazyGameLevelProxy(String path){
    this.path = path;
  }

  @Override
  public void update() {
    initializeGameLevel();
    this.gameLevel.update();
  }

  @Override
  public void render(Graphics g) {
    initializeGameLevel();
    this.gameLevel.render(g);
  }

  @Override
  public List<Effect> getLevelEffects() {
    initializeGameLevel();
    return this.gameLevel.getLevelEffects();
  }

  @Override
  public List<Score> getLevelScores() {
    initializeGameLevel();
    return this.gameLevel.getLevelScores();
  }

  private void initializeGameLevel(){
    if(gameLevel == null){
      gameLevel = new GameLevel();
      gameLevel.load(path);
    }
  }
}
