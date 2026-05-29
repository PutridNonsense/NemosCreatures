package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.CustomSpiderEyesFeatureRenderer;
import net.minecraft.client.model.monster.spider.SpiderModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.spider.Spider;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers.SNOW_SPIDER;

import com.mojang.blaze3d.vertex.PoseStack;
import org.jspecify.annotations.NonNull;

public class SnowSpiderRenderer<T extends Spider> extends MobRenderer<T, LivingEntityRenderState, SpiderModel> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/spider/snow_spider.png");
    private static final String EYES_TEXTURE_PATH = "textures/entity/spider/snow_spider_eyes.png";
    private static final float SCALE = 0.4f;

    public SnowSpiderRenderer(EntityRendererProvider.Context context) {
        super(context, new SpiderModel(context.bakeLayer(SNOW_SPIDER)), 0.8F);
        this.addLayer(new CustomSpiderEyesFeatureRenderer<>(this, EYES_TEXTURE_PATH));
        this.shadowRadius *= SCALE;
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    protected void scale(LivingEntityRenderState state, PoseStack matrices) {
        matrices.scale(SCALE, SCALE, SCALE);
    }

    @Override
    public @NonNull Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
