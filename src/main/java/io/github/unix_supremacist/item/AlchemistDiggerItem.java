package io.github.unix_supremacist.item;

import io.github.unix_supremacist.interfaces.AreaBox;
import io.github.unix_supremacist.interfaces.Destroyer;
import io.github.unix_supremacist.interfaces.DurablityBar;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;

public class AlchemistDiggerItem extends DiggerItem implements AreaBox, Destroyer, DurablityBar {
    public AlchemistDiggerItem(float f, float g, Tier tier, TagKey<Block> tagKey, Properties properties) {
        super(f, g, tier, tagKey, properties);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        Vec3 look = entity.getLookAngle();
        ArrayList<BlockPos> blocks = getAreaFromFacing(Direction.getNearest(look.x(), look.y(), look.z()), pos, 1, 0);
        destroyArea(level, blocks, entity);
        return super.mineBlock(itemStack, level, state, pos, entity);
    }

    @Override
    public int getBarColor(ItemStack item) {
        return getColor(item.getMaxDamage(), item.getDamageValue());
    }

    @Override
    public Rarity getRarity(ItemStack s){
        return Rarity.EPIC;
    }
}
