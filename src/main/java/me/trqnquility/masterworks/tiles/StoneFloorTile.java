package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class StoneFloorTile extends Tile{

    public StoneFloorTile() {
        super(new BufferedImage[]{Assets.stoneFloor, Assets.stoneFloorWithStones}, 7);
    }

    @Override
    public void tick(int x, int y) {

    }
}
