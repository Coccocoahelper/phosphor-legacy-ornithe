package me.jellysquid.mods.phosphor.mixins.common;

import net.minecraft.util.Long2ObjectHashMap;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.chunk.ServerChunkCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ServerChunkCache.class)
public interface ServerChunkCacheAccessor {
    @Accessor("chunkStorage")
    Long2ObjectHashMap<WorldChunk> getChunkStorage();
}