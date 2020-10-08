package dev.runnergame.entities;

import dev.runnergame.observer.EffectSubject;

import java.awt.*;

// Activates acceleration platforms
public class PlatformAccelerationEffect extends EffectSubject {

    private boolean isActivated;

    public PlatformAccelerationEffect(float x, float y) {
        super(x, y);
        this.isActivated = false;
    }
    public boolean isActivated() {
        return isActivated;
    }
    public void changeState(){
        isActivated = true;
    }
    public void onCollision(Player p){
        changeState();
        notifyAllObservers();
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) x, (int) y, width, height);
    }

    @Override
    public void modifySpeed() {

    }

}
