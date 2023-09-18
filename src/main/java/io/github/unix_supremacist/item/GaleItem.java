package io.github.unix_supremacist.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GaleItem extends Item {
    public GaleItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level l, Player p, InteractionHand h) {
        //TODO this needs to be more mod compatible and somehow disable if you dont have the item
        p.getAbilities().mayfly = !p.getAbilities().mayfly;
        if (p.getAbilities().mayfly == false) p.getAbilities().flying = false;
        p.onUpdateAbilities();
        return InteractionResultHolder.success(p.getItemInHand(h));
    }
}
