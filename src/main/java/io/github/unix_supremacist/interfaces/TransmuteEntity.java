package io.github.unix_supremacist.interfaces;

import io.github.unix_supremacist.content.AlchemistItems;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface TransmuteEntity {
    public default InteractionResult transmuteEntity(LivingEntity entity, Level level){
        if(entity instanceof Villager){
            level.addFreshEntity(new ItemEntity(level, entity.getPosition(0).x(), entity.getPosition(0).y(), entity.getPosition(0).z(), new ItemStack(AlchemistItems.philosophers_stone.getItem())));
            entity.kill();
            return InteractionResult.SUCCESS;
        }

        if(entity instanceof Wolf){
            Cat cat = new Cat(EntityType.CAT, level);
            cat.setPos(entity.getPosition(0));
            entity.remove(Entity.RemovalReason.DISCARDED);
            level.addFreshEntity(cat);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
