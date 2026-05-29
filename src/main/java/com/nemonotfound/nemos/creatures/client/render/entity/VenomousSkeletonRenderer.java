package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.VenomousSkeleton;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.SkeletonClothingLayer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

@Environment(value = EnvType.CLIENT)
public class VenomousSkeletonRenderer extends AbstractSkeletonRenderer<VenomousSkeleton, SkeletonRenderState> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/skeleton/venomous_skeleton.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/skeleton/venomous_skeleton_overlay.png");
    private static final Identifier OVERLAY_PANTS_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/skeleton/venomous_skeleton_overlay_pants.png");

    public VenomousSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context, CreaturesEntityModelLayers.VENOMOUS_SKELETON, CreaturesEntityModelLayers.VENOMOUS_SKELETON_EQUIPMENT);
        this.addLayer(new SkeletonClothingLayer<>(this, context.getModelSet(), CreaturesEntityModelLayers.VENOMOUS_SKELETON_OUTER, OVERLAY_TEXTURE));
        this.addLayer(new SkeletonClothingLayer<>(this, context.getModelSet(), CreaturesEntityModelLayers.VENOMOUS_SKELETON_OUTER_PANTS, OVERLAY_PANTS_TEXTURE));
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
