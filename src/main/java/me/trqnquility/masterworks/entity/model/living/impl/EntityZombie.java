package me.trqnquility.masterworks.entity.model.living.impl;

import me.trqnquility.masterworks.boundingbox.BoundingBox;
import me.trqnquility.masterworks.entity.model.living.LivingEntity;
import me.trqnquility.masterworks.location.Position;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public final class EntityZombie extends LivingEntity {



	public EntityZombie(@NotNull Position position) {
		super(position);
	}

	@Override
	public int entityId() {
		return 0;
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
