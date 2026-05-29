package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.block.CreaturesBlocks;
import com.nemonotfound.nemos.creatures.registry.tag.CreatureBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE;

public class BlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public BlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        valueLookupBuilder(CreatureBlockTags.CRIMSON_BONE_MEAL_REPLACEABLE)
                .forceAddTag(BlockTags.BASE_STONE_OVERWORLD)
                .forceAddTag(BlockTags.CAVE_VINES)
                .forceAddTag(BlockTags.DIRT)
                .add(Blocks.NETHERRACK)
                .add(Blocks.WARPED_NYLIUM);

        valueLookupBuilder(CreatureBlockTags.WARPED_BONE_MEAL_REPLACEABLE)
                .forceAddTag(BlockTags.BASE_STONE_OVERWORLD)
                .forceAddTag(BlockTags.CAVE_VINES)
                .forceAddTag(BlockTags.DIRT)
                .add(Blocks.NETHERRACK)
                .add(Blocks.CRIMSON_NYLIUM);

        valueLookupBuilder(MINEABLE_WITH_PICKAXE)
                .add(CreaturesBlocks.FROZEN_BONE_BLOCK)
                .add(CreaturesBlocks.CRIMSON_BONE_BLOCK)
                .add(CreaturesBlocks.PARCHED_BONE_BLOCK)
                .add(CreaturesBlocks.WARPED_BONE_BLOCK);
    }
}
