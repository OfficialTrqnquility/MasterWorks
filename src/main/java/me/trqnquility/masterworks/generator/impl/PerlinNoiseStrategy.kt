package me.trqnquility.masterworks.generator.impl

import me.trqnquility.masterworks.generator.NoiseStrategy

/**
 * Within this class handles the Perlin Noise strategy
 * that we will use for a randomly generated the following world
 * without having to worry about a minimum size of the world.
 */
class PerlinNoiseStrategy private constructor() : NoiseStrategy{

    override fun generate(x: Double, y: Double): Pair<Double, Double> {
        return Pair(x, y)
    }

    private object HOLDER {
        val INSTANCE = PerlinNoiseStrategy()
    }

    /**
     * Sinlgeton instance of this class as it's going to be used a lot.
     */
    companion object{
        val instance: PerlinNoiseStrategy by lazy { HOLDER.INSTANCE }
    }

}