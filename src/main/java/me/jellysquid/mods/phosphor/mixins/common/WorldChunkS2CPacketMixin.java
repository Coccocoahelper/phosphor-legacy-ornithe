package me.jellysquid.mods.phosphor.mixins.common;

import me.jellysquid.mods.phosphor.api.ILightingEngineProvider;
import net.minecraft.network.packet.s2c.play.WorldChunkDataS2CPacket;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldChunkDataS2CPacket.class)
public abstract class WorldChunkDataS2CPacketMixin {
    /**
     * Injects a callback into the constructor of WorldChunkDataS2CPacketMixin to force light updates to be
     * processed before creating the client payload.
     *
     * @author JellySquid
     */
    @Inject(method = "saveChunkData", at = @At("HEAD"))
    private static void onCalculateChunkSize(WorldChunk chunk, boolean load, boolean notNether, int i, CallbackInfoReturnable<WorldChunkDataS2CPacket.ChunkData> cir) {
        ((ILightingEngineProvider) chunk).getLightingEngine().processLightUpdates();
    }
}