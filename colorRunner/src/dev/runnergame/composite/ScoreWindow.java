package dev.runnergame.composite;

import dev.runnergame.entities.Effect;
import java.util.ArrayList;
import java.util.List;

public class ScoreWindow implements Score{
  private List<Score> scores;

  public ScoreWindow(List<Effect> effects){
    scores = new ArrayList<Score>();
    for(Effect effect : effects){
      this.scores.add((Score)effect);
    }
  }

  public void addScore(Score score){
    scores.add(score);
  }

  @Override
  public void displayScore() {
    int sum = 0;
    System.out.println("Effects: " + getEffectScore());
    for(Score score : scores){
      score.displayScore();
      sum += score.getScore();
    }
    System.out.println("Score: " + sum);
  }

  @Override
  public void increaseScore() {
  }

  @Override
  public int getScore() {
    return 0;
  }

  public int getEffectScore(){
    int sum = 0;
    for(Score score : scores){
      if(score instanceof Effect){
        sum += score.getScore();
      }
    }
    return sum;
  }

}
