
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
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
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
import net.minecraft.world.entity.Entity;
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

import net.mcreator.thedeepvoid.procedures.ApostleTickUpdateProcedure;
import net.mcreator.thedeepvoid.procedures.ApostleSpawnsProcedure;
import net.mcreator.thedeepvoid.procedures.ApostleOfCatastropheDiesProcedure;
import net.mcreator.thedeepvoid.procedures.ApostleBossPlayerCollidesWithThisEntityProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;

import javax.annotation.Nullable;

public class ApostleBossEntity extends Monster implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Boolean> DATA_dying = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_attackChance = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_laughChance = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_random = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_doingAttack = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_runGrab = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_grabbedPlayer = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_jumpGrab = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_upMotion = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_downMotion = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_canDoGrab = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_taunt = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_spinning = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_fog = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_throwPlayer = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_piercedPlayer = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_tpTries = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_xPos = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_yPos = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_zPos = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_teleportCount = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_teleportCooldown = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_shieldIsUsed = SynchedEntityData.defineId(ApostleBossEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.RED, ServerBossEvent.BossBarOverlay.NOTCHED_6);

	public ApostleBossEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheDeepVoidModEntities.APOSTLE_BOSS.get(), world);
	}

	public ApostleBossEntity(EntityType<ApostleBossEntity> type, Level world) {
		super(type, world);
		xpReward = 250;
		setNoAi(false);
		setMaxUpStep(0.6f);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "apostleofcatastrophe");
		this.entityData.define(DATA_dying, false);
		this.entityData.define(DATA_attackChance, 0);
		this.entityData.define(DATA_laughChance, 0);
		this.entityData.define(DATA_random, 0);
		this.entityData.define(DATA_doingAttack, false);
		this.entityData.define(DATA_runGrab, false);
		this.entityData.define(DATA_grabbedPlayer, false);
		this.entityData.define(DATA_jumpGrab, false);
		this.entityData.define(DATA_upMotion, false);
		this.entityData.define(DATA_downMotion, false);
		this.entityData.define(DATA_canDoGrab, false);
		this.entityData.define(DATA_taunt, 300);
		this.entityData.define(DATA_spinning, false);
		this.entityData.define(DATA_fog, false);
		this.entityData.define(DATA_throwPlayer, false);
		this.entityData.define(DATA_piercedPlayer, false);
		this.entityData.define(DATA_tpTries, 0);
		this.entityData.define(DATA_xPos, 0);
		this.entityData.define(DATA_yPos, 0);
		this.entityData.define(DATA_zPos, 0);
		this.entityData.define(DATA_teleportCount, 0);
		this.entityData.define(DATA_teleportCooldown, 0);
		this.entityData.define(DATA_shieldIsUsed, 0);
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
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new FloatGoal(this));
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
		if (source.is(DamageTypes.FALL))
			return false;
		if (source.is(DamageTypes.CACTUS))
			return false;
		if (source.is(DamageTypes.DROWN))
			return false;
		if (source.is(DamageTypes.FALLING_ANVIL))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		ApostleOfCatastropheDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		ApostleSpawnsProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putBoolean("Datadying", this.entityData.get(DATA_dying));
		compound.putInt("DataattackChance", this.entityData.get(DATA_attackChance));
		compound.putInt("DatalaughChance", this.entityData.get(DATA_laughChance));
		compound.putInt("Datarandom", this.entityData.get(DATA_random));
		compound.putBoolean("DatadoingAttack", this.entityData.get(DATA_doingAttack));
		compound.putBoolean("DatarunGrab", this.entityData.get(DATA_runGrab));
		compound.putBoolean("DatagrabbedPlayer", this.entityData.get(DATA_grabbedPlayer));
		compound.putBoolean("DatajumpGrab", this.entityData.get(DATA_jumpGrab));
		compound.putBoolean("DataupMotion", this.entityData.get(DATA_upMotion));
		compound.putBoolean("DatadownMotion", this.entityData.get(DATA_downMotion));
		compound.putBoolean("DatacanDoGrab", this.entityData.get(DATA_canDoGrab));
		compound.putInt("Datataunt", this.entityData.get(DATA_taunt));
		compound.putBoolean("Dataspinning", this.entityData.get(DATA_spinning));
		compound.putBoolean("Datafog", this.entityData.get(DATA_fog));
		compound.putBoolean("DatathrowPlayer", this.entityData.get(DATA_throwPlayer));
		compound.putBoolean("DatapiercedPlayer", this.entityData.get(DATA_piercedPlayer));
		compound.putInt("DatatpTries", this.entityData.get(DATA_tpTries));
		compound.putInt("DataxPos", this.entityData.get(DATA_xPos));
		compound.putInt("DatayPos", this.entityData.get(DATA_yPos));
		compound.putInt("DatazPos", this.entityData.get(DATA_zPos));
		compound.putInt("DatateleportCount", this.entityData.get(DATA_teleportCount));
		compound.putInt("DatateleportCooldown", this.entityData.get(DATA_teleportCooldown));
		compound.putInt("DatashieldIsUsed", this.entityData.get(DATA_shieldIsUsed));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("Datadying"))
			this.entityData.set(DATA_dying, compound.getBoolean("Datadying"));
		if (compound.contains("DataattackChance"))
			this.entityData.set(DATA_attackChance, compound.getInt("DataattackChance"));
		if (compound.contains("DatalaughChance"))
			this.entityData.set(DATA_laughChance, compound.getInt("DatalaughChance"));
		if (compound.contains("Datarandom"))
			this.entityData.set(DATA_random, compound.getInt("Datarandom"));
		if (compound.contains("DatadoingAttack"))
			this.entityData.set(DATA_doingAttack, compound.getBoolean("DatadoingAttack"));
		if (compound.contains("DatarunGrab"))
			this.entityData.set(DATA_runGrab, compound.getBoolean("DatarunGrab"));
		if (compound.contains("DatagrabbedPlayer"))
			this.entityData.set(DATA_grabbedPlayer, compound.getBoolean("DatagrabbedPlayer"));
		if (compound.contains("DatajumpGrab"))
			this.entityData.set(DATA_jumpGrab, compound.getBoolean("DatajumpGrab"));
		if (compound.contains("DataupMotion"))
			this.entityData.set(DATA_upMotion, compound.getBoolean("DataupMotion"));
		if (compound.contains("DatadownMotion"))
			this.entityData.set(DATA_downMotion, compound.getBoolean("DatadownMotion"));
		if (compound.contains("DatacanDoGrab"))
			this.entityData.set(DATA_canDoGrab, compound.getBoolean("DatacanDoGrab"));
		if (compound.contains("Datataunt"))
			this.entityData.set(DATA_taunt, compound.getInt("Datataunt"));
		if (compound.contains("Dataspinning"))
			this.entityData.set(DATA_spinning, compound.getBoolean("Dataspinning"));
		if (compound.contains("Datafog"))
			this.entityData.set(DATA_fog, compound.getBoolean("Datafog"));
		if (compound.contains("DatathrowPlayer"))
			this.entityData.set(DATA_throwPlayer, compound.getBoolean("DatathrowPlayer"));
		if (compound.contains("DatapiercedPlayer"))
			this.entityData.set(DATA_piercedPlayer, compound.getBoolean("DatapiercedPlayer"));
		if (compound.contains("DatatpTries"))
			this.entityData.set(DATA_tpTries, compound.getInt("DatatpTries"));
		if (compound.contains("DataxPos"))
			this.entityData.set(DATA_xPos, compound.getInt("DataxPos"));
		if (compound.contains("DatayPos"))
			this.entityData.set(DATA_yPos, compound.getInt("DatayPos"));
		if (compound.contains("DatazPos"))
			this.entityData.set(DATA_zPos, compound.getInt("DatazPos"));
		if (compound.contains("DatateleportCount"))
			this.entityData.set(DATA_teleportCount, compound.getInt("DatateleportCount"));
		if (compound.contains("DatateleportCooldown"))
			this.entityData.set(DATA_teleportCooldown, compound.getInt("DatateleportCooldown"));
		if (compound.contains("DatashieldIsUsed"))
			this.entityData.set(DATA_shieldIsUsed, compound.getInt("DatashieldIsUsed"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		ApostleTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		ApostleBossPlayerCollidesWithThisEntityProcedure.execute(this.level(), this, sourceentity);
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	@Override
	protected void pushEntities() {
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
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 720);
		builder = builder.add(Attributes.ARMOR, 14);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 74);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 999);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("animation.apostle_walk"));
			}
			if (this.isDeadOrDying()) {
				return event.setAndContinue(RawAnimation.begin().thenPlay("animation.apostle_fall"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.apostle_idle"));
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
			this.remove(ApostleBossEntity.RemovalReason.KILLED);
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
