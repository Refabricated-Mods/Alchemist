package io.github.unix_supremacist.content;

import io.github.unix_supremacist.Alchemist;
import io.github.unix_supremacist.item.ChalkItem;
import io.github.unix_supremacist.item.DestructionCatalystItem;
import io.github.unix_supremacist.item.GaleItem;
import io.github.unix_supremacist.item.PhilosophersStoneItem;
import lombok.Getter;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public enum AlchemistItems {
    alchemical_coal(6400),
    //archangels_smite,
    //black_hole_band,
    //catalytic_lens,
    chalk(new ChalkItem(AlchemistBlocks.transmutation_circle.getBlock(), new Properties().durability(64))),
    dark_matter,
    //dark_matter_pickaxe,
    //dark_matter_shovel,
    //dark_matter_hoe,
    //dark_matter_sword,
    //dark_matter_axe,
    //dark_matter_shears,
    //dark_matter_hammer,
    destruction_catalyst(new DestructionCatalystItem(new Properties())),
    //evertide_amulet,
    //gem_of_eternal_density,
    //harvest_goddess_band,
    //hyperkinetic_lens,
    iron_band,
    mobius_fuel(25600),
    philosophers_stone(new PhilosophersStoneItem(new Properties())),
    swiftwolfs_rending_gale(new GaleItem(new Properties())),
    //volcanite_amulet,
    ;
    @Getter Item item;
    AlchemistItems(){
        this(0);
    }

    AlchemistItems(int burntime){
        this(new Properties(), burntime);
    }

    AlchemistItems(Properties properties){
        this(new Item(properties), 0);
    }

    AlchemistItems(Properties properties, int burntime){
        this(new Item(properties), burntime);
    }

    AlchemistItems(Item item){
        this(item, 0);
    }

    AlchemistItems(Item item, int burntime){
        this.item = item;
        FuelRegistry.INSTANCE.add(item, burntime);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Alchemist.MODID, this.name()), item);
        ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(Alchemist.MODID, "tab"))).register(content -> {
            content.accept(item);
        });
    }
}
