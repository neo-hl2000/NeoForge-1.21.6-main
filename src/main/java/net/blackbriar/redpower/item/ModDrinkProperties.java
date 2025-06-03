package net.blackbriar.redpower.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModDrinkProperties {
    public static final FoodProperties HOT_COCO = new FoodProperties.Builder()
            .usingConvertsTo(ModItems.CUP) // Returns the empty cup after use
            .nutrition(3)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION,1200),1.0f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,1200),1.0f)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION,1200),1.0f)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED,1200),1.0f).build();
}

