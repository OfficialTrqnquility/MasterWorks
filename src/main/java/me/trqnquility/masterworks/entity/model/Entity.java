package me.trqnquility.masterworks.entity.model;

import me.trqnquility.masterworks.Tickable.Tickable;

import java.util.UUID;

/**
 * Provides a base entity shou
 */
public interface Entity<T extends Enum<T>> extends Tickable {

	/**
	 * @return The ID bound to the entity used for tracking, and removal.
	 */
	UUID getEntityId();

	/**
	 * @return The type of the entity.
	 */
	T getEntityType();

}
