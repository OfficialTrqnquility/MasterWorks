package me.trqnquility.masterworks.entity.model.living.creature

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.entity.model.living.LivingEntity
import me.trqnquility.masterworks.location.Position

abstract class EntityCreature(position: Position, boundingBox: BoundingBox, speed: Int) : LivingEntity(position, boundingBox, speed) {

}
