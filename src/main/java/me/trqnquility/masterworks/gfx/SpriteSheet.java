package me.trqnquility.masterworks.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private final BufferedImage sheet;
    private final int width, height;

    public SpriteSheet(BufferedImage sheet, int width, int height) {
        this.sheet = sheet;
        this.width = width;
        this.height = height;
    }

    public BufferedImage crop(int x, int y) {
        return crop(x, y, width, height);
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }


}
