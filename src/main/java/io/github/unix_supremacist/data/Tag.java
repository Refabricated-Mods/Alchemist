package io.github.unix_supremacist.data;

import io.github.unix_supremacist.Alchemist;
import io.github.unix_supremacist.content.AlchemistItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import java.util.concurrent.CompletableFuture;

public class Tag extends FabricTagProvider.ItemTagProvider {
    public Tag(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(TagKey.create(BuiltInRegistries.ITEM.key(), new ResourceLocation(Alchemist.MODID, "philosophers_stone"))).add(AlchemistItems.philosophers_stone.getItem());
    }
}
