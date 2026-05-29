package com.nemonotfound.nemos.creatures.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.item.CreaturesItems.*;
import static net.minecraft.world.item.CreativeModeTab.Row.TOP;

public class CreaturesItemGroups {

    public static final ResourceKey<CreativeModeTab> NEMOS_CREATURES_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MOD_ID, "nemos_creatures"));
    public static final CreativeModeTab NEMOS_CREATURES = CreativeModeTab.builder(TOP, 0)
            .icon(() -> new ItemStack(SCORCHED_CREEPER_SPAWN_EGG))
            .title(Component.translatable("itemGroup.nemos_creatures"))
            .build();

    public static void bootstrap() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, NEMOS_CREATURES_KEY, NEMOS_CREATURES);

        modifySpawnEggsItemGroup();
    }

    private static void modifySpawnEggsItemGroup() {
        CreativeModeTabEvents.modifyOutputEvent(NEMOS_CREATURES_KEY)
                .register(entries -> {
                    entries.accept(CRIMSON_SKELETON_SPAWN_EGG);
                    entries.accept(FROZEN_CREEPER_SPAWN_EGG);
                    entries.accept(FROZEN_SKELETON_SPAWN_EGG);
                    entries.accept(FROZEN_SPIDER_SPAWN_EGG);
                    entries.accept(FROZEN_ZOMBIE_SPAWN_EGG);
                    entries.accept(ICE_SPIDER_SPAWN_EGG);
                    entries.accept(SAND_SPIDER_SPAWN_EGG);
                    entries.accept(SCORCHED_CREEPER_SPAWN_EGG);
                    entries.accept(SNOW_SPIDER_SPAWN_EGG);
                    entries.accept(SNOWY_COW_SPAWN_EGG);
                    entries.accept(SNOWY_CREEPER_SPAWN_EGG);
                    entries.accept(SNOWY_PIG_SPAWN_EGG);
                    entries.accept(SNOWY_SKELETON_SPAWN_EGG);
                    entries.accept(SNOWY_SPIDER_SPAWN_EGG);
                    entries.accept(SNOWY_ZOMBIE_SPAWN_EGG);
                    entries.accept(VENOMOUS_CREEPER_SPAWN_EGG);
                    entries.accept(VENOMOUS_SKELETON_SPAWN_EGG);
                    entries.accept(VENOMOUS_SPIDER_SPAWN_EGG);
                    entries.accept(VENOMOUS_ZOMBIE_SPAWN_EGG);
                    entries.accept(WARPED_SKELETON_SPAWN_EGG);
                    entries.accept(WILD_BOAR_SPAWN_EGG);
                    entries.accept(SAND_DUST);
                    entries.accept(FROZEN_BONE_BLOCK);
                    entries.accept(FROZEN_BONE_MEAL);
                    entries.accept(FROZEN_BONE);
                    entries.accept(PARCHED_BONE_BLOCK);
                    entries.accept(PARCHED_BONE_MEAL);
                    entries.accept(PARCHED_BONE);
                    entries.accept(CRIMSON_BONE_BLOCK);
                    entries.accept(CRIMSON_BONE_MEAL);
                    entries.accept(CRIMSON_BONE);
                    entries.accept(WARPED_BONE_BLOCK);
                    entries.accept(WARPED_BONE_MEAL);
                    entries.accept(WARPED_BONE);
                });
    }
}
