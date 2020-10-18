package dev.runnergame.command;

import dev.runnergame.entities.Structure;

public class MoveLeftCommand implements IMoveCommand{

  Structure structure;

  public MoveLeftCommand(Structure structure) {
    this.structure = structure;
  }

  @Override
  public void execute() {
    this.structure.moveLeft();
  }

  @Override
  public void undo() {
    this.structure.moveRight();
  }

}
