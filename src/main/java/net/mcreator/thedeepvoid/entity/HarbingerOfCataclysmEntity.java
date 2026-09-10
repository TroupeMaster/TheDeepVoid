
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
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
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

import net.mcreator.thedeepvoid.procedures.HarbingerOfCataclysmSpawnsProcedure;
import net.mcreator.thedeepvoid.procedures.HarbingerOfCataclysmPlayerCollidesWithThisEntityProcedure;
import net.mcreator.thedeepvoid.procedures.HarbingerOfCataclysmOnEntityTickUpdateProcedure;
import net.mcreator.thedeepvoid.procedures.HarbingerOfCataclysmEntityIsHurtProcedure;
import net.mcreator.thedeepvoid.procedures.HarbingerOfCataclysmDiesProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;

import javax.annotation.Nullable;

public class HarbingerOfCataclysmEntity extends Monster implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Boolean> DATA_dying = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_attackChance = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_attacking = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_parry = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_attackCooldown = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_piercing = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_repeat = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_repeatCooldown = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_teleport = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_teleportAttack = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_dyingCooldown = SynchedEntityData.defineId(HarbingerOfCataclysmEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.RED, ServerBossEvent.BossBarOverlay.NOTCHED_6);

	public HarbingerOfCataclysmEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheDeepVoidModEntities.HARBINGER_OF_CATACLYSM.get(), world);
	}

	public HarbingerOfCataclysmEntity(EntityType<HarbingerOfCataclysmEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setMaxUpStep(0.6f);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "harbinger");
		this.entityData.define(DATA_dying, false);
		this.entityData.define(DATA_attackChance, 0);
		this.entityData.define(DATA_attacking, false);
		this.entityData.define(DATA_parry, 0);
		this.entityData.define(DATA_attackCooldown, 0);
		this.entityData.define(DATA_piercing, false);
		this.entityData.define(DATA_repeat, 0);
		this.entityData.define(DATA_repeatCooldown, 0);
		this.entityData.define(DATA_teleport, false);
		this.entityData.define(DATA_teleportAttack, false);
		this.entityData.define(DATA_dyingCooldown, 0);
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
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
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
		HarbingerOfCataclysmEntityIsHurtProcedure.execute(this.level(), this, source.getEntity());
		if (source.is(DamageTypes.FALL))
			return false;
		if (source.is(DamageTypes.EXPLOSION))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		HarbingerOfCataclysmDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		HarbingerOfCataclysmSpawnsProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putBoolean("Datadying", this.entityData.get(DATA_dying));
		compound.putInt("DataattackChance", this.entityData.get(DATA_attackChance));
		compound.putBoolean("Dataattacking", this.entityData.get(DATA_attacking));
		compound.putInt("Dataparry", this.entityData.get(DATA_parry));
		compound.putInt("DataattackCooldown", this.entityData.get(DATA_attackCooldown));
		compound.putBoolean("Datapiercing", this.entityData.get(DATA_piercing));
		compound.putInt("Datarepeat", this.entityData.get(DATA_repeat));
		compound.putInt("DatarepeatCooldown", this.entityData.get(DATA_repeatCooldown));
		compound.putBoolean("Datateleport", this.entityData.get(DATA_teleport));
		compound.putBoolean("DatateleportAttack", this.entityData.get(DATA_teleportAttack));
		compound.putInt("DatadyingCooldown", this.entityData.get(DATA_dyingCooldown));
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
		if (compound.contains("Dataattacking"))
			this.entityData.set(DATA_attacking, compound.getBoolean("Dataattacking"));
		if (compound.contains("Dataparry"))
			this.entityData.set(DATA_parry, compound.getInt("Dataparry"));
		if (compound.contains("DataattackCooldown"))
			this.entityData.set(DATA_attackCooldown, compound.getInt("DataattackCooldown"));
		if (compound.contains("Datapiercing"))
			this.entityData.set(DATA_piercing, compound.getBoolean("Datapiercing"));
		if (compound.contains("Datarepeat"))
			this.entityData.set(DATA_repeat, compound.getInt("Datarepeat"));
		if (compound.contains("DatarepeatCooldown"))
			this.entityData.set(DATA_repeatCooldown, compound.getInt("DatarepeatCooldown"));
		if (compound.contains("Datateleport"))
			this.entityData.set(DATA_teleport, compound.getBoolean("Datateleport"));
		if (compound.contains("DatateleportAttack"))
			this.entityData.set(DATA_teleportAttack, compound.getBoolean("DatateleportAttack"));
		if (compound.contains("DatadyingCooldown"))
			this.entityData.set(DATA_dyingCooldown, compound.getInt("DatadyingCooldown"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		HarbingerOfCataclysmOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1.2);
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		HarbingerOfCataclysmPlayerCollidesWithThisEntityProcedure.execute(this.level(), this, sourceentity);
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
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 620);
		builder = builder.add(Attributes.ARMOR, 14);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 999);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

					&& !this.isAggressive()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("animation.harbinger_walk"));
			}
			if (this.isDeadOrDying()) {
				return event.setAndContinue(RawAnimation.begin().thenPlay("animation.harbinger_death"));
			}
			if (this.isAggressive() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("animation.harbinger_aggressive"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.harbinger_idle"));
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
		if (this.deathTime == 120) {
			this.remove(HarbingerOfCataclysmEntity.RemovalReason.KILLED);
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
