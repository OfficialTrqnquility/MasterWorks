package me.trqnquility.masterworks.ui;

import lombok.Getter;
import me.trqnquility.masterworks.tickable.Tickable;

import java.awt.*;
import java.awt.event.MouseEvent;

@Getter
public abstract class UIObject implements Tickable {

    private int x, y, width, height;

    private boolean hovering;

    protected UIObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public void onMouseMove(MouseEvent e) {
        if (inRectangle(e.getX(), e.getY())) {
            hovering = true;
        } else {
            hovering = false;
        }
    }

    public void onMouseRelease() {
        if (hovering) {
            onClick();
        }
    }

    protected abstract void onClick();

    private boolean inRectangle(int x, int y) {

        if (x >= this.x && y >= this.y && x <= this.x + this.width && y <= this.y + this.height ) return true;

        return false;

    }

    @Override
    public void tick() {
    }

    public void render(Graphics g) {

    }
}
