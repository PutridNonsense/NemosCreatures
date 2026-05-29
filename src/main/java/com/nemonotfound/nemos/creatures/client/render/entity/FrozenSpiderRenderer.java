package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSpiderEyesFeatureRenderer;
import net.minecraft.client.model.monster.spider.SpiderModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.spider.Spider;
import org.jspecify.annotations.NonNull;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers.FROZEN_SPIDER;

public class FrozenSpiderRenderer<T extends Spider> extends MobRenderer<T, LivingEntityRenderState, SpiderModel> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/spider/frozen_spider.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/spider/frozen_spider_eyes.png";

    public FrozenSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, new SpiderModel(context.bakeLayer(FROZEN_SPIDER)), 0.8F);
        this.addLayer(new CustomSpiderEyesFeatureRenderer<>(this, EYES_TEXTURE_PATH));
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    public @NonNull Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
