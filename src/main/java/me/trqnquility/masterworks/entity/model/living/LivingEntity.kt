package me.trqnquility.masterworks.entity.model.living

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.entity.model.Entity
import me.trqnquility.masterworks.location.Position
import me.trqnquility.masterworks.state.GameState
import me.trqnquility.masterworks.state.State
import me.trqnquility.masterworks.utils.Utils

abstract class LivingEntity constructor(var position: Position, var boundingBox: BoundingBox, var speed: Int, var health: Int, var damage: Int, isSolid: Boolean) : Entity(isSolid) {

    var xMove: Int = 0
    var yMove: Int = 0

    override fun entityPosition(): Position {
        return position
    }

    override fun entityBoundingBox(): BoundingBox {
        return boundingBox
    }

    override fun tick() {
        for (other in (State.getState() as GameState).world.entities.values) {
            if (other.isSolid) {
                if (Utils.isOverlapping(Position.of(position.x + xMove, position.y + yMove), if (other is LivingEntity) Position.of(other.position.x + other.xMove, other.position.y + other.yMove) else other.entityPosition(), boundingBox, other.entityBoundingBox())) {
                    xMove = 0
                    yMove = 0
                }
                onCollide()
            }
        }
    }

}