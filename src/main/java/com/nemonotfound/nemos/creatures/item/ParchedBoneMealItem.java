package com.nemonotfound.nemos.creatures.item;

import com.nemonotfound.nemos.creatures.world.CreatureWorldEvents;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jspecify.annotations.NonNull;

public class ParchedBoneMealItem extends Item {

    private static final Map<Block, Block> BLOCK_REPLACEMENT_MAP = Map.of(
            Blocks.GRASS_BLOCK, Blocks.SAND,
            Blocks.DIRT, Blocks.SAND,
            Blocks.SHORT_GRASS, Blocks.SHORT_DRY_GRASS,
            Blocks.TALL_GRASS, Blocks.TALL_DRY_GRASS,
            Blocks.BUSH, Blocks.DEAD_BUSH
    );

    public ParchedBoneMealItem(Properties settings) {
        super(settings);
    }

    @Override
    public @NonNull InteractionResult useOn(UseOnContext context) {
        var world = context.getLevel();
        var blockPos = context.getClickedPos();
        var blockState = world.getBlockState(blockPos);
        var itemStack = context.getItemInHand();

        if (useOnDryableBlock(world, blockState, blockPos, itemStack)) {
            if (!world.isClientSide()) {
                context.getPlayer().gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.levelEvent(CreatureWorldEvents.PARCHED_BONE_MEAL_USED, blockPos, 15);

            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    public static boolean useOnDryableBlock(Level world, BlockState blockState, BlockPos blockPos, ItemStack itemStack) {
        var oldBlock = blockState.getBlock();
        var blockReplacement = BLOCK_REPLACEMENT_MAP.get(oldBlock);

        if (blockReplacement == null) {
            return false;
        }

        if (world instanceof ServerLevel) {
            world.setBlockAndUpdate(calculateNewBlockPos(blockState, blockPos), blockReplacement.defaultBlockState());
            itemStack.shrink(1);
        }

        return true;
    }

    private static BlockPos calculateNewBlockPos(BlockState blockState, BlockPos blockPos) {
        if (
                blockState.hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF) &&
                        blockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF).equals(DoubleBlockHalf.UPPER)
        ) {
            return blockPos.below();
        }

        return blockPos;
    }

    public static void createParticles(LevelAccessor world, BlockPos pos, int count) {
        var blockState = world.getBlockState(pos);
        var oldBlock = blockState.getBlock();
        var blockReplacement = BLOCK_REPLACEMENT_MAP.get(oldBlock);

        if (blockReplacement != null) {
            ParticleUtils.spawnParticleInBlock(world, calculateNewBlockPos(blockState, pos), count, ParticleTypes.DUST_PLUME);
        }
    }
}
