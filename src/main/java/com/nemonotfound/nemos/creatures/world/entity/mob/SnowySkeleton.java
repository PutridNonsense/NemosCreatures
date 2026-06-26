package com.nemonotfound.nemos.creatures.world.entity.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.skeleton.AbstractSkeleton;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public class SnowySkeleton extends AbstractSkeleton {

    public SnowySkeleton(EntityType<? extends AbstractSkeleton> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    @Override
    protected @NonNull SoundEvent getHurtSound(@NonNull DamageSource source) {
        return SoundEvents.SKELETON_HURT;
    }

    @Override
    protected @NonNull SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

    @Override
    protected @NonNull SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    @Override
    protected void playStepSound(@NonNull BlockPos pos, @NonNull BlockState state) {
        this.playSound(this.getStepSound(), 0.15F, 0.5F);
    }

    @Override
    public float getVoicePitch() {
        return 1.1F;
    }

    @Override
    public float getSoundVolume() {
        return 0.8F;
    }

    @Override
    protected @NonNull AbstractArrow getArrow(@NonNull ItemStack arrow, float damageModifier, @Nullable ItemStack shotFrom) {
        AbstractArrow persistentProjectileEntity = super.getArrow(arrow, damageModifier, shotFrom);

        if (persistentProjectileEntity instanceof Arrow) {
            ((Arrow)persistentProjectileEntity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 200));
        }

        return persistentProjectileEntity;
    }
}
