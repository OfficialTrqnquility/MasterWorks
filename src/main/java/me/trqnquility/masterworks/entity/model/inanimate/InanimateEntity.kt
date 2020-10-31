package me.trqnquility.masterworks.entity.model.inanimate

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.entity.model.Entity
import me.trqnquility.masterworks.location.Position

abstract class InanimateEntity constructor(var position: Position, var boundingBox: BoundingBox) : Entity {


    override fun entityPosition(): Position {
        return position
    }

    override fun entityBoundingBox(): BoundingBox {
        return boundingBox
    }

    abstract fun onCollide()
}