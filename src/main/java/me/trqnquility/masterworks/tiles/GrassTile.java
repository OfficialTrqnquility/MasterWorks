package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class GrassTile extends Tile {

    public GrassTile() {
        super(new BufferedImage[]{Assets.grass,
                Assets.grassTopLeft,
                Assets.grassTop,
                Assets.grassTopRight,
                Assets.grassLeft,
                Assets.grassRight,
                Assets.grassBottomLeft,
                Assets.grassBottom,
                Assets.grassBottomRight}, 0);
    }

    @Override
    public void tick(int x, int y) {

    }

    @Override
    boolean isSolid() {
        return false;
    }
}
