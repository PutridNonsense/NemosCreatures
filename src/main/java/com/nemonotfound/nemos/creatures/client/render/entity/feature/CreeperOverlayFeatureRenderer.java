package com.nemonotfound.nemos.creatures.client.render.entity.feature;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.monster.creeper.CreeperModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class CreeperOverlayFeatureRenderer<S extends CreeperRenderState, M extends EntityModel<S>> extends RenderLayer<S, M> {
    private final CreeperModel outerModel;
    private final Identifier texture;

    public CreeperOverlayFeatureRenderer(RenderLayerParent<S, M> context, EntityModelSet loader, ModelLayerLocation layer, Identifier texture) {
        super(context);
        this.texture = texture;
        this.outerModel = new CreeperModel(loader.bakeLayer(layer));
    }

    @Override
    public void submit(@NonNull PoseStack matrixStack, @NonNull SubmitNodeCollector submitNodeCollector, int light, S zombieEntityRenderState, float limbAngle, float limbDistance) {
        coloredCutoutModelCopyLayerRender(outerModel, this.texture, matrixStack, submitNodeCollector, light, zombieEntityRenderState, -1, 1);
    }
}
