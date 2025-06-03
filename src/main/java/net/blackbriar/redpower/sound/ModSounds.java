package net.blackbriar.redpower.sound;

import net.blackbriar.redpower.RedPower;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, RedPower.MOD_ID);

    public static final Supplier<SoundEvent> METAL_DETECTOR_BEEP = registerSoundEvent("metal_detector_beep");
    public static final Supplier<SoundEvent> CHAINSAW_CUT = registerSoundEvent("chainsaw_cut");
    public static final Supplier<SoundEvent> CHAINSAW_PULL = registerSoundEvent("chainsaw_pull");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(RedPower.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
