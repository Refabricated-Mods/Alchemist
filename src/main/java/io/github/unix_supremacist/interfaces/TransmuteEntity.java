package io.github.unix_supremacist.interfaces;

import io.github.unix_supremacist.content.AlchemistItems;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface TransmuteEntity {
    default InteractionResult transmuteEntity(LivingEntity entity, Level level){
        if(entity instanceof Villager){
            level.addFreshEntity(new ItemEntity(level, entity.getPosition(0).x(), entity.getPosition(0).y(), entity.getPosition(0).z(), new ItemStack(AlchemistItems.philosophers_stone.getItem())));
            entity.kill();
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
