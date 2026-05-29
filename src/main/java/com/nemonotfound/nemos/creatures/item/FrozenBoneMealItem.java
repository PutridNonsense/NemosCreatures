package com.nemonotfound.nemos.creatures.item;

import com.nemonotfound.nemos.creatures.world.CreatureWorldEvents;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.HitResult;
import org.jspecify.annotations.NonNull;

public class FrozenBoneMealItem extends Item {

    private static final Map<Fluid, Block> FLUID_REPLACEMENT_MAP = Map.of(
            Fluids.WATER, Blocks.ICE,
            Fluids.LAVA, Blocks.OBSIDIAN
    );
    private static final Map<Fluid, ParticleOptions> FLUID_PARTICLE_MAP = Map.of(
            Fluids.WATER, ParticleTypes.SPLASH,
            Fluids.LAVA, ParticleTypes.FLAME
    );
    private static final Map<Fluid, SoundEvent> FLUID_SOUND_MAP = Map.of(
            Fluids.WATER, SoundEvents.BUCKET_EMPTY_POWDER_SNOW,
            Fluids.LAVA, SoundEvents.LAVA_EXTINGUISH
    );

    public FrozenBoneMealItem(Properties settings) {
        super(settings);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level world, @NonNull Player user, @NonNull InteractionHand hand) {
        var blockHitResult = getPlayerPOVHitResult(world, user, ClipContext.Fluid.SOURCE_ONLY);
        var hitResultType = blockHitResult.getType();

        if (hitResultType != HitResult.Type.BLOCK) {
            return InteractionResult.PASS;
        }

        var blockPos = blockHitResult.getBlockPos();
        var fluidState = world.getFluidState(blockPos);

        if (useOnFluidBlock(world, fluidState, blockPos, user.getItemInHand(hand))) {
            if (!world.isClientSide()) {
                user.gameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.levelEvent(CreatureWorldEvents.FROZEN_BONE_MEAL_USED, blockPos, 15);

            }
        }

        return InteractionResult.PASS;
    }

    public static boolean useOnFluidBlock(Level world, FluidState fluidState, BlockPos blockPos, ItemStack itemStack) {
        var blockReplacement = FLUID_REPLACEMENT_MAP.get(fluidState.getType());

        if (blockReplacement == null) {
            return false;
        }

        if (world instanceof ServerLevel) {
            world.setBlockAndUpdate(blockPos, blockReplacement.defaultBlockState());
            itemStack.shrink(1);
        }

        return true;
    }

    public static void createParticles(LevelAccessor world, BlockPos pos, int count) {
        var fluidState = world.getFluidState(pos);
        var blockReplacement = FLUID_REPLACEMENT_MAP.get(fluidState.getType());

        if (blockReplacement != null) {
            ParticleUtils.spawnParticleInBlock(world, pos.above(), count, FLUID_PARTICLE_MAP.get(fluidState.getType()));
        }
    }

    public static void playSound(Level world, BlockPos pos) {
        var fluidState = world.getFluidState(pos);
        var blockReplacement = FLUID_REPLACEMENT_MAP.get(fluidState.getType());

        if (blockReplacement != null) {
            world.playLocalSound(pos, FLUID_SOUND_MAP.get(fluidState.getType()), SoundSource.BLOCKS, 1.0F, 1.0F, false);
        }
    }
}
