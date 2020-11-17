package dev.runnergame.levels;

import dev.runnergame.template.GameWindowTemplate;

public class GameMenu extends GameWindowTemplate {
    public GameMenu() {

    }

    @Override
    protected void initialize(String path) {
        System.out.println("GameMenu initialize");
    }

    @Override
    protected void loadWorld() {
        System.out.println("GameMenu load world");
    }
}
