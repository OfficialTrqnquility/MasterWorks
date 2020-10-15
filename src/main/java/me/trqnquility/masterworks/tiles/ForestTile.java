package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class ForestTile extends Tile{


    public ForestTile() {
        super(new BufferedImage[]{Assets.forest}, 3);
    }

    @Override
    public void tick(int x, int y) {

    }

    @Override
    boolean isSolid() {
        return true;
    }
}
