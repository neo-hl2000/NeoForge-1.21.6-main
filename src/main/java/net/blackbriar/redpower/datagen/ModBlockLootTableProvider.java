package net.blackbriar.redpower.datagen;


import net.blackbriar.redpower.block.ModBlocks;
import net.blackbriar.redpower.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;


import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        dropSelf(ModBlocks.AMETHYST_INGOT_BLOCK.get());
        dropSelf(ModBlocks.MagicBlock.get());
        dropSelf(ModBlocks.MagicBlock2.get());
        dropSelf(ModBlocks.BASIC_LAMP.get());
        dropSelf(ModBlocks.NICKEL_BLOCK.get());
        dropSelf(ModBlocks.RAW_NICKEL_BLOCK.get());
        dropSelf(ModBlocks.SILVER_BLOCK.get());
        dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());
        dropSelf(ModBlocks.PLATINUM_BLOCK.get());
        dropSelf(ModBlocks.RAW_PLATINUM_BLOCK.get());
        dropSelf(ModBlocks.TIN_BLOCK.get());
        dropSelf(ModBlocks.RAW_TIN_BLOCK.get());
        dropSelf(ModBlocks.REINFORCED_CONCRETE.get());
        dropSelf(ModBlocks.REINFORCED_GLASS.get());
        dropSelf((ModBlocks.CHAIR.get()));

        /// NON-BLOCK BLOCKS///
        dropSelf(ModBlocks.REINFORCED_CONCRETE_DOOR.get());
        dropSelf(ModBlocks.REINFORCED_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.REINFORCED_BUTTON.get());
        dropSelf(ModBlocks.REINFORCED_GLASS.get());
        dropSelf(ModBlocks.BISMUTH_FENCE.get());
        dropSelf(ModBlocks.BISMUTH_FENCE_GATE.get());
        dropSelf(ModBlocks.BISMUTH_WALL.get());
        dropSelf(ModBlocks.BISMUTH_TRAPDOOR.get());
        dropSelf(ModBlocks.EBONY_SLAB.get());
        dropSelf(ModBlocks.EBONY_STAIRS.get());
        dropSelf(ModBlocks.EBONY_BUTTON.get());

        add(ModBlocks.BISMUTH_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BISMUTH_SLAB.get()));
        add(ModBlocks.EBONY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.EBONY_SLAB.get()));
        add(ModBlocks.REINFORCED_CONCRETE_DOOR.get(),
                block -> createDoorTable(ModBlocks.REINFORCED_CONCRETE_DOOR.get()));
        /// END ///

        add(ModBlocks.BISMUTH_ORE.get(),
               block -> createOreDrop(ModBlocks.BISMUTH_ORE.get(), ModItems.RAW_BISMUTH.get()));

        add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),ModItems.RAW_BISMUTH.get(),2,5));

        add(ModBlocks.NICKEL_ORE.get(),
               block -> createOreDrop(ModBlocks.NICKEL_ORE.get(), ModItems.RAW_NICKEL.get()));

        add(ModBlocks.NICKEL_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.NICKEL_DEEPSLATE_ORE.get(),ModItems.RAW_NICKEL.get(),2,5));

       add(ModBlocks.PLATINUM_ORE.get(),
                block -> createOreDrop(ModBlocks.PLATINUM_ORE.get(),ModItems.RAW_PLATINUM.get()));

        add(ModBlocks.PLATINUM_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.PLATINUM_DEEPSLATE_ORE.get(),ModItems.RAW_PLATINUM.get(),1,3));

        add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        add(ModBlocks.SILVER_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SILVER_DEEPSLATE_ORE.get(),ModItems.RAW_SILVER.get(),1,3));

        add(ModBlocks.TIN_ORE.get(),
                block -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));

        add(ModBlocks.TIN_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.TIN_DEEPSLATE_ORE.get(),ModItems.RAW_TIN.get(),1,3));
        ///END ///

        /// Tree Stuff
        this.dropSelf(ModBlocks.EBONY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_PLANKS.get());
        this.dropSelf(ModBlocks.EBONY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
        this.dropSelf(ModBlocks.EBONY_SAPLING.get());

        this.add(ModBlocks.EBONY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    //Getting all blocks that are registered
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
