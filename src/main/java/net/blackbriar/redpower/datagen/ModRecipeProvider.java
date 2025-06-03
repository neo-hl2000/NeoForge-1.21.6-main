package net.blackbriar.redpower.datagen;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.block.ModBlocks;
import net.blackbriar.redpower.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BISMUTH_SMELTABLES = List.of(
                ModItems.RAW_BISMUTH,
                ModBlocks.BISMUTH_ORE,
                ModBlocks.BISMUTH_DEEPSLATE_ORE);

        List<ItemLike> NICKEL_SMELTABLES = List.of(
                ModBlocks.NICKEL_ORE,
                ModBlocks.NICKEL_DEEPSLATE_ORE,
                ModItems.RAW_NICKEL,
                ModItems.NICKEL_DUST);

        List<ItemLike> PLATINUM_SMELTABLES = List.of(
                ModBlocks.PLATINUM_ORE,
                ModBlocks.PLATINUM_DEEPSLATE_ORE,
                ModItems.PLATINUM_DUST,
                ModItems.RAW_PLATINUM);

        List<ItemLike> SILVER_SMELTABLES = List.of(
                ModBlocks.SILVER_ORE,
                ModBlocks.SILVER_DEEPSLATE_ORE,
                ModItems.RAW_SILVER,
                ModItems.SILVER_DUST);

        List<ItemLike> TIN_SMELTABLES = List.of(
                ModBlocks.TIN_ORE,
                ModBlocks.TIN_DEEPSLATE_ORE,
                ModItems.RAW_TIN,
                ModItems.TIN_DUST);

        List<ItemLike> CRYSTAL_SMELTABLES = List.of(ModItems.AMETHYST_DUST);

        //SMELTING Recipes:
        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(),0.25f,30,"bismuth");
        oreSmelting(recipeOutput, NICKEL_SMELTABLES,RecipeCategory.MISC, ModItems.NICKEL_INGOT.get(),0.25f,600,"nickel");
        oreSmelting(recipeOutput, PLATINUM_SMELTABLES,RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(),0.25f,1000,"platinum");
        oreSmelting(recipeOutput, SILVER_SMELTABLES,RecipeCategory.MISC, ModItems.SILVER_INGOT.get(),0.25f,400,"silver");
        oreSmelting(recipeOutput, TIN_SMELTABLES,RecipeCategory.MISC, ModItems.TIN_INGOT.get(),0.25f,200,"tin");
        oreSmelting(recipeOutput, CRYSTAL_SMELTABLES,RecipeCategory.MISC, ModItems.AMETHYST_INGOT.get(),0.25f,20,"amethyst_dust");
        //END

        //BLASTING Recipes:
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES,RecipeCategory.MISC,ModItems.BISMUTH.get(),0.30f,25,"bismuth");
        oreBlasting(recipeOutput, NICKEL_SMELTABLES,RecipeCategory.MISC,ModItems.NICKEL_INGOT.get(),0.50f,500,"nickel");
        oreBlasting(recipeOutput, PLATINUM_SMELTABLES,RecipeCategory.MISC,ModItems.PLATINUM_INGOT.get(),0.75f,800,"platinum");
        oreBlasting(recipeOutput, SILVER_SMELTABLES,RecipeCategory.MISC,ModItems.SILVER_INGOT.get(),0.30f,300,"silver");
        oreBlasting(recipeOutput, TIN_SMELTABLES,RecipeCategory.MISC,ModItems.TIN_INGOT.get(),0.20f,100,"tin");
        oreBlasting(recipeOutput, CRYSTAL_SMELTABLES,RecipeCategory.MISC,ModItems.AMETHYST_INGOT.get(),0.30f,10,"amethyst_dust");
        //END

        //Shaped Recipe:
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.BISMUTH.get())
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput,"redpower:bismuth_block_from_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AMETHYST_INGOT_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.AMETHYST_INGOT.get())
                .unlockedBy("has_amethyst_ingot", has(ModItems.AMETHYST_INGOT))
                .save(recipeOutput,"redpower:amethyst_ingot_block_from_ingot");
        /// Nickel
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NICKEL_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.NICKEL_INGOT.get())
                .unlockedBy("has_nickel_ingot", has(ModItems.NICKEL_INGOT))
                .save(recipeOutput,"redpower:nickel_block_from_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NICKEL_INGOT.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.NICKEL_NUGGET.get())
                .unlockedBy("has_nickel_nugget", has(ModItems.NICKEL_NUGGET))
                .save(recipeOutput,"redpower:nickel_ingot_from_nugget");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_NICKEL_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.RAW_NICKEL.get())
                .unlockedBy("has_raw_nickel", has(ModItems.RAW_NICKEL))
                .save(recipeOutput,"redpower:raw_nickel_block_from_raw_nickel");
        /// END

        /// Platinum
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLATINUM_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.PLATINUM_INGOT.get())
                .unlockedBy("has_platinum_ingot", has(ModItems.PLATINUM_INGOT))
                .save(recipeOutput,"redpower:platinum_block_from_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.PLATINUM_NUGGET.get())
                .unlockedBy("has_platinum_nugget", has(ModItems.PLATINUM_NUGGET))
                .save(recipeOutput,"redpower:platinum_ingot_from_nugget");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_PLATINUM_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.RAW_PLATINUM.get())
                .unlockedBy("has_raw_nickel", has(ModItems.RAW_PLATINUM))
                .save(recipeOutput,"redpower:raw_platinum_block_from_raw_platinum");
        /// END

        /// Silver
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.SILVER_INGOT.get())
                .unlockedBy("has_silver_ingot", has(ModItems.SILVER_INGOT))
                .save(recipeOutput,"redpower:silver_block_from_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_INGOT.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.SILVER_NUGGET.get())
                .unlockedBy("has_silver_nugget", has(ModItems.SILVER_NUGGET))
                .save(recipeOutput,"redpower:silver_ingot_from_nugget");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_SILVER_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.RAW_SILVER.get())
                .unlockedBy("has_raw_nickel", has(ModItems.RAW_SILVER))
                .save(recipeOutput,"redpower:raw_silver_block_from_raw_silver");

        /// END

        /// Tin
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT))
                .save(recipeOutput,"redpower:tin_block_from_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TIN_INGOT.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.TIN_NUGGET.get())
                .unlockedBy("has_tin_nugget", has(ModItems.TIN_NUGGET))
                .save(recipeOutput,"redpower:tin_ingot_from_nugget");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.RAW_TIN.get())
                .unlockedBy("has_raw_tin", has(ModItems.RAW_TIN))
                .save(recipeOutput,"redpower:raw_tin_block_from_raw_tin");

        /// END
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CUP.get())
                .pattern("   ")
                .pattern("X X")
                .pattern("XXX")
                .define('X', Items.BRICK)
                .unlockedBy("has_cup",has(ModItems.CUP))
                .save(recipeOutput,"redpower:cup_from_brick");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HOT_COCO.get())
                .pattern("ABC")
                .pattern(" D ")
                .pattern("   ")
                .define('A', Items.COCOA_BEANS)
                .define('B', Items.SUGAR)
                .define('C',Items.MILK_BUCKET)
                .define('D',ModItems.CUP)
                .unlockedBy("has_cup",has(ModItems.HOT_COCO))
                .save(recipeOutput,"redpower:hot_coco_from_cup");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EBONY_WOOD.get(),3)
                .pattern("AA ")
                .pattern("AA ")
                .pattern("   ")
                .define('A',ModBlocks.EBONY_LOG)
                .unlockedBy("has_ebony_log",has(ModBlocks.EBONY_WOOD))
                .save(recipeOutput,"redpower:ebony_wood_from_ebony_log");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK,4)
                .pattern("   ")
                .pattern(" A ")
                .pattern(" A ")
                .define('A',ModBlocks.EBONY_PLANKS)
                .unlockedBy("has_ebony_planks",has(ModBlocks.EBONY_PLANKS))
                .save(recipeOutput,"redpower:sticks_from_ebony_planks");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EBONY_STAIRS,4)
                .pattern("  A")
                .pattern(" AA")
                .pattern("AAA")
                .define('A',ModBlocks.EBONY_PLANKS)
                .unlockedBy("has_ebony_planks",has(ModBlocks.EBONY_PLANKS))
                .save(recipeOutput,"redpower:ebony_stairs_from_ebony_planks");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EBONY_BUTTON,1)
                .pattern("   ")
                .pattern(" A ")
                .pattern("   ")
                .define('A',ModBlocks.EBONY_PLANKS)
                .unlockedBy("has_ebony_planks",has(ModBlocks.EBONY_PLANKS))
                .save(recipeOutput,"redpower:ebony_button_from_ebony_planks");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CHEST,1)
                .pattern("AAA")
                .pattern("A A")
                .pattern("AAA")
                .define('A',ModBlocks.EBONY_PLANKS)
                .unlockedBy("has_ebony_planks",has(ModBlocks.EBONY_PLANKS))
                .save(recipeOutput,"redpower:chest_from_ebony_planks");


        //Shapeless Recipe with output name so it won't conflict with other Recipes:
        //From Blocks to ingots
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.BISMUTH.get(), 9)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy("has_bismuth_block", has(ModBlocks.BISMUTH_BLOCK))
                .save(recipeOutput,"redpower:bismuth_block_to_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.NICKEL_INGOT.get(),9)
                .requires(ModBlocks.NICKEL_BLOCK)
                .unlockedBy("has_nickel_block",has(ModBlocks.NICKEL_BLOCK))
                .save(recipeOutput,"redpower:nickel_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.PLATINUM_INGOT.get(),9)
                .requires(ModBlocks.PLATINUM_BLOCK)
                .unlockedBy("has_platinum_block",has(ModBlocks.PLATINUM_BLOCK))
                .save(recipeOutput,"redpower:platinum_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.SILVER_INGOT.get(),9)
                .requires(ModBlocks.SILVER_BLOCK)
                .unlockedBy("has_silver_block",has(ModBlocks.SILVER_BLOCK))
                .save(recipeOutput,"redpower:silver_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.TIN_INGOT.get(),9)
                .requires(ModBlocks.TIN_BLOCK)
                .unlockedBy("has_tin_block",has(ModBlocks.TIN_BLOCK))
                .save(recipeOutput,"redpower:tin_ingot_from_block");
        //END:

        ///Wood EBONEY
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,ModBlocks.EBONY_PLANKS.get(),4)
                .requires(ModBlocks.EBONY_LOG)
                .unlockedBy("has_ebony_log",has(ModBlocks.EBONY_LOG))
                .save(recipeOutput,"redpower:planks_from_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,ModBlocks.EBONY_PLANKS.get(),4)
                .requires(ModBlocks.EBONY_WOOD)
                .unlockedBy("has_ebony_log",has(ModBlocks.EBONY_WOOD))
                .save(recipeOutput,"redpower:planks_from_wood");


        //From ingot to nugget
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.NICKEL_NUGGET.get(),9)
                .requires(ModItems.NICKEL_INGOT)
                .unlockedBy("has_nickel_ingot",has(ModItems.NICKEL_INGOT))
                .save(recipeOutput,"redpower:nickel_nugget_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.PLATINUM_NUGGET.get(),9)
                .requires(ModItems.PLATINUM_INGOT)
                .unlockedBy("has_platinum_ingot",has(ModItems.PLATINUM_INGOT))
                .save(recipeOutput,"redpower:platinum_nugget_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.SILVER_NUGGET.get(),9)
                .requires(ModItems.SILVER_INGOT)
                .unlockedBy("has_silver_ingot",has(ModItems.SILVER_INGOT))
                .save(recipeOutput,"redpower:silver_nugget_from_ingot");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.TIN_NUGGET.get(),9)
                .requires(ModItems.TIN_INGOT)
                .unlockedBy("has_tin_ingot",has(ModItems.TIN_INGOT))
                .save(recipeOutput,"redpower:tin_nugget_from_ingot");
        //END:


        //MagicBlock to bismuth Test Only OR as Reference
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.BISMUTH.get(), 9)
                .requires(ModBlocks.MagicBlock)
                .unlockedBy("has_magic_block", has(ModBlocks.MagicBlock))
                .save(recipeOutput, "redpower:bismuth_from_magic_block");


        //RAW Blocks to Raw Metals
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RAW_SILVER.get(),9)
                .requires(ModBlocks.RAW_SILVER_BLOCK)
                .unlockedBy("has_raw_silver_block",has(ModBlocks.RAW_SILVER_BLOCK))
                .save(recipeOutput,"redpower:raw_silver_from_raw_silver_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RAW_NICKEL.get(),9)
                .requires(ModBlocks.RAW_NICKEL_BLOCK)
                .unlockedBy("has_raw_nickel_block",has(ModBlocks.RAW_NICKEL_BLOCK))
                .save(recipeOutput, "redpower:raw_nickel_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RAW_PLATINUM.get(),9)
                .requires(ModBlocks.RAW_PLATINUM_BLOCK)
                .unlockedBy("has_raw_platinum_block",has(ModBlocks.RAW_PLATINUM_BLOCK))
                .save(recipeOutput,"redpower:raw_platinum_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RAW_TIN.get(),9)
                .requires(ModBlocks.RAW_TIN_BLOCK)
                .unlockedBy("has_raw_tin_block",has(ModBlocks.RAW_TIN_BLOCK))
                .save(recipeOutput,"redpower:raw_tin_block");
        //END:


        //CRYSTAL SHAPELESS RECIPES
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.AMETHYST_INGOT.get(), 9)
                .requires(ModBlocks.AMETHYST_INGOT_BLOCK)
                .unlockedBy("has_amethyst_ingot_block", has(ModBlocks.AMETHYST_INGOT_BLOCK))
                .save(recipeOutput, "redpower:amethyst_ingot_from_amethyst_ingot_block");
        //END:

        /// NON-BLOCK BLOCKS///
        doorBuilder(ModBlocks.REINFORCED_CONCRETE_DOOR.get(), Ingredient.of(ModBlocks.REINFORCED_CONCRETE.get())).group("reinforced_concrete")
                .unlockedBy("has_reinforced_concrete", has(ModBlocks.REINFORCED_CONCRETE.get())).save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.REINFORCED_PRESSURE_PLATE.get(), ModBlocks.REINFORCED_CONCRETE.get());

        buttonBuilder(ModBlocks.REINFORCED_BUTTON.get(), Ingredient.of(ModBlocks.REINFORCED_CONCRETE.get())).group("reinforced_concrete")
                .unlockedBy("has_bismuth", has(ModBlocks.REINFORCED_CONCRETE.get())).save(recipeOutput);

        stairBuilder(ModBlocks.EBONY_STAIRS.get(), Ingredient.of(ModBlocks.EBONY_PLANKS)).group("ebony")
                .unlockedBy("has_ebony", has(ModBlocks.EBONY_PLANKS)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_SLAB.get(), ModItems.BISMUTH.get());


        fenceBuilder(ModBlocks.BISMUTH_FENCE.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(recipeOutput);

        fenceGateBuilder(ModBlocks.BISMUTH_FENCE_GATE.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_WALL.get(), ModItems.BISMUTH.get());



        trapdoorBuilder(ModBlocks.BISMUTH_TRAPDOOR.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(recipeOutput);
    }
    /// END ///

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput,
                  RecipeSerializer<T> pCookingSerializer,
                  AbstractCookingRecipe.Factory<T> factory,
                  List<ItemLike> pIngredients,
                  RecipeCategory pCategory,
                  ItemLike pResult,
                  float pExperience,
                  int pCookingTime,
                  String pGroup,
                  String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(
                    Ingredient.of(itemlike),
                            pCategory,
                            pResult,
                            pExperience,
                            pCookingTime,
                            pCookingSerializer,
                            factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, RedPower.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
