package me.trqnquility.masterworks.state;

import me.trqnquility.masterworks.Tickable.Tickable;

import java.awt.*;

public abstract class State implements Tickable {

    private static State state;

    public static void setState(State state) {
        State.state = state;
    }

    public static State getState() {
        return state;
    }

    @Override
    public abstract void tick();

    public abstract void render(Graphics g);
}
