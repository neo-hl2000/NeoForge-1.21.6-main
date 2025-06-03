
package net.blackbriar.redpower.item.custom;

import net.blackbriar.redpower.component.ModDataComponentTypes;
import net.blackbriar.redpower.sound.ModSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;


import java.util.List;
import java.util.Objects;


public class ChainsawItem extends Item {
    public ChainsawItem(Properties pProperties) {super(pProperties); }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();

        if(!level.isClientSide()) {
            if (level.getBlockState(pContext.getClickedPos()).is(BlockTags.LOGS)) {
                level.destroyBlock(pContext.getClickedPos(), true, pContext.getPlayer());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> Objects.requireNonNull(pContext.getPlayer()).onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                pContext.getLevel().playSound(null, pContext.getPlayer().blockPosition(), ModSounds.CHAINSAW_CUT.get(), SoundSource.PLAYERS, 1f, 1f);
            }else{
                pContext.getLevel().playSound(null,pContext.getPlayer().blockPosition(),ModSounds.CHAINSAW_PULL.get(),SoundSource.PLAYERS,1f,1f);


                if (ModDataComponentTypes.COORDINATES.isBound()) {
                    pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());
                }else{
                    System.err.println("Coordinates data component is not bound. ");
                }
            }
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.redpower.chainsaw.tooltip.1"));
            pTooltipComponents.add(Component.translatable("tooltip.redpower.chainsaw.tooltip.2"));
        }else{
            pTooltipComponents.add(Component.translatable("tooltip.redpower.chainsaw.tooltip.shift"));
        }
        if (ModDataComponentTypes.COORDINATES.isBound() && pStack.get(ModDataComponentTypes.COORDINATES) != null) {
            pTooltipComponents.add(Component.literal("Last Tree was chopped at " + pStack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}