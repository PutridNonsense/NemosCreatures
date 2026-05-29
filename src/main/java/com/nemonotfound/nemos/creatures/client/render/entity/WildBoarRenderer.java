package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.client.render.entity.model.WildBoarEntityModel;
import com.nemonotfound.nemos.creatures.client.render.entity.state.WildBoarRenderState;
import com.nemonotfound.nemos.creatures.entity.mob.WildBoar;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.AgeableMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

import com.mojang.blaze3d.vertex.PoseStack;
import org.jspecify.annotations.NonNull;

public class WildBoarRenderer extends AgeableMobRenderer<WildBoar, WildBoarRenderState, WildBoarEntityModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/pig/wild_boar.png");

    public WildBoarRenderer(EntityRendererProvider.Context context) {
        super(context, new WildBoarEntityModel(context.bakeLayer(CreaturesEntityModelLayers.WILD_BOAR)), new WildBoarEntityModel(context.bakeLayer(CreaturesEntityModelLayers.WILD_BOAR_BABY)), 0.7f);
    }

    @Override
    public @NonNull Identifier getTextureLocation(WildBoarRenderState wildBoarRenderState) {
        return TEXTURE;
    }

    @Override
    public void submit(WildBoarRenderState wildBoarRenderState, @NonNull PoseStack matrixStack, @NonNull SubmitNodeCollector orderedRenderCommandQueue, @NonNull CameraRenderState cameraRenderState) {
        if(wildBoarRenderState.isBaby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.submit(wildBoarRenderState, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    @Override
    public WildBoarRenderState createRenderState() {
        return new WildBoarRenderState();
    }

    //TODO: Check
    public void updateRenderState(WildBoar wildBoar, WildBoarRenderState wildBoarRenderState, float f) {
        super.extractRenderState(wildBoar, wildBoarRenderState, f);
        wildBoarRenderState.idleAnimationState.copyFrom(wildBoar.idleAnimationState);
        wildBoarRenderState.attackAnimationState.copyFrom(wildBoar.attackAnimationState);
    }
}
