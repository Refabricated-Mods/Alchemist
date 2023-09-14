package io.github.unix_supremacist;

import net.fabricmc.api.ModInitializer;

public class Entrypoint implements ModInitializer {


	@Override
	public void onInitialize() {
		Alchemist.Init();
	}
}