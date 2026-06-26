package com.nemonotfound.nemos.creatures.client.render.entity.model;

import com.google.common.collect.ImmutableMap;
import com.nemonotfound.nemos.creatures.client.render.entity.*;
import com.nemonotfound.nemos.creatures.world.entity.CreaturesEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.animal.cow.CowModel;
import net.minecraft.client.model.animal.pig.PigModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.monster.creeper.CreeperModel;
import net.minecraft.client.model.monster.skeleton.SkeletonModel;
import net.minecraft.client.model.monster.spider.SpiderModel;
import net.minecraft.client.model.monster.zombie.ZombieModel;
import net.minecraft.client.renderer.entity.EntityRenderers;
import org.jetbrains.annotations.NotNull;

public class CreaturesEntityModels {

    private static final CubeDeformation OUTER_DILATION = new CubeDeformation(0.1f);
    private static final CubeDeformation ARMOR_DILATION = new CubeDeformation(1.0F);
    private static final CubeDeformation HAT_DILATION = new CubeDeformation(0.5F);

    public static void bootstrap() {
        EntityRenderers.register(CreaturesEntityTypes.VENOMOUS_SKELETON, VenomousSkeletonRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.VENOMOUS_SPIDER, VenomousSpiderRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.VENOMOUS_ZOMBIE, VenomousZombieRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.VENOMOUS_CREEPER, VenomousCreeperRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.SAND_SPIDER, SandSpiderRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.SCORCHED_CREEPER, ScorchedCreeperRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.CRIMSON_SKELETON, CrimsonSkeletonRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.WARPED_SKELETON, WarpedSkeletonRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.WILD_BOAR, WildBoarRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.SNOWY_SKELETON, SnowySkeletonRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.SNOWY_PIG, SnowyPigRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.SNOWY_COW, SnowyCowRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.SNOWY_SPIDER, SnowySpiderRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.SNOW_SPIDER, SnowSpiderRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.SNOWY_CREEPER, SnowyCreeperRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.SNOWY_ZOMBIE, SnowyZombieRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.FROZEN_SKELETON, FrozenSkeletonRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.FROZEN_CREEPER, FrozenCreeperRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.FROZEN_SPIDER, FrozenSpiderRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.ICE_SPIDER, IceSpiderRenderer::new);
        EntityRenderers.register(CreaturesEntityTypes.FROZEN_ZOMBIE, FrozenZombieRenderer::new);

        ImmutableMap.Builder<ModelLayerLocation, LayerDefinition> builder = ImmutableMap.builder();

        var bipedEquipmentModelData = HumanoidModel.createArmorMeshSet(HAT_DILATION, ARMOR_DILATION)
                .map(data -> LayerDefinition.create(data, 64, 32));
        var babyBipedEquipmentModelData = bipedEquipmentModelData.map(modelData -> modelData.apply(HumanoidModel.BABY_TRANSFORMER));

        var skeletonOuterTexturedModelData = bipedTexturedModelData64x32(OUTER_DILATION);
        var skeletonOuterPantsTexturedModelData = bipedTexturedModelData64x32(new CubeDeformation(0.25f));
        var zombieTexturedModelData64x64 = zombieTexturedModelData(CubeDeformation.NONE, 64);
        var zombieOuterTexturedModelData64x64 = zombieTexturedModelData(OUTER_DILATION, 64);
        var zombieTexturedModelData64x32 = zombieTexturedModelData(CubeDeformation.NONE, 32);
        var zombieOuterTexturedModelData64x32 = zombieTexturedModelData(OUTER_DILATION, 32);

        builder.put(CreaturesEntityModelLayers.VENOMOUS_SKELETON, SkeletonModel.createBodyLayer());
        builder.put(CreaturesEntityModelLayers.VENOMOUS_SKELETON_OUTER, skeletonOuterTexturedModelData);
        builder.put(CreaturesEntityModelLayers.VENOMOUS_SKELETON_OUTER_PANTS, skeletonOuterPantsTexturedModelData);
        builder.put(CreaturesEntityModelLayers.VENOMOUS_SPIDER, SpiderModel.createSpiderBodyLayer());
        builder.put(CreaturesEntityModelLayers.VENOMOUS_CREEPER_OUTER, CreeperModel.createBodyLayer(OUTER_DILATION));
        builder.put(CreaturesEntityModelLayers.VENOMOUS_ZOMBIE, zombieTexturedModelData64x64);
        builder.put(CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_OUTER, zombieOuterTexturedModelData64x64);
        builder.put(CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY, zombieTexturedModelData64x64.apply(HumanoidModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY_OUTER, zombieOuterTexturedModelData64x64.apply(HumanoidModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.SAND_SPIDER, SpiderModel.createSpiderBodyLayer());
        builder.put(CreaturesEntityModelLayers.SCORCHED_CREEPER_OUTER, CreeperModel.createBodyLayer(OUTER_DILATION));
        builder.put(CreaturesEntityModelLayers.CRIMSON_SKELETON, SkeletonModel.createBodyLayer());
        builder.put(CreaturesEntityModelLayers.WARPED_SKELETON, SkeletonModel.createBodyLayer());
        builder.put(CreaturesEntityModelLayers.WILD_BOAR, WildBoarEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.WILD_BOAR_BABY, WildBoarEntityModel.getTexturedModelData());
        builder.put(CreaturesEntityModelLayers.SNOWY_SKELETON, SkeletonModel.createBodyLayer());
        builder.put(CreaturesEntityModelLayers.SNOWY_SKELETON_OUTER, skeletonOuterTexturedModelData);
        builder.put(CreaturesEntityModelLayers.SNOWY_PIG, PigModel.createBodyLayer(CubeDeformation.NONE));
        builder.put(CreaturesEntityModelLayers.SNOWY_PIG_BABY, PigModel.createBodyLayer(CubeDeformation.NONE));
        builder.put(CreaturesEntityModelLayers.SNOWY_COW, CowModel.createBodyLayer());
        builder.put(CreaturesEntityModelLayers.SNOWY_COW_BABY, CowModel.createBodyLayer());
        builder.put(CreaturesEntityModelLayers.SNOWY_SPIDER, SpiderModel.createSpiderBodyLayer());
        builder.put(CreaturesEntityModelLayers.SNOW_SPIDER, SpiderModel.createSpiderBodyLayer());
        builder.put(CreaturesEntityModelLayers.SNOWY_CREEPER_OUTER, CreeperModel.createBodyLayer(OUTER_DILATION));
        builder.put(CreaturesEntityModelLayers.SNOWY_ZOMBIE, zombieTexturedModelData64x32);
        builder.put(CreaturesEntityModelLayers.SNOWY_ZOMBIE_OUTER, zombieOuterTexturedModelData64x32);
        builder.put(CreaturesEntityModelLayers.SNOWY_ZOMBIE_BABY, zombieTexturedModelData64x32.apply(HumanoidModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.SNOWY_ZOMBIE_BABY_OUTER, zombieOuterTexturedModelData64x32.apply(HumanoidModel.BABY_TRANSFORMER));
        builder.put(CreaturesEntityModelLayers.FROZEN_SKELETON, SkeletonModel.createBodyLayer());
        builder.put(CreaturesEntityModelLayers.FROZEN_SPIDER, SpiderModel.createSpiderBodyLayer());
        builder.put(CreaturesEntityModelLayers.ICE_SPIDER, SpiderModel.createSpiderBodyLayer());
        builder.put(CreaturesEntityModelLayers.FROZEN_ZOMBIE, zombieTexturedModelData64x64);
        builder.put(CreaturesEntityModelLayers.FROZEN_ZOMBIE_BABY, zombieTexturedModelData64x64.apply(HumanoidModel.BABY_TRANSFORMER));

        CreaturesEntityModelLayers.VENOMOUS_SKELETON_EQUIPMENT.putFrom(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_EQUIPMENT.putFrom(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY_EQUIPMENT.putFrom(babyBipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.CRIMSON_SKELETON_EQUIPMENT.putFrom(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.WARPED_SKELETON_EQUIPMENT.putFrom(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.SNOWY_SKELETON_EQUIPMENT.putFrom(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.SNOWY_ZOMBIE_EQUIPMENT.putFrom(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.SNOWY_ZOMBIE_BABY_EQUIPMENT.putFrom(babyBipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.FROZEN_SKELETON_EQUIPMENT.putFrom(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.FROZEN_ZOMBIE_EQUIPMENT.putFrom(bipedEquipmentModelData, builder);
        CreaturesEntityModelLayers.FROZEN_ZOMBIE_BABY_EQUIPMENT.putFrom(babyBipedEquipmentModelData, builder);

        builder.build().entrySet().forEach(
                entry -> ModelLayerRegistry.registerModelLayer(entry.getKey(), entry::getValue)
        );
    }

    private static @NotNull LayerDefinition bipedTexturedModelData64x32(CubeDeformation dilation) {
        return LayerDefinition.create(
                HumanoidModel.createMesh(dilation, 0.0f),
                64,
                32
        );
    }

    private static LayerDefinition zombieTexturedModelData(CubeDeformation dilation, int height) {
        return LayerDefinition.create(
                ZombieModel.createMesh(dilation, 0f),
                64,
                height
        );
    }
}
