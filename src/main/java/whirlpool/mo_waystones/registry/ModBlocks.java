package whirlpool.mo_waystones.registry;

import net.blay09.mods.waystones.block.WaystoneBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import whirlpool.mo_waystones.Mo_waystones;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Mo_waystones.MODID);


    public static final DeferredBlock<Block> DIVINE_BRICKS = registerBlock("divine_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.CALCITE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> RUNIC_DIVINE_BRICKS = registerBlock("runic_divine_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.CALCITE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> STABLE_DIVINE_STONE = registerBlock("stable_divine_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.CALCITE).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> UNSTABLE_DIVINE_STONE = registerBlock("unstable_divine_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.CALCITE).requiresCorrectToolForDrops()));




    public static final DeferredBlock<WaystoneBlock> ICE_WAYSTONE = registerBlock("ice_waystone",
            () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.GLASS).noOcclusion()));

    public static final DeferredBlock<WaystoneBlock> CALCITE_WAYSTONE = registerBlock("calcite_waystone",
            () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.CALCITE)));

    public static final DeferredBlock<WaystoneBlock> POLISHED_CALCITE_WAYSTONE = registerBlock("polished_calcite_waystone",
            () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.CALCITE)));

    public static final DeferredBlock<WaystoneBlock> SEA_STONE_WAYSTONE = registerBlock("sea_stone_waystone",
            () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.STONE)));

    public static final DeferredBlock<WaystoneBlock> MUD_BRICKS_WAYSTONE = registerBlock("mud_bricks_waystone",
            () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.MUD_BRICKS)));

    public static final DeferredBlock<WaystoneBlock> NETHER_BRICKS_WAYSTONE = registerBlock("nether_bricks_waystone",
                                                                              () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.NETHER_BRICKS)));

    public static final DeferredBlock<WaystoneBlock> SCULK_WAYSTONE = registerBlock("sculk_waystone",
                                                                              () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.SCULK)));

    public static final DeferredBlock<WaystoneBlock> TUFF_BRICKS_WAYSTONE = registerBlock("tuff_bricks_waystone",
                                                                              () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.TUFF)));

    public static final DeferredBlock<WaystoneBlock> TUFF_WAYSTONE = registerBlock("tuff_waystone",
                                                                              () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.TUFF)));

    public static final DeferredBlock<WaystoneBlock> DIVINE_BRICKS_WAYSTONE = registerBlock("divine_bricks_waystone",
            () -> new WaystoneBlock(BlockBehaviour.Properties.of()
                    .strength(5f, 2000f).sound(SoundType.CALCITE)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
