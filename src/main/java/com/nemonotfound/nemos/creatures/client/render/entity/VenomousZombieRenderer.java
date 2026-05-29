package com.nemonotfound.nemos.creatures.client.render.entity;

import com.nemonotfound.nemos.creatures.client.render.entity.feature.ZombieOverlayFeatureRenderer;
import com.nemonotfound.nemos.creatures.client.render.entity.model.CreaturesEntityModelLayers;
import com.nemonotfound.nemos.creatures.entity.mob.VenomousZombie;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.monster.zombie.ZombieModel;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class VenomousZombieRenderer extends AbstractZombieRenderer<VenomousZombie, ZombieRenderState, ZombieModel<ZombieRenderState>> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/zombie/venomous_zombie.png");
    private static final Identifier OVERLAY_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/entity/zombie/venomous_zombie_overlay.png");

    public VenomousZombieRenderer(EntityRendererProvider.Context context) {
        this(context, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_EQUIPMENT, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY_EQUIPMENT);
    }

    public VenomousZombieRenderer(EntityRendererProvider.Context context, ModelLayerLocation body, ModelLayerLocation baby, ArmorModelSet<ModelLayerLocation> equipmentModelData, ArmorModelSet<ModelLayerLocation> babyEquipmentModelData) {
        super(
                context,
                new ZombieModel<>(context.bakeLayer(body)),
                new ZombieModel<>(context.bakeLayer(baby)),
                ArmorModelSet.bake(equipmentModelData, context.getModelSet(), ZombieModel::new),
                ArmorModelSet.bake(babyEquipmentModelData, context.getModelSet(), ZombieModel::new)
        );
        this.addLayer(new ZombieOverlayFeatureRenderer<>(this, context.getModelSet(), CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_OUTER, CreaturesEntityModelLayers.VENOMOUS_ZOMBIE_BABY_OUTER, OVERLAY_TEXTURE));
    }

    @Override
    public ZombieRenderState createRenderState() {
        return new ZombieRenderState();
    }

    @Override
    public @NonNull Identifier getTextureLocation(ZombieRenderState state) {
        return TEXTURE;
    }
}
