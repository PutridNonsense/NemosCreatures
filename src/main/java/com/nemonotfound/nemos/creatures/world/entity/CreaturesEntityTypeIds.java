package com.nemonotfound.nemos.creatures.world.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class CreaturesEntityTypeIds {

    public static final ResourceKey<EntityType<?>> VENOMOUS_SKELETON = create("venomous_skeleton");
    public static final ResourceKey<EntityType<?>> VENOMOUS_SPIDER = create("venomous_spider");
    public static final ResourceKey<EntityType<?>> VENOMOUS_ZOMBIE = create("venomous_zombie");
    public static final ResourceKey<EntityType<?>> VENOMOUS_CREEPER = create("venomous_creeper");
    public static final ResourceKey<EntityType<?>> SAND_SPIDER = create("sand_spider");
    public static final ResourceKey<EntityType<?>> SCORCHED_CREEPER = create("scorched_creeper");
    public static final ResourceKey<EntityType<?>> CRIMSON_SKELETON = create("crimson_skeleton");
    public static final ResourceKey<EntityType<?>> WARPED_SKELETON = create("warped_skeleton");
    public static final ResourceKey<EntityType<?>> WILD_BOAR = create("wild_boar");
    public static final ResourceKey<EntityType<?>> SNOWY_SKELETON = create("snowy_skeleton");
    public static final ResourceKey<EntityType<?>> SNOWY_SPIDER = create("snowy_spider");
    public static final ResourceKey<EntityType<?>> SNOW_SPIDER = create("snow_spider");
    public static final ResourceKey<EntityType<?>> SNOWY_CREEPER = create("snowy_creeper");
    public static final ResourceKey<EntityType<?>> SNOWY_ZOMBIE = create("snowy_zombie");
    public static final ResourceKey<EntityType<?>> SNOWY_PIG = create("snowy_pig");
    public static final ResourceKey<EntityType<?>> SNOWY_COW = create("snowy_cow");
    public static final ResourceKey<EntityType<?>> FROZEN_SKELETON = create("frozen_skeleton");
    public static final ResourceKey<EntityType<?>> FROZEN_CREEPER = create("frozen_creeper");
    public static final ResourceKey<EntityType<?>> FROZEN_SPIDER = create("frozen_spider");
    public static final ResourceKey<EntityType<?>> ICE_SPIDER = create("ice_spider");
    public static final ResourceKey<EntityType<?>> FROZEN_ZOMBIE = create("frozen_zombie");

    private static ResourceKey<EntityType<?>> create(final String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, name));
    }
}
