package com.nemonotfound.nemos.creatures.entity.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class FrozenSpider extends Spider {

    public FrozenSpider(EntityType<? extends FrozenSpider> entityType, Level world) {
        super(entityType, world);
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
                    ((LivingEntity)target).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, durationMultiplier * 40, 0), this);
                }
            }
            return true;
        }
        return false;
    }

    public static AttributeSupplier.@NonNull Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 18.0).
                add(Attributes.MOVEMENT_SPEED, 0.28);
    }
}
