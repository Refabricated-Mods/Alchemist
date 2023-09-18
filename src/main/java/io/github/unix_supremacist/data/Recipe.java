package io.github.unix_supremacist.data;

import io.github.unix_supremacist.Alchemist;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
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
        twoWayPhilStoneRecipe(Items.COAL, Items.CHARCOAL, 4, recipeoutput);
        twoWayPhilStoneRecipe(alchemical_coal.getItem(), Items.COAL, 4, recipeoutput);
        twoWayPhilStoneRecipe(mobius_fuel.getItem(), alchemical_coal.getItem(), 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.IRON_INGOT, Items.COPPER_INGOT, 8, recipeoutput);
        twoWayPhilStoneRecipe(Items.DIAMOND, Items.GOLD_INGOT, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.NETHERITE_SCRAP, Items.DIAMOND, 4, recipeoutput);
        twoWayPhilStoneRecipe(dark_matter.getItem(), Items.NETHERITE_BLOCK, 2, recipeoutput);
        philStoneRecipe(Items.FLINT, 3, Items.GRAVEL, 3, recipeoutput);
        twoWayPhilStoneRecipe(Items.GRAVEL, 4, Items.COBBLESTONE, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.DIRT, 4, Items.SAND, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.GRAVEL, 8, Items.DIRT, 8, recipeoutput);
        twoWayPhilStoneRecipe(Items.COBBLESTONE, 8, Items.SAND, 8, recipeoutput);
        twoWayPhilStoneRecipe(Items.CLAY_BALL, Items.STONE, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.RAW_COPPER, Items.CLAY, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.RAW_IRON, Items.RAW_COPPER, 8, recipeoutput);
        twoWayPhilStoneRecipe(Items.RAW_GOLD, Items.RAW_IRON, 8, recipeoutput);
        twoWayPhilStoneRecipe(Items.GUNPOWDER, Items.EMERALD, 1, recipeoutput);
        twoWayPhilStoneRecipe(Items.BLAZE_ROD, Items.GUNPOWDER, 2, recipeoutput);
        twoWayPhilStoneRecipe(Items.ENDER_PEARL, Items.BLAZE_ROD, 2, recipeoutput);

    }

    public void twoWayPhilStoneRecipe(Item first, Item second, int count, RecipeOutput recipeoutput){
        twoWayPhilStoneRecipe(first, 1, second, count, recipeoutput);
    }

    public void twoWayPhilStoneRecipe(Item first, int firstcount, Item second, int secondcount, RecipeOutput recipeoutput){
        philStoneRecipe(first, firstcount, second, secondcount, recipeoutput);
        philStoneRecipe(second, secondcount, first, firstcount, recipeoutput);
    }

    public void philStoneRecipe(Item output, int outputcount, Item input, int inputcount, RecipeOutput recipeoutput){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, outputcount)
                .requires(philosophers_stone.getItem())
                .requires(input, inputcount)
                .unlockedBy(RecipeProvider.getHasName(philosophers_stone.getItem()), RecipeProvider.has(philosophers_stone.getItem()))
                .save(recipeoutput, new ResourceLocation(Alchemist.MODID, output +"_to_"+input));
    }
}