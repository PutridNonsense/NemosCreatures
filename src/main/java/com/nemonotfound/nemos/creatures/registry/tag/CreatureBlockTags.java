package com.nemonotfound.nemos.creatures.registry.tag;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CreatureBlockTags {

    public static final TagKey<Block> CRIMSON_BONE_MEAL_REPLACEABLE = of("crimson_bone_meal_replaceable");
    public static final TagKey<Block> WARPED_BONE_MEAL_REPLACEABLE = of("warped_bone_meal_replaceable");

    private static TagKey<Block> of(String id) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MOD_ID, id));
    }
}
