package io.github.unix_supremacist.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class AbstractEmpowerableItem extends Item {
    protected final int maxPower;
    public AbstractEmpowerableItem(Properties properties, int maxPower) {
        super(properties);
        this.maxPower = maxPower;
    }

    @Override
    public int getBarColor(ItemStack item) {
        float f = Math.max(0.0F, ((float)this.maxPower - (float)getPower(item)) / (float)this.maxPower);
        return Mth.hsvToRgb(f / 1.1F, 1.0F, 1.0F);
    }

    @Override
    public boolean isBarVisible(ItemStack item) {
        return getPower(item) > 0;
    }

    public int getPower(ItemStack item){
        if (item.getTag() != null){
            return item.getTag().getInt("alchemist.empowered");
        } else {
            item.setTag(new CompoundTag());
            return 0;
        }
    }

    public void setPower(ItemStack item, int i){
        if (item.getTag() != null){
            item.getTag().putInt("alchemist.empowered", i);
        } else {
            CompoundTag tag = new CompoundTag();
            tag.putInt("alchemist.empowered", i);
            item.setTag(tag);
        }
    }

    public void empower(ItemStack item, Player p){
        if(isBarVisible(item))
            setPower(item, getPower(item)-1);
        else
            setPower(item,maxPower-1);
    }

    @Override
    public int getBarWidth(ItemStack item) {
        return Math.round(13.0F - (float)getPower(item) * 13.0F / (float)this.maxPower);
    }

    @Override
    public Rarity getRarity(ItemStack s){
        return Rarity.EPIC;
    }
}
