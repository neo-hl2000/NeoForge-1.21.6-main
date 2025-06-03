package net.blackbriar.redpower.item.custom;

import net.blackbriar.redpower.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

//
public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.ofEntries(
                    Map.entry(Blocks.DIRT,Blocks.SAND),
                    Map.entry(Blocks.SAND, Blocks.GRASS_BLOCK),
                    Map.entry(Blocks.STONE,Blocks.COBBLESTONE),
                    Map.entry(Blocks.COBBLESTONE,Blocks.STONE),
                    Map.entry(Blocks.AMETHYST_BLOCK,ModBlocks.AMETHYST_INGOT_BLOCK.get()),
                    Map.entry(ModBlocks.AMETHYST_INGOT_BLOCK.get(), Blocks.AMETHYST_BLOCK),
                    Map.entry(Blocks.OBSIDIAN,Blocks.CRYING_OBSIDIAN),

                    //Cold Stuff
                    Map.entry(Blocks.ICE,Blocks.BLUE_ICE),
                    Map.entry(Blocks.BLUE_ICE,Blocks.PACKED_ICE),
                    Map.entry(Blocks.PACKED_ICE,Blocks.ICE),
                    Map.entry(Blocks.SNOW_BLOCK,Blocks.SNOW),
                    Map.entry(Blocks.SNOW,Blocks.SNOW_BLOCK),

                    //Wood Logs
                    Map.entry(Blocks.OAK_LOG,Blocks.SPRUCE_LOG),
                    Map.entry(Blocks.SPRUCE_LOG,Blocks.BIRCH_LOG),
                    Map.entry(Blocks.BIRCH_LOG,Blocks.JUNGLE_LOG),
                    Map.entry(Blocks.JUNGLE_LOG,Blocks.ACACIA_LOG),
                    Map.entry(Blocks.ACACIA_LOG,Blocks.CHERRY_LOG),
                    Map.entry(Blocks.CHERRY_LOG,Blocks.DARK_OAK_LOG),
                    Map.entry(Blocks.DARK_OAK_LOG,Blocks.MANGROVE_LOG),
                    Map.entry(Blocks.MANGROVE_LOG,Blocks.OAK_LOG),

                    //Wood
                    Map.entry(Blocks.OAK_WOOD,Blocks.SPRUCE_WOOD),
                    Map.entry(Blocks.SPRUCE_WOOD,Blocks.BIRCH_WOOD),
                    Map.entry(Blocks.BIRCH_WOOD,Blocks.JUNGLE_WOOD),
                    Map.entry(Blocks.JUNGLE_WOOD,Blocks.ACACIA_WOOD),
                    Map.entry(Blocks.ACACIA_WOOD,Blocks.CHERRY_WOOD),
                    Map.entry(Blocks.CHERRY_WOOD,Blocks.DARK_OAK_WOOD),
                    Map.entry(Blocks.DARK_OAK_WOOD,Blocks.MANGROVE_WOOD),
                    Map.entry(Blocks.MANGROVE_WOOD,Blocks.OAK_WOOD),

                    //Wood Stripped Logs
                    Map.entry(Blocks.STRIPPED_OAK_LOG,Blocks.STRIPPED_SPRUCE_LOG),
                    Map.entry(Blocks.STRIPPED_SPRUCE_LOG,Blocks.STRIPPED_BIRCH_LOG),
                    Map.entry(Blocks.STRIPPED_BIRCH_LOG,Blocks.STRIPPED_JUNGLE_LOG),
                    Map.entry(Blocks.STRIPPED_JUNGLE_LOG,Blocks.STRIPPED_ACACIA_LOG),
                    Map.entry(Blocks.STRIPPED_ACACIA_LOG,Blocks.STRIPPED_CHERRY_LOG),
                    Map.entry(Blocks.STRIPPED_CHERRY_LOG,Blocks.STRIPPED_DARK_OAK_LOG),
                    Map.entry(Blocks.STRIPPED_DARK_OAK_LOG,Blocks.STRIPPED_MANGROVE_LOG),
                    Map.entry(Blocks.STRIPPED_MANGROVE_LOG,Blocks.STRIPPED_OAK_LOG),

                    //Leaves
                    Map.entry(Blocks.OAK_LEAVES,Blocks.SPRUCE_LEAVES),
                    Map.entry(Blocks.SPRUCE_LEAVES,Blocks.BIRCH_LEAVES),
                    Map.entry(Blocks.BIRCH_LEAVES,Blocks.JUNGLE_LEAVES),
                    Map.entry(Blocks.JUNGLE_LEAVES,Blocks.ACACIA_LEAVES),
                    Map.entry(Blocks.ACACIA_LEAVES,Blocks.CHERRY_LEAVES),
                    Map.entry(Blocks.CHERRY_LEAVES,Blocks.DARK_OAK_LEAVES),
                    Map.entry(Blocks.DARK_OAK_LEAVES,Blocks.MANGROVE_LEAVES),
                    Map.entry(Blocks.MANGROVE_LEAVES,Blocks.OAK_LEAVES)

            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) { // ! = Determine if we are on server side
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                //This Determines the damage given to the chisel_tool
                context.getItemInHand().hurtAndBreak(0, ((ServerLevel) level),context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                //Adds Sound Effects to item
                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_HIT, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
    //Adds Tooltip to the Item with shift Down functionality
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.redpower.chisel.shift.down"));
        }else{
            tooltipComponents.add(Component.translatable("tooltip.redpower.chisel"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}