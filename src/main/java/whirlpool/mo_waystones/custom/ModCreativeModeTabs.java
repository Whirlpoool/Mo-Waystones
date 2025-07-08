package whirlpool.mo_waystones.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import whirlpool.mo_waystones.Mo_waystones;
import whirlpool.mo_waystones.registry.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mo_waystones.MODID);

    public static final Supplier<CreativeModeTab> MO_WAYSTONES_TAB = CREATIVE_MODE_TAB.register("mo_waystones_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.POLISHED_CALCITE_WAYSTONE))
                    .title(Component.translatable("creativetab.mo_waystones.mo_waystones_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ICE_WAYSTONE);
                        output.accept(ModBlocks.SEA_STONE_WAYSTONE);
                        output.accept(ModBlocks.CALCITE_WAYSTONE);
                        output.accept(ModBlocks.POLISHED_CALCITE_WAYSTONE);
                    })).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
