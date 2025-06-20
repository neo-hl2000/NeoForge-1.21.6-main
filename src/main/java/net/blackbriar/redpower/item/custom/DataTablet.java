package net.blackbriar.redpower.item.custom;

import net.blackbriar.redpower.component.ModDataComponentTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;


public class DataTablet extends Item {
    public DataTablet(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUseHand) {
        if (pPlayer.getItemInHand(pUseHand).get(ModDataComponentTypes.FOUND_BLOCK.get()) !=null) {
            pPlayer.getItemInHand(pUseHand).set(ModDataComponentTypes.FOUND_BLOCK.get(),null);
        }
        return InteractionResultHolder.success(pPlayer.getItemInHand(pUseHand));
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return pStack.get(ModDataComponentTypes.FOUND_BLOCK.get()) !=null;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(pStack.get(ModDataComponentTypes.FOUND_BLOCK.get()) !=null) {
            pTooltipComponents.add(Component.literal(pStack.get(ModDataComponentTypes.FOUND_BLOCK.get()).getOutputString()));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}