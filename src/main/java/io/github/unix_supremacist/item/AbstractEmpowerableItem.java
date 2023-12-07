package io.github.unix_supremacist.item;

import io.github.unix_supremacist.interfaces.DurablityBar;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class AbstractEmpowerableItem extends Item implements DurablityBar {
    protected final int maxPower;
    public AbstractEmpowerableItem(Properties properties, int maxPower) {
        super(properties);
        this.maxPower = maxPower;
    }

    @Override
    public int getBarColor(ItemStack item) {
        return getColor(this.maxPower, getPower(item));
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
