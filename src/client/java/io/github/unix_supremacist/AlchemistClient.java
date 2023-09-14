package io.github.unix_supremacist;

import io.github.unix_supremacist.content.AlchemistBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class AlchemistClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(AlchemistBlocks.transmutation_circle.getBlock(), RenderType.cutout());
	}
}