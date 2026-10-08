package me.jellysquid.mods.phosphor.mod.world;

import me.jellysquid.mods.phosphor.mixins.common.ClientChunkCacheAccessor;
import me.jellysquid.mods.phosphor.mixins.common.ServerChunkCacheAccessor;
import net.minecraft.util.Long2ObjectHashMap;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.WorldChunk;
<<<<<<< HEAD
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.client.world.chunk.ClientChunkCache;
import net.minecraft.world.chunk.ServerChunkCache;
=======
import net.minecraft.world.chunk.WorldChunkProvider;
import net.minecraft.world.chunk.ClientChunkCache;
import net.minecraft.server.world.chunk.ServerChunkCache;
>>>>>>> 633a7c9d1a559bd49f722d1b818899f4fa92b4cb

public class ChunkHelper {
    public static WorldChunk getLoadedChunk(ChunkSource chunkProvider, int x, int z) {
        if (chunkProvider instanceof ServerChunkCache) {
<<<<<<< HEAD
            Long2ObjectHashMap<WorldChunk> chunkStorage = ((ServerChunkCacheAccessor) chunkProvider).getChunkStorage();
            return chunkStorage.get(ChunkPos.getIdFromCoords(x, z));
=======
            Long2ObjectHashMap<Chunk> chunkStorage = ((ServerChunkCacheAccessor) chunkProvider).getChunkStorage();
            return chunkStorage.get(ChunkPos.toLong(x, z));
>>>>>>> 633a7c9d1a559bd49f722d1b818899f4fa92b4cb
        }
        if (chunkProvider instanceof ClientChunkCache) {
<<<<<<< HEAD
            Long2ObjectHashMap<WorldChunk> chunkStorage = ((ClientChunkCacheAccessor) chunkProvider).getChunkStorage();
            return chunkStorage.get(ChunkPos.getIdFromCoords(x, z));
=======
            Long2ObjectHashMap<Chunk> chunkStorage = ((ClientChunkCacheAccessor) chunkProvider).getChunkStorage();
            return chunkStorage.get(ChunkPos.toLong(x, z));
>>>>>>> 633a7c9d1a559bd49f722d1b818899f4fa92b4cb
        }

        // Fallback for other providers, hopefully this doesn't break...
        return chunkProvider.getChunk(x, z);
    }
}