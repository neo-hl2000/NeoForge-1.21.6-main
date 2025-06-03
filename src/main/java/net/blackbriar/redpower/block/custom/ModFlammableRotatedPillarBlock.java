package net.blackbriar.redpower.block.custom;

import net.blackbriar.redpower.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    /// If item Axe is in hand get stripped wood
    /// Use " Map.of " if you have multiple wood types
    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlocks.EBONY_LOG.get())) {
                return ModBlocks.STRIPPED_EBONY_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS)); /// <--Makes sure the block does not change AXIS
            }
            if (state.is(ModBlocks.EBONY_WOOD.get())) {
                return ModBlocks.STRIPPED_EBONY_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS)); /// <--Makes sure the block does not change AXIS

            }
        }
            return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}