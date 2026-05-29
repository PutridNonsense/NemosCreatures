package com.nemonotfound.nemos.creatures.entity.mob;

import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public class SnowyCow extends Cow {

    public SnowyCow(EntityType<? extends Cow> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    @Nullable
    public Cow getBreedOffspring(@NonNull ServerLevel world, @NonNull AgeableMob entity) {
        return CreaturesEntityTypes.SNOWY_COW.create(world, EntitySpawnReason.BREEDING);
    }
}
