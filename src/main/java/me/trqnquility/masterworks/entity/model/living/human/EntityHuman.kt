package me.trqnquility.masterworks.entity.model.living.human

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.entity.model.living.LivingEntity
import me.trqnquility.masterworks.location.Position

abstract class EntityHuman(position: Position, boundingBox: BoundingBox) : LivingEntity(position, boundingBox) {



}