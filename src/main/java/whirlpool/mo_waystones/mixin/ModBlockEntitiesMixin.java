package whirlpool.mo_waystones.mixin;

import net.blay09.mods.waystones.block.entity.ModBlockEntities;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import whirlpool.mo_waystones.registry.ModBlocks;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(ModBlockEntities.class)
public abstract class ModBlockEntitiesMixin {
    @Inject(
            method = "lambda$static$0",
            at = @At(value = "RETURN"),
            cancellable = true,
            remap = false
    )
    private static void injectIntoWaystoneBlocks(CallbackInfoReturnable<Block[]> cir) {
        Block[] originalBlocks = cir.getReturnValue();
        ArrayList<Block> newBlocks = new ArrayList<>(Arrays.asList(originalBlocks));

        newBlocks.add(ModBlocks.ICE_WAYSTONE.get());
        newBlocks.add(ModBlocks.CALCITE_WAYSTONE.get());

        cir.setReturnValue(newBlocks.toArray(new Block[0]));
    }
}