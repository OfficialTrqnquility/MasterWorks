package me.trqnquility.masterWorks.state;

import java.awt.*;

public abstract class State {

    private static State state;

    public static void setState(State state) {
        State.state = state;
    }

    public static State getState() {
        return state;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
