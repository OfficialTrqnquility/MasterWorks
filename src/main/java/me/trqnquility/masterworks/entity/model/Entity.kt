package me.trqnquility.masterworks.entity.model

import me.trqnquility.masterworks.tickable.Tickable
import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.location.Position
import java.awt.Graphics
import java.awt.image.BufferedImage

interface Entity: Tickable {
    fun entityId(): Int
    fun entityBoundingBox(): BoundingBox
    fun entityPosition(): Position
    fun entitySprites(): Map<Int, BufferedImage>
    fun render(graphics: Graphics)

}