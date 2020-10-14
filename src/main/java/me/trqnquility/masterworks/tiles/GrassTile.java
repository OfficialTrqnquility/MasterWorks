package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

public class GrassTile extends Tile{

    public GrassTile() {
        super(Assets.grass, 0);
    }

    @Override
    public void tick(int x, int y) {

    }

    @Override
    boolean isSolid() {
        return false;
    }
}
