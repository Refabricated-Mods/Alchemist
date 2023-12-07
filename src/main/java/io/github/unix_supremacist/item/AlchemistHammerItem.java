package io.github.unix_supremacist.item;

import io.github.unix_supremacist.interfaces.AreaBox;
import io.github.unix_supremacist.interfaces.Destroyer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;

public class AlchemistHammerItem extends AlchemistDiggerItem implements AreaBox, Destroyer {

    public AlchemistHammerItem(Tier tier, int i, float f, Properties properties) {
        super(i, f, tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        Vec3 look = entity.getLookAngle();
        Direction dir = Direction.getNearest(look.x(), look.y(), look.z());
        ArrayList<BlockPos> blocks = getAreaFromFacing(dir, pos, 1, 0);
        destroyArea(level, blocks, entity);
        return super.mineBlock(itemStack, level, state, pos, entity);
    }
}
