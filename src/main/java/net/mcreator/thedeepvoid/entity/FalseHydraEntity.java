
package net.mcreator.thedeepvoid.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.thedeepvoid.procedures.FalseHydraPlayerCountProcedure;
import net.mcreator.thedeepvoid.procedures.FalseHydraPlayerCollidesWithThisEntityProcedure;
import net.mcreator.thedeepvoid.procedures.FalseHydraOnEntityTickUpdateProcedure;
import net.mcreator.thedeepvoid.procedures.FalseHydraEntityIsHurtProcedure;
import net.mcreator.thedeepvoid.procedures.FalseHydraEntityDiesProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;

import javax.annotation.Nullable;

public class FalseHydraEntity extends Monster implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_attackChance = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_rndEffect = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_volley = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_dying = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_laugh = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_playerCount = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_baseHealth = SynchedEntityData.defineId(FalseHydraEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.WHITE, ServerBossEvent.BossBarOverlay.NOTCHED_6);

	public FalseHydraEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheDeepVoidModEntities.FALSE_HYDRA.get(), world);
	}

	public FalseHydraEntity(EntityType<FalseHydraEntity> type, Level world) {
		super(type, world);
		xpReward = 250;
		setNoAi(false);
		setMaxUpStep(3f);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "falsehydra");
		this.entityData.define(DATA_attackChance, 0);
		this.entityData.define(DATA_rndEffect, 0);
		this.entityData.define(DATA_volley, false);
		this.entityData.define(DATA_dying, false);
		this.entityData.define(DATA_laugh, 0);
		this.entityData.define(DATA_playerCount, 0);
		this.entityData.define(DATA_baseHealth, 0);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 16;
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		FalseHydraEntityIsHurtProcedure.execute(this, source.getEntity());
		if (source.is(DamageTypes.IN_FIRE))
			return false;
		if (source.is(DamageTypes.FALL))
			return false;
		if (source.is(DamageTypes.CACTUS))
			return false;
		if (source.is(DamageTypes.DROWN))
			return false;
		if (source.is(DamageTypes.EXPLOSION))
			return false;
		if (source.is(DamageTypes.FALLING_ANVIL))
			return false;
		if (source.is(DamageTypes.WITHER))
			return false;
		if (source.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		FalseHydraEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		FalseHydraPlayerCountProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("DataattackChance", this.entityData.get(DATA_attackChance));
		compound.putInt("DatarndEffect", this.entityData.get(DATA_rndEffect));
		compound.putBoolean("Datavolley", this.entityData.get(DATA_volley));
		compound.putBoolean("Datadying", this.entityData.get(DATA_dying));
		compound.putInt("Datalaugh", this.entityData.get(DATA_laugh));
		compound.putInt("DataplayerCount", this.entityData.get(DATA_playerCount));
		compound.putInt("DatabaseHealth", this.entityData.get(DATA_baseHealth));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("DataattackChance"))
			this.entityData.set(DATA_attackChance, compound.getInt("DataattackChance"));
		if (compound.contains("DatarndEffect"))
			this.entityData.set(DATA_rndEffect, compound.getInt("DatarndEffect"));
		if (compound.contains("Datavolley"))
			this.entityData.set(DATA_volley, compound.getBoolean("Datavolley"));
		if (compound.contains("Datadying"))
			this.entityData.set(DATA_dying, compound.getBoolean("Datadying"));
		if (compound.contains("Datalaugh"))
			this.entityData.set(DATA_laugh, compound.getInt("Datalaugh"));
		if (compound.contains("DataplayerCount"))
			this.entityData.set(DATA_playerCount, compound.getInt("DataplayerCount"));
		if (compound.contains("DatabaseHealth"))
			this.entityData.set(DATA_baseHealth, compound.getInt("DatabaseHealth"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		FalseHydraOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 2);
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		FalseHydraPlayerCollidesWithThisEntityProcedure.execute(this.level(), this, sourceentity);
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 600);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 48);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 999);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if (this.isDeadOrDying()) {
				return event.setAndContinue(RawAnimation.begin().thenPlay("animation.falseHydra_death"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.falseHydra_idle"));
		}
		return PlayState.STOP;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 60) {
			this.remove(FalseHydraEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
