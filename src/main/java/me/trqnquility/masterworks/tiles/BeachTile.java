package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class BeachTile extends Tile {

	public BeachTile() {
		super(new BufferedImage[]{Assets.beach, Assets.beachToWaterdown}, 4);
	}

	@Override
	public void tick(int x, int y) {

	}

	@Override
	public boolean isSolid() {
		return false;
	}
}
