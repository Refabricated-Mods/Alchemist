package io.github.unix_supremacist;

import io.github.unix_supremacist.alabli.Alabli;
import io.github.unix_supremacist.content.AlchemistBlocks;
import io.github.unix_supremacist.content.AlchemistItems;
import io.github.unix_supremacist.content.AlchemistSplashes;
import io.github.unix_supremacist.data.BlockTag;
import io.github.unix_supremacist.item.AbstractEmpowerableItem;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class Alchemist {
    public static final String MODID = "alchemist";
    public static final ResourceLocation empower_packet = new ResourceLocation(Alchemist.MODID, "empower_packet");



    public static void Init(){
        AlchemistSplashes.init();
        AlchemistBlocks.values(); //force the enum to load
        AlchemistItems.values(); //force the enum to load
        Alabli.initializeCreativeTab();
        CommonLifecycleEvents.TAGS_LOADED.register((registries, client) -> {
            BlockTag.init();
        });
        ServerPlayNetworking.registerGlobalReceiver(empower_packet, (server, player, handler, buf, responseSender) -> {
            ItemStack item = player.getMainHandItem();
            if(item.getItem() instanceof AbstractEmpowerableItem){
                ((AbstractEmpowerableItem) item.getItem()).empower(item, player);
            }
        });
    }
}
