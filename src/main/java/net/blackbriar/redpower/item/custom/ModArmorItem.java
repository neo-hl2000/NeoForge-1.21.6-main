package net.blackbriar.redpower.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;


public class ModArmorItem extends ArmorItem {
    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ArmorMaterials.BISMUTH_ARMOR_MATERIAL,
                            List.of(new MobEffectInstance(MobEffects.ABSORPTION, 10, 1, false, false,false)))
                                    //new MobEffectInstance(MobEffects.DOLPHINS_GRACE,10,100,false,false,false),
                                   // new MobEffectInstance(MobEffects.REGENERATION, 10, 1, false, false,false)))
                    .build();

    public ModArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player && !level.isClientSide() && hasFullSuitOfArmorOn(player)) {
            evaluateArmorEffects(player);
            evaluateMovementSpeedEffect(player);
            evaluateJumpEffect(player);
            onPlayerLanding(player);
            waterBreathing(player);
        }
    }
/// Player Running Speed ///
    private void evaluateMovementSpeedEffect(Player player) {
        // Check if the player is running
        if (player.isSprinting()) {
            // Define the speed effect parameters
            MobEffectInstance speedEffect = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 30, true, false,false);

            // Apply the speed effect if the player does not already have it
            if (!player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                player.addEffect(speedEffect);
            }
        } else {
            // Optionally remove the speed effect if they stop running
            player.removeEffect(MobEffects.MOVEMENT_SPEED);
        }
    }
    /// Needs fixing keeps popping up in gui
    public void evaluateJumpEffect(Player player) {
        // Check if the player is onGround
        if (player.getDeltaMovement().y < 0) {
            // Define the Jump effect parameters
            MobEffectInstance jumpEffect = new MobEffectInstance(MobEffects.JUMP, 10, 20,true,false,false);

            // Apply the jump effect if the player does not already have it
            if (!player.hasEffect(MobEffects.JUMP)) {
                player.addEffect(jumpEffect);
            }
        } else {
            // Optionally remove the jump effect if they stop jumping
            player.removeEffect(MobEffects.JUMP);
        }
    }
/// Cancel all fall damage ///
    private void onPlayerLanding(Player player) {
        player.setDeltaMovement(player.getDeltaMovement().x, 0, player.getDeltaMovement().z); // Reset Y motion to 0
        player.fallDistance = 0; // Reset fall distance to 0, effectively negating fall damage
    }
    private void waterBreathing(Player player) {
        // Check if the player is in water
        if (player.isInWater()) {
            // Define the effect parameters
            MobEffectInstance dolphinsGraceEffect = new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 100, false, false);

            // Apply the effect if the player does not already have it
            if (!player.hasEffect(MobEffects.WATER_BREATHING)) {
                player.addEffect(dolphinsGraceEffect);
            }
        } else {
            // Optionally remove the effect if the player has it
            if (player.hasEffect(MobEffects.WATER_BREATHING)) {
                player.removeEffect(MobEffects.WATER_BREATHING);
            }
        }
    }

    /*
    private void applyWaterSpeedEffect(Player player) {
        // Check if the player is in water
        if (player.isInWater()) {
            // Define the effect parameters
            MobEffectInstance dolphinsGraceEffect = new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 900, false, false);

            // Apply the effect if the player does not already have it
            if (!player.hasEffect(MobEffects.DOLPHINS_GRACE)) {
                player.addEffect(dolphinsGraceEffect);
                System.out.println("Applying Dolphins Grace effect to player in water.");
            }
        } else {
            // Optionally remove the effect if the player has it
            if (player.hasEffect(MobEffects.DOLPHINS_GRACE)) {
                player.removeEffect(MobEffects.DOLPHINS_GRACE);
                System.out.println("Removing Dolphins Grace effect from player.");
            }
        }
    }
*/
    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn(mapArmorMaterial, player)) {
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}