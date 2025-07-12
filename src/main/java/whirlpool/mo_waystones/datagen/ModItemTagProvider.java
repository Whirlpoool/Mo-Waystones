package whirlpool.mo_waystones.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import whirlpool.mo_waystones.Mo_waystones;
import whirlpool.mo_waystones.registry.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Mo_waystones.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        TagKey<Item> waystonesItemsTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("waystones", "waystones"));

        tag(waystonesItemsTag)
                .add(ModBlocks.ICE_WAYSTONE.get().asItem())
                .add(ModBlocks.TUFF_WAYSTONE.get().asItem())
                .add(ModBlocks.TUFF_BRICKS_WAYSTONE.get().asItem())
                .add(ModBlocks.CALCITE_WAYSTONE.get().asItem())
                .add(ModBlocks.POLISHED_CALCITE_WAYSTONE.get().asItem())
                .add(ModBlocks.SCULK_WAYSTONE.get().asItem())
                .add(ModBlocks.SEA_STONE_WAYSTONE.get().asItem())
                .add(ModBlocks.MUD_BRICKS_WAYSTONE.get().asItem())
                .add(ModBlocks.NETHER_BRICKS_WAYSTONE.get().asItem());
    }
}
