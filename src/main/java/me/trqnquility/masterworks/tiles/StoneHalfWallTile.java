package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class StoneHalfWallTile extends Tile{

    public StoneHalfWallTile() {
        super(new BufferedImage[] {Assets.stoneWallTopLeft, Assets.stoneWallTop, Assets.stoneWallTopRight, Assets.stoneWallLeft, Assets.stoneWallRight, Assets.stoneWallBottomLeft, Assets.stoneWallBottom, Assets.stoneWallBottomRight}, 8);
    }

    @Override
    public void tick(int x, int y) {
        
    }
}
