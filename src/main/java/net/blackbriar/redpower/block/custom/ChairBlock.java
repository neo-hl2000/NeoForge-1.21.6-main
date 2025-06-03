package net.blackbriar.redpower.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChairBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(2,0,2,14,13,14);

    public ChairBlock(Properties properties){
        super(properties);
    }
    @Override
    protected VoxelShape getShape(BlockState State, BlockGetter Level, BlockPos Pos, CollisionContext Context) {
        return SHAPE;
    }
}
