package me.trqnquility.masterworks.entity.model.inanimate

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.entity.model.Entity
import me.trqnquility.masterworks.location.Position
import java.util.*

abstract class InanimateEntity constructor(var position: Position, var boundingBox: BoundingBox, isSolid: Boolean) : Entity(isSolid) {


    override fun entityPosition(): Position {
        return position
    }

    override fun entityBoundingBox(): BoundingBox {
        return boundingBox
    }

}