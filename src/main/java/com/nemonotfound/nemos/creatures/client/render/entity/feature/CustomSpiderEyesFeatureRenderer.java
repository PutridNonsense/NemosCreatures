package com.nemonotfound.nemos.creatures.client.render.entity.feature;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

import net.minecraft.client.model.monster.spider.SpiderModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class CustomSpiderEyesFeatureRenderer<M extends SpiderModel> extends EyesLayer<LivingEntityRenderState, M> {

    private final RenderType eyes;

    public CustomSpiderEyesFeatureRenderer(RenderLayerParent<LivingEntityRenderState, M> featureRendererContext, String path) {
        super(featureRendererContext);
        eyes = RenderTypes.eyes(Identifier.fromNamespaceAndPath(MOD_ID, path));
    }

    public @NonNull RenderType renderType() {
        return eyes;
    }
}
