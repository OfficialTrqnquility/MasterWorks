package me.trqnquility.masterworks.tiles;

import me.trqnquility.masterworks.entity.model.living.LivingEntity;
import me.trqnquility.masterworks.gfx.Assets;
import me.trqnquility.masterworks.state.GameState;
import me.trqnquility.masterworks.state.State;
import me.trqnquility.masterworks.worlds.WorldManager;

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
        GameState state = (GameState) State.getState();
        state.setWorld(WorldManager.getInstance().getWorld("bossworld"));
        System.out.println(state.getWorld().getTile(0, 0).getId());
    }
}
