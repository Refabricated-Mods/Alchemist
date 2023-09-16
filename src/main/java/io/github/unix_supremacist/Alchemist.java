package io.github.unix_supremacist;

import io.github.unix_supremacist.content.AlchemistBlocks;
import io.github.unix_supremacist.content.AlchemistItems;
import io.github.unix_supremacist.content.AlchemistSplashes;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Alchemist {
    public static final String MODID = "alchemist";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
    public static final CreativeModeTab tab = FabricItemGroup.builder()
            .icon(() -> new ItemStack(AlchemistItems.philosophers_stone.getItem()))
            .title(Component.translatable("itemGroup."+MODID))
            .build();


    public static void Init(){
        LOGGER.info("Welcome to the World of Alchemy!");
        AlchemistRegistry.registerExchanges();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MODID, "tab"), tab);
        AlchemistSplashes.init();
        AlchemistBlocks.values(); //force the enum to load
        AlchemistItems.values(); //force the enum to load
    }
}
