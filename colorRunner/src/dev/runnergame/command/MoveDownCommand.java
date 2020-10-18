package dev.runnergame.command;

import dev.runnergame.entities.Structure;

public class MoveDownCommand implements IMoveCommand {

  Structure structure;

  public MoveDownCommand(Structure structure) {
    this.structure = structure;
  }

  @Override
  public void execute() {
    this.structure.moveDown();
  }

  @Override
  public void undo() {
    this.structure.moveUp();
  }

}
