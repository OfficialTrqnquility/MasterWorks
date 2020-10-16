package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class DockTile extends Tile {

    public DockTile() {
        super(new BufferedImage[]{Assets.dock, Assets.dockCenter, Assets.dockDown, Assets.dockSide, Assets.dockFeet, Assets.dockFeetLeft, Assets.dockFeetRight, Assets.dockLeft, Assets.dockRight}, 3);
    }

    @Override
    public void tick(int x, int y) {

    }

    @Override
    boolean isSolid() {
        return false;
    }
}
