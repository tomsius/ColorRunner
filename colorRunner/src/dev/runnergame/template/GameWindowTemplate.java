package dev.runnergame.template;

public abstract class GameWindowTemplate {
    public final void load(String path) {
        initialize(path);
        loadWorld();
    }

    protected abstract void initialize(String path);
    protected abstract void loadWorld();
}
