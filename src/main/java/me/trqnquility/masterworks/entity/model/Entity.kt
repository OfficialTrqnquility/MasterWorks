package me.trqnquility.masterworks.entity.model

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.location.Position
import me.trqnquility.masterworks.tickable.Tickable
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.util.*

abstract class Entity : Tickable {
    val id = UUID.randomUUID()

    fun entityId(): UUID {
        return id
    }

    abstract fun entityBoundingBox(): BoundingBox
    abstract fun entityPosition(): Position
    abstract fun entitySprites(): Map<Int, BufferedImage>
    abstract fun render(graphics: Graphics)
}