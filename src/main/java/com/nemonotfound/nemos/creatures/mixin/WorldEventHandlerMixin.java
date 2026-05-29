package com.nemonotfound.nemos.creatures.mixin;

import com.nemonotfound.nemos.creatures.item.CrimsonBoneMealItem;
import com.nemonotfound.nemos.creatures.item.FrozenBoneMealItem;
import com.nemonotfound.nemos.creatures.item.ParchedBoneMealItem;
import com.nemonotfound.nemos.creatures.item.WarpedBoneMealItem;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelEventHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nemonotfound.nemos.creatures.world.CreatureWorldEvents.*;

@Mixin(LevelEventHandler.class)
public class WorldEventHandlerMixin {

    @Shadow @Final private ClientLevel level;

    @Inject(method = "levelEvent", at = @At(value = "TAIL"))
    private void processWorldEvent(int eventId, BlockPos pos, int count, CallbackInfo ci) {
        switch (eventId) {
            case FROZEN_BONE_MEAL_USED:
                FrozenBoneMealItem.createParticles(this.level, pos, count);
                FrozenBoneMealItem.playSound(this.level, pos);
                playBoneMealUseSound(pos);
            case PARCHED_BONE_MEAL_USED:
                ParchedBoneMealItem.createParticles(this.level, pos, count);
                playBoneMealUseSound(pos);
            case CRIMSON_BONE_MEAL_USED:
                CrimsonBoneMealItem.createParticles(this.level, pos, count);
                playBoneMealUseSound(pos);
            case WARPED_BONE_MEAL_USED:
                WarpedBoneMealItem.createParticles(this.level, pos, count);
                playBoneMealUseSound(pos);
        }
    }

    @Unique
    private void playBoneMealUseSound(BlockPos pos) {
        this.level.playLocalSound(pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
    }
}
