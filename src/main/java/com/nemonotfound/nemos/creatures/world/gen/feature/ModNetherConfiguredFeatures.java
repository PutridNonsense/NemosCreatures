package com.nemonotfound.nemos.creatures.world.gen.feature;

import com.nemonotfound.nemos.creatures.registry.tag.CreatureBlockTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class ModNetherConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_FOREST_VEGETATION_PATCH = of("crimson_forest_vegetation_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRIMSON_FOREST_VEGETATION_PATCH_BONEMEAL = of("crimson_forest_vegetation_patch_bonemeal");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_FOREST_VEGETATION_PATCH = of("warped_forest_vegetation_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WARPED_FOREST_VEGETATION_PATCH_BONEMEAL = of("warped_forest_vegetation_patch_bonemeal");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> featureRegisterable) {
        HolderGetter<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.lookup(Registries.CONFIGURED_FEATURE);

        WeightedStateProvider crimsonWeightedBlockStateProvider = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(Blocks.CRIMSON_ROOTS.defaultBlockState(), 87)
                        .add(Blocks.CRIMSON_FUNGUS.defaultBlockState(), 13)
        );

        FeatureUtils.register(
                featureRegisterable,
                CRIMSON_FOREST_VEGETATION_PATCH,
                Feature.NETHER_FOREST_VEGETATION,
                new NetherForestVegetationConfig(crimsonWeightedBlockStateProvider, 3, 4)
        );

        FeatureUtils.register(
                featureRegisterable,
                CRIMSON_FOREST_VEGETATION_PATCH_BONEMEAL,
                Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        CreatureBlockTags.CRIMSON_BONE_MEAL_REPLACEABLE,
                        BlockStateProvider.simple(Blocks.CRIMSON_NYLIUM),
                        PlacementUtils.inlinePlaced(registryEntryLookup.getOrThrow(CRIMSON_FOREST_VEGETATION_PATCH)),
                        CaveSurface.FLOOR,
                        ConstantInt.of(1),
                        0.0F,
                        5,
                        0.6F,
                        UniformInt.of(1, 2),
                        0.75F
                )
        );

        WeightedStateProvider warpedWeightedBlockStateProvider = new WeightedStateProvider(
                WeightedList.<BlockState>builder()
                        .add(Blocks.WARPED_ROOTS.defaultBlockState(), 87)
                        .add(Blocks.WARPED_FUNGUS.defaultBlockState(), 13)
        );

        FeatureUtils.register(
                featureRegisterable,
                WARPED_FOREST_VEGETATION_PATCH,
                Feature.NETHER_FOREST_VEGETATION,
                new NetherForestVegetationConfig(warpedWeightedBlockStateProvider, 3, 4)
        );

        FeatureUtils.register(
                featureRegisterable,
                WARPED_FOREST_VEGETATION_PATCH_BONEMEAL,
                Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        CreatureBlockTags.WARPED_BONE_MEAL_REPLACEABLE,
                        BlockStateProvider.simple(Blocks.WARPED_NYLIUM),
                        PlacementUtils.inlinePlaced(registryEntryLookup.getOrThrow(WARPED_FOREST_VEGETATION_PATCH)),
                        CaveSurface.FLOOR,
                        ConstantInt.of(1),
                        0.0F,
                        5,
                        0.6F,
                        UniformInt.of(1, 2),
                        0.75F
                )
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> of(String id) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(MOD_ID, id));
    }
}
