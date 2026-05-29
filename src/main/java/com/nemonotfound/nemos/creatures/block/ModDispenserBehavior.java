package com.nemonotfound.nemos.creatures.block;

import com.nemonotfound.nemos.creatures.item.*;
import com.nemonotfound.nemos.creatures.world.CreatureWorldEvents;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import org.jspecify.annotations.NonNull;

public interface ModDispenserBehavior {

    static void registerDefaults() {
        DispenserBlock.registerBehavior(CreaturesItems.FROZEN_BONE_MEAL, new OptionalDispenseItemBehavior() {
            @Override
            protected @NonNull ItemStack execute(@NonNull BlockSource pointer, @NonNull ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.level();
                var blockPos = pointer.pos().relative(pointer.state().getValue(DispenserBlock.FACING));
                var fluidState = world.getFluidState(blockPos);

                if (!FrozenBoneMealItem.useOnFluidBlock(world, fluidState, blockPos, stack)) {
                    this.setSuccess(false);
                } else if (!world.isClientSide()) {
                    world.levelEvent(CreatureWorldEvents.FROZEN_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });

        DispenserBlock.registerBehavior(CreaturesItems.PARCHED_BONE_MEAL, new OptionalDispenseItemBehavior() {
            @Override
            protected @NonNull ItemStack execute(@NonNull BlockSource pointer, @NonNull ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.level();
                var blockPos = pointer.pos().relative(pointer.state().getValue(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (!ParchedBoneMealItem.useOnDryableBlock(world, blockState, blockPos, stack)) {
                    this.setSuccess(false);
                } else if (!world.isClientSide()) {
                    world.levelEvent(CreatureWorldEvents.PARCHED_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });

        DispenserBlock.registerBehavior(CreaturesItems.CRIMSON_BONE_MEAL, new OptionalDispenseItemBehavior() {
            @Override
            protected @NonNull ItemStack execute(@NonNull BlockSource pointer, @NonNull ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.level();
                var blockPos = pointer.pos().relative(pointer.state().getValue(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (!CrimsonBoneMealItem.useOnReplaceable(world, blockState, blockPos, stack) && !CrimsonBoneMealItem.useOnCrimsonNylium(stack, world, blockState, blockPos)) {
                    this.setSuccess(false);
                } else if (!world.isClientSide()) {
                    world.levelEvent(CreatureWorldEvents.CRIMSON_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });

        DispenserBlock.registerBehavior(CreaturesItems.WARPED_BONE_MEAL, new OptionalDispenseItemBehavior() {
            @Override
            protected @NonNull ItemStack execute(@NonNull BlockSource pointer, @NonNull ItemStack stack) {
                this.setSuccess(true);
                var world = pointer.level();
                var blockPos = pointer.pos().relative(pointer.state().getValue(DispenserBlock.FACING));
                var blockState = world.getBlockState(blockPos);

                if (!WarpedBoneMealItem.useOnReplaceable(world, blockState, blockPos, stack) && !WarpedBoneMealItem.useOnWarpedNylium(stack, world, blockState, blockPos)) {
                    this.setSuccess(false);
                } else if (!world.isClientSide()) {
                    world.levelEvent(CreatureWorldEvents.WARPED_BONE_MEAL_USED, blockPos, 15);
                }

                return stack;
            }
        });
    }
}
