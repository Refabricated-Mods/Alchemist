package io.github.unix_supremacist;

import io.github.unix_supremacist.data.BlockTag;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.HashSet;

public class AlchemistRegistry {
    public static HashSet<ArrayList<Block>> exchanges = new HashSet<>();
    public static ArrayList<Block> terra = new ArrayList<>();
    public static ArrayList<Block> wood = new ArrayList<>();
    public static ArrayList<Block> leave = new ArrayList<>();

    public static void registerExchanges(){
        CommonLifecycleEvents.TAGS_LOADED.register((registries, client) -> {
            BuiltInRegistries.BLOCK.getTagOrEmpty(BlockTag.terratag).iterator().forEachRemaining(t ->terra.add(t.value()));
            BuiltInRegistries.BLOCK.getTagOrEmpty(BlockTag.woodtag).iterator().forEachRemaining(t ->wood.add(t.value()));
            BuiltInRegistries.BLOCK.getTagOrEmpty(BlockTag.leavetag).iterator().forEachRemaining(t ->leave.add(t.value()));
            exchanges.add(terra);
            exchanges.add(wood);
            exchanges.add(leave);
        });
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
