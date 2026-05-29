package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.SandSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

import com.mojang.blaze3d.vertex.PoseStack;
import org.jspecify.annotations.NonNull;

public class SandSpiderRenderer extends SpiderRenderer<SandSpider> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/spider/sand_spider.png");
    private static final float SCALE = 0.4f;

    public SandSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, CreaturesEntityModelLayers.SAND_SPIDER);
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
