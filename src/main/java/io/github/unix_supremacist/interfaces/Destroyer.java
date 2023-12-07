package io.github.unix_supremacist.interfaces;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public interface Destroyer {
    default void destroy(Level level, BlockPos pos, LivingEntity entity){
        if(!level.isClientSide() && !(level.getBlockState(pos).getBlock().defaultDestroyTime() < 0)){
            if (entity instanceof Player)
                level.destroyBlock(pos, !((Player) entity).isCreative());
            else
                level.destroyBlock(pos, true);
        }
    }

    default InteractionResult destroyArea(Level level, ArrayList<BlockPos> blocks, LivingEntity entity){
        if(!level.isClientSide()){
            if(!blocks.isEmpty()){
                for (BlockPos b : blocks){
                    destroy(level, b, entity);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
