package me.trqnquility.masterworks.animation;

import java.awt.*;

public interface Animation {


    void start();

    void stop();

    Color getColor();


    boolean isActive();

    int getAnimationLength();

    void setAnimationLength(int amount);
}
