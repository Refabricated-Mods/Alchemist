package io.github.unix_supremacist.content;

import io.github.unix_supremacist.Alchemist;
import io.github.unix_supremacist.alabli.Alabli;
import io.github.unix_supremacist.alabli.AlabliRegistry;
import io.github.unix_supremacist.block.TransmutionCircleBlock;
import lombok.Getter;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public enum AlchemistBlocks {
    transmutation_circle(new TransmutionCircleBlock(Alabli.properties));
    @Getter Block block;

    AlchemistBlocks(Block block){
        this.block = block;
        AlabliRegistry.registerBlock(block, this.name());
    }
}
