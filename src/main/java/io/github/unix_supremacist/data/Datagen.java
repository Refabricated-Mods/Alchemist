package io.github.unix_supremacist.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class Datagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(ItemTag::new);
        fabricDataGenerator.addProvider(BlockTag::new);
        fabricDataGenerator.addProvider(Recipe::new);
        fabricDataGenerator.addProvider(Language::new);
    }
}
