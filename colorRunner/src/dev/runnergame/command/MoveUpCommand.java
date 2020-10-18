package dev.runnergame.command;

import dev.runnergame.entities.Structure;

public class MoveUpCommand implements IMoveCommand{

  Structure structure;

  public MoveUpCommand(Structure structure) {
    this.structure = structure;
  }

  @Override
  public void execute() {
    this.structure.moveUp();
  }

  @Override
  public void undo() {
    this.structure.moveDown();
  }

}
