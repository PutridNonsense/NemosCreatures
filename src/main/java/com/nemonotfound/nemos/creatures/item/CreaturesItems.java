package com.nemonotfound.nemos.creatures.item;

import com.nemonotfound.nemos.creatures.block.CreaturesBlocks;
import com.nemonotfound.nemos.creatures.reference.CreaturesBlockItemIds;
import com.nemonotfound.nemos.creatures.reference.CreaturesItemIds;
import com.nemonotfound.nemos.creatures.world.entity.CreaturesEntityTypes;
import java.util.function.BiFunction;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;

public class CreaturesItems {

    public static final Item VENOMOUS_SKELETON_SPAWN_EGG = register(CreaturesItemIds.VENOMOUS_SKELETON_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.VENOMOUS_SKELETON));
    public static final Item VENOMOUS_SPIDER_SPAWN_EGG = register(CreaturesItemIds.VENOMOUS_SPIDER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.VENOMOUS_SPIDER));
    public static final Item VENOMOUS_ZOMBIE_SPAWN_EGG = register(CreaturesItemIds.VENOMOUS_ZOMBIE_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.VENOMOUS_ZOMBIE));
    public static final Item VENOMOUS_CREEPER_SPAWN_EGG = register(CreaturesItemIds.VENOMOUS_CREEPER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.VENOMOUS_CREEPER));
    public static final Item SAND_SPIDER_SPAWN_EGG = register(CreaturesItemIds.SAND_SPIDER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.SAND_SPIDER));
    public static final Item SCORCHED_CREEPER_SPAWN_EGG = register(CreaturesItemIds.SCORCHED_CREEPER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.SCORCHED_CREEPER));
    public static final Item CRIMSON_SKELETON_SPAWN_EGG = register(CreaturesItemIds.CRIMSON_SKELETON_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.CRIMSON_SKELETON));
    public static final Item WARPED_SKELETON_SPAWN_EGG = register(CreaturesItemIds.WARPED_SKELETON_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.WARPED_SKELETON));
    public static final Item WILD_BOAR_SPAWN_EGG = register(CreaturesItemIds.WILD_BOAR_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.WILD_BOAR));
    public static final Item SNOWY_SKELETON_SPAWN_EGG = register(CreaturesItemIds.SNOWY_SKELETON_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.SNOWY_SKELETON));
    public static final Item SNOWY_PIG_SPAWN_EGG = register(CreaturesItemIds.SNOWY_PIG_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.SNOWY_PIG));
    public static final Item SNOWY_COW_SPAWN_EGG = register(CreaturesItemIds.SNOWY_COW_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.SNOWY_COW));
    public static final Item SNOWY_SPIDER_SPAWN_EGG = register(CreaturesItemIds.SNOWY_SPIDER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.SNOWY_SPIDER));
    public static final Item SNOW_SPIDER_SPAWN_EGG = register(CreaturesItemIds.SNOW_SPIDER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.SNOW_SPIDER));
    public static final Item SNOWY_CREEPER_SPAWN_EGG = register(CreaturesItemIds.SNOWY_CREEPER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.SNOWY_CREEPER));
    public static final Item SNOWY_ZOMBIE_SPAWN_EGG = register(CreaturesItemIds.SNOWY_ZOMBIE_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.SNOWY_ZOMBIE));
    public static final Item FROZEN_SKELETON_SPAWN_EGG = register(CreaturesItemIds.FROZEN_SKELETON_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.FROZEN_SKELETON));
    public static final Item FROZEN_CREEPER_SPAWN_EGG = register(CreaturesItemIds.FROZEN_CREEPER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.FROZEN_CREEPER));
    public static final Item FROZEN_SPIDER_SPAWN_EGG = register(CreaturesItemIds.FROZEN_SPIDER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.FROZEN_SPIDER));
    public static final Item ICE_SPIDER_SPAWN_EGG = register(CreaturesItemIds.ICE_SPIDER_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.ICE_SPIDER));
    public static final Item FROZEN_ZOMBIE_SPAWN_EGG = register(CreaturesItemIds.FROZEN_ZOMBIE_SPAWN_EGG, createSpawnEggItem(CreaturesEntityTypes.FROZEN_ZOMBIE));
    public static final Item SAND_DUST = register(CreaturesItemIds.SAND_DUST, Item::new);
    public static final Item FROZEN_BONE = register(CreaturesItemIds.FROZEN_BONE, Item::new);
    public static final Item FROZEN_BONE_MEAL = register(CreaturesItemIds.FROZEN_BONE_MEAL, FrozenBoneMealItem::new);
    public static final Item FROZEN_BONE_BLOCK = registerBlock(CreaturesBlockItemIds.FROZEN_BONE_BLOCK, CreaturesBlocks.FROZEN_BONE_BLOCK);
    public static final Item PARCHED_BONE = register(CreaturesItemIds.PARCHED_BONE, Item::new);
    public static final Item PARCHED_BONE_MEAL = register(CreaturesItemIds.PARCHED_BONE_MEAL, ParchedBoneMealItem::new);
    public static final Item PARCHED_BONE_BLOCK = registerBlock(CreaturesBlockItemIds.PARCHED_BONE_BLOCK, CreaturesBlocks.PARCHED_BONE_BLOCK);
    public static final Item CRIMSON_BONE = register(CreaturesItemIds.CRIMSON_BONE, Item::new);
    public static final Item CRIMSON_BONE_MEAL = register(CreaturesItemIds.CRIMSON_BONE_MEAL, CrimsonBoneMealItem::new);
    public static final Item CRIMSON_BONE_BLOCK = registerBlock(CreaturesBlockItemIds.CRIMSON_BONE_BLOCK, CreaturesBlocks.CRIMSON_BONE_BLOCK);
    public static final Item WARPED_BONE = register(CreaturesItemIds.WARPED_BONE, Item::new);
    public static final Item WARPED_BONE_MEAL = register(CreaturesItemIds.WARPED_BONE_MEAL, WarpedBoneMealItem::new);
    public static final Item WARPED_BONE_BLOCK = registerBlock(CreaturesBlockItemIds.WARPED_BONE_BLOCK, CreaturesBlocks.WARPED_BONE_BLOCK);

    public static void bootstrap() {}

    private static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory) {
        Item item = factory.apply(new Item.Properties().setId(key));

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static Item registerBlock(final BlockItemId blockItemId, final Block block) {
        return registerBlock(blockItemId, block, BlockItem::new);
    }

    private static Item registerBlock(final BlockItemId blockItemId, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory) {
        return registerBlock(blockItemId, block, itemFactory, new Item.Properties());
    }

    private static Item registerBlock(final BlockItemId blockItemId, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties) {
        return registerItem(
                blockItemId.item(),
                p -> itemFactory.apply(block, p),
                properties.useBlockDescriptionPrefix()
                        .requiredFeatures(block.requiredFeatures())
        );
    }

    private static Item registerItem(final ResourceKey<Item> key, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        Item item = itemFactory.apply(properties.setId(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static Function<Item.Properties, Item> createSpawnEggItem(EntityType<? extends Mob> entityType) {
        return settings -> new SpawnEggItem(settings.spawnEgg(entityType));
    }
}
