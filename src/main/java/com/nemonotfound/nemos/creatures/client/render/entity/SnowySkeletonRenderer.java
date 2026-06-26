package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.world.entity.mob.SnowySkeleton;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.SkeletonClothingLayer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class SnowySkeletonRenderer extends AbstractSkeletonRenderer<SnowySkeleton, SkeletonRenderState> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/skeleton/snowy_skeleton.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/skeleton/snowy_skeleton_overlay.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/snowy_skeleton_glow.png";

    public SnowySkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, CreaturesEntityModelLayers.SNOWY_SKELETON, CreaturesEntityModelLayers.SNOWY_SKELETON_EQUIPMENT);
        this.addLayer(new CustomSkeletonGlowFeatureRenderer<>(this, EYES_TEXTURE_PATH));
        this.addLayer(new SkeletonClothingLayer<>(this, context.getModelSet(), CreaturesEntityModelLayers.SNOWY_SKELETON_OUTER, OVERLAY_TEXTURE));
    }

    @Override
    public SkeletonRenderState createRenderState() {
        return new SkeletonRenderState();
    }

    @Override
    public @NonNull Identifier getTextureLocation(SkeletonRenderState state) {
        return TEXTURE;
    }
}
