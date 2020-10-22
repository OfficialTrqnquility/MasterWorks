package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class GrassTile extends Tile {

    public GrassTile() {
        super(new BufferedImage[]{Assets.grass,}, 0);
    }

    @Override
    public void tick(int x, int y) {

    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
