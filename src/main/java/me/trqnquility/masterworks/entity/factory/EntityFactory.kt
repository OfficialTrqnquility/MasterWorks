package me.trqnquility.masterworks.entity.factory

import me.trqnquility.masterworks.boundingbox.BoundingBox
import me.trqnquility.masterworks.entity.model.inanimate.InanimateEntity
import me.trqnquility.masterworks.entity.model.inanimate.InanimateEntityType
import me.trqnquility.masterworks.entity.model.inanimate.item.EntityItem
import me.trqnquility.masterworks.entity.model.living.LivingEntity
import me.trqnquility.masterworks.entity.model.living.LivingEntityType
import me.trqnquility.masterworks.entity.model.living.creature.impl.EntityZombie
import me.trqnquility.masterworks.entity.model.living.human.impl.EntityPlayer
import me.trqnquility.masterworks.location.Position

object EntityFactory {

    fun newLivingEntity(type: LivingEntityType, position: Position, boundingBox: BoundingBox, health: Int, damage: Int, isSolid: Boolean): LivingEntity {
        return when (type) {
            LivingEntityType.ZOMBIE -> EntityZombie(position, boundingBox, health, damage, isSolid)
            LivingEntityType.PLAYER -> EntityPlayer(position, boundingBox, health, damage)
        }
    }

    fun newInanimateEntity(type: InanimateEntityType, position: Position, boundingBox: BoundingBox): InanimateEntity {
        return when (type) {
            InanimateEntityType.Item -> EntityItem(position, boundingBox)
        }
    }

}