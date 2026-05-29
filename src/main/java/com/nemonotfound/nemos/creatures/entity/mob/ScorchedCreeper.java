package com.nemonotfound.nemos.creatures.entity.mob;

import java.util.Collection;
import java.util.List;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class ScorchedCreeper extends Creeper {

    public ScorchedCreeper(EntityType<? extends Creeper> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public @NonNull Collection<MobEffectInstance> getActiveEffects() {
        return List.of(new MobEffectInstance(MobEffects.HUNGER, 200, 0));
    }

    @Override
    public boolean canBeAffected(MobEffectInstance effect) {
        if (effect.getEffect() == MobEffects.HUNGER) {
            return false;
        }
        return super.canBeAffected(effect);
    }
}
