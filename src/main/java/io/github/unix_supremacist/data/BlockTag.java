package io.github.unix_supremacist.data;

import dev.emi.trinkets.TrinketsMain;
import io.github.unix_supremacist.Alchemist;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static io.github.unix_supremacist.content.AlchemistItems.swiftwolfs_rending_gale;

public class BlockTag extends FabricTagProvider.BlockTagProvider {
    public static TagKey<Block> terratag = TagKey.create(BuiltInRegistries.BLOCK.key(), new ResourceLocation(Alchemist.MODID, "terra"));
    public static TagKey<Block> woodtag = TagKey.create(BuiltInRegistries.BLOCK.key(), new ResourceLocation(Alchemist.MODID, "wood"));
    public static TagKey<Block> netherwoodtag = TagKey.create(BuiltInRegistries.BLOCK.key(), new ResourceLocation(Alchemist.MODID, "netherwood"));
    public static TagKey<Block> leavetag = TagKey.create(BuiltInRegistries.BLOCK.key(), new ResourceLocation(Alchemist.MODID, "leave"));
    public static TagKey<Block> stonetag = TagKey.create(BuiltInRegistries.BLOCK.key(), new ResourceLocation(Alchemist.MODID, "stone"));

    public BlockTag(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        FabricTagBuilder terra = getOrCreateTagBuilder(terratag);
        FabricTagBuilder wood = getOrCreateTagBuilder(woodtag);
        FabricTagBuilder netherwood = getOrCreateTagBuilder(woodtag);
        FabricTagBuilder leave = getOrCreateTagBuilder(leavetag);
        FabricTagBuilder stone = getOrCreateTagBuilder(stonetag);
        terra.add(Blocks.GRASS_BLOCK);
        terra.add(Blocks.DIRT);
        terra.add(Blocks.COARSE_DIRT);
        terra.add(Blocks.COBBLESTONE);
        terra.add(Blocks.COBBLED_DEEPSLATE);
        terra.add(Blocks.STONE);
        terra.add(Blocks.DEEPSLATE);
        terra.add(Blocks.SAND);
        terra.add(Blocks.RED_SAND);
        terra.add(Blocks.GRAVEL);
        wood.add(Blocks.OAK_LOG);
        wood.add(Blocks.ACACIA_LOG);
        wood.add(Blocks.BIRCH_LOG);
        wood.add(Blocks.CHERRY_LOG);
        wood.add(Blocks.JUNGLE_LOG);
        wood.add(Blocks.DARK_OAK_LOG);
        wood.add(Blocks.MANGROVE_LOG);
        wood.add(Blocks.SPRUCE_LOG);
        wood.add(Blocks.STRIPPED_OAK_LOG);
        wood.add(Blocks.STRIPPED_ACACIA_LOG);
        wood.add(Blocks.STRIPPED_BIRCH_LOG);
        wood.add(Blocks.STRIPPED_CHERRY_LOG);
        wood.add(Blocks.STRIPPED_JUNGLE_LOG);
        wood.add(Blocks.STRIPPED_DARK_OAK_LOG);
        wood.add(Blocks.STRIPPED_MANGROVE_LOG);
        wood.add(Blocks.STRIPPED_SPRUCE_LOG);
        wood.add(Blocks.OAK_WOOD);
        wood.add(Blocks.ACACIA_LOG);
        wood.add(Blocks.BIRCH_LOG);
        wood.add(Blocks.CHERRY_LOG);
        wood.add(Blocks.JUNGLE_LOG);
        wood.add(Blocks.DARK_OAK_LOG);
        wood.add(Blocks.MANGROVE_LOG);
        wood.add(Blocks.SPRUCE_LOG);
        netherwood.add(Blocks.CRIMSON_STEM);
        netherwood.add(Blocks.WARPED_STEM);
        netherwood.add(Blocks.STRIPPED_CRIMSON_STEM);
        netherwood.add(Blocks.STRIPPED_WARPED_STEM);
        leave.add(Blocks.OAK_LEAVES);
        leave.add(Blocks.ACACIA_LEAVES);
        leave.add(Blocks.BIRCH_LEAVES);
        leave.add(Blocks.CHERRY_LEAVES);
        leave.add(Blocks.JUNGLE_LEAVES);
        leave.add(Blocks.DARK_OAK_LEAVES);
        leave.add(Blocks.MANGROVE_LEAVES);
        leave.add(Blocks.SPRUCE_LEAVES);
        leave.add(Blocks.NETHER_WART_BLOCK);
        leave.add(Blocks.WARPED_WART_BLOCK);
        stone.add(Blocks.ANDESITE);
        stone.add(Blocks.DIORITE);
        stone.add(Blocks.GRANITE);
    }
}
