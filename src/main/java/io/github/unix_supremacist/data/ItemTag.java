package io.github.unix_supremacist.data;

import dev.emi.trinkets.TrinketsMain;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

import static io.github.unix_supremacist.content.AlchemistItems.*;

public class ItemTag extends FabricTagProvider<Item> {
    public static String common = "c";
    public static TagKey<Item> handring = TagKey.create(Registry.ITEM.key(), new ResourceLocation(TrinketsMain.MOD_ID, "hand/ring"));
    public static TagKey<Item> offhandring = TagKey.create(Registry.ITEM.key(), new ResourceLocation(TrinketsMain.MOD_ID, "offhand/ring"));
    public static TagKey<Item> water_bucket = TagKey.create(Registry.ITEM.key(), new ResourceLocation(common, "water_buckets"));
    public static TagKey<Item> lava_bucket = TagKey.create(Registry.ITEM.key(), new ResourceLocation(common, "lava_buckets"));

    public ItemTag(FabricDataGenerator dataGenerator) {
        super(dataGenerator, Registry.ITEM);
    }

    @Override
    protected void generateTags() {
        getOrCreateTagBuilder(handring).add(swiftwolfs_rending_gale.getItem());
        getOrCreateTagBuilder(offhandring).add(swiftwolfs_rending_gale.getItem());
        getOrCreateTagBuilder(water_bucket).add(evertide_amulet.getItem());
        getOrCreateTagBuilder(lava_bucket).add(volcanite_amulet.getItem());
    }
}
