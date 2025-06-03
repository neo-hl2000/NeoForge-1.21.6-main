package net.blackbriar.redpower.datagen;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.block.ModBlocks;
import net.blackbriar.redpower.item.ModItems;
import net.blackbriar.redpower.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, RedPower.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BISMUTH.get())
                .add(ModItems.RAW_BISMUTH.get())
                .add(ModItems.AMETHYST_DUST.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        /// TOOLS ///
        tag(ItemTags.SWORDS).add(ModItems.BISMUTH_SWORD.get());
        tag(ItemTags.PICKAXES).add(ModItems.BISMUTH_PICKAXE.get());
        tag(ItemTags.PICKAXES).add(ModItems.BISMUTH_HAMMER.get());
        tag(ItemTags.PICKAXES).add(ModItems.PAXEL.get());

        /// Armor ///
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BISMUTH_HELMET.get())
                .add(ModItems.BISMUTH_CHESTPLATE.get())
                .add(ModItems.BISMUTH_LEGGINGS.get())
                .add(ModItems.BISMUTH_BOOTS.get());

        /// Tree stuff
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EBONY_LOG.get().asItem())
                .add(ModBlocks.EBONY_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_EBONY_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_EBONY_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.EBONY_PLANKS.get().asItem());

        tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.EBONY_STAIRS.get().asItem());

    }
}
