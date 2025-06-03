package net.blackbriar.redpower.item.custom;

import net.blackbriar.redpower.component.FoundBlockData;
import net.blackbriar.redpower.component.ModDataComponentTypes;
import net.blackbriar.redpower.item.ModItems;
import net.blackbriar.redpower.sound.ModSounds;
import net.blackbriar.redpower.util.InventoryUtil;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class MetalDetector extends Item {
    private static final Map<Block, Boolean> VALUABLE_BLOCKS = Map.ofEntries(
            Map.entry(Blocks.IRON_ORE, true),
            Map.entry(Blocks.REDSTONE_ORE,true),
            Map.entry(Blocks.DEEPSLATE_REDSTONE_ORE,true),
            Map.entry(Blocks.LAPIS_ORE,true),
            Map.entry(Blocks.DEEPSLATE_LAPIS_ORE,true),
            Map.entry(Blocks.DIAMOND_ORE, true)
    );


    public MetalDetector(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState blockState =pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    if (InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET.get())) {
                        addDataToDataTablet(player, positionClicked.below(i), blockState.getBlock());
                    }
                    pContext.getLevel().playSeededSound(null, player.getX(), player.getY(), player.getZ(),
                            ModSounds.METAL_DETECTOR_BEEP.get(), SoundSource.PLAYERS, 1f, 1f, 0);
                    break;
                }
            }
            if(!foundBlock) {
                outputNoValuableFound(player);
            }
        }
        return InteractionResult.SUCCESS;
    }
    private void addDataToDataTablet(Player player, BlockPos below, Block block) {
        ItemStack dataTablet = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

        FoundBlockData data = new FoundBlockData(block.defaultBlockState(),below);
        dataTablet.set(ModDataComponentTypes.FOUND_BLOCK.get(),data);
    }
    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.redpower.metal_detector.no_valuables"));
    }
    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valuable Found " + I18n.get(block.getDescriptionId())
        +" at (" + below.getX() + "," + below.getY() + "," + below.getZ() + ")"));
    }
    private boolean isValuableBlock(BlockState blockState) {
        return VALUABLE_BLOCKS.containsKey(blockState.getBlock());
    }
}