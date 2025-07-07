package whirlpool.mo_waystones.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import whirlpool.mo_waystones.Mo_waystones;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Mo_waystones.MODID);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
