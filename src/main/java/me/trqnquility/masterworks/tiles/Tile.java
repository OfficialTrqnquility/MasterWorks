package me.trqnquility.masterworks.tiles;

import lombok.Getter;
import me.trqnquility.masterworks.entity.model.living.LivingEntity;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
public abstract class Tile {

    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;

    private final BufferedImage[] images;
    private final int id;

    public Tile(BufferedImage[] images, int id) {

        this.images = images;
        this.id = id;

    }

    public abstract void tick(int x, int y);

    public void onCollide(LivingEntity entity) {

    }

    public void render(Graphics g, int x, int y, int data) {
        g.drawImage(images[data], x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

}
