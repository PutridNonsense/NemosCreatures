package com.nemonotfound.nemos.creatures.world.entity;

import com.nemonotfound.nemos.creatures.world.entity.mob.*;
import com.nemonotfound.nemos.creatures.registry.tag.ModBiomeTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import java.util.function.Predicate;

public class CreaturesEntityTypes {

    public static final EntityType<VenomousSkeleton> VENOMOUS_SKELETON = register(
            CreaturesEntityTypeIds.VENOMOUS_SKELETON,
            EntityType.Builder.of(VenomousSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f)
                    .eyeHeight(1.74F)
                    .ridingOffset(-0.7F)
                    .clientTrackingRange(8)
                    .notInPeaceful()
    );
    public static final EntityType<VenomousSpider> VENOMOUS_SPIDER = register(
            CreaturesEntityTypeIds.VENOMOUS_SPIDER,
            EntityType.Builder.of(VenomousSpider::new, MobCategory.MONSTER)
                    .sized(0.8f, 0.6f)
                    .notInPeaceful());
    public static final EntityType<VenomousZombie> VENOMOUS_ZOMBIE = register(
            CreaturesEntityTypeIds.VENOMOUS_ZOMBIE,
            EntityType.Builder.of(VenomousZombie::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .notInPeaceful()
    );
    public static final EntityType<VenomousCreeper> VENOMOUS_CREEPER = register(
            CreaturesEntityTypeIds.VENOMOUS_CREEPER,
            EntityType.Builder.of(VenomousCreeper::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.7f)
                    .notInPeaceful()
    );
    public static final EntityType<SandSpider> SAND_SPIDER = register(
            CreaturesEntityTypeIds.SAND_SPIDER,
            EntityType.Builder.of(SandSpider::new, MobCategory.MONSTER)
                    .sized(0.4f, 0.2f)
                    .notInPeaceful()
    );
    public static final EntityType<ScorchedCreeper> SCORCHED_CREEPER = register(
            CreaturesEntityTypeIds.SCORCHED_CREEPER,
            EntityType.Builder.of(ScorchedCreeper::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.7f)
                    .notInPeaceful()
    );
    public static final EntityType<CrimsonSkeleton> CRIMSON_SKELETON = register(
            CreaturesEntityTypeIds.CRIMSON_SKELETON,
            EntityType.Builder.of(CrimsonSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f)
                    .notInPeaceful()
    );
    public static final EntityType<WarpedSkeleton> WARPED_SKELETON = register(
            CreaturesEntityTypeIds.WARPED_SKELETON,
            EntityType.Builder.of(WarpedSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f)
                    .notInPeaceful()
    );
    public static final EntityType<WildBoar> WILD_BOAR = register(CreaturesEntityTypeIds.WILD_BOAR,
            EntityType.Builder.of(WildBoar::new, MobCategory.CREATURE)
                    .sized(0.9f, 0.9f)
    );
    public static final EntityType<SnowySkeleton> SNOWY_SKELETON = register(
            CreaturesEntityTypeIds.SNOWY_SKELETON,
            EntityType.Builder.of(SnowySkeleton::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f)
                    .notInPeaceful()
    );
    public static final EntityType<SnowySpider> SNOWY_SPIDER = register(
            CreaturesEntityTypeIds.SNOWY_SPIDER,
            EntityType.Builder.of(SnowySpider::new, MobCategory.MONSTER)
                    .sized(1.4F, 0.9F)
                    .eyeHeight(0.65F)
                    .passengerAttachments(0.765F)
                    .clientTrackingRange(8)
                    .notInPeaceful()
    );
    public static final EntityType<SnowSpider> SNOW_SPIDER = register(
            CreaturesEntityTypeIds.SNOW_SPIDER,
            EntityType.Builder.of(SnowSpider::new, MobCategory.MONSTER)
                    .sized(0.4f, 0.2f)
                    .notInPeaceful()
    );
    public static final EntityType<SnowyCreeper> SNOWY_CREEPER = register(
            CreaturesEntityTypeIds.SNOWY_CREEPER,
            EntityType.Builder.of(SnowyCreeper::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.7f));
    public static final EntityType<SnowyZombie> SNOWY_ZOMBIE = register(
            CreaturesEntityTypeIds.SNOWY_ZOMBIE,
            EntityType.Builder.of(SnowyZombie::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .notInPeaceful()
    );
    public static final EntityType<SnowyPig> SNOWY_PIG = register(
            CreaturesEntityTypeIds.SNOWY_PIG,
            EntityType.Builder.of(SnowyPig::new, MobCategory.CREATURE)
                    .sized(0.9f, 0.9f)
                    .passengerAttachments(0.86875f)
                    .clientTrackingRange(10)
    );
    public static final EntityType<SnowyCow> SNOWY_COW =  register(
            CreaturesEntityTypeIds.SNOWY_COW,
            EntityType.Builder.of(SnowyCow::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.4f)
                    .eyeHeight(1.3f)
                    .passengerAttachments(1.36875f)
                    .clientTrackingRange(10)
    );
    public static final EntityType<FrozenSkeleton> FROZEN_SKELETON = register(
            CreaturesEntityTypeIds.FROZEN_SKELETON,
            EntityType.Builder.of(FrozenSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f)
                    .notInPeaceful()
    );
    public static final EntityType<FrozenCreeper> FROZEN_CREEPER = register(
            CreaturesEntityTypeIds.FROZEN_CREEPER,
            EntityType.Builder.of(FrozenCreeper::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.7f)
                    .notInPeaceful()
    );
    public static final EntityType<FrozenSpider> FROZEN_SPIDER = register(
            CreaturesEntityTypeIds.FROZEN_SPIDER,
            EntityType.Builder.of(FrozenSpider::new, MobCategory.MONSTER)
                    .sized(1.4F, 0.9F)
                    .eyeHeight(0.65F)
                    .passengerAttachments(0.765F)
                    .clientTrackingRange(8)
                    .notInPeaceful()
    );
    public static final EntityType<IceSpider> ICE_SPIDER = register(
            CreaturesEntityTypeIds.ICE_SPIDER,
            EntityType.Builder.of(IceSpider::new, MobCategory.MONSTER)
                    .sized(0.4f, 0.2f)
                    .notInPeaceful()
    );
    public static final EntityType<FrozenZombie> FROZEN_ZOMBIE = register(
            CreaturesEntityTypeIds.FROZEN_ZOMBIE,
            EntityType.Builder.of(FrozenZombie::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .notInPeaceful()
    );

    public static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> entityTypeBuilder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, entityTypeBuilder.build(key));
    }

    public static void registerSpawnRestrictions() {
        SpawnPlacements.register(VENOMOUS_SKELETON, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(VENOMOUS_SPIDER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(VENOMOUS_ZOMBIE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(VENOMOUS_CREEPER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(SAND_SPIDER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(SCORCHED_CREEPER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(CRIMSON_SKELETON, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(WARPED_SKELETON, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(WILD_BOAR, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WildBoar::canSpawn);
        SpawnPlacements.register(SNOWY_SKELETON, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(SNOWY_PIG, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        SpawnPlacements.register(SNOWY_COW, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        SpawnPlacements.register(SNOWY_SPIDER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(SNOW_SPIDER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(SNOWY_CREEPER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(SNOWY_ZOMBIE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(FROZEN_SKELETON, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(FROZEN_CREEPER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(FROZEN_SPIDER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ICE_SPIDER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(FROZEN_ZOMBIE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(VENOMOUS_SKELETON, VenomousSkeleton.createAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_SPIDER, VenomousSpider.createJungleSpiderAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_ZOMBIE, VenomousZombie.createAttributes());
        FabricDefaultAttributeRegistry.register(VENOMOUS_CREEPER, VenomousCreeper.createAttributes());
        FabricDefaultAttributeRegistry.register(SAND_SPIDER, SandSpider.createSandSpiderAttributes());
        FabricDefaultAttributeRegistry.register(SCORCHED_CREEPER, ScorchedCreeper.createAttributes());
        FabricDefaultAttributeRegistry.register(CRIMSON_SKELETON, CrimsonSkeleton.createAttributes());
        FabricDefaultAttributeRegistry.register(WARPED_SKELETON, WarpedSkeleton.createAttributes());
        FabricDefaultAttributeRegistry.register(WILD_BOAR, WildBoar.createBoarAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_SKELETON, SnowySkeleton.createAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_PIG, SnowyPig.createAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_COW, SnowyCow.createAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_SPIDER, SnowySpider.createAttributes());
        FabricDefaultAttributeRegistry.register(SNOW_SPIDER, SnowSpider.createSnowSpiderAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_CREEPER, SnowyCreeper.createAttributes());
        FabricDefaultAttributeRegistry.register(SNOWY_ZOMBIE, SnowyZombie.createAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_SKELETON, FrozenSkeleton.createFrozenSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_CREEPER, FrozenCreeper.createAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_SPIDER, FrozenSpider.createAttributes());
        FabricDefaultAttributeRegistry.register(ICE_SPIDER, IceSpider.createIceSpiderAttributes());
        FabricDefaultAttributeRegistry.register(FROZEN_ZOMBIE, FrozenZombie.createAttributes());
    }

    public static void addMobsToBiome() {
        Predicate<BiomeSelectionContext> jungle = BiomeSelectors.tag(ConventionalBiomeTags.IS_JUNGLE);
        Predicate<BiomeSelectionContext> desert = BiomeSelectors.tag(ConventionalBiomeTags.IS_DESERT);
        Predicate<BiomeSelectionContext> crimsonForest = BiomeSelectors.tag(ModBiomeTags.IS_CRIMSON_FOREST);
        Predicate<BiomeSelectionContext> warpedForest = BiomeSelectors.tag(ModBiomeTags.IS_WARPED_FOREST);
        Predicate<BiomeSelectionContext> forest = BiomeSelectors.tag(ConventionalBiomeTags.IS_FOREST);
        Predicate<BiomeSelectionContext> snowy = BiomeSelectors.tag(ConventionalBiomeTags.IS_SNOWY);
        Predicate<BiomeSelectionContext> snowyTaiga = BiomeSelectors.tag(ModBiomeTags.IS_SNOWY_TAIGA);
        Predicate<BiomeSelectionContext> icy = BiomeSelectors.tag(ConventionalBiomeTags.IS_ICY);

        BiomeModifications.addSpawn(jungle, MobCategory.MONSTER, VENOMOUS_SKELETON, 100, 4, 4);
        BiomeModifications.addSpawn(jungle, MobCategory.MONSTER, VENOMOUS_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(jungle, MobCategory.MONSTER, VENOMOUS_ZOMBIE, 95, 4, 4);
        BiomeModifications.addSpawn(jungle, MobCategory.MONSTER, VENOMOUS_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(desert, MobCategory.MONSTER, SAND_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(desert, MobCategory.MONSTER, SCORCHED_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(crimsonForest, MobCategory.MONSTER, CRIMSON_SKELETON, 40, 1, 1);
        BiomeModifications.addSpawn(warpedForest, MobCategory.MONSTER, WARPED_SKELETON, 60, 1, 1);
        BiomeModifications.addSpawn(forest, MobCategory.CREATURE, WILD_BOAR, 12, 2, 4);
        BiomeModifications.addSpawn(snowy, MobCategory.MONSTER, SNOWY_SKELETON, 100, 4, 4);
        BiomeModifications.addSpawn(snowy, MobCategory.MONSTER, SNOWY_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(snowy, MobCategory.MONSTER, SNOW_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(snowy, MobCategory.MONSTER, SNOWY_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(snowy, MobCategory.MONSTER, SNOWY_ZOMBIE, 95, 4, 4);
        BiomeModifications.addSpawn(snowyTaiga, MobCategory.CREATURE, SNOWY_PIG, 10, 4, 4);
        BiomeModifications.addSpawn(snowyTaiga, MobCategory.CREATURE, SNOWY_COW, 8, 4, 4);
        BiomeModifications.addSpawn(icy, MobCategory.MONSTER, FROZEN_SKELETON, 80, 4, 4);
        BiomeModifications.addSpawn(icy, MobCategory.MONSTER, FROZEN_CREEPER, 100, 4, 4);
        BiomeModifications.addSpawn(icy, MobCategory.MONSTER, FROZEN_SPIDER, 100, 4, 4);
        BiomeModifications.addSpawn(icy, MobCategory.MONSTER, ICE_SPIDER, 80, 4, 4);
        BiomeModifications.addSpawn(icy, MobCategory.MONSTER, FROZEN_ZOMBIE, 95, 4, 4);
    }
}
