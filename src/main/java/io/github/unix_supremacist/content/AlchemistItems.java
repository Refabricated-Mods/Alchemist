package io.github.unix_supremacist.content;

import io.github.unix_supremacist.Alchemist;
import io.github.unix_supremacist.item.*;
import lombok.Getter;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Blocks;

public enum AlchemistItems {
    alchemical_coal(25600),
    aeternalis_fuel(1638400),
    //black_hole_band,
    catalytic_lens(new DestructionItem(new Properties().tab(Alchemist.tab).stacksTo(1), 3, 10, 5)),
    chalk(new AlchemistBlockItem(AlchemistBlocks.transmutation_circle.getBlock(), new Properties().tab(Alchemist.tab).durability(64))),
    coal_coke(3200),
    dark_matter,
    //dark_matter_pickaxe,
    //dark_matter_shovel,
    //dark_matter_hoe,
    //dark_matter_sword,
    //dark_matter_axe,
    //dark_matter_shears,

    dark_matter_hammer(new AlchemistHammerItem(Tiers.NETHERITE, 1, -2.8f, new Properties().tab(Alchemist.tab))),
    destruction_catalyst(new DestructionItem(new Properties().tab(Alchemist.tab).stacksTo(1), 3, 5, 1)),
    evertide_amulet(new AlchemistBlockItem(Blocks.WATER, new Properties().tab(Alchemist.tab).stacksTo(1))),
    //gem_of_eternal_density,
    //harvest_goddess_band,
    //hyperkinetic_lens,
    iron_band,
    mobius_fuel(204800),
    philosophers_stone(new PhilosophersStoneItem(new Properties().tab(Alchemist.tab).stacksTo(1))),
    red_matter,
    swiftwolfs_rending_gale(new GaleItem(new Properties().stacksTo(1))),
    volcanite_amulet(new AlchemistBlockItem(Blocks.LAVA, new Properties().tab(Alchemist.tab).durability(64))),
    ;
    @Getter Item item;
    AlchemistItems(){
        this(0);
    }

    AlchemistItems(int burntime){
        this(new Properties().tab(Alchemist.tab), burntime);
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
        Registry.register(Registry.ITEM, new ResourceLocation(Alchemist.MODID, this.name()), item);
    }
}
