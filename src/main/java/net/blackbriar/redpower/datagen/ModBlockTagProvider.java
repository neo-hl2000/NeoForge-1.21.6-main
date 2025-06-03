package net.blackbriar.redpower.datagen;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.block.ModBlocks;
import net.blackbriar.redpower.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RedPower.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AMETHYST_INGOT_BLOCK.get())
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.NICKEL_ORE.get())
                .add(ModBlocks.NICKEL_DEEPSLATE_ORE.get())
                .add(ModBlocks.NICKEL_BLOCK.get())
                .add(ModBlocks.PLATINUM_ORE.get())
                .add(ModBlocks.PLATINUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.PLATINUM_BLOCK.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.SILVER_DEEPSLATE_ORE.get())
                .add(ModBlocks.SILVER_BLOCK.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.TIN_DEEPSLATE_ORE.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.RAW_TIN_BLOCK.get())
                .add(ModBlocks.BASIC_LAMP.get())
                .add(ModBlocks.MagicBlock.get())
                .add(ModBlocks.MagicBlock2.get())
                .add(ModBlocks.REINFORCED_BUTTON.get())
                .add(ModBlocks.REINFORCED_PRESSURE_PLATE.get())
                .add(ModBlocks.REINFORCED_CONCRETE_DOOR.get())
                .add(ModBlocks.REINFORCED_GLASS.get())
                .add(ModBlocks.REINFORCED_CONCRETE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.AMETHYST_INGOT_BLOCK.get())
                .add(ModBlocks.MagicBlock.get())
                .add(ModBlocks.MagicBlock2.get())
                .add(ModBlocks.BASIC_LAMP.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BISMUTH_ORE.get())
                .add(ModBlocks.BISMUTH_BLOCK.get())
                .add(ModBlocks.NICKEL_ORE.get())
                .add(ModBlocks.NICKEL_BLOCK.get())
                .add(ModBlocks.RAW_NICKEL_BLOCK.get())
                .add(ModBlocks.PLATINUM_ORE.get())
                .add(ModBlocks.PLATINUM_BLOCK.get())
                .add(ModBlocks.RAW_PLATINUM_BLOCK.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.SILVER_BLOCK.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.RAW_TIN_BLOCK.get())
                .add(ModBlocks.REINFORCED_BUTTON.get())
                .add(ModBlocks.REINFORCED_PRESSURE_PLATE.get())
                .add(ModBlocks.REINFORCED_CONCRETE_DOOR.get())
                .add(ModBlocks.REINFORCED_GLASS.get())
                .add(ModBlocks.REINFORCED_CONCRETE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get())
                .add(ModBlocks.NICKEL_DEEPSLATE_ORE.get())
                .add(ModBlocks.PLATINUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.SILVER_DEEPSLATE_ORE.get())
                .add(ModBlocks.TIN_DEEPSLATE_ORE.get());

        ///Bismuth Tools///
        tag(ModTags.Blocks.NEEDS_BISMUTH_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_BISMUTH_TOOL);

        /// Paxel Tool ///
       tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_AXE);

        /// NON-BLOCK BLOCKS///
        tag(BlockTags.FENCES)
                .add(ModBlocks.BISMUTH_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.BISMUTH_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.BISMUTH_WALL.get());
        tag(BlockTags.DOORS)
                .add(ModBlocks.REINFORCED_CONCRETE_DOOR.get());
        /// END ///
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.BISMUTH_SLAB.get());

        /// Tree Blocks Tags
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.EBONY_LOG.get())
                .add(ModBlocks.EBONY_WOOD.get())
                .add(ModBlocks.STRIPPED_EBONY_LOG.get())
                .add(ModBlocks.EBONY_BUTTON.get())
                .add(ModBlocks.EBONY_PLANKS.get())
                .add(ModBlocks.EBONY_STAIRS.get())
                .add(ModBlocks.EBONY_BUTTON.get())
                .add(ModBlocks.STRIPPED_EBONY_WOOD.get());
        /// End
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.EBONY_LOG.get())
                .add(ModBlocks.EBONY_WOOD.get())
                .add(ModBlocks.EBONY_STAIRS.get())
                .add(ModBlocks.EBONY_PLANKS.get())
                .add(ModBlocks.EBONY_SLAB.get())
                .add(ModBlocks.EBONY_BUTTON.get());
        }
    }