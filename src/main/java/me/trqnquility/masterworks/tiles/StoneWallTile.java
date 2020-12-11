package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class StoneWallTile extends Tile {

    public StoneWallTile() {
        super(new BufferedImage[] {Assets.brickLeft, Assets.brickMiddle, Assets.brickRight, Assets.fullBrick}, 5);
    }

    @Override
    public void tick(int x, int y) {

    }


    @Override
    public boolean isSolid() {
        return true;
    }
}
