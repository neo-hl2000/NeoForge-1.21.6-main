package net.blackbriar.redpower.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;


public class ModDrink extends Item {


    public ModDrink() {
        super(new Properties().food(ModDrinkProperties.HOT_COCO));
    }

    //Used for Overrideing the food animation to drinking animation hand
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;

    }
}

