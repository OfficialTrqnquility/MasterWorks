package me.trqnquility.masterworks.entity.model.living

import me.trqnquility.masterworks.Game
import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.entity.model.Entity
import me.trqnquility.masterworks.keymanager.KeyManager
import me.trqnquility.masterworks.location.Position

abstract class LivingEntity constructor(var position: Position, var boundingBox: BoundingBox, var speed: Int) : Entity() {

    override fun entityPosition(): Position {
        return position
    }

    override fun entityBoundingBox(): BoundingBox {
        return boundingBox
    }

}