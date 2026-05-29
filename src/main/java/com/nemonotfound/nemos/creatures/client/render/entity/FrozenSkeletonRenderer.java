package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.FrozenSkeleton;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class FrozenSkeletonRenderer extends AbstractSkeletonRenderer<FrozenSkeleton, SkeletonRenderState> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/skeleton/frozen_skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/frozen_skeleton_glow.png";

    public FrozenSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, CreaturesEntityModelLayers.FROZEN_SKELETON, CreaturesEntityModelLayers.FROZEN_SKELETON_EQUIPMENT);
        this.addLayer(new CustomSkeletonGlowFeatureRenderer<>(this, EYES_TEXTURE_PATH));
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
