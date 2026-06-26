package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.world.entity.mob.SnowySpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers.SNOWY_SPIDER;

public class SnowySpiderRenderer extends SpiderRenderer<SnowySpider> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/spider/snowy_spider.png");

    public SnowySpiderRenderer(EntityRendererProvider.Context context) {
        super(context, SNOWY_SPIDER);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull LivingEntityRenderState state) {
        return TEXTURE;
    }
}
