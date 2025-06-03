package net.blackbriar.redpower.item;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.item.custom.ModArmorItem;
import net.blackbriar.redpower.item.custom.*;
import net.blackbriar.redpower.item.custom.ArmorMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RedPower.MOD_ID);

    ///TOOLS:
    public static final DeferredItem<SwordItem> BISMUTH_SWORD = ITEMS.register("bismuth_sword",()-> new SwordItem(ModToolTiers.BISMUTH,
            new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.BISMUTH,
                    50,
                    -3f))));

    public static final DeferredItem<PickaxeItem> BISMUTH_PICKAXE = ITEMS.register("bismuth_pickaxe",()-> new PickaxeItem(ModToolTiers.BISMUTH,
            new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.BISMUTH,
                    5,
                    -3f))));

    public static final DeferredItem<HammerItem> BISMUTH_HAMMER = ITEMS.register("bismuth_hammer",
            () -> new HammerItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BISMUTH, 7F, -3.5f))));

    public static final DeferredItem<Item> PAXEL = ITEMS.register("paxel",
            () -> new PaxelItem(ModToolTiers.BISMUTH,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.BISMUTH,1,5))));

    public static final DeferredItem<Item> CHAINSAW = ITEMS.register("chainsaw",
            () -> new ChainsawItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTablet(new Item.Properties().durability(100)));

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetector(new Item.Properties().stacksTo(1)));

    ///END///

    ///This Line will Register a new item
    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_NICKEL = ITEMS.register("raw_nickel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NICKEL_NUGGET = ITEMS.register("nickel_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NICKEL_DUST = ITEMS.register("nickel_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_PLATINUM = ITEMS.register("raw_platinum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLATINUM_DUST = ITEMS.register("platinum_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SILVER_DUST = ITEMS.register("silver_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_DUST = ITEMS.register("tin_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AMETHYST_INGOT = ITEMS.register("amethyst_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CUP = ITEMS.register("cup",
            () -> new Item(new Item.Properties()));

    /// ELECTRONICS ////
    public static final DeferredItem<Item> SILICON_WAFER = ITEMS.register("silicon_wafer",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DOPED_SILICON_WAFER = ITEMS.register("doped_silicon_wafer",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MICRO_CHIP_REDSTONE = ITEMS.register("micro_chip_redstone",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MICRO_CHIP_SILVER = ITEMS.register("micro_chip_silver",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MICRO_CHIP_GOLD = ITEMS.register("micro_chip_gold",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MICRO_CHIP_DIAMOND = ITEMS.register("micro_chip_diamond",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MICRO_CHIP_PLATINUM = ITEMS.register("micro_chip_platinum",
            () -> new Item(new Item.Properties()));


/// Armor Items:
    public static final DeferredItem<ArmorItem> BISMUTH_HELMET = ITEMS.register("bismuth_helmet",
        () -> new ModArmorItem(ArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40))));

    public static final DeferredItem<ArmorItem> BISMUTH_CHESTPLATE = ITEMS.register("bismuth_chestplate",
            () -> new ArmorItem(ArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));

    public static final DeferredItem<ArmorItem> BISMUTH_LEGGINGS = ITEMS.register("bismuth_leggings",
            () -> new ArmorItem(ArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));

    public static final DeferredItem<ArmorItem> BISMUTH_BOOTS = ITEMS.register("bismuth_boots",
            () -> new ArmorItem(ArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(40))));



/// Items With Special Functions:
    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel_tool",
            () -> new ChiselItem(new Item.Properties().durability(32)));

/// ModFuelTypes
    //Method 1 of adding fuel types
    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () ->new FuelItem(new Item.Properties(),800));

    //Method 2 of adding fuel types with data_maps
    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties()));

///ModFood Registry
    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)) {

        ///Anonymous Class for tooltips
        @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.redpower.radish.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

///ModDrinks Registry
    public static final DeferredItem<ModDrink> HOT_COCO = ITEMS.register("hot_coco",
        ModDrink::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
