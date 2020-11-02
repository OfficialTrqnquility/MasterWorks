package me.trqnquility.masterworks.entity.model.inanimate.item;

import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.entity.model.inanimate.InanimateEntity;
import me.trqnquility.masterworks.location.Position;
import me.trqnquility.masterworks.state.GameState;
import me.trqnquility.masterworks.state.State;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class EntityItem extends InanimateEntity {

    public EntityItem(@NotNull Position position, @NotNull BoundingBox boundingBox) {
        super(position, boundingBox, false);
    }

    @Override
    public void onCollide() {
        if (!((GameState) State.getState()).getPlayer().getInventory().isFull()) {
            kill();
            ((GameState) State.getState()).getPlayer().getInventory().addItem(this);
        }
    }

    @NotNull
    @Override
    public Map<Integer, BufferedImage> entitySprites() {
        return null;
    }

    @Override
    public void render(@NotNull Graphics graphics) {

    }

    @Override
    public void tick() {

    }
}
