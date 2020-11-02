package me.trqnquility.masterworks.entity.model

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.location.Position
import me.trqnquility.masterworks.state.GameState
import me.trqnquility.masterworks.state.State
import me.trqnquility.masterworks.tickable.Tickable
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.util.*

abstract class Entity constructor(var isSolid: Boolean) : Tickable {
    val id = UUID.randomUUID()

    var needsTick = false

    fun entityId(): UUID {
        return id
    }

    abstract fun entityBoundingBox(): BoundingBox
    abstract fun entityPosition(): Position
    abstract fun entitySprites(): Map<Int, BufferedImage>
    abstract fun render(graphics: Graphics)
    abstract fun onCollide()

    fun kill() {
        (State.getState() as GameState).world.entities.remove(id)
    }
}