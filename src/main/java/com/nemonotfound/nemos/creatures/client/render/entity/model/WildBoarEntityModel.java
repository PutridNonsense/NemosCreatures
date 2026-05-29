package com.nemonotfound.nemos.creatures.client.render.entity.model;

import com.nemonotfound.nemos.creatures.client.render.entity.animation.Animations;
import com.nemonotfound.nemos.creatures.client.render.entity.state.WildBoarRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class WildBoarEntityModel extends QuadrupedModel<WildBoarRenderState> {

    private final KeyframeAnimation idleAnimation;
    private final KeyframeAnimation attackAnimation;

    public WildBoarEntityModel(ModelPart root) {
        super(root);

        this.idleAnimation = Animations.WILD_BOAR_IDLE.bake(root);
        this.attackAnimation = Animations.WILD_BOAR_ATTACK.bake(root);
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition body = modelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -14.0F, -9.0F, 10.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition back = body.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));
        back.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 28).addBox(-2.6889F, -15.0301F, -6.0F, 3.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-1.6889F, -16.0301F, -6.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition head = modelPartData.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(38, 34).addBox(-3.0F, 0.0F, -10.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(36, 0).addBox(-1.6889F, -5.0301F, -8.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(32, 41).addBox(-0.6889F, -6.0301F, -7.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -8.0F));
        head.addOrReplaceChild("horn_right", CubeListBuilder.create().texOffs(7, 10).addBox(-5.0F, -11.0F, -17.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.0F, -13.0F, -17.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0F, 8.0F, 0.0F, 0.0F, -0.0873F));
        head.addOrReplaceChild("horn_left", CubeListBuilder.create().texOffs(7, 12).addBox(3.0F, -11.0F, -17.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(4.0F, -13.0F, -17.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 12.0F, 8.0F, 0.0F, 0.0F, 0.0873F));

        modelPartData.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, 6.0F));
        modelPartData.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(16, 41).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, 6.0F));
        modelPartData.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, -6.0F));
        modelPartData.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(38, 24).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, -6.0F));

        return LayerDefinition.create(modelData, 64, 64);
    }

    @Override
    public void setupAnim(WildBoarRenderState wildBoarRenderState) {
        super.setupAnim(wildBoarRenderState);

        this.idleAnimation.apply(wildBoarRenderState.idleAnimationState, wildBoarRenderState.ageInTicks);
        this.attackAnimation.apply(wildBoarRenderState.attackAnimationState, wildBoarRenderState.ageInTicks);
    }
}