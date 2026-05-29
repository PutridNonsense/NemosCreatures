package com.nemonotfound.nemos.creatures.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

import static com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes.*;

public class EntityTypeTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {

    public EntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        valueLookupBuilder(EntityTypeTags.SKELETONS)
                .add(CRIMSON_SKELETON)
                .add(SNOWY_SKELETON)
                .add(FROZEN_SKELETON)
                .add(VENOMOUS_SKELETON)
                .add(WARPED_SKELETON);

        valueLookupBuilder(EntityTypeTags.ZOMBIES)
                .add(SNOWY_ZOMBIE)
                .add(FROZEN_ZOMBIE)
                .add(VENOMOUS_ZOMBIE);

        valueLookupBuilder(EntityTypeTags.BURN_IN_DAYLIGHT)
                .add(CRIMSON_SKELETON)
                .add(SNOWY_SKELETON)
                .add(FROZEN_SKELETON)
                .add(VENOMOUS_SKELETON)
                .add(WARPED_SKELETON)
                .add(SNOWY_ZOMBIE)
                .add(FROZEN_ZOMBIE)
                .add(VENOMOUS_ZOMBIE);
    }
}
