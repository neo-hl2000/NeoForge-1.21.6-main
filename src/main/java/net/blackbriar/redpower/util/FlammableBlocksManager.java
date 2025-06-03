package net.blackbriar.redpower.util;

import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class FlammableBlocksManager {
    private static final Map<Block, Integer> flammabilityMap = new HashMap<>();
    private static final Map<Block, Integer> spreadSpeedMap = new HashMap<>();

    public static void addBlock(Block block, int flammability, int spreadSpeed) {
        flammabilityMap.put(block, flammability);
        spreadSpeedMap.put(block, spreadSpeed);
    }

    public static boolean isFlammable(Block block) {
        return true;
    }

    public static int getFlammability(Block block) {
        return flammabilityMap.getOrDefault(block, 60);
    }

    public static int getSpreadSpeed(Block block) {
        return spreadSpeedMap.getOrDefault(block, 30);
    }

}