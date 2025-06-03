package net.blackbriar.redpower.block.custom;

import net.blackbriar.redpower.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }
    //If  Right Click sound will play
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.BELL_BLOCK, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }
    // Throw and item on the block, and it will transform it to another item
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem().equals(ModItems.RAW_BISMUTH.get())) {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }
            if (itemEntity.getItem().getItem().equals(ModItems.AMETHYST_DUST.get())) {
                itemEntity.setItem(new ItemStack(Items.COAL, itemEntity.getItem().getCount()));
            }
            if (itemEntity.getItem().getItem().equals(Items.SAND)) {
                itemEntity.setItem(new ItemStack(ModItems.SILICON_WAFER.get(),itemEntity.getItem().getCount()));
            }
        }
        super.stepOn(level, pos, state, entity);
    }

    //Adds Tooltip to the block
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.redpower.magic_block.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}