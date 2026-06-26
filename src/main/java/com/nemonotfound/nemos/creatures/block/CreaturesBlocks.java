package com.nemonotfound.nemos.creatures.block;

import com.nemonotfound.nemos.creatures.reference.CreaturesBlockItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class CreaturesBlocks {

    public static final Block FROZEN_BONE_BLOCK = register(
            CreaturesBlockItemIds.FROZEN_BONE_BLOCK.block(),
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.ICE)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F)
                    .sound(SoundType.BONE_BLOCK)
    );
    public static final Block PARCHED_BONE_BLOCK = register(
            CreaturesBlockItemIds.PARCHED_BONE_BLOCK.block(),
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F)
                    .sound(SoundType.BONE_BLOCK)
    );
    public static final Block CRIMSON_BONE_BLOCK = register(
            CreaturesBlockItemIds.CRIMSON_BONE_BLOCK.block(),
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F)
                    .sound(SoundType.BONE_BLOCK)
    );
    public static final Block WARPED_BONE_BLOCK = register(
            CreaturesBlockItemIds.WARPED_BONE_BLOCK.block(),
            RotatedPillarBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F)
                    .sound(SoundType.BONE_BLOCK)
    );

    public static void bootstrap() {}

    private static Block register(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return Blocks.register(key, factory, settings);
    }
}
