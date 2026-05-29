package com.nemonotfound.nemos.creatures.client.render.entity.feature;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.monster.zombie.ZombieModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class ZombieOverlayFeatureRenderer<S extends ZombieRenderState, M extends EntityModel<S>> extends RenderLayer<S, M> {
    private final ZombieModel<S> outerModel;
    private final ZombieModel<S> babyOuterModel;
    private final Identifier texture;

    public ZombieOverlayFeatureRenderer(RenderLayerParent<S, M> context, EntityModelSet loader, ModelLayerLocation layer, ModelLayerLocation babyLayer, Identifier texture) {
        super(context);
        this.texture = texture;
        this.outerModel = new ZombieModel<>(loader.bakeLayer(layer));
        this.babyOuterModel = new ZombieModel<>(loader.bakeLayer(babyLayer));
    }

    @Override
    public void submit(@NonNull PoseStack matrixStack, @NonNull SubmitNodeCollector submitNodeCollector, int light, S zombieEntityRenderState, float limbAngle, float limbDistance) {
        coloredCutoutModelCopyLayerRender(getModel(zombieEntityRenderState), this.texture, matrixStack, submitNodeCollector, light, zombieEntityRenderState, -1, 1);
    }

    private ZombieModel<S> getModel(S state) {
        return state.isBaby ? this.babyOuterModel : this.outerModel;
    }
}
