package net.blackbriar.redpower.item;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RedPower.MOD_ID);

    //First CreativeMode Tab for Items
    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.redpower.bismuth_items"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                        output.accept(ModItems.AMETHYST_DUST);
                        output.accept(ModItems.AMETHYST_INGOT);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.RADISH);
                        output.accept(ModItems.HOT_COCO);
                        output.accept(ModItems.CUP);
                        output.accept(ModItems.FROSTFIRE_ICE);
                        output.accept(ModItems.STARLIGHT_ASHES);
                        output.accept(ModItems.RAW_NICKEL);
                        output.accept(ModItems.NICKEL_INGOT);
                        output.accept(ModItems.NICKEL_NUGGET);
                        output.accept(ModItems.NICKEL_DUST);
                        output.accept(ModItems.RAW_PLATINUM);
                        output.accept(ModItems.PLATINUM_INGOT);
                        output.accept(ModItems.PLATINUM_NUGGET);
                        output.accept(ModItems.PLATINUM_DUST);
                        output.accept(ModItems.RAW_SILVER);
                        output.accept(ModItems.SILVER_INGOT);
                        output.accept(ModItems.SILVER_NUGGET);
                        output.accept(ModItems.SILVER_DUST);
                        output.accept(ModItems.RAW_TIN);
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModItems.TIN_NUGGET);
                        output.accept(ModItems.TIN_DUST);
                        output.accept(ModItems.BISMUTH_SWORD);
                        output.accept(ModItems.BISMUTH_PICKAXE);
                        output.accept(ModItems.BISMUTH_HAMMER);
                        output.accept(ModItems.BISMUTH_HELMET);
                        output.accept(ModItems.BISMUTH_CHESTPLATE);
                        output.accept(ModItems.BISMUTH_LEGGINGS);
                        output.accept(ModItems.BISMUTH_BOOTS);
                        output.accept(ModItems.PAXEL);
                        output.accept(ModItems.CHAINSAW);
                        output.accept(ModItems.DATA_TABLET);
                        output.accept(ModItems.METAL_DETECTOR);
                    }).build());

    public static final Supplier<CreativeModeTab> REDPOWER_ELECTRONICS_TAB = CREATIVE_MODE_TAB.register("redpower_electronics_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SILICON_WAFER.get()))
                    .title(Component.translatable("creativetab.redpower.redpower_electronics"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModItems.SILICON_WAFER);
                        output.accept(ModItems.DOPED_SILICON_WAFER);
                        output.accept(ModItems.MICRO_CHIP_REDSTONE);
                        output.accept(ModItems.MICRO_CHIP_SILVER);
                        output.accept(ModItems.MICRO_CHIP_GOLD);
                        output.accept(ModItems.MICRO_CHIP_DIAMOND);
                        output.accept(ModItems.MICRO_CHIP_PLATINUM);
                    }).build());


    //Second CreativeMode Tab for Blocks
    public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB = CREATIVE_MODE_TAB.register("bismuth_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID, "bismuth_items_tab"))
                    .title(Component.translatable("creativetab.redpower.bismuth_blocks"))
                    .displayItems((itemDisplayParameters,output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        output.accept(ModBlocks.AMETHYST_INGOT_BLOCK);
                        output.accept(ModBlocks.NICKEL_BLOCK);
                        output.accept(ModBlocks.NICKEL_ORE);
                        output.accept(ModBlocks.NICKEL_DEEPSLATE_ORE);
                        output.accept(ModBlocks.PLATINUM_BLOCK);
                        output.accept(ModBlocks.PLATINUM_ORE);
                        output.accept(ModBlocks.PLATINUM_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MagicBlock);
                        output.accept(ModBlocks.MagicBlock2);
                        output.accept(ModBlocks.SILVER_BLOCK);
                        output.accept(ModBlocks.SILVER_ORE);
                        output.accept(ModBlocks.SILVER_DEEPSLATE_ORE);
                        output.accept(ModBlocks.TIN_BLOCK);
                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.TIN_DEEPSLATE_ORE);
                        output.accept(ModBlocks.RAW_NICKEL_BLOCK);
                        output.accept(ModBlocks.RAW_SILVER_BLOCK);
                        output.accept(ModBlocks.RAW_PLATINUM_BLOCK);
                        output.accept(ModBlocks.RAW_TIN_BLOCK);
                        output.accept(ModBlocks.REINFORCED_CONCRETE);
                        output.accept(ModBlocks.REINFORCED_GLASS);
                        output.accept(ModBlocks.BASIC_LAMP);
                        output.accept(ModBlocks.CHAIR);

                        /// NON-BLOCK BLOCKS///
                        output.accept(ModBlocks.EBONY_STAIRS);
                        output.accept(ModBlocks.BISMUTH_SLAB);
                        output.accept(ModBlocks.EBONY_SLAB);
                        output.accept(ModBlocks.REINFORCED_PRESSURE_PLATE);
                        output.accept(ModBlocks.REINFORCED_BUTTON);
                        output.accept(ModBlocks.EBONY_BUTTON);
                        output.accept(ModBlocks.BISMUTH_FENCE);
                        output.accept(ModBlocks.BISMUTH_FENCE_GATE);
                        output.accept(ModBlocks.BISMUTH_WALL);
                        output.accept(ModBlocks.REINFORCED_CONCRETE_DOOR);
                        output.accept(ModBlocks.BISMUTH_TRAPDOOR);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
