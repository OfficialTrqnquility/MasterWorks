package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class DirtTile extends Tile {


    public DirtTile() {
        super(new BufferedImage[]{Assets.dirt}, 1);
    }

    @Override
    public boolean  isSolid() {
        return false;
    }

    @Override
    public void tick(int x, int y) {
    }
}
