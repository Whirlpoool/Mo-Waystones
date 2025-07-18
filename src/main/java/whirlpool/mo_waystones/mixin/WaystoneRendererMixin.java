package whirlpool.mo_waystones.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.blay09.mods.waystones.block.WaystoneBlock;
import net.blay09.mods.waystones.block.entity.WaystoneBlockEntity;
import net.blay09.mods.waystones.client.render.WaystoneRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import whirlpool.mo_waystones.registry.ModBlocks;

@Mixin(WaystoneRenderer.class)
public abstract class WaystoneRendererMixin {
    private static final String RENDER_TO_BUFFER_TARGET = "Lnet/blay09/mods/waystones/client/render/SharestoneModel;renderToBuffer(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;III)V";


    @ModifyVariable(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = RENDER_TO_BUFFER_TARGET,
                    shift = At.Shift.BEFORE
            ),
            name = "color",
            remap = false
    )
    private int yourModId_modifyWaystoneRuneColor(
            int originalColor, // This will hold the value of the 'color' local variable
            WaystoneBlockEntity tileEntity,
            float partialTicks,
            PoseStack matrixStack,
            MultiBufferSource buffer,
            int combinedLightIn,
            int combinedOverlayIn
    ) {
        BlockState state = tileEntity.getBlockState();

        if (state.getValue(WaystoneBlock.HALF) != DoubleBlockHalf.LOWER) {
            return originalColor;
        }

        if (state.getBlock() == ModBlocks.CALCITE_WAYSTONE.get() || state.getBlock() == ModBlocks.POLISHED_CALCITE_WAYSTONE.get()) {
            return 0xFF77B6FF;
        } else if (state.getBlock() == ModBlocks.ICE_WAYSTONE.get()) {
            return 0xFFD5E9FF;
        } else if (state.getBlock() == ModBlocks.SCULK_WAYSTONE.get()) {
            return 0xFF30CFFF;
        } else if (state.getBlock() == ModBlocks.DIVINE_WAYSTONE.get() || state.getBlock() == ModBlocks.DIVINE_BRICKS_WAYSTONE.get()) {
            return 0x5E98D6;
        }

        return originalColor;
    }
}