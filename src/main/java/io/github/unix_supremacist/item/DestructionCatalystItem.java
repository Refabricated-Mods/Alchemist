package io.github.unix_supremacist.item;

import io.github.unix_supremacist.interfaces.AreaBox;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;

import java.util.ArrayList;

public class DestructionCatalystItem extends Item implements AreaBox {
    public DestructionCatalystItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        ArrayList<BlockPos> blocks = getAreaFromFacing(context.getClickedFace(), context.getClickedPos(), 2, 5);
        InteractionResult result = InteractionResult.PASS;

        if(!blocks.isEmpty()){
            for (BlockPos b : blocks){
                if (!context.getLevel().isClientSide()) {
                    context.getLevel().destroyBlock(b, !context.getPlayer().isCreative());
                    ItemStack stack = context.getPlayer().getItemInHand(context.getHand()).copy();
                    context.getPlayer().setItemInHand(context.getHand(), stack);
                }
            }
            result = InteractionResult.SUCCESS;
        }

        return result;
    }

    @Override
    public Rarity getRarity(ItemStack s){
        return Rarity.EPIC;
    }
}
