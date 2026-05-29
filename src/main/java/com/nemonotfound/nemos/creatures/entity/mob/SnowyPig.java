package com.nemonotfound.nemos.creatures.entity.mob;

import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public class SnowyPig extends Pig {

    public SnowyPig(EntityType<? extends Pig> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    @Nullable
    public Pig getBreedOffspring(@NonNull ServerLevel world, @NonNull AgeableMob entity) {
        return CreaturesEntityTypes.SNOWY_PIG.create(world, EntitySpawnReason.BREEDING);
    }
}
