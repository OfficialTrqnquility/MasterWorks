package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.entity.model.living.LivingEntity;
import me.trqnquility.masterworks.gfx.Assets;

import java.awt.image.BufferedImage;

public class StonePortal extends Tile {

    public StonePortal() {
        super(new BufferedImage[]{Assets.brickPortal} , 6);
    }

    @Override
    public void tick(int x, int y) {

    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void onCollide(LivingEntity entity) {
        System.out.println("True");
    }
}
