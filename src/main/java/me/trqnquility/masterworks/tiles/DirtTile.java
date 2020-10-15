package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class DirtTile extends Tile {


    public DirtTile() {
        super(new BufferedImage[]{Assets.dirt,
                Assets.dirtTopleft,
                Assets.dirtTopRight,
                Assets.dirtBottomLeft,
                Assets.dirtBottomRight}, 1);
    }

    @Override
    boolean isSolid() {
        return false;
    }

    @Override
    public void tick(int x, int y) {
    }
}
