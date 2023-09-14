package io.github.unix_supremacist.content;

import io.github.unix_supremacist.Alchemist;
import io.github.unix_supremacist.item.ChalkItem;
import io.github.unix_supremacist.item.DestructionCatalystItem;
import io.github.unix_supremacist.item.PhilosophersStoneItem;
import lombok.Getter;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.resources.ResourceKey;

public enum AlchemistItems {
    alchemical_coal,
    chalk(new ChalkItem(AlchemistBlocks.transmutation_circle.getBlock(), new Properties().durability(64))),
    destruction_catalyst(new DestructionCatalystItem(new Properties())),
    mobius_fuel,
    philosophers_stone(new PhilosophersStoneItem(new Properties()));

    @Getter Item item;
    AlchemistItems(Item item){
        this.item = item;
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Alchemist.MODID, this.name()), item);
        ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(Alchemist.MODID, "tab"))).register(content -> {
            content.accept(item);
        });
    }

    AlchemistItems(Properties properties){
        this(new Item(properties));
    }

    AlchemistItems(){
        this(new Properties());
    }
}
