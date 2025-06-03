package net.blackbriar.redpower.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FlammableStairBlocks extends StairBlock {
    public FlammableStairBlocks(BlockState blockState, Properties properties) {
        super(blockState, properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return FlammableBlocksManager.isFlammable(this);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return FlammableBlocksManager.getFlammability(this);
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return FlammableBlocksManager.getSpreadSpeed(this);
    }
}