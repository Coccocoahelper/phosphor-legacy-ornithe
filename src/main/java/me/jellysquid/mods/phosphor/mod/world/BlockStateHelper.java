package me.jellysquid.mods.phosphor.mod.world;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.chunk.WorldChunkSection;

public class BlockStateHelper {
    private static final BlockState DEFAULT_BLOCK_STATE = Blocks.AIR.defaultState();

    // Avoids some additional logic in WorldChunk#getBlockState... 0 is always air
    public static BlockState posToState(final BlockPos pos, final WorldChunk chunk) {
        return posToState(pos, chunk.getSections()[pos.getY() >> 4]);
    }

    public static BlockState posToState(final BlockPos pos, final WorldChunkSection section) {
        final int x = pos.getX();
        final int y = pos.getY();
        final int z = pos.getZ();

        if (section != null) {
            int key = section.getBlockStates()[(y & 15) << 8 | (z & 15) << 4 | x & 15];

            if (key != 0) {
                BlockState state = Block.STATE_REGISTRY.fromId(key);

                if (state != null) {
                    return state;
                }
            }
        }

        return DEFAULT_BLOCK_STATE;
    }
}