package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public class VenomousSpider extends Spider {

    public VenomousSpider(EntityType<? extends VenomousSpider> entityType, Level world) {
        super(entityType, world);
    }

    public static AttributeSupplier.Builder createJungleSpiderAttributes() {
        return Spider.createAttributes().add(Attributes.MAX_HEALTH, 14.0);
    }

    @Override
    public boolean doHurtTarget(@NonNull ServerLevel world, @NonNull Entity target) {
        if (super.doHurtTarget(world, target)) {
            if (target instanceof LivingEntity) {
                var durationMultiplier = 0;

                if (world.getDifficulty() == Difficulty.EASY) {
                    durationMultiplier = 3;
                } else if (world.getDifficulty() == Difficulty.NORMAL) {
                    durationMultiplier = 7;
                } else if (world.getDifficulty() == Difficulty.HARD) {
                    durationMultiplier = 15;
                }
                if (durationMultiplier > 0) {
                    ((LivingEntity)target).addEffect(new MobEffectInstance(MobEffects.POISON, durationMultiplier * 20, 0), this);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    @Nullable
    public SpawnGroupData finalizeSpawn(@NonNull ServerLevelAccessor world, @NonNull DifficultyInstance difficulty, @NonNull EntitySpawnReason spawnReason, @Nullable SpawnGroupData entityData) {
        return entityData;
    }

    @Override
    public @NonNull Vec3 getVehicleAttachmentPoint(Entity vehicle) {
        if (vehicle.getBbWidth() <= this.getBbWidth()) {
            return new Vec3(0.0, 0.21875 * (double)this.getScale(), 0.0);
        }
        return super.getVehicleAttachmentPoint(vehicle);
    }

    @Override
    public boolean canBeAffected(MobEffectInstance effect) {
        if (effect.getEffect() == MobEffects.POISON) {
            return false;
        }
        return super.canBeAffected(effect);
    }
}
