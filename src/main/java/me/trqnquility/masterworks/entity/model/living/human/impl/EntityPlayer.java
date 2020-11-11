package me.trqnquility.masterworks.entity.model.living.human.impl;

import me.trqnquility.masterworks.Game;
import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.entity.model.living.human.EntityHuman;
import me.trqnquility.masterworks.gfx.Assets;
import me.trqnquility.masterworks.inventory.Inventory;
import me.trqnquility.masterworks.keymanager.KeyManager;
import me.trqnquility.masterworks.location.Position;
import me.trqnquility.masterworks.state.GameState;
import me.trqnquility.masterworks.state.State;
import me.trqnquility.masterworks.worlds.World;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class EntityPlayer extends EntityHuman {

    //Temporary rendering code
    private BufferedImage playerImage = Assets.player_left[0];

    private int xMove;
    private int yMove;

    private Inventory inventory;

    public EntityPlayer(@NotNull Position position, @NotNull BoundingBox boundingBox, @NotNull int health, @NotNull int damage) {
        super(position, boundingBox, 3, health, damage, true);

        inventory = new Inventory(3);
    }

    @NotNull
    @Override
    public Map<Integer, BufferedImage> entitySprites() {
        return null;
    }

    @Override
    public void render(@NotNull Graphics graphics) {
        graphics.drawImage(playerImage, entityPosition().getX(), entityPosition().getY(), playerImage.getWidth(), playerImage.getHeight(), null);
        graphics.fillRect(entityPosition().getX() + entityBoundingBox().getXOffset(), entityPosition().getY() + entityBoundingBox().getYOffset(), entityBoundingBox().getWidth(), entityBoundingBox().getHeight());
        inventory.render(graphics);
    }

    @Override
    public void tick() {
        move();
    }

    private final void move() {
        KeyManager keyManager = Game.getInstance().getKeyManager();
        World world = ((GameState) State.getState()).getWorld();

        if (keyManager.up) {
            int leftX = (entityPosition().getX() + entityBoundingBox().getXOffset()) / 32;
            int y = (entityPosition().getY() + entityBoundingBox().getYOffset() - getSpeed()) / 32;
            int rightX = (entityPosition().getX() + entityBoundingBox().getXOffset() + entityBoundingBox().getWidth()) / 32;

            if (!world.getTile(leftX, y).isSolid()) {
                if (!world.getTile(rightX, y).isSolid()) {
                    yMove -= getSpeed();
                } else world.getTile(rightX, y).onCollide(this);

                world.getTile(leftX, y).onCollide(this);

            } else world.getTile(leftX, y).onCollide(this);

        }
        if (keyManager.down) {

            int leftX = (entityPosition().getX() + entityBoundingBox().getXOffset()) / 32;
            int y = (entityPosition().getY() + entityBoundingBox().getYOffset() + entityBoundingBox().getHeight() + getSpeed()) / 32;
            int rightX = (entityPosition().getX() + entityBoundingBox().getXOffset() + entityBoundingBox().getWidth()) / 32;

            if (!world.getTile(leftX, y).isSolid()) {
                if (!world.getTile(rightX, y).isSolid()) {
                    yMove += getSpeed();
                } else world.getTile(rightX, y).onCollide(this);

                world.getTile(leftX, y).onCollide(this);

            } else world.getTile(leftX, y).onCollide(this);

        }
        if (keyManager.left) {
            int topY = (entityPosition().getY() + entityBoundingBox().getYOffset()) / 32;
            int x = (entityPosition().getX() + entityBoundingBox().getXOffset() - getSpeed()) / 32;
            int bottomY = (entityPosition().getY() + entityBoundingBox().getYOffset() + entityBoundingBox().getHeight()) / 32;

            if (!world.getTile(x, bottomY).isSolid()) {
                if (!world.getTile(x, topY).isSolid()) {
                    xMove -= getSpeed();
                } else world.getTile(x, topY).onCollide(this);

                world.getTile(x, bottomY).onCollide(this);

            } else world.getTile(x, bottomY).onCollide(this);
        }
        if (keyManager.right) {
            int topY = (entityPosition().getY() + entityBoundingBox().getYOffset()) / 32;
            int x = (entityPosition().getX() + entityBoundingBox().getXOffset() + entityBoundingBox().getWidth() + getSpeed()) / 32;
            int bottomY = (entityPosition().getY() + entityBoundingBox().getYOffset() + entityBoundingBox().getHeight()) / 32;

            if (!world.getTile(x, bottomY).isSolid() && !world.getTile(x, topY).isSolid()) {
                xMove += getSpeed();
            }
        }

        super.tick();

        entityPosition().add(xMove, yMove);

        xMove = 0;
        yMove = 0;
    }

    private boolean isSolid(int x, int y) {
        return ((GameState) State.getState()).getWorld().getTile(x, y).isSolid();
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void onCollide() {

    }
}
