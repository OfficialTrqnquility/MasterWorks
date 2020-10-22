package me.trqnquility.masterworks.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class UIButton extends UIObject {

    private final BufferedImage icon;

    protected UIButton(int x, int y, int width, int height, BufferedImage icon) {
        super(x, y, width, height);
        this.icon = icon;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(icon, getX(), getY(), getWidth(), getHeight(), null);
    }
}
