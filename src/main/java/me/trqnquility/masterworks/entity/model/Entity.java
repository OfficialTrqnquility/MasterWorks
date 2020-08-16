package me.trqnquility.masterworks.entity.model;

import me.trqnquility.masterworks.tick.Ticker;

import java.util.UUID;

/**
 * Provides a base entity shou
 */
public interface Entity<T extends Enum<T>> extends Ticker {

	/**
	 * @return The ID bound to the entity used for tracking, and removal.
	 */
	UUID getEntityId();

	/**
	 * @return The type of the entity.
	 */
	T getEntityType();

}
