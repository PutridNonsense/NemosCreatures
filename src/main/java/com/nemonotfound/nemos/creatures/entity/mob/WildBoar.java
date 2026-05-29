package com.nemonotfound.nemos.creatures.entity.mob;

import com.nemonotfound.nemos.creatures.entity.CreaturesEntityTypes;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class WildBoar extends Pig implements NeutralMob {

    private static final EntityDataAccessor<Boolean> ATTACK = SynchedEntityData.defineId(WildBoar.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    private static final Ingredient BREEDING_INGREDIENT = Ingredient.of(Items.CARROT, Items.POTATO, Items.BEETROOT);
    private static final UniformInt ANGER_TIME_RANGE = TimeUtil.rangeOfSeconds(20, 39);
    private long angerEndTime;
    private EntityReference<LivingEntity> angryAt;

    public WildBoar(EntityType<? extends Pig> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AttackGoal());
        this.goalSelector.addGoal(1, new BoarEscapeDangerGoal());
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2, BREEDING_INGREDIENT, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new BoarRevengeGoal());
        this.targetSelector.addGoal(2, new ProtectBabiesGoal());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isPlayerTooClose));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    @Override
    protected void updateWalkAnimation(float posDelta) {
        float f = this.getPose() == Pose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.walkAnimation.update(f, 0.2f, this.isBaby() ? 3.0F : 1.0F);
    }

    @Override
    public @NonNull SpawnGroupData finalizeSpawn(@NonNull ServerLevelAccessor world, @NonNull DifficultyInstance difficulty, @NonNull EntitySpawnReason spawnReason, @Nullable SpawnGroupData entityData) {
        if (entityData == null) {
            entityData = new AgeableMob.AgeableMobGroupData(1.0f);
        }
        return super.finalizeSpawn(world, difficulty, spawnReason, entityData);
    }

    public static AttributeSupplier.Builder createBoarAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MAX_HEALTH, 15.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.FOLLOW_RANGE, 10)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.ATTACK_KNOCKBACK, 1);
    }

    public static boolean canSpawn(EntityType<WildBoar> type, LevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        Holder<Biome> registryEntry = world.getBiome(pos);
        if (registryEntry.is(BiomeTags.IS_FOREST)) {
            return isBrightEnoughToSpawn(world, pos) && world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON);
        }
        return WildBoar.checkAnimalSpawnRules(type, world, spawnReason, pos, random);
    }

    protected static boolean isBrightEnoughToSpawn(BlockAndTintGetter world, BlockPos pos) {
        return world.getRawBrightness(pos, 0) > 8;
    }

    public boolean isPlayerTooClose(LivingEntity entity, ServerLevel world) {
        List<Player> closePlayers = world
                .getEntitiesOfClass(Player.class, WildBoar.this.getBoundingBox().inflate(5.0, 4.0, 5.0));

        if (!closePlayers.isEmpty() && entity instanceof Player) {
            return closePlayers.contains(entity);
        }

        return false;
    }

    @Override
    public Pig getBreedOffspring(@NonNull ServerLevel world, @NonNull AgeableMob entity) {
        return CreaturesEntityTypes.WILD_BOAR.create(world, EntitySpawnReason.BREEDING);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NonNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACK, false);
    }

    @Override
    public float getVoicePitch() {
        if (this.isBaby()) {
            return 1.3F;
        }
        return 0.7F;
    }

    @Override
    public @NonNull InteractionResult mobInteract(@NonNull Player player, @NonNull InteractionHand hand) {
        InteractionResult actionResult = super.mobInteract(player, hand);

        if (!actionResult.consumesAction()) {
            return InteractionResult.PASS;
        }

        return actionResult;
    }

    @Override
    public boolean isFood(@NonNull ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    @Override
    public void onSyncedDataUpdated(@NonNull EntityDataAccessor<?> data) {
        super.onSyncedDataUpdated(data);
    }

    @Override
    protected void addAdditionalSaveData(@NonNull ValueOutput view) {
        super.addAdditionalSaveData(view);
        this.addPersistentAngerSaveData(view);
    }

    @Override
    protected void readAdditionalSaveData(@NonNull ValueInput view) {
        super.readAdditionalSaveData(view);
        this.readPersistentAngerSaveData(this.level(), view);
    }

    @Override
    public @NonNull Vec3 getLeashOffset() {
        return new Vec3(0.0, 0.6f * this.getEyeHeight(), this.getBbWidth() * 0.4f);
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setPersistentAngerEndTime(ANGER_TIME_RANGE.sample(this.random));
    }

    @Override
    public long getPersistentAngerEndTime() {
        return this.angerEndTime;
    }

    @Override
    public void setPersistentAngerEndTime(long angerEndTime) {
        this.angerEndTime = angerEndTime;
    }

    @Override
    public EntityReference<LivingEntity> getPersistentAngerTarget() {
        return this.angryAt;
    }

    @Override
    public void setPersistentAngerTarget(EntityReference<LivingEntity> angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    public void tick() {
        super.tick();
        var world = level();

        if (!world.isClientSide()) {
            this.updatePersistentAnger((ServerLevel) world, true);
        }

        if(world.isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAggressive() && this.isAttack() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 19;
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAggressive()) {
            attackAnimationState.stop();
        }
    }

    public boolean isAttack() {
        return this.entityData.get(ATTACK);
    }

    public void setAttack(boolean attacking) {
        this.entityData.set(ATTACK, attacking);
    }

    class AttackGoal
            extends MeleeAttackGoal {

        public AttackGoal() {
            super(WildBoar.this, 1.25, true);
        }

        @Override
        protected void checkAndPerformAttack(@NonNull LivingEntity target) {
            if (this.canPerformAttack(target)) {
                this.resetAttackCooldown();
                this.mob.doHurtTarget(getServerLevel(this.mob), target);
                WildBoar.this.setAttack(true);
            } else if (this.mob.distanceToSqr(target) < (double)((target.getBbWidth() + 3.0f) * (target.getBbWidth() + 3.0f))) {
                if (this.isTimeToAttack()) {
                    this.resetAttackCooldown();
                }
            } else {
                this.resetAttackCooldown();
                WildBoar.this.setAttack(false);
            }
        }

        @Override
        public void stop() {
            WildBoar.this.setAttack(false);
            super.stop();
        }
    }

    class BoarEscapeDangerGoal
            extends PanicGoal {
        public BoarEscapeDangerGoal() {
            super(WildBoar.this, 2.0);
        }

        @Override
        protected boolean shouldPanic() {
            return this.mob.getLastHurtByMob() != null && this.mob.isBaby() || this.mob.isOnFire();
        }
    }

    class BoarRevengeGoal
            extends HurtByTargetGoal {
        public BoarRevengeGoal() {
            super(WildBoar.this);
        }

        @Override
        public void start() {
            super.start();
            if (WildBoar.this.isBaby()) {
                this.alertOthers();
                this.stop();
            }
        }

        @Override
        protected void alertOther(@NonNull Mob mob, @NonNull LivingEntity target) {
            if (mob instanceof WildBoar && !mob.isBaby()) {
                super.alertOther(mob, target);
            }
        }
    }

    class ProtectBabiesGoal
            extends NearestAttackableTargetGoal<Player> {
        public ProtectBabiesGoal() {
            super(WildBoar.this, Player.class, 20, true, true, null);
        }

        @Override
        public boolean canUse() {
            if (WildBoar.this.isBaby()) {
                return false;
            }
            if (super.canUse()) {
                List<WildBoar> wildBoars = WildBoar.this.level()
                        .getEntitiesOfClass(WildBoar.class, WildBoar.this.getBoundingBox().inflate(8.0, 4.0, 8.0));
                for (WildBoar wildBoar : wildBoars) {
                    if (!wildBoar.isBaby()) continue;
                    return true;
                }
            }
            return false;
        }

        @Override
        protected double getFollowDistance() {
            return super.getFollowDistance() * 0.5;
        }
    }
}
