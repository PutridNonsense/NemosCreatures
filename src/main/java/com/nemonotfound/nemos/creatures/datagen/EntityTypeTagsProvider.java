package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.world.entity.CreaturesEntityTypeIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.tags.EntityTypeTags;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EntityTypeTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {

    private static final List<ResourceKey<EntityType<?>>> SKELETONS = List.of(
            CreaturesEntityTypeIds.CRIMSON_SKELETON,
            CreaturesEntityTypeIds.SNOWY_SKELETON,
            CreaturesEntityTypeIds.FROZEN_SKELETON,
            CreaturesEntityTypeIds.VENOMOUS_SKELETON,
            CreaturesEntityTypeIds.WARPED_SKELETON
    );
    private static final List<ResourceKey<EntityType<?>>> ZOMBIES = List.of(
            CreaturesEntityTypeIds.SNOWY_ZOMBIE,
            CreaturesEntityTypeIds.FROZEN_ZOMBIE,
            CreaturesEntityTypeIds.VENOMOUS_ZOMBIE
    );

    public EntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        addEntityTypes(EntityTypeTags.SKELETONS, SKELETONS);

        addEntityTypes(EntityTypeTags.ZOMBIES, ZOMBIES);

        addEntityTypes(EntityTypeTags.BURN_IN_DAYLIGHT, SKELETONS);
        addEntityTypes(EntityTypeTags.BURN_IN_DAYLIGHT, ZOMBIES);
    }

    private void addEntityTypes(TagKey<EntityType<?>> tagKey, List<ResourceKey<EntityType<?>>> entityTypes) {
        var builder = tag(tagKey);
        entityTypes.forEach(builder::add);
    }
}
