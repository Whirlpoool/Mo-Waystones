package whirlpool.mo_waystones.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import whirlpool.mo_waystones.registry.ModBlocks;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.DIVINE_BRICKS.get());
        dropSelf(ModBlocks.RUNIC_DIVINE_BRICKS.get());
        dropSelf(ModBlocks.STABLE_DIVINE_STONE.get());
        dropSelf(ModBlocks.UNSTABLE_DIVINE_STONE.get());

        add(ModBlocks.CALCITE_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.CALCITE_WAYSTONE.get()));
        add(ModBlocks.MUD_BRICKS_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.MUD_BRICKS_WAYSTONE.get()));
        add(ModBlocks.NETHER_BRICKS_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.NETHER_BRICKS_WAYSTONE.get()));
        add(ModBlocks.SCULK_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.SCULK_WAYSTONE.get()));
        add(ModBlocks.TUFF_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.TUFF_WAYSTONE.get()));
        add(ModBlocks.TUFF_BRICKS_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.TUFF_BRICKS_WAYSTONE.get()));
        add(ModBlocks.SEA_STONE_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.SEA_STONE_WAYSTONE.get()));
        add(ModBlocks.POLISHED_CALCITE_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.POLISHED_CALCITE_WAYSTONE.get()));
        add(ModBlocks.ICE_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.ICE_WAYSTONE.get()));
        add(ModBlocks.DIVINE_BRICKS_WAYSTONE.get(),
                block -> createDoorTable(ModBlocks.ICE_WAYSTONE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
