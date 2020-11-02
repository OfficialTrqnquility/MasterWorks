package me.trqnquility.masterworks.entity.model.living.human.impl;

import me.trqnquility.masterworks.Game;
import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.entity.model.living.human.EntityHuman;
import me.trqnquility.masterworks.gfx.Assets;
import me.trqnquility.masterworks.keymanager.KeyManager;
import me.trqnquility.masterworks.location.Position;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class EntityPlayer extends EntityHuman {

    //Temporary rendering code
    private BufferedImage playerImage = Assets.player_left[0];

    public EntityPlayer(@NotNull Position position, @NotNull BoundingBox boundingBox) {
        super(position, boundingBox, 3);
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
        graphics.drawImage(playerImage, entityPosition().getX(), entityPosition().getY(), playerImage.getWidth(), playerImage.getHeight(), null);
    }

    @Override
    public void tick() {
        KeyManager keyManager = Game.getInstance().getKeyManager();
        if (keyManager.up) {
            getPosition().add(0, -getSpeed());
        }
        if (keyManager.down) {
            getPosition().add(0, getSpeed());
        }
        if (keyManager.left) {
            getPosition().add(-getSpeed(), 0);
        }
        if (keyManager.right) {
            getPosition().add(getSpeed(), 0);
        }    }
}
