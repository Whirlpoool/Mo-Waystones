package whirlpool.mo_waystones.registry;

import net.blay09.mods.waystones.block.entity.WaystoneBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import whirlpool.mo_waystones.Mo_waystones;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Mo_waystones.MODID);

    public static final Supplier<BlockEntityType<WaystoneBlockEntity>> MO_WAYSTONES =
            BLOCK_ENTITIES.register("mo_waystones", () -> BlockEntityType.Builder.of(
                    WaystoneBlockEntity::new, ModBlocks.ICE_WAYSTONE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}