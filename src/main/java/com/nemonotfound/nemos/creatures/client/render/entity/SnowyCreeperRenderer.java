package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CreeperOverlayFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class SnowyCreeperRenderer extends CreeperRenderer {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/creeper/snowy_creeper.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/creeper/snowy_creeper_overlay.png");

    public SnowyCreeperRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.addLayer(new CreeperOverlayFeatureRenderer<>(this, context.getModelSet(), CreaturesEntityModelLayers.SNOWY_CREEPER_OUTER, OVERLAY_TEXTURE));
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull CreeperRenderState creeperRenderState) {
        return TEXTURE;
    }
}
