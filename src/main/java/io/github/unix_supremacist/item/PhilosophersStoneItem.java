package io.github.unix_supremacist.item;

import io.github.unix_supremacist.content.AlchemistItems;
import io.github.unix_supremacist.AlchemistRegistry;
import io.github.unix_supremacist.interfaces.AreaBox;
import io.github.unix_supremacist.interfaces.TransmuteEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;

public class PhilosophersStoneItem extends Item implements AreaBox, TransmuteEntity {
    public PhilosophersStoneItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        ArrayList<BlockPos> blocks = getAreaFromFacing(context.getClickedFace(), context.getClickedPos(), 2, 0);
        ArrayList<Block> exchange = new ArrayList<>();
        InteractionResult result = InteractionResult.PASS;
        for (ArrayList<Block> e : AlchemistRegistry.exchanges){
            if (e.contains(context.getLevel().getBlockState(context.getClickedPos()).getBlock())){
                exchange = e;
                result = InteractionResult.SUCCESS;
                break;
            }
        }
        if(!blocks.isEmpty()){
            for (BlockPos b : blocks){
                Block block = context.getLevel().getBlockState(b).getBlock();
                if (!context.getLevel().isClientSide() && exchange.contains(block)) {
                    Block newBlock;
                    if(context.getPlayer().isShiftKeyDown())
                        newBlock = AlchemistRegistry.getBlockWithOffset(block, exchange,-1);
                    else
                        newBlock = AlchemistRegistry.getBlockWithOffset(block, exchange,+1);
                    context.getLevel().setBlock(b, newBlock.defaultBlockState(), 3);
                    ItemStack stack = context.getPlayer().getItemInHand(context.getHand()).copy();
                    context.getPlayer().setItemInHand(context.getHand(), stack);
                }
            }
        }

        return result;
    }

    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        return transmuteEntity(entity, player.level());
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        return new ItemStack(AlchemistItems.philosophers_stone.getItem());
    }

    @Override
    public Rarity getRarity(ItemStack s){
        return Rarity.EPIC;
    }
}
