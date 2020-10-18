package dev.runnergame.command;

import javax.swing.ImageIcon;

public class MoveCommandInvoker {

  IMoveCommand up;
  IMoveCommand right;
  IMoveCommand down;
  IMoveCommand left;

  public MoveCommandInvoker(IMoveCommand up, IMoveCommand right, IMoveCommand down, IMoveCommand left){
    this.up = up;
    this.right = right;
    this.down = down;
    this.left = left;
  }

  public void moveRight() {
    this.right.execute();
  }

  public void moveLeft(){
    this.left.execute();
  }

  public void moveUp(){
    this.up.execute();
  }

  public void moveDown(){
    this.down.execute();
  }

}
