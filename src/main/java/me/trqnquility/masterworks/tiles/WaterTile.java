package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class WaterTile extends Tile {

	public WaterTile() {
		super(new BufferedImage[]{Assets.water, Assets.darkWater, Assets.waterToLightBottomLeft, Assets.waterToLightLeft, Assets.waterToLightRight, Assets.waterToDarkTopRight, Assets.waterToDarkTop, Assets.waterToDarkBottomLeft, Assets.waterToDarkTopLeft, Assets.waterToLightBottom}, 2);
	}

	@Override
	public void tick(int x, int y) {

	}

	@Override
	public boolean isSolid() {
		return true;
	}
}
