package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.reference.CreaturesBlockItemIds;
import com.nemonotfound.nemos.creatures.registry.tag.CreatureBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE;

public class BlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    private static final List<ResourceKey<Block>> BONE_BLOCKS = List.of(
            CreaturesBlockItemIds.FROZEN_BONE_BLOCK.block(),
            CreaturesBlockItemIds.CRIMSON_BONE_BLOCK.block(),
            CreaturesBlockItemIds.PARCHED_BONE_BLOCK.block(),
            CreaturesBlockItemIds.WARPED_BONE_BLOCK.block()
    );

    public BlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        addBoneMealReplaceable(CreatureBlockTags.CRIMSON_BONE_MEAL_REPLACEABLE, Blocks.WARPED_NYLIUM);

        addBoneMealReplaceable(CreatureBlockTags.WARPED_BONE_MEAL_REPLACEABLE, Blocks.CRIMSON_NYLIUM);

        var mineableWithPickaxe = tag(MINEABLE_WITH_PICKAXE);
        BONE_BLOCKS.forEach(mineableWithPickaxe::add);
    }

    private void addBoneMealReplaceable(TagKey<Block> tagKey, Block nylium) {
        tag(tagKey)
                .forceAddTag(BlockTags.BASE_STONE_OVERWORLD)
                .forceAddTag(BlockTags.CAVE_VINES)
                .forceAddTag(BlockTags.DIRT)
                .add(key(Blocks.NETHERRACK))
                .add(key(nylium));
    }

    private ResourceKey<Block> key(Block block) {
        return block.builtInRegistryHolder().key();
    }
}
