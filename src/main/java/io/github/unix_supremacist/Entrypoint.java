package io.github.unix_supremacist;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Alchemist.MODID)
public class Entrypoint {

	public Entrypoint() {

	}

	private void commonSetup(final FMLCommonSetupEvent event){
		Alchemist.Init();
	}
}