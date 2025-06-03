package net.blackbriar.redpower.worldgen.tree;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower EBONY = new TreeGrower(RedPower.MOD_ID + ":ebony",
            Optional.empty(), Optional.of(ModConfiguredFeatures.EBONY_KEY), Optional.empty());
}
