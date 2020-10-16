package me.trqnquility.masterworks.generator

/**
 * Handles the template for a strategy that we will use
 * for all world generation.
 */
interface NoiseStrategy {

    fun generate(x: Double, y: Double) : Pair<Double, Double>

}