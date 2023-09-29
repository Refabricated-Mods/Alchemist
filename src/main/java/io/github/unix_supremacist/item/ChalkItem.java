package io.github.unix_supremacist.item;

import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class ChalkItem extends BlockItem {
    public ChalkItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        context.getItemInHand().grow(1);
        InteractionResult interactionResult = this.place(new BlockPlaceContext(context));
        if(interactionResult == InteractionResult.FAIL) context.getItemInHand().shrink(1);
        context.getItemInHand().hurtAndBreak(1, context.getPlayer(), livingEntity -> livingEntity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return interactionResult;
    }

    @Override
    public int getBarColor(ItemStack item) {
        float f = Math.max(0.0F, ((float)this.getMaxDamage() - (float)item.getDamageValue()) / (float)this.getMaxDamage());
        return Mth.hsvToRgb(f / 1.1F, 1.0F, 1.0F);
    }

    @Override
    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}
