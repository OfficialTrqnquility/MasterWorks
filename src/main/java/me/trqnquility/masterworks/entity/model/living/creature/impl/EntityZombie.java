package me.trqnquility.masterworks.entity.model.living.creature.impl;

import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.entity.model.living.creature.EntityCreature;
import me.trqnquility.masterworks.location.Position;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public final class EntityZombie extends EntityCreature {



	public EntityZombie(@NotNull Position position, @NotNull BoundingBox boundingBox, int health, int damage, boolean isSolid) {
		super(position, boundingBox, 10, health, damage, isSolid);
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
		super.tick();
	}

	@Override
	public void onCollide() {

	}
}
