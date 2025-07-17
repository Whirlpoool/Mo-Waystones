package whirlpool.mo_waystones.datagen;

import net.blay09.mods.waystones.block.WaystoneBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import whirlpool.mo_waystones.Mo_waystones;
import whirlpool.mo_waystones.registry.ModBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Mo_waystones.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        TagKey<Block> waystonesBlockTag = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("waystones", "waystones"));
        TagKey<Block> isTeleportTargetBlockTag = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("waystones", "is_teleport_target"));

        List<WaystoneBlock> blocks = List.of(
                ModBlocks.CALCITE_WAYSTONE.get(),
                ModBlocks.ICE_WAYSTONE.get(),
                ModBlocks.POLISHED_CALCITE_WAYSTONE.get(),
                ModBlocks.TUFF_WAYSTONE.get(),
                ModBlocks.TUFF_BRICKS_WAYSTONE.get(),
                ModBlocks.MUD_BRICKS_WAYSTONE.get(),
                ModBlocks.NETHER_BRICKS_WAYSTONE.get(),
                ModBlocks.SCULK_WAYSTONE.get(),
                ModBlocks.SEA_STONE_WAYSTONE.get(),
                ModBlocks.DIVINE_BRICKS_WAYSTONE.get(),
                ModBlocks.DIVINE_WAYSTONE.get()
        );


        for (Block block: blocks) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            tag(waystonesBlockTag).add(block);
            tag(isTeleportTargetBlockTag).add(block);
        }

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.DIVINE_BRICKS.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.RUNIC_DIVINE_BRICKS.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.STABLE_DIVINE_STONE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.UNSTABLE_DIVINE_STONE.get());
    }
}
