package me.trqnquility.masterworks.entity.model.living.creature.impl;

import com.google.common.collect.Lists;
import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.entity.model.living.creature.EntityCreature;
import me.trqnquility.masterworks.gfx.Assets;
import me.trqnquility.masterworks.location.Position;
import me.trqnquility.masterworks.pathfinding.PathNode;
import me.trqnquility.masterworks.state.GameState;
import me.trqnquility.masterworks.state.State;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public final class EntityZombie extends EntityCreature {

    private BoundingBox boundingBox;

    public EntityZombie(@NotNull Position position, @NotNull BoundingBox boundingBox, int health, int damage, boolean isSolid) {
        super(position, boundingBox, 1, health, damage, isSolid);
        this.boundingBox = boundingBox;
    }

    @NotNull
    @Override
    public BoundingBox entityBoundingBox() {
        return boundingBox;
    }

    @NotNull
    @Override
    public List<BufferedImage> entitySprites() {
        return Lists.newArrayList(Assets.zombie);
    }

    @Override
    public void render(@NotNull Graphics graphics) {
        graphics.drawImage(entitySprites().get(0), entityPosition().getX(), entityPosition().getY(), entitySprites().get(0).getWidth(), entitySprites().get(0).getHeight(), null);
        if (path != null) {
            Color color = Color.BLACK;
            for (PathNode node : path) {
                if (node.getPreviousNode() != null) {
                    graphics.setColor(color);
                    if (color.equals(Color.BLACK)) {
                        color = Color.WHITE;
                    } else color = Color.BLACK;
                    //g.drawLine(node.getPreviousNode().getX() * 32, node.getPreviousNode().getY() * 32, node.getX() * 32, node.getY() * 32);
                    graphics.drawLine(node.getPreviousNode().getX() * 32 + 16, node.getPreviousNode().getY() * 32 + 16, node.getX() * 32 + 16, node.getY() * 32 + 16);
                }
            }
        }
    }

    List<PathNode> path;

    @Override
    public void tick() {

        GameState state = ((GameState) State.getState());
        path = state.getAStar().findPath(entityPosition().getX() / 32, entityPosition().getY() / 32, state.getPlayer().getPosition().getX() / 32, state.getPlayer().getPosition().getY() / 32);
        if (path != null && path.size() > 1) {
            int deltaX = (path.get(1).getX() - path.get(0).getX()) * 32;
            int deltaY = (path.get(0).getY() - path.get(1).getY()) * 32;
            entityPosition().add(deltaX / 30, -(deltaY / 30));
        }
        //entityPosition().setX(entityPosition().getX() + distance);
    }

    @Override
    public void onCollide() {

    }
}
