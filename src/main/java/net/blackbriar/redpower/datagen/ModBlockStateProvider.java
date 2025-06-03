package net.blackbriar.redpower.datagen;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.block.ModBlocks;
import net.blackbriar.redpower.block.custom.Basic_Lamp;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RedPower.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AMETHYST_INGOT_BLOCK);
        blockWithItem(ModBlocks.BISMUTH_BLOCK);
        blockWithItem(ModBlocks.BISMUTH_ORE);
        blockWithItem(ModBlocks.BISMUTH_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.NICKEL_ORE);
        blockWithItem(ModBlocks.NICKEL_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.NICKEL_BLOCK);
        blockWithItem(ModBlocks.RAW_NICKEL_BLOCK);
        blockWithItem(ModBlocks.PLATINUM_ORE);
        blockWithItem(ModBlocks.PLATINUM_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.PLATINUM_BLOCK);
        blockWithItem(ModBlocks.RAW_PLATINUM_BLOCK);
        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.SILVER_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.SILVER_BLOCK);
        blockWithItem(ModBlocks.RAW_SILVER_BLOCK);
        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.TIN_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.TIN_BLOCK);
        blockWithItem(ModBlocks.RAW_TIN_BLOCK);
        blockWithItem(ModBlocks.MagicBlock);
        blockWithItem(ModBlocks.MagicBlock2);
        blockWithItem(ModBlocks.REINFORCED_GLASS);
        blockWithItem(ModBlocks.REINFORCED_CONCRETE);


        /// Tree stuff
        logBlock(((RotatedPillarBlock) ModBlocks.EBONY_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.EBONY_WOOD.get()), blockTexture(ModBlocks.EBONY_LOG.get()), blockTexture(ModBlocks.EBONY_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_WOOD.get()), blockTexture(ModBlocks.STRIPPED_EBONY_LOG.get()), blockTexture(ModBlocks.STRIPPED_EBONY_LOG.get()));

        blockItem(ModBlocks.EBONY_LOG);
        blockItem(ModBlocks.EBONY_WOOD);
        blockItem(ModBlocks.EBONY_STAIRS);
        blockItem(ModBlocks.EBONY_SLAB);
        blockItem(ModBlocks.EBONY_BUTTON);
        blockItem(ModBlocks.STRIPPED_EBONY_LOG);
        blockItem(ModBlocks.STRIPPED_EBONY_WOOD);

        blockWithItem(ModBlocks.EBONY_PLANKS);

        leavesBlock(ModBlocks.EBONY_LEAVES);
        saplingBlock(ModBlocks.EBONY_SAPLING);
        /// End


        /// NON-BLOCK BLOCKS///
        stairsBlock(ModBlocks.EBONY_STAIRS.get(), blockTexture((ModBlocks.EBONY_PLANKS.get())));
        slabBlock(ModBlocks.BISMUTH_SLAB.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        slabBlock(ModBlocks.EBONY_SLAB.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));

        buttonBlock(ModBlocks.REINFORCED_BUTTON.get(), blockTexture(ModBlocks.REINFORCED_CONCRETE.get()));
        buttonBlock(ModBlocks.EBONY_BUTTON.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()));

        pressurePlateBlock(ModBlocks.REINFORCED_PRESSURE_PLATE.get(), blockTexture(ModBlocks.REINFORCED_CONCRETE.get()));

        fenceBlock(ModBlocks.BISMUTH_FENCE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        fenceGateBlock(ModBlocks.BISMUTH_FENCE_GATE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        wallBlock(ModBlocks.BISMUTH_WALL.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.REINFORCED_CONCRETE_DOOR.get(), modLoc("block/reinforced_concrete_door_bottom"),modLoc("block/reinforced_concrete_door_top"),"cutout");

        trapdoorBlockWithRenderType(ModBlocks.BISMUTH_TRAPDOOR.get(), modLoc("block/bismuth_trapdoor"), true, "cutout");

        blockItem(ModBlocks.EBONY_STAIRS);
        blockItem(ModBlocks.BISMUTH_SLAB);
        blockItem(ModBlocks.REINFORCED_PRESSURE_PLATE);
        blockItem(ModBlocks.BISMUTH_FENCE_GATE);
        blockItem(ModBlocks.BISMUTH_TRAPDOOR, "_bottom");
        /// End ///

        customLamp();
    }

    /// Hardcoded Basic Lamp Block
    private void customLamp() {
        getVariantBuilder(ModBlocks.BASIC_LAMP.get()).forAllStates(state -> {
            if(state.getValue(Basic_Lamp.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("basic_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID, "block/" + "basic_lamp_on")))};
            }else{
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("basic_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID,"block/" + "basic_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.BASIC_LAMP.get(),models().cubeAll("basic_lamp_on",
                ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID,"block/" + "basic_lamp_on")));
    }
    /// END ///


    private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }
    private void saplingBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("redpower:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("redpower:block/" + deferredBlock.getId().getPath() + appendix));
    }
}