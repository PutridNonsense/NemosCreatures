package com.nemonotfound.nemos.creatures.client.render.entity;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class FrozenCreeperRenderer extends CreeperRenderer {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/creeper/frozen_creeper.png");

    public FrozenCreeperRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull CreeperRenderState creeperRenderState) {
        return TEXTURE;
    }
}
