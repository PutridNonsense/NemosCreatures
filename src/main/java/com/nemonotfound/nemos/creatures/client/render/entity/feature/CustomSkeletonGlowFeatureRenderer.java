package com.nemonotfound.nemos.creatures.client.render.entity.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.monster.skeleton.SkeletonModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

@Environment(value= EnvType.CLIENT)
public class CustomSkeletonGlowFeatureRenderer<M extends SkeletonModel<SkeletonRenderState>>
        extends EyesLayer<SkeletonRenderState, M> {

    private final RenderType eyes;

    public CustomSkeletonGlowFeatureRenderer(RenderLayerParent<SkeletonRenderState, M> featureRendererContext, String path) {
        super(featureRendererContext);
        eyes = RenderTypes.eyes(Identifier.fromNamespaceAndPath(MOD_ID, path));
    }

    @Override
    public @NonNull RenderType renderType() {
        return eyes;
    }
}
