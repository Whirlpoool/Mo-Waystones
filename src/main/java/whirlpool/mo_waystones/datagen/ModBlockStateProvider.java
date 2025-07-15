package whirlpool.mo_waystones.datagen;


import net.blay09.mods.waystones.block.WaystoneBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import whirlpool.mo_waystones.Mo_waystones;
import whirlpool.mo_waystones.registry.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Mo_waystones.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DIVINE_BRICKS);

        registerWaystone(ModBlocks.ICE_WAYSTONE.get(),
                ResourceLocation.withDefaultNamespace("block/ice")); // Particle texture
        registerWaystone(ModBlocks.CALCITE_WAYSTONE.get(),
                ResourceLocation.withDefaultNamespace("block/calcite"));
        registerWaystone(ModBlocks.POLISHED_CALCITE_WAYSTONE.get(),
                ResourceLocation.withDefaultNamespace("block/calcite"));
        registerWaystone(ModBlocks.MUD_BRICKS_WAYSTONE.get(),
                ResourceLocation.withDefaultNamespace("block/mud_bricks"));
        registerWaystone(ModBlocks.NETHER_BRICKS_WAYSTONE.get(),
                ResourceLocation.withDefaultNamespace("block/nether_bricks"));
        registerWaystone(ModBlocks.SEA_STONE_WAYSTONE.get(),
                ResourceLocation.withDefaultNamespace("block/prismarine"));
        registerWaystone(ModBlocks.TUFF_BRICKS_WAYSTONE.get(),
                ResourceLocation.withDefaultNamespace("block/tuff_bricks"));
        registerWaystone(ModBlocks.TUFF_WAYSTONE.get(),
                ResourceLocation.withDefaultNamespace("block/tuff"));
        registerWaystone(ModBlocks.SCULK_WAYSTONE.get(),
                ResourceLocation.withDefaultNamespace("block/sculk"));
        registerWaystone(ModBlocks.DIVINE_BRICKS_WAYSTONE.get(),
                ResourceLocation.fromNamespaceAndPath(Mo_waystones.MODID, "block/divine_bricks"));
    }

    private void registerWaystone(Block block, ResourceLocation particleTexture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation mainTexture = ResourceLocation.fromNamespaceAndPath(Mo_waystones.MODID, "block/" + baseName);

        ModelFile waystoneTopParent = models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Mo_waystones.MODID, "block/waystone_top"));
        ModelFile waystoneBottomParent = models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Mo_waystones.MODID, "block/waystone_bottom"));

        // 1. Generate Block Models using models() from BlockStateProvider
        models().getBuilder(baseName + "_top")
                .parent(waystoneTopParent)
                .texture("particle", particleTexture)
                .texture("texture", mainTexture);

        models().getBuilder(baseName + "_bottom")
                .parent(waystoneBottomParent)
                .texture("particle", particleTexture)
                .texture("texture", mainTexture);

        // 2. Generate Block State JSON
        ModelFile bottomModel = models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Mo_waystones.MODID, "block/" + baseName + "_bottom"));
        ModelFile topModel = models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Mo_waystones.MODID, "block/" + baseName + "_top"));


        BooleanProperty WATERLOGGED_PROPERTY = BlockStateProperties.WATERLOGGED;

        EnumProperty<?> ORIGIN_PROPERTY = (EnumProperty<?>) block.getStateDefinition().getProperty("origin");

        getVariantBuilder(block)
                .forAllStatesExcept(
                        state -> {
                            DoubleBlockHalf half = state.getValue(WaystoneBlock.HALF);
                            Direction facing = state.getValue(WaystoneBlock.FACING);

                            int yRotation = 0;
                            if (facing == Direction.EAST) yRotation = 90;
                            else if (facing == Direction.SOUTH) yRotation = 180;
                            else if (facing == Direction.WEST) yRotation = 270;

                            return ConfiguredModel.builder()
                                    .modelFile(half == DoubleBlockHalf.LOWER ? bottomModel : topModel)
                                    .rotationY(yRotation)
                                    .build();
                        },
                        ORIGIN_PROPERTY,
                        WATERLOGGED_PROPERTY
                );

        // 3. Generate Item Model
        ModelFile waystoneItemParent = models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Mo_waystones.MODID, "item/waystone"));

        // 3. Generate Item Model
        itemModels().getBuilder(baseName)
                .parent(waystoneItemParent)
                .texture("texture", mainTexture);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}