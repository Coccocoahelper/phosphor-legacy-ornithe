package me.jellysquid.mods.phosphor.mixins.common;

import net.minecraft.util.Long2ObjectHashMap;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.chunk.ClientChunkCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientChunkCache.class)
public interface ClientChunkCacheAccessor {
    @Accessor("chunkStorage")
    Long2ObjectHashMap<WorldChunk> getChunkStorage();
}