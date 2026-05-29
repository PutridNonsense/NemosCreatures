package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.entity.mob.VenomousSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers.VENOMOUS_SPIDER;

import com.mojang.blaze3d.vertex.PoseStack;
import org.jspecify.annotations.NonNull;

public class VenomousSpiderRenderer extends SpiderRenderer<VenomousSpider> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/spider/venomous_spider.png");
    private static final float SCALE = 0.8f;

    public VenomousSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, VENOMOUS_SPIDER);
        this.shadowRadius *= SCALE;
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull LivingEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    protected void scale(LivingEntityRenderState state, PoseStack matrices) {
        matrices.scale(SCALE, SCALE, SCALE);
    }
}
