package com.nemonotfound.nemos.creatures.reference;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class CreaturesItemIds {

    public static final ResourceKey<Item> VENOMOUS_SKELETON_SPAWN_EGG = create("venomous_skeleton_spawn_egg");
    public static final ResourceKey<Item> VENOMOUS_SPIDER_SPAWN_EGG = create("venomous_spider_spawn_egg");
    public static final ResourceKey<Item> VENOMOUS_ZOMBIE_SPAWN_EGG = create("venomous_zombie_spawn_egg");
    public static final ResourceKey<Item> VENOMOUS_CREEPER_SPAWN_EGG = create("venomous_creeper_spawn_egg");
    public static final ResourceKey<Item> SAND_SPIDER_SPAWN_EGG = create("sand_spider_spawn_egg");
    public static final ResourceKey<Item> SCORCHED_CREEPER_SPAWN_EGG = create("scorched_creeper_spawn_egg");
    public static final ResourceKey<Item> CRIMSON_SKELETON_SPAWN_EGG = create("crimson_skeleton_spawn_egg");
    public static final ResourceKey<Item> WARPED_SKELETON_SPAWN_EGG = create("warped_skeleton_spawn_egg");
    public static final ResourceKey<Item> WILD_BOAR_SPAWN_EGG = create("wild_boar_spawn_egg");
    public static final ResourceKey<Item> SNOWY_SKELETON_SPAWN_EGG = create("snowy_skeleton_spawn_egg");
    public static final ResourceKey<Item> SNOWY_PIG_SPAWN_EGG = create("snowy_pig_spawn_egg");
    public static final ResourceKey<Item> SNOWY_COW_SPAWN_EGG = create("snowy_cow_spawn_egg");
    public static final ResourceKey<Item> SNOWY_SPIDER_SPAWN_EGG = create("snowy_spider_spawn_egg");
    public static final ResourceKey<Item> SNOW_SPIDER_SPAWN_EGG = create("snow_spider_spawn_egg");
    public static final ResourceKey<Item> SNOWY_CREEPER_SPAWN_EGG = create("snowy_creeper_spawn_egg");
    public static final ResourceKey<Item> SNOWY_ZOMBIE_SPAWN_EGG = create("snowy_zombie_spawn_egg");
    public static final ResourceKey<Item> FROZEN_SKELETON_SPAWN_EGG = create("frozen_skeleton_spawn_egg");
    public static final ResourceKey<Item> FROZEN_CREEPER_SPAWN_EGG = create("frozen_creeper_spawn_egg");
    public static final ResourceKey<Item> FROZEN_SPIDER_SPAWN_EGG = create("frozen_spider_spawn_egg");
    public static final ResourceKey<Item> ICE_SPIDER_SPAWN_EGG = create("ice_spider_spawn_egg");
    public static final ResourceKey<Item> FROZEN_ZOMBIE_SPAWN_EGG = create("frozen_zombie_spawn_egg");
    public static final ResourceKey<Item> SAND_DUST = create("sand_dust");
    public static final ResourceKey<Item> FROZEN_BONE = create("frozen_bone");
    public static final ResourceKey<Item> FROZEN_BONE_MEAL = create("frozen_bone_meal");
    public static final ResourceKey<Item> PARCHED_BONE = create("parched_bone");
    public static final ResourceKey<Item> PARCHED_BONE_MEAL = create("parched_bone_meal");
    public static final ResourceKey<Item> CRIMSON_BONE = create("crimson_bone");
    public static final ResourceKey<Item> CRIMSON_BONE_MEAL = create("crimson_bone_meal");
    public static final ResourceKey<Item> WARPED_BONE = create("warped_bone");
    public static final ResourceKey<Item> WARPED_BONE_MEAL = create("warped_bone_meal");

    private static ResourceKey<Item> create(final String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));
    }
}
