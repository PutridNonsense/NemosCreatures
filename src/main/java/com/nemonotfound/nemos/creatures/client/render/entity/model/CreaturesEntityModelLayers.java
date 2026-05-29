package com.nemonotfound.nemos.creatures.client.render.entity.model;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;
import static com.nemonotfound.nemos.creatures.NemosCreatures.log;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.resources.Identifier;

public class CreaturesEntityModelLayers {

    private static final String MAIN = "main";
    public static final String OUTER = "outer";

    public static final ModelLayerLocation VENOMOUS_SKELETON = createEntityModelLayer("venomous_skeleton", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> VENOMOUS_SKELETON_EQUIPMENT = registerEquipment("venomous_skeleton");
    public static final ModelLayerLocation VENOMOUS_SKELETON_OUTER_PANTS = createEntityModelLayer("venomous_skeleton_outer_pants", "outer");
    public static final ModelLayerLocation VENOMOUS_SKELETON_OUTER = createEntityModelLayer("venomous_skeleton", "outer");
    public static final ModelLayerLocation VENOMOUS_SPIDER = createEntityModelLayer("venomous_spider", MAIN);
    public static final ModelLayerLocation VENOMOUS_CREEPER_OUTER = createEntityModelLayer("venomous_creeper", OUTER);
    public static final ModelLayerLocation VENOMOUS_ZOMBIE = createEntityModelLayer("venomous_zombie", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> VENOMOUS_ZOMBIE_EQUIPMENT = registerEquipment("venomous_zombie");
    public static final ModelLayerLocation VENOMOUS_ZOMBIE_OUTER = createEntityModelLayer("venomous_zombie", OUTER);
    public static final ModelLayerLocation VENOMOUS_ZOMBIE_BABY = createEntityModelLayer("venomous_zombie_baby", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> VENOMOUS_ZOMBIE_BABY_EQUIPMENT = registerEquipment("venomous_zombie_baby");
    public static final ModelLayerLocation VENOMOUS_ZOMBIE_BABY_OUTER = createEntityModelLayer("venomous_zombie_baby", OUTER);
    public static final ModelLayerLocation SAND_SPIDER = createEntityModelLayer("sand_spider", MAIN);
    public static final ModelLayerLocation SCORCHED_CREEPER_OUTER = createEntityModelLayer("scorched_creeper", OUTER);
    public static final ModelLayerLocation CRIMSON_SKELETON = createEntityModelLayer("crimson_skeleton", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> CRIMSON_SKELETON_EQUIPMENT = registerEquipment("crimson_skeleton");
    public static final ModelLayerLocation WARPED_SKELETON = createEntityModelLayer("warped_skeleton", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> WARPED_SKELETON_EQUIPMENT = registerEquipment("warped_skeleton");
    public static final ModelLayerLocation WILD_BOAR = createEntityModelLayer("wild_boar", MAIN);
    public static final ModelLayerLocation WILD_BOAR_BABY = createEntityModelLayer("wild_boar_baby", MAIN);
    public static final ModelLayerLocation SNOWY_SKELETON = createEntityModelLayer("snowy_skeleton", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> SNOWY_SKELETON_EQUIPMENT = registerEquipment("snowy_skeleton");
    public static final ModelLayerLocation SNOWY_SKELETON_OUTER = createEntityModelLayer("snowy_skeleton", OUTER);
    public static final ModelLayerLocation SNOWY_PIG = createEntityModelLayer("snowy_pig", MAIN);
    public static final ModelLayerLocation SNOWY_PIG_BABY = createEntityModelLayer("snowy_pig_baby", MAIN);
    public static final ModelLayerLocation SNOWY_COW = createEntityModelLayer("snowy_cow", MAIN);
    public static final ModelLayerLocation SNOWY_COW_BABY = createEntityModelLayer("snowy_cow_baby", MAIN);
    public static final ModelLayerLocation SNOWY_SPIDER = createEntityModelLayer("snowy_spider", MAIN);
    public static final ModelLayerLocation SNOW_SPIDER = createEntityModelLayer("snow_spider", MAIN);
    public static final ModelLayerLocation SNOWY_CREEPER_OUTER = createEntityModelLayer("snowy_creeper", OUTER);
    public static final ModelLayerLocation SNOWY_ZOMBIE = createEntityModelLayer("snowy_zombie", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> SNOWY_ZOMBIE_EQUIPMENT = registerEquipment("snowy_zombie");
    public static final ModelLayerLocation SNOWY_ZOMBIE_OUTER = createEntityModelLayer("snowy_zombie", OUTER);
    public static final ModelLayerLocation SNOWY_ZOMBIE_BABY = createEntityModelLayer("snowy_zombie_baby", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> SNOWY_ZOMBIE_BABY_EQUIPMENT = registerEquipment("snowy_zombie_baby");
    public static final ModelLayerLocation SNOWY_ZOMBIE_BABY_OUTER = createEntityModelLayer("snowy_zombie_baby", OUTER);
    public static final ModelLayerLocation FROZEN_SKELETON = createEntityModelLayer("frozen_skeleton", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> FROZEN_SKELETON_EQUIPMENT = registerEquipment("frozen_skeleton");
    public static final ModelLayerLocation FROZEN_SPIDER = createEntityModelLayer("frozen_spider", MAIN);
    public static final ModelLayerLocation ICE_SPIDER = createEntityModelLayer("ice_spider", MAIN);
    public static final ModelLayerLocation FROZEN_ZOMBIE = createEntityModelLayer("frozen_zombie", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> FROZEN_ZOMBIE_EQUIPMENT = registerEquipment("frozen_zombie");
    public static final ModelLayerLocation FROZEN_ZOMBIE_BABY = createEntityModelLayer("frozen_zombie_baby", MAIN);
    public static final ArmorModelSet<ModelLayerLocation> FROZEN_ZOMBIE_BABY_EQUIPMENT = registerEquipment("frozen_zombie_baby");

    public static void registerEntityModelLayers() {
        log.info("Register entity model layers");
    }
    
    private static ModelLayerLocation createEntityModelLayer(String path, String layer) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(MOD_ID, path), layer);
    }

    private static ArmorModelSet<ModelLayerLocation> registerEquipment(String path) {
        return new ArmorModelSet<>(createEntityModelLayer(path, "helmet"), createEntityModelLayer(path, "chestplate"), createEntityModelLayer(path, "leggings"), createEntityModelLayer(path, "boots"));
    }
}
