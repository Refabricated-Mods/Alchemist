package io.github.unix_supremacist.data;

import io.github.unix_supremacist.Alchemist;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.registries.BuiltInRegistries;
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
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, swiftwolfs_rending_gale.getItem())
                .pattern("D")
                .pattern("B")
                .define('D', dark_matter.getItem())
                .define('B', iron_band.getItem())
                .unlockedBy(RecipeProvider.getHasName(dark_matter.getItem()), RecipeProvider.has(dark_matter.getItem()))
                .unlockedBy(RecipeProvider.getHasName(iron_band.getItem()), RecipeProvider.has(iron_band.getItem()))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, iron_band.getItem())
                .pattern("III")
                .pattern("ILI")
                .pattern("III")
                .define('I', Items.IRON_INGOT)
                .define('L', ItemTag.lava_bucket)
                .unlockedBy(RecipeProvider.getHasName(Items.IRON_INGOT), RecipeProvider.has(Items.IRON_INGOT))
                .unlockedBy(RecipeProvider.getHasName(Items.LAVA_BUCKET), RecipeProvider.has(Items.LAVA_BUCKET))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, catalytic_lens.getItem())
                .pattern("DDD")
                .pattern("CDC")
                .pattern("DDD")
                .define('D', red_matter.getItem())
                .define('C', destruction_catalyst.getItem())
                .unlockedBy(RecipeProvider.getHasName(red_matter.getItem()), RecipeProvider.has(red_matter.getItem()))
                .unlockedBy(RecipeProvider.getHasName(destruction_catalyst.getItem()), RecipeProvider.has(destruction_catalyst.getItem()))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, destruction_catalyst.getItem())
                .pattern("FRF")
                .pattern("ASA")
                .pattern("FRF")
                .define('F', Items.FLINT_AND_STEEL)
                .define('A', aeternalis_fuel.getItem())
                .define('S', philosophers_stone.getItem())
                .define('R', red_matter.getItem())
                .unlockedBy(RecipeProvider.getHasName(Items.FLINT_AND_STEEL), RecipeProvider.has(Items.FLINT_AND_STEEL))
                .unlockedBy(RecipeProvider.getHasName(aeternalis_fuel.getItem()), RecipeProvider.has(aeternalis_fuel.getItem()))
                .unlockedBy(RecipeProvider.getHasName(philosophers_stone.getItem()), RecipeProvider.has(philosophers_stone.getItem()))
                .unlockedBy(RecipeProvider.getHasName(red_matter.getItem()), RecipeProvider.has(red_matter.getItem()))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, volcanite_amulet.getItem())
                .pattern("LLL")
                .pattern("DDD")
                .pattern("LLL")
                .define('D', dark_matter.getItem())
                .define('L', ItemTag.lava_bucket)
                .unlockedBy(RecipeProvider.getHasName(dark_matter.getItem()), RecipeProvider.has(dark_matter.getItem()))
                .unlockedBy(RecipeProvider.getHasName(Items.LAVA_BUCKET), RecipeProvider.has(Items.LAVA_BUCKET))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, evertide_amulet.getItem())
                .pattern("WWW")
                .pattern("DDD")
                .pattern("WWW")
                .define('D', dark_matter.getItem())
                .define('W', ItemTag.water_bucket)
                .unlockedBy(RecipeProvider.getHasName(dark_matter.getItem()), RecipeProvider.has(dark_matter.getItem()))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, chalk.getItem())
                .pattern("CD")
                .pattern("D ")
                .define('D', Items.DIORITE)
                .define('C', Items.CLAY_BALL)
                .unlockedBy(RecipeProvider.getHasName(Items.DIORITE), RecipeProvider.has(Items.DIORITE))
                .unlockedBy(RecipeProvider.getHasName(Items.CLAY_BALL), RecipeProvider.has(Items.CLAY_BALL))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COBBLESTONE)
                .pattern("WPL")
                .define('W', ItemTag.water_bucket)
                .define('P', philosophers_stone.getItem())
                .define('L', ItemTag.lava_bucket)
                .unlockedBy(RecipeProvider.getHasName(Items.LAVA_BUCKET), RecipeProvider.has(Items.LAVA_BUCKET))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .unlockedBy(RecipeProvider.getHasName(philosophers_stone.getItem()), RecipeProvider.has(philosophers_stone.getItem()))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.OBSIDIAN)
                .pattern("PWL")
                .define('W', ItemTag.water_bucket)
                .define('P', philosophers_stone.getItem())
                .define('L', ItemTag.lava_bucket)
                .unlockedBy(RecipeProvider.getHasName(Items.LAVA_BUCKET), RecipeProvider.has(Items.LAVA_BUCKET))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .unlockedBy(RecipeProvider.getHasName(philosophers_stone.getItem()), RecipeProvider.has(philosophers_stone.getItem()))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STONE)
                .pattern("PLW")
                .define('W', ItemTag.water_bucket)
                .define('P', philosophers_stone.getItem())
                .define('L', ItemTag.lava_bucket)
                .unlockedBy(RecipeProvider.getHasName(Items.LAVA_BUCKET), RecipeProvider.has(Items.LAVA_BUCKET))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .unlockedBy(RecipeProvider.getHasName(philosophers_stone.getItem()), RecipeProvider.has(philosophers_stone.getItem()))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, dark_matter.getItem())
                .pattern("MMM")
                .pattern("MNM")
                .pattern("MMM")
                .define('M', mobius_fuel.getItem())
                .define('N', Items.NETHERITE_BLOCK)
                .unlockedBy(RecipeProvider.getHasName(mobius_fuel.getItem()), RecipeProvider.has(mobius_fuel.getItem()))
                .unlockedBy(RecipeProvider.getHasName(Items.NETHERITE_BLOCK), RecipeProvider.has(Items.NETHERITE_BLOCK))
                .save(recipeoutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, red_matter.getItem())
                .pattern("AAA")
                .pattern("DDD")
                .pattern("AAA")
                .define('D', dark_matter.getItem())
                .define('A', aeternalis_fuel.getItem())
                .unlockedBy(RecipeProvider.getHasName(dark_matter.getItem()), RecipeProvider.has(dark_matter.getItem()))
                .unlockedBy(RecipeProvider.getHasName(aeternalis_fuel.getItem()), RecipeProvider.has(aeternalis_fuel.getItem()))
                .save(recipeoutput);
        twoWayPhilStoneRecipe(Items.COAL, Items.CHARCOAL, 1, recipeoutput);
        philStoneRecipe(coal_coke.getItem(), 2, Items.COAL, 2, recipeoutput);
        twoWayPhilStoneRecipe(alchemical_coal.getItem(), coal_coke.getItem(), 8, recipeoutput);
        twoWayPhilStoneRecipe(mobius_fuel.getItem(), alchemical_coal.getItem(), 8, recipeoutput);
        twoWayPhilStoneRecipe(aeternalis_fuel.getItem(), mobius_fuel.getItem(), 8, recipeoutput);

        twoWayPhilStoneRecipe(Items.COPPER_INGOT, BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:tin_ingot")), 1, recipeoutput);
        twoWayPhilStoneRecipe(Items.IRON_INGOT, Items.COPPER_INGOT, 8, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:aluminum_ingot")), Items.IRON_INGOT, 2, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:nickel_ingot")), BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:aluminum_ingot")), 2, recipeoutput);

        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:silver_ingot")), BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:lead_ingot")), 2, recipeoutput);
        twoWayPhilStoneRecipe(Items.GOLD_INGOT, BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:silver_ingot")), 2, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:peridot_gem")), BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:yellow_garnet_gem")), 2, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:ruby_gem")), BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:red_garnet_gem")), 2, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:peridot_gem")), 6, BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:ruby_gem")), 6, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:peridot_gem")), 8, BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:sapphire_gem")), 8, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:ruby_gem")), 4, BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:sapphire_gem")), 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.DIAMOND, Items.GOLD_INGOT, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.DIAMOND,2, BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:ruby_gem")), 8, recipeoutput);
        twoWayPhilStoneRecipe(Items.NETHERITE_SCRAP, Items.DIAMOND, 4, recipeoutput);

        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:platinum_ingot")), BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:titanium_ingot")), 2, recipeoutput);
        twoWayPhilStoneRecipe(Items.NETHERITE_INGOT, BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:platinum_ingot")), 2, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:tungsten_ingot")), Items.NETHERITE_INGOT, 2, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:iridium_ingot")), BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:tungsten_ingot")), 2, recipeoutput);

        philStoneRecipe(Items.FLINT, 3, Items.GRAVEL, 3, recipeoutput);
        twoWayPhilStoneRecipe(Items.GRAVEL, 4, Items.COBBLESTONE, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.DIRT, 4, Items.SAND, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.GRAVEL, 8, Items.DIRT, 8, recipeoutput);
        twoWayPhilStoneRecipe(Items.COBBLESTONE, 8, Items.SAND, 8, recipeoutput);
        twoWayPhilStoneRecipe(Items.CLAY_BALL, Items.STONE, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.RAW_COPPER, 2, BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:raw_tin")), 2, recipeoutput);
        twoWayPhilStoneRecipe(Items.RAW_COPPER, Items.CLAY, 4, recipeoutput);
        twoWayPhilStoneRecipe(Items.RAW_IRON, Items.RAW_COPPER, 8, recipeoutput);
        twoWayPhilStoneRecipe(BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:raw_silver")), BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:raw_lead")), 2, recipeoutput);
        twoWayPhilStoneRecipe(Items.RAW_GOLD, 2, BuiltInRegistries.ITEM.get(new ResourceLocation("techreborn:raw_silver")), 4, recipeoutput);
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