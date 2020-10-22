package me.trqnquility.masterworks.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class UIOverlay extends UIObject {

    protected BufferedImage icon;

    protected UIOverlay(int x, int y, int width, int height, BufferedImage icon) {
        super(x, y, width, height);
        this.icon = icon;
    }

    @Override
    protected final void onClick() {

        //No Code needed, overlays shouldn't be clickable.

    }

    @Override
    public abstract void tick();

    @Override
    public void render(Graphics g) {
        g.drawImage(icon, getX(), getY(), getWidth(), getHeight(), null);
    }

}
