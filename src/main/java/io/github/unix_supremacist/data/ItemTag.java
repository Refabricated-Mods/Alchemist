package io.github.unix_supremacist.data;

import dev.emi.trinkets.TrinketsMain;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

import static io.github.unix_supremacist.content.AlchemistItems.swiftwolfs_rending_gale;

public class ItemTag extends FabricTagProvider.ItemTagProvider {
    public static TagKey<Item> handring = TagKey.create(BuiltInRegistries.ITEM.key(), new ResourceLocation(TrinketsMain.MOD_ID, "hand/ring"));
    public static TagKey<Item> offhandring = TagKey.create(BuiltInRegistries.ITEM.key(), new ResourceLocation(TrinketsMain.MOD_ID, "offhand/ring"));

    public ItemTag(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(handring).add(swiftwolfs_rending_gale.getItem());
        getOrCreateTagBuilder(offhandring).add(swiftwolfs_rending_gale.getItem());
    }
}
