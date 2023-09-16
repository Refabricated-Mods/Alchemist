package io.github.unix_supremacist.data;

import io.github.unix_supremacist.Alchemist;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static io.github.unix_supremacist.content.AlchemistItems.*;

public class Recipe extends FabricRecipeProvider {
    public Recipe(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeoutput) {
        twoWayPhilStoneRecipe(alchemical_coal.getItem(), Items.COAL, 4, recipeoutput);
        twoWayPhilStoneRecipe(mobius_fuel.getItem(), alchemical_coal.getItem(), 4, recipeoutput);
    }

    public void twoWayPhilStoneRecipe(Item first, Item second, int count, RecipeOutput recipeoutput){
        philStoneRecipe(first, 1, second, count, recipeoutput);
        philStoneRecipe(second, count, first, 1, recipeoutput);
    }

    public void philStoneRecipe(Item output, int outputcount, Item input, int inputcount, RecipeOutput recipeoutput){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputcount)
                .requires(philosophers_stone.getItem())
                .requires(input, inputcount)
                .unlockedBy(RecipeProvider.getHasName(philosophers_stone.getItem()), RecipeProvider.has(philosophers_stone.getItem()))
                .save(recipeoutput, new ResourceLocation(Alchemist.MODID, output +"_to_"+input));
    }
}