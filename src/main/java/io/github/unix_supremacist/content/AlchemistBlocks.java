package io.github.unix_supremacist.content;

import io.github.unix_supremacist.Alchemist;
import io.github.unix_supremacist.block.TransmutionCircleBlock;
import lombok.Getter;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public enum AlchemistBlocks {
    transmutation_circle(new TransmutionCircleBlock(FabricBlockSettings.of(Material.AIR)));
    @Getter Block block;

    AlchemistBlocks(Block block){
        this.block = block;
        Registry.register(Registry.BLOCK, new ResourceLocation(Alchemist.MODID, this.name()), block);
    }
}
