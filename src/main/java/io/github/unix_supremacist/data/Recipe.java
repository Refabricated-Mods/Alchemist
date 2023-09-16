package io.github.unix_supremacist.data;

import io.github.unix_supremacist.Alchemist;
import io.github.unix_supremacist.content.AlchemistItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static io.github.unix_supremacist.content.AlchemistItems.*;

public class Recipe extends FabricRecipeProvider {
    public Recipe(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        twoWayPhilStoneRecipe(alchemical_coal.getItem(), Items.COAL, 4, consumer);
        twoWayPhilStoneRecipe(mobius_fuel.getItem(), alchemical_coal.getItem(), 4, consumer);
    }

    public void twoWayPhilStoneRecipe(Item first, Item second, int count, Consumer<FinishedRecipe> consumer){
        philStoneRecipe(first, 1, second, count, consumer);
        philStoneRecipe(second, count, first, 1, consumer);
    }

    public void philStoneRecipe(Item output, int outputcount, Item input, int inputcount, Consumer<FinishedRecipe> consumer){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputcount)
                .requires(philosophers_stone.getItem())
                .requires(input, inputcount)
                .unlockedBy(RecipeProvider.getHasName(philosophers_stone.getItem()), RecipeProvider.has(philosophers_stone.getItem()))
                .save(consumer, new ResourceLocation(Alchemist.MODID, output +"_to_"+input));
    }
}