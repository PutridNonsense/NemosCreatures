package com.nemonotfound.nemos.creatures.datagen;

import com.nemonotfound.nemos.creatures.block.CreaturesBlocks;
import com.nemonotfound.nemos.creatures.item.CreaturesItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;

public class CreaturesModelProvider extends FabricModelProvider {

    public CreaturesModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createAxisAlignedPillarBlock(CreaturesBlocks.FROZEN_BONE_BLOCK, TexturedModel.COLUMN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CreaturesBlocks.PARCHED_BONE_BLOCK, TexturedModel.COLUMN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CreaturesBlocks.CRIMSON_BONE_BLOCK, TexturedModel.COLUMN);
        blockStateModelGenerator.createAxisAlignedPillarBlock(CreaturesBlocks.WARPED_BONE_BLOCK, TexturedModel.COLUMN);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(CreaturesItems.VENOMOUS_SKELETON_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.VENOMOUS_SPIDER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.VENOMOUS_ZOMBIE_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.VENOMOUS_CREEPER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SAND_SPIDER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SCORCHED_CREEPER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.CRIMSON_SKELETON_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.WARPED_SKELETON_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.WILD_BOAR_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SNOWY_SKELETON_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SNOWY_PIG_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SNOWY_COW_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SNOWY_SPIDER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SNOW_SPIDER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SNOWY_CREEPER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SNOWY_ZOMBIE_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.FROZEN_SKELETON_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.FROZEN_CREEPER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.FROZEN_SPIDER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.ICE_SPIDER_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.FROZEN_ZOMBIE_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.SAND_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.FROZEN_BONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.FROZEN_BONE_MEAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.PARCHED_BONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.PARCHED_BONE_MEAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.CRIMSON_BONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.CRIMSON_BONE_MEAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.WARPED_BONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(CreaturesItems.WARPED_BONE_MEAL, ModelTemplates.FLAT_ITEM);
    }
}
