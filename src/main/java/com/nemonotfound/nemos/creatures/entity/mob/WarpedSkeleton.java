package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.skeleton.AbstractSkeleton;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class WarpedSkeleton extends AbstractSkeleton {

    public WarpedSkeleton(EntityType<? extends AbstractSkeleton> entityType, Level world) {
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
    protected void populateDefaultEquipmentSlots(@NonNull RandomSource random, @NonNull DifficultyInstance localDifficulty) {
        super.populateDefaultEquipmentSlots(random, localDifficulty);
        ItemStack bow = new ItemStack(Items.BOW);
        this.setItemSlot(EquipmentSlot.MAINHAND, bow);
    }

    @Override
    public void setItemSlot(@NonNull EquipmentSlot slot, @NonNull ItemStack stack) {
        super.setItemSlot(slot, stack);
        if (!this.level().isClientSide()) {
            this.reassessWeaponGoal();
        }
    }

    @Override
    public void performRangedAttack(LivingEntity target, float pullProgress) {
        var bow = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW));
        var projectile = this.getProjectile(bow);
        var persistentProjectileEntity = this.getArrow(projectile, pullProgress, bow);
        persistentProjectileEntity.setInvisible(true);
        var d = target.getX() - this.getX();
        var e = target.getY(0.3333333333333333) - persistentProjectileEntity.getY();
        var f = target.getZ() - this.getZ();
        var g = Math.sqrt(d * d + f * f);
        var world = level();

        if (world instanceof ServerLevel serverWorld) {
            Projectile.spawnProjectileUsingShoot(persistentProjectileEntity, serverWorld, projectile, d, e + g * (double)0.1f, f, 2.5f, 7 - world.getDifficulty().getId() * 4);
        }

        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.2f + 0.6f));
    }
}
