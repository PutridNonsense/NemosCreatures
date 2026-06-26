package com.nemonotfound.nemos.creatures.world.entity.mob;

import java.util.Collection;
import java.util.List;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class FrozenCreeper extends Creeper {

    public FrozenCreeper(EntityType<? extends Creeper> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public @NonNull Collection<MobEffectInstance> getActiveEffects() {
        return List.of(new MobEffectInstance(MobEffects.SLOWNESS, 400, 0));
    }

    @Override
    public boolean canBeAffected(MobEffectInstance effect) {
        if (effect.getEffect() == MobEffects.SLOWNESS) {
            return false;
        }
        return super.canBeAffected(effect);
    }

    public static AttributeSupplier.@NonNull Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.23);
    }
}
