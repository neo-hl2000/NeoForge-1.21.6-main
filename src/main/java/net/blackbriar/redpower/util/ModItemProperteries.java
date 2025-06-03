package net.blackbriar.redpower.util;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.component.ModDataComponentTypes;
import net.blackbriar.redpower.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperteries {
    public static void addCustomItemProperterties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID,"on"),
                (stack, level, entity, seed) -> stack.get(ModDataComponentTypes.FOUND_BLOCK) !=null ? 1f : 0f);
    }
}
