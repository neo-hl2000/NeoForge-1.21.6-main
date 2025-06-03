package net.blackbriar.redpower;

import net.blackbriar.redpower.block.ModBlocks;
import net.blackbriar.redpower.component.ModDataComponentTypes;
import net.blackbriar.redpower.item.ModItems;
import net.blackbriar.redpower.item.ModCreativeModeTabs;
import net.blackbriar.redpower.sound.ModSounds;
import net.blackbriar.redpower.util.FlammableBlocksManager;
import net.blackbriar.redpower.util.ModItemProperteries;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(RedPower.MOD_ID)
public class RedPower
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "redpower";

    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public RedPower(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        //Register CreativeModeTab
        ModCreativeModeTabs.register(modEventBus);

        // Register Mod eventBus
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModSounds.register(modEventBus);
        ModDataComponentTypes.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BISMUTH);
            event.accept(ModItems.RAW_BISMUTH);
            event.accept(ModItems.AMETHYST_DUST);
            event.accept(ModItems.AMETHYST_INGOT);
            event.accept(ModItems.FROSTFIRE_ICE);
            event.accept(ModItems.STARLIGHT_ASHES);
            event.accept(ModItems.RAW_NICKEL);
            event.accept(ModItems.NICKEL_DUST);
            event.accept(ModItems.NICKEL_INGOT);
            event.accept(ModItems.NICKEL_NUGGET);
            event.accept(ModItems.RAW_PLATINUM);
            event.accept(ModItems.PLATINUM_DUST);
            event.accept(ModItems.PLATINUM_INGOT);
            event.accept(ModItems.PLATINUM_NUGGET);
            event.accept(ModItems.RAW_SILVER);
            event.accept(ModItems.SILVER_DUST);
            event.accept(ModItems.SILVER_INGOT);
            event.accept(ModItems.SILVER_NUGGET);
            event.accept(ModItems.RAW_TIN);
            event.accept(ModItems.TIN_DUST);
            event.accept(ModItems.TIN_INGOT);
            event.accept(ModItems.TIN_NUGGET);
            event.accept(ModItems.BISMUTH_PICKAXE);
            event.accept(ModItems.MICRO_CHIP_REDSTONE);
            event.accept(ModItems.MICRO_CHIP_SILVER);
            event.accept(ModItems.MICRO_CHIP_GOLD);
            event.accept(ModItems.MICRO_CHIP_DIAMOND);
            event.accept(ModItems.MICRO_CHIP_PLATINUM);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.BISMUTH_SWORD);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.BISMUTH_PICKAXE);
            event.accept(ModItems.BISMUTH_HAMMER);
            event.accept(ModItems.PAXEL);
            event.accept(ModItems.CHAINSAW);
            event.accept(ModItems.DATA_TABLET);
            event.accept(ModItems.METAL_DETECTOR);
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.EBONY_PLANKS);
            event.accept(ModBlocks.EBONY_LOG);
            event.accept(ModBlocks.EBONY_WOOD);
            event.accept(ModBlocks.EBONY_LEAVES);
            event.accept(ModBlocks.EBONY_SAPLING);
            event.accept(ModBlocks.STRIPPED_EBONY_LOG);
            event.accept(ModBlocks.STRIPPED_EBONY_WOOD);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.BISMUTH_BLOCK);
            event.accept(ModBlocks.BISMUTH_ORE);
            event.accept(ModBlocks.AMETHYST_INGOT_BLOCK);
            event.accept(ModBlocks.NICKEL_ORE);
            event.accept(ModBlocks.NICKEL_DEEPSLATE_ORE);
            event.accept(ModBlocks.NICKEL_BLOCK);
            event.accept(ModBlocks.PLATINUM_ORE);
            event.accept(ModBlocks.PLATINUM_DEEPSLATE_ORE);
            event.accept(ModBlocks.PLATINUM_BLOCK);
            event.accept(ModBlocks.MagicBlock);
            event.accept(ModBlocks.MagicBlock2);
            event.accept(ModBlocks.SILVER_ORE);
            event.accept(ModBlocks.SILVER_DEEPSLATE_ORE);
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.RAW_SILVER_BLOCK);
            event.accept(ModBlocks.TIN_ORE);
            event.accept(ModBlocks.TIN_DEEPSLATE_ORE);
            event.accept(ModBlocks.TIN_BLOCK);
            event.accept(ModBlocks.RAW_TIN_BLOCK);
            event.accept(ModBlocks.REINFORCED_CONCRETE);
            event.accept(ModBlocks.REINFORCED_GLASS);
            event.accept(ModBlocks.EBONY_SLAB);
            event.accept(ModBlocks.EBONY_BUTTON);
            event.accept(ModBlocks.EBONY_STAIRS);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.AMETHYST_INGOT_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.REINFORCED_GLASS.get(), RenderType.translucent());
            ModItemProperteries.addCustomItemProperterties();
            FlammableBlocksManager.addBlock(ModBlocks.EBONY_STAIRS.get(),60,30);
        }
    }
}
