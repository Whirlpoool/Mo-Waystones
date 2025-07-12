package whirlpool.mo_waystones.datagen;

import net.blay09.mods.waystones.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import whirlpool.mo_waystones.registry.ModBlocks;

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
    }
}
