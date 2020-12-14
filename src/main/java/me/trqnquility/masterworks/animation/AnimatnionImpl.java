package me.trqnquility.masterworks.animation;

import java.awt.*;

public class AnimatnionImpl implements Animation {

    private boolean isActive = false;

    private int animationLength = 10;

    @Override
    public void start() {
    isActive = true;
    }

    @Override
    public void stop() {
    isActive =  false;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public int getAnimationLength() {
        return animationLength;
    }

    @Override
    public void setAnimationLength(int amount) {
        animationLength = amount;
    }
}
