package me.trqnquility.masterworks.entity.model.living.creature

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.entity.model.living.LivingEntity
import me.trqnquility.masterworks.location.Position

abstract class EntityCreature(position: Position, boundingBox: BoundingBox, speed: Int, health: Int, damage: Int, isSolid: Boolean) : LivingEntity(position, boundingBox, speed, health, damage, isSolid) {

}
