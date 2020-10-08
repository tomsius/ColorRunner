package dev.runnergame.entities;

import dev.runnergame.observer.PlatformObserver;

import java.awt.*;

public class AccelerationPlatform extends PlatformObserver {
    private boolean isEffectActivated;
    private PlatformAccelerationEffect effect;

    public AccelerationPlatform(float x, float y, int width, int height, PlatformAccelerationEffect effect) {
        super(x, y, width, height);
        this.effect = effect;
        this.effect.attach(this);
    }
    //reikalinga Collision implementacija
    /*public void onCollision(Player p){
        if(isActivated){
         p.setSpeed(p.getSpeed()*2);
        }

    }*/

    @Override
    public void updateObserver() {
        isEffectActivated = effect.isActivated();
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int) x, (int) y, width, height);
        if(isEffectActivated){
            g.setColor(Color.BLACK);
            g.fillRect((int) x, (int) y, width, height);
        }
    }

    @Override
    public void modifySpeed() {

    }
}
