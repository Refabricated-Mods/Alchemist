package io.github.unix_supremacist.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import io.github.ladysnake.pal.AbilitySource;
import io.github.ladysnake.pal.Pal;
import io.github.ladysnake.pal.VanillaAbilities;
import io.github.unix_supremacist.Alchemist;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class GaleItem extends TrinketItem {
    public GaleItem(Properties properties) {
        super(properties);
    }
    public static final AbilitySource gale_ability = Pal.getAbilitySource(Alchemist.MODID, "swiftwolfs_rending_gale");

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.level().isClientSide())
            if (entity instanceof Player)
                gale_ability.grantTo((Player) entity, VanillaAbilities.ALLOW_FLYING);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.level().isClientSide())
            if (entity instanceof Player)
                gale_ability.revokeFrom((Player) entity, VanillaAbilities.ALLOW_FLYING);
    }
}
