package io.github.unix_supremacist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.HashSet;

public class AlchemistRegistry {
    public static HashSet<ArrayList<Block>> exchanges = new HashSet<>();
    public static ArrayList<Block> ground = new ArrayList<>();
    public static ArrayList<Block> wood = new ArrayList<>();
    public static void registerExchanges(){
        ground.add(Blocks.GRASS_BLOCK);
        ground.add(Blocks.DIRT);
        ground.add(Blocks.COBBLESTONE);
        ground.add(Blocks.STONE);
        ground.add(Blocks.SAND);
        ground.add(Blocks.GRAVEL);
        exchanges.add(ground);
        wood.add(Blocks.OAK_LOG);
        wood.add(Blocks.ACACIA_LOG);
        wood.add(Blocks.BIRCH_LOG);
        wood.add(Blocks.CHERRY_LOG);
        wood.add(Blocks.JUNGLE_LOG);
        wood.add(Blocks.DARK_OAK_LOG);
        wood.add(Blocks.MANGROVE_LOG);
        wood.add(Blocks.SPRUCE_LOG);
        wood.add(Blocks.CRIMSON_STEM);
        wood.add(Blocks.WARPED_STEM);
        wood.add(Blocks.STRIPPED_OAK_LOG);
        wood.add(Blocks.STRIPPED_ACACIA_LOG);
        wood.add(Blocks.STRIPPED_BIRCH_LOG);
        wood.add(Blocks.STRIPPED_CHERRY_LOG);
        wood.add(Blocks.STRIPPED_JUNGLE_LOG);
        wood.add(Blocks.STRIPPED_DARK_OAK_LOG);
        wood.add(Blocks.STRIPPED_MANGROVE_LOG);
        wood.add(Blocks.STRIPPED_SPRUCE_LOG);
        wood.add(Blocks.STRIPPED_CRIMSON_STEM);
        wood.add(Blocks.STRIPPED_WARPED_STEM);
        exchanges.add(wood);
    }

    public static Block getBlockWithOffset(Block b, ArrayList<Block> exchange, int o){
        int id = exchange.indexOf(b);
        int size = exchange.size();
        id += o;
        if (id < 0)
            id = size + id % size;
        else
            id %= size;
        return exchange.get(id);
    }
}
