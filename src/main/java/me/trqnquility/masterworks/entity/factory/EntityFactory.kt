package me.trqnquility.masterworks.entity.factory

import me.trqnquility.masterworks.entity.model.living.LivingEntity
import me.trqnquility.masterworks.entity.model.living.LivingEntityType
import me.trqnquility.masterworks.entity.model.living.creature.impl.EntityZombie
import me.trqnquility.masterworks.location.Position

object EntityFactory {

    fun newLivingEntity(type: LivingEntityType, position: Position): LivingEntity {
        when (type) {
            LivingEntityType.ZOMBIE -> return EntityZombie()
        }
    }

}