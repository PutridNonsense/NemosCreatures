package com.nemonotfound.nemos.creatures.reference;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import static com.nemonotfound.nemos.creatures.NemosCreatures.MOD_ID;

public class CreaturesBlockItemIds {

    public static final BlockItemId FROZEN_BONE_BLOCK = create("frozen_bone_block");
    public static final BlockItemId PARCHED_BONE_BLOCK = create("parched_bone_block");
    public static final BlockItemId CRIMSON_BONE_BLOCK = create("crimson_bone_block");
    public static final BlockItemId WARPED_BONE_BLOCK = create("warped_bone_block");

    private static BlockItemId create(final String name) {
        Identifier id = Identifier.fromNamespaceAndPath(MOD_ID, name);
        return create(id, id);
    }

    private static BlockItemId create(final Identifier blockId, final Identifier itemId) {
        return new BlockItemId(ResourceKey.create(Registries.BLOCK, blockId), ResourceKey.create(Registries.ITEM, itemId));
    }
}
