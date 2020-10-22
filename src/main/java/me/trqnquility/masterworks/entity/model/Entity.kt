package me.trqnquility.masterworks.entity.model

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.location.Position

interface Entity {
    fun entityId(): Int
    fun entityHealth(): Double
    fun entityBoundingBox(): BoundingBox
    fun entityPosition(): Position
}