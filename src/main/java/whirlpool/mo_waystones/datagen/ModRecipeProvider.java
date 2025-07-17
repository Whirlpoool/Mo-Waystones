package whirlpool.mo_waystones.datagen;

import net.blay09.mods.waystones.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import whirlpool.mo_waystones.registry.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ICE_WAYSTONE.get())
                .pattern(" B ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', Blocks.ICE)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CALCITE_WAYSTONE.get())
                .pattern(" B ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', Blocks.CALCITE)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MUD_BRICKS_WAYSTONE.get())
                .pattern(" B ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', Blocks.MUD_BRICKS)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SCULK_WAYSTONE.get())
                .pattern(" B ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', Blocks.SCULK)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NETHER_BRICKS_WAYSTONE.get())
                .pattern(" B ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', Blocks.NETHER_BRICKS)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TUFF_BRICKS_WAYSTONE.get())
                .pattern(" B ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', Blocks.TUFF_BRICKS)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TUFF_WAYSTONE.get())
                .pattern(" B ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', Blocks.TUFF)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DIVINE_BRICKS_WAYSTONE.get())
                .pattern(" B ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', ModBlocks.DIVINE_BRICKS)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DIVINE_WAYSTONE.get())
                .pattern(" B ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', ModBlocks.STABLE_DIVINE_STONE)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);






        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POLISHED_CALCITE_WAYSTONE.get())
                .pattern(" I ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', Blocks.CALCITE)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .define('I', Items.COAL)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SEA_STONE_WAYSTONE.get())
                .pattern(" I ")
                .pattern("BWB")
                .pattern("OOO")
                .define('B', Items.PRISMARINE_SHARD)
                .define('W', ModItems.warpStone)
                .define('O', Blocks.OBSIDIAN)
                .define('I', Items.PRISMARINE_CRYSTALS)
                .unlockedBy("has_warp_stone", has(ModItems.warpStone)).save(recipeOutput);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.UNSTABLE_DIVINE_STONE.get(), 4)
                .pattern("OW")
                .pattern("OO")
                .define('W', Items.PRISMARINE_CRYSTALS)
                .define('O', Blocks.QUARTZ_BLOCK)
                .unlockedBy("has_quartz_block", has(Blocks.QUARTZ_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.DIVINE_BRICKS.get(), 4)
                .requires(ModBlocks.STABLE_DIVINE_STONE)
                .requires(ModBlocks.STABLE_DIVINE_STONE)
                .requires(ModBlocks.STABLE_DIVINE_STONE)
                .requires(ModBlocks.STABLE_DIVINE_STONE)
                .unlockedBy("has_stable_divine_stone", has(ModBlocks.STABLE_DIVINE_STONE)).save(recipeOutput,
                        "mo_waystones:crafting_divine_bricks");

        stonecutterResultFromBase(recipeOutput, RecipeCategory.MISC, ModBlocks.RUNIC_DIVINE_BRICKS, ModBlocks.DIVINE_BRICKS);

        oreSmelting(recipeOutput, List.of(ModBlocks.UNSTABLE_DIVINE_STONE), RecipeCategory.MISC, ModBlocks.STABLE_DIVINE_STONE, 0.25f, 200, "divine_stone");

    }
}
