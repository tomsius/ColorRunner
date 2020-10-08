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
        if(
            ((this.getY() <= p.getY() && this.getY()+this.getHeight() >= p.getY()) &&
            (this.getX() <= p.getX() && this.getX() + this.getWidth() >= p.getX())) ||
            ((this.getY() <= p.getY() && this.getY()+this.getHeight() >= p.getY()) &&
            (this.getX() <= p.getX()+p.getWidth() && this.getX() + this.getWidth() >= p.getX()+p.getWidth())) ||
            ((this.getY() <= p.getY()+p.getHeight() && this.getY()+this.getHeight() >= p.getY()+p.getHeight()) &&
            (this.getX() <= p.getX()+p.getWidth() && this.getX() + this.getWidth() >= p.getX()+p.getWidth())) ||
            ((this.getY() <= p.getY()+p.getHeight() && this.getY()+this.getHeight() >= p.getY()+p.getHeight()) &&
            (this.getX() <= p.getX() && this.getX() + this.getWidth() >= p.getX()))
        ){
            changeState();
            notifyAllObservers();
        }
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
