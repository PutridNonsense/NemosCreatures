package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSkeletonGlowFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.world.entity.mob.WarpedSkeleton;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class WarpedSkeletonRenderer extends AbstractSkeletonRenderer<WarpedSkeleton, SkeletonRenderState> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/skeleton/warped_skeleton.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/skeleton/warped_skeleton_glow.png";

    public WarpedSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, CreaturesEntityModelLayers.WARPED_SKELETON, CreaturesEntityModelLayers.WARPED_SKELETON_EQUIPMENT);
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
