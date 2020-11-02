package me.trqnquility.masterworks.entity.model.inanimate.item;

import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.entity.model.inanimate.InanimateEntity;
import me.trqnquility.masterworks.location.Position;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.UUID;

public class EntityItem extends InanimateEntity {

    public EntityItem(@NotNull Position position, @NotNull BoundingBox boundingBox) {
        super(position, boundingBox);
    }

    @Override
    public void onCollide() {

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
