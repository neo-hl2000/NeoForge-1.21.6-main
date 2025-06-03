package net.blackbriar.redpower.block;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.block.custom.*;
import net.blackbriar.redpower.item.ModItems;
import net.blackbriar.redpower.util.FlammableBlocks;
import net.blackbriar.redpower.util.FlammableSlabBlocks;
import net.blackbriar.redpower.util.FlammableStairBlocks;
import net.blackbriar.redpower.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RedPower.MOD_ID);

    public static final DeferredBlock<Block> AMETHYST_INGOT_BLOCK = registerBlock("amethyst_ingot_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock("bismuth_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE = registerBlock("bismuth_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
                    .lightLevel(p_50872_ -> 15)));

    public static final DeferredBlock<Block> NICKEL_ORE = registerBlock("nickel_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> NICKEL_DEEPSLATE_ORE = registerBlock("nickel_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> NICKEL_BLOCK = registerBlock("nickel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> RAW_NICKEL_BLOCK = registerBlock("raw_nickel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PLATINUM_DEEPSLATE_ORE = registerBlock("platinum_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> SILVER_DEEPSLATE_ORE = registerBlock("silver_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> TIN_DEEPSLATE_ORE = registerBlock("tin_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> REINFORCED_CONCRETE = registerBlock("reinforced_concrete",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f, 3000f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    /// REINFORCED_GLASS Needs texture fixing like Logs
    public static final DeferredBlock<TransparentBlock> REINFORCED_GLASS = registerBlock("reinforced_glass",
            () -> new Reinforced_Glass(BlockBehaviour.Properties.of()
                    .noOcclusion()));

    public static final DeferredBlock<Block> MagicBlock = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(0.1f, 99999)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> MagicBlock2 = registerBlock("magic_block2",
            () -> new MagicBlock2(BlockBehaviour.Properties.of()
                    .strength(0.1f, 99999)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final DeferredBlock<Block> BASIC_LAMP = registerBlock("basic_lamp",
            () -> new Basic_Lamp(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(Basic_Lamp.CLICKED) ? 15 : 0)));

    public static final DeferredBlock<Block> CHAIR = registerBlock("chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of()
                    .noOcclusion()));

    /// Tree Blocks
    public static final DeferredBlock<Block> EBONY_LOG = registerBlock("ebony_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> EBONY_WOOD = registerBlock("ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));

    public static final DeferredBlock<Block> STRIPPED_EBONY_LOG = registerBlock("stripped_ebony_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final DeferredBlock<Block> STRIPPED_EBONY_WOOD = registerBlock("stripped_ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    ///Planks if more planks are added make a class for them
    public static final DeferredBlock<Block> EBONY_PLANKS = registerBlock("ebony_planks",
            () -> new FlammableBlocks(BlockBehaviour.Properties.of()
                    .ignitedByLava()
                    .sound(SoundType.WOOD)
                    .strength(2f)));


    public static final DeferredBlock<Block> EBONY_LEAVES = registerBlock("ebony_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
               @Override
               public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                   return true;
               }

               @Override
               public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                   return 60;
               }

              @Override
              public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                  return 30;
              }
    });

    public static final DeferredBlock<Block> EBONY_SAPLING = registerBlock("ebony_sapling",
            ()-> new SaplingBlock(ModTreeGrowers.EBONY, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));


    /// NON-BLOCK BLOCKS///
    /// Doors
     public static final DeferredBlock<DoorBlock> REINFORCED_CONCRETE_DOOR = registerBlock("reinforced_concrete_door",
                 () -> new DoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of()
                         .strength(2f,3000.0f)
                         .requiresCorrectToolForDrops()));
/// Pressure plates
    public static final DeferredBlock<PressurePlateBlock> REINFORCED_PRESSURE_PLATE = registerBlock("reinforced_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(2f,3000f)
                    .requiresCorrectToolForDrops()));
/// Buttons
    public static final DeferredBlock<ButtonBlock> REINFORCED_BUTTON = registerBlock("reinforced_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20,BlockBehaviour.Properties.of()
                    .strength(1f,3000f)
                    .noCollission()
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<ButtonBlock> EBONY_BUTTON = registerBlock("ebony_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20,BlockBehaviour.Properties.of()
                    .strength(1f)
                    .noCollission()));
/// Stairs

public static final DeferredBlock<StairBlock> EBONY_STAIRS = registerBlock("ebony_stairs",
        () -> new FlammableStairBlocks(ModBlocks.EBONY_PLANKS.get()
                .defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));

/// Slabs
    public static final DeferredBlock<SlabBlock> BISMUTH_SLAB =registerBlock("bismuth_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<SlabBlock> EBONY_SLAB =registerBlock("ebony_slab",
            () -> new FlammableSlabBlocks(ModBlocks.EBONY_PLANKS.get()
                    .defaultBlockState(),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
/// Fences
    public static final DeferredBlock<FenceBlock> BISMUTH_FENCE = registerBlock("bismuth_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<FenceGateBlock> BISMUTH_FENCE_GATE = registerBlock("bismuth_fence_gate",
            () -> new FenceGateBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));
/// Walls
    public static final DeferredBlock<WallBlock> BISMUTH_WALL = registerBlock("bismuth_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .noOcclusion()
                    .requiresCorrectToolForDrops()));
/// Trapdoors
    public static final DeferredBlock<TrapDoorBlock> BISMUTH_TRAPDOOR = registerBlock("bismuth_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.STONE, BlockBehaviour.Properties.of()
                    .strength(2f)
                    .noOcclusion()
                    .requiresCorrectToolForDrops()));
    /// END ///



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
