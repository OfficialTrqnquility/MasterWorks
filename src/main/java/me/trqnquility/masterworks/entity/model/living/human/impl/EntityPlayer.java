package me.trqnquility.masterworks.entity.model.living.human.impl;

import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.entity.model.living.human.EntityHuman;
import me.trqnquility.masterworks.location.Position;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class EntityPlayer extends EntityHuman {

    public EntityPlayer(@NotNull Position position, @NotNull BoundingBox boundingBox) {
        super(position, boundingBox);
    }

    @NotNull
    @Override
    public BoundingBox entityBoundingBox() {
        return null;
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
