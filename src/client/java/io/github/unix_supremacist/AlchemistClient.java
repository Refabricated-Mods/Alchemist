package io.github.unix_supremacist;

import io.github.unix_supremacist.content.AlchemistBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class AlchemistClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		//KeyMapping empower = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.alchemist.empower", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V, "key.categories.alchemist"));
		BlockRenderLayerMap.INSTANCE.putBlock(AlchemistBlocks.transmutation_circle.getBlock(), RenderType.cutout());

		/*ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (empower.isDown()) Alchemist.empowerByKey(empower.isDown(), client.player.getMainHandItem());
		});*/
	}
}