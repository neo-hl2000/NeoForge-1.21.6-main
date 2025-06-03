package net.blackbriar.redpower.datagen;

import net.blackbriar.redpower.RedPower;
import net.blackbriar.redpower.block.ModBlocks;
import net.blackbriar.redpower.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    // Armor Trim
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ,0.1f);
        trimMaterials.put(TrimMaterials.IRON,0.2f);
        trimMaterials.put(TrimMaterials.NETHERITE,0.3f);
        trimMaterials.put(TrimMaterials.REDSTONE,0.4f);
        trimMaterials.put(TrimMaterials.COPPER,0.5f);
        trimMaterials.put(TrimMaterials.GOLD,0.6f);
        trimMaterials.put(TrimMaterials.EMERALD,0.7f);
        trimMaterials.put(TrimMaterials.DIAMOND,0.8f);
        trimMaterials.put(TrimMaterials.LAPIS,0.9f);
        trimMaterials.put(TrimMaterials.AMETHYST,1.0f);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RedPower.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.AMETHYST_INGOT.get());
        basicItem(ModItems.AMETHYST_DUST.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.CUP.get());
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.RAW_BISMUTH.get());
        basicItem(ModItems.RAW_NICKEL.get());
        basicItem(ModItems.NICKEL_INGOT.get());
        basicItem(ModItems.NICKEL_NUGGET.get());
        basicItem(ModItems.NICKEL_DUST.get());
        basicItem(ModItems.RAW_PLATINUM.get());
        basicItem(ModItems.PLATINUM_INGOT.get());
        basicItem(ModItems.PLATINUM_NUGGET.get());
        basicItem(ModItems.PLATINUM_DUST.get());
        basicItem(ModItems.RAW_SILVER.get());
        basicItem(ModItems.SILVER_INGOT.get());
        basicItem(ModItems.SILVER_NUGGET.get());
        basicItem(ModItems.SILVER_DUST.get());
        basicItem(ModItems.RAW_TIN.get());
        basicItem(ModItems.TIN_INGOT.get());
        basicItem(ModItems.TIN_NUGGET.get());
        basicItem(ModItems.TIN_DUST.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModItems.HOT_COCO.get());
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.DOPED_SILICON_WAFER.get());
        basicItem(ModItems.SILICON_WAFER.get());
        basicItem(ModItems.MICRO_CHIP_REDSTONE.get());
        basicItem(ModItems.MICRO_CHIP_SILVER.get());
        basicItem(ModItems.MICRO_CHIP_GOLD.get());
        basicItem(ModItems.MICRO_CHIP_DIAMOND.get());
        basicItem(ModItems.MICRO_CHIP_PLATINUM.get());
        basicItem(ModItems.METAL_DETECTOR.get());

        handheldItem(ModItems.BISMUTH_SWORD.get());
        handheldItem(ModItems.BISMUTH_PICKAXE.get());
        handheldItem(ModItems.BISMUTH_HAMMER.get());
        handheldItem(ModItems.PAXEL.get());
        handheldItem(ModItems.CHAINSAW.get());

        /// Trim Armor ///
        trimmedArmorItem(ModItems.BISMUTH_HELMET);
        trimmedArmorItem(ModItems.BISMUTH_CHESTPLATE);
        trimmedArmorItem(ModItems.BISMUTH_LEGGINGS);
        trimmedArmorItem(ModItems.BISMUTH_BOOTS);


    /// NON-BLOCK BLOCKS///
        buttonItem(ModBlocks.REINFORCED_BUTTON,ModBlocks.REINFORCED_CONCRETE);
        buttonItem(ModBlocks.EBONY_BUTTON,ModBlocks.EBONY_PLANKS);
        fenceItem(ModBlocks.BISMUTH_FENCE,ModBlocks.BISMUTH_BLOCK);
        wallItem(ModBlocks.BISMUTH_WALL,ModBlocks.BISMUTH_BLOCK);

        basicItem(ModBlocks.REINFORCED_CONCRETE_DOOR.asItem());


        /// Tree Saplings
        saplingItem(ModBlocks.EBONY_SAPLING); /// <-- is useing Custom Helper Method
    }

    /// Custom Helper Method for Saplings
    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID, "block/" + item.getId().getPath()));
    }

    /// End

    /// Trim Armor ///
    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = RedPower.MOD_ID; // Change this to your mod id

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }
    ///END ///



    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
            .texture("texture",  ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID,
                    "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
            .texture("texture",  ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID,
                    "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
            .texture("wall",  ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID,
                    "block/" + baseBlock.getId().getPath()));
    }
}
/// END ///