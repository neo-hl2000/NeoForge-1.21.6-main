
package net.blackbriar.redpower.component;


import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;
import static net.minecraft.core.registries.Registries.DATA_COMPONENT_TYPE;

public class ModDataComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.create(DATA_COMPONENT_TYPE,"redpower");

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> COORDINATES =
            register("coordinates", builder -> builder.persistent(BlockPos.CODEC));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<FoundBlockData>> FOUND_BLOCK = register("found_block",
            builder -> builder.persistent(FoundBlockData.CODEC));

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                           UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
























/*
public class ModDataComponentTypes {
    public static final DeferredRegister<DataComponentType<?>> REGISTER =
            DeferredRegister.create(DATA_COMPONENT_TYPE, "redpower");

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> COORDINATES = register("coordinates",
            builder -> builder.persistent(BlockPos.CODEC));

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(
            String name, UnaryOperator<DataComponentType.Builder<T>> builderUnaryOperator) {

        return REGISTER.register(name, () -> {
            DataComponentType.Builder<T> builder = new DataComponentType.Builder<>();
            return builderUnaryOperator.apply(builder).build();
        });

    }

    public static void REGISTER(IEventBus modEventBus) {
    }
}

 */