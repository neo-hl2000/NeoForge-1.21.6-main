package net.blackbriar.redpower.block.custom;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;


public class Reinforced_Glass extends TransparentBlock {
    public Reinforced_Glass(Properties properties){
        super(BlockBehaviour.Properties.of()
                .strength(0.2f,3000f)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn(((state, level, pos, value) -> false))
                .isRedstoneConductor(((state, level, pos) -> false))
                .isSuffocating(((state, level, pos) -> false))
                .isViewBlocking(((state, level, pos) -> false))
                .requiresCorrectToolForDrops()
                .dynamicShape());
    }
}