package me.trqnquility.masterworks.tiles;

import lombok.Getter;
import me.trqnquility.masterworks.Tickable.Tickable;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
public abstract class Tile {

    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;

    private final BufferedImage image;
    private final int id;

    public Tile(BufferedImage image, int id) {

        this.image = image;
        this.id = id;

    }

    public abstract void tick(int x, int y);

    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
}
