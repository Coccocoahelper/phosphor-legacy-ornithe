package me.jellysquid.mods.phosphor.mod.world;

import me.jellysquid.mods.phosphor.mixins.common.ClientChunkCacheAccessor;
import me.jellysquid.mods.phosphor.mixins.common.ServerChunkCacheAccessor;
import net.minecraft.util.Long2ObjectHashMap;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.chunk.WorldChunkProvider;
import net.minecraft.world.chunk.ClientChunkCache;
import net.minecraft.world.chunk.ServerChunkCache;

public class ChunkHelper {
    public static WorldChunk getLoadedChunk(WorldChunkProvider chunkProvider, int x, int z) {
        if (chunkProvider instanceof ServerChunkCache) {
            Long2ObjectHashMap<Chunk> chunkStorage = ((ServerChunkCacheAccessor) chunkProvider).getChunkStorage();
            return chunkStorage.get(ChunkPos.getIdFromCoords(x, z));
        }
        if (chunkProvider instanceof ClientChunkCache) {
            Long2ObjectHashMap<Chunk> chunkStorage = ((ClientChunkCacheAccessor) chunkProvider).getChunkStorage();
            return chunkStorage.get(ChunkPos.getIdFromCoords(x, z));
        }

        // Fallback for other providers, hopefully this doesn't break...
        return chunkProvider.getChunk(x, z);
    }
}