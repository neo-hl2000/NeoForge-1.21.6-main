package net.blackbriar.redpower.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends DiggerItem {

    public HammerItem(Tier tier, Properties properties) {
        // Initialize the item with a block tag that is a pickaxe
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        // Check if the block can be mined with this hammer
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE) ||
                state.is(BlockTags.MINEABLE_WITH_SHOVEL);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        // This method can handle the usage of the hammer on a block
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());

        // Log the interaction for debugging
        System.out.println("HammerItem used on: " + blockState);

        // Check if the hammer can harvest the current block
        if (isCorrectToolForDrops(context.getItemInHand(), blockState)) {
            System.out.println("HammerItem can harvest this block!");
            // Logic to harvest/block destruction can go here
            return InteractionResult.SUCCESS; // Indicate successful use
        }

        return super.useOn(context); // Fallback to the default method
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();

        // Using ray tracing to check initial hit
        BlockHitResult traceResult = player.level().clip(new ClipContext(
                player.getEyePosition(1f),
                player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f)),
                ClipContext.Block.COLLIDER,
                ClipContext.Fluid.NONE,
                player));

        if (traceResult.getType() == HitResult.Type.MISS) {
            return positions; // If no block was hit, no positions to add
        }

        // Iterate through all three dimensions within the defined range
        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    BlockPos posToCheck = initialBlockPos.offset(x, y, z); // Create new position based on offsets
                    positions.add(posToCheck); // Add each calculated position
                }
            }
        }

        return positions; // Return the list of block positions to be destroyed
    }
}