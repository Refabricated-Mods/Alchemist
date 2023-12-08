package io.github.unix_supremacist.item;

import io.github.unix_supremacist.alabli.AlabliBlockItem;
import io.github.unix_supremacist.interfaces.DurablityBar;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static io.github.unix_supremacist.content.AlchemistItems.chalk;

public class AlchemistBlockItem extends AlabliBlockItem implements DurablityBar {
    public AlchemistBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult interactionResult;
        ItemStack item = context.getItemInHand();
        if(context.getLevel().getBlockState(context.getClickedPos().relative(context.getClickedFace())) == Blocks.LAVA.defaultBlockState() && item.getDamageValue() < this.getMaxDamage()){
            context.getLevel().setBlock(context.getClickedPos().relative(context.getClickedFace()), Blocks.AIR.defaultBlockState(), 0);
            context.getItemInHand().setDamageValue(item.getDamageValue()+1);
            interactionResult = InteractionResult.SUCCESS;
        } else {
            context.getItemInHand().grow(1);
            interactionResult = this.place(new BlockPlaceContext(context));
            if(interactionResult == InteractionResult.FAIL) context.getItemInHand().shrink(1);
            if (this.getMaxDamage() > 0) context.getItemInHand().hurtAndBreak(1, context.getPlayer(), livingEntity -> livingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }

        return interactionResult;
    }

    @Override
    public int getBarColor(ItemStack item) {
        return getColor(item.getMaxDamage(), item.getDamageValue());
    }

    public ItemStack getRecipeRemainder(ItemStack stack) {
        if (this.getMaxDamage() > 0) stack.setDamageValue(stack.getDamageValue()-1);
        if (stack.getDamageValue() == getMaxDamage()) stack = ItemStack.EMPTY;
        return stack.copy();
    }

    @Override
    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    /*@Override
    public boolean isValidRepairItem(ItemStack itemStack2, ItemStack itemStack) {
        return itemStack.getItem() == Items.BLAZE_POWDER || super.isValidRepairItem(itemStack2, itemStack);
    }*/

    @Override
    public Rarity getRarity(ItemStack s){
        return s.getItem()==chalk.getItem() ? Rarity.COMMON : Rarity.EPIC;
    }
}
