package dev.runnergame.command;

import dev.runnergame.entities.Structure;

public class MoveRightCommand implements IMoveCommand {

  Structure structure;

  public MoveRightCommand(Structure structure) {
    this.structure = structure;
  }

  @Override
  public void execute() {
    this.structure.moveRight();
  }

  @Override
  public void undo() {
    this.structure.moveLeft();
  }
}
