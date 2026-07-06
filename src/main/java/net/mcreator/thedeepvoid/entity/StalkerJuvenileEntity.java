
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

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.thedeepvoid.procedures.StalkerJuvenileThisEntityKillsAnotherOneProcedure;
import net.mcreator.thedeepvoid.procedures.StalkerJuvenileRunsAwayProcedure;
import net.mcreator.thedeepvoid.procedures.StalkerJuvenileOnEntityTickUpdateProcedure;
import net.mcreator.thedeepvoid.procedures.StalkerJuvenileLookAroundProcedure;
import net.mcreator.thedeepvoid.procedures.StalkerJuvenileAttacksEntityProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;

public class StalkerJuvenileEntity extends Monster implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(StalkerJuvenileEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(StalkerJuvenileEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(StalkerJuvenileEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_jump = SynchedEntityData.defineId(StalkerJuvenileEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_playful = SynchedEntityData.defineId(StalkerJuvenileEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_playingDead = SynchedEntityData.defineId(StalkerJuvenileEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_runAway = SynchedEntityData.defineId(StalkerJuvenileEntity.class, EntityDataSerializers.BOOLEAN);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public StalkerJuvenileEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheDeepVoidModEntities.STALKER_JUVENILE.get(), world);
	}

	public StalkerJuvenileEntity(EntityType<StalkerJuvenileEntity> type, Level world) {
		super(type, world);
		xpReward = 15;
		setNoAi(false);
		setMaxUpStep(0.6f);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "stalkerjuvenile");
		this.entityData.define(DATA_jump, 0);
		this.entityData.define(DATA_playful, 0);
		this.entityData.define(DATA_playingDead, 0);
		this.entityData.define(DATA_runAway, true);
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
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LightEntity.class, (float) 6, 1.3, 1.2));
		this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, LivingEntity.class, (float) 12, 1.2, 1.2) {
			@Override
			public boolean canUse() {
				double x = StalkerJuvenileEntity.this.getX();
				double y = StalkerJuvenileEntity.this.getY();
				double z = StalkerJuvenileEntity.this.getZ();
				Entity entity = StalkerJuvenileEntity.this;
				Level world = StalkerJuvenileEntity.this.level();
				return super.canUse() && StalkerJuvenileRunsAwayProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = StalkerJuvenileEntity.this.getX();
				double y = StalkerJuvenileEntity.this.getY();
				double z = StalkerJuvenileEntity.this.getZ();
				Entity entity = StalkerJuvenileEntity.this;
				Level world = StalkerJuvenileEntity.this.level();
				return super.canContinueToUse() && StalkerJuvenileRunsAwayProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 6.0025;
			}
		});
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = StalkerJuvenileEntity.this.getX();
				double y = StalkerJuvenileEntity.this.getY();
				double z = StalkerJuvenileEntity.this.getZ();
				Entity entity = StalkerJuvenileEntity.this;
				Level world = StalkerJuvenileEntity.this.level();
				return super.canUse() && StalkerJuvenileLookAroundProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = StalkerJuvenileEntity.this.getX();
				double y = StalkerJuvenileEntity.this.getY();
				double z = StalkerJuvenileEntity.this.getZ();
				Entity entity = StalkerJuvenileEntity.this;
				Level world = StalkerJuvenileEntity.this.level();
				return super.canContinueToUse() && StalkerJuvenileLookAroundProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(7, new FloatGoal(this));
		this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, LivingEntity.class, false, false) {
			@Override
			public boolean canUse() {
				double x = StalkerJuvenileEntity.this.getX();
				double y = StalkerJuvenileEntity.this.getY();
				double z = StalkerJuvenileEntity.this.getZ();
				Entity entity = StalkerJuvenileEntity.this;
				Level world = StalkerJuvenileEntity.this.level();
				return super.canUse() && StalkerJuvenileAttacksEntityProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = StalkerJuvenileEntity.this.getX();
				double y = StalkerJuvenileEntity.this.getY();
				double z = StalkerJuvenileEntity.this.getZ();
				Entity entity = StalkerJuvenileEntity.this;
				Level world = StalkerJuvenileEntity.this.level();
				return super.canContinueToUse() && StalkerJuvenileAttacksEntityProcedure.execute(entity);
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
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
		if (source.is(DamageTypes.IN_FIRE))
			return false;
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source.is(DamageTypes.FALL))
			return false;
		if (source.is(DamageTypes.CACTUS))
			return false;
		if (source.is(DamageTypes.DROWN))
			return false;
		if (source.is(DamageTypes.LIGHTNING_BOLT))
			return false;
		if (source.is(DamageTypes.EXPLOSION))
			return false;
		if (source.is(DamageTypes.FALLING_ANVIL))
			return false;
		if (source.is(DamageTypes.DRAGON_BREATH))
			return false;
		if (source.is(DamageTypes.WITHER))
			return false;
		if (source.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("Datajump", this.entityData.get(DATA_jump));
		compound.putInt("Dataplayful", this.entityData.get(DATA_playful));
		compound.putInt("DataplayingDead", this.entityData.get(DATA_playingDead));
		compound.putBoolean("DatarunAway", this.entityData.get(DATA_runAway));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("Datajump"))
			this.entityData.set(DATA_jump, compound.getInt("Datajump"));
		if (compound.contains("Dataplayful"))
			this.entityData.set(DATA_playful, compound.getInt("Dataplayful"));
		if (compound.contains("DataplayingDead"))
			this.entityData.set(DATA_playingDead, compound.getInt("DataplayingDead"));
		if (compound.contains("DatarunAway"))
			this.entityData.set(DATA_runAway, compound.getBoolean("DatarunAway"));
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		StalkerJuvenileThisEntityKillsAnotherOneProcedure.execute(entity, this);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		StalkerJuvenileOnEntityTickUpdateProcedure.execute(this.level(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 100);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 6);
		builder = builder.add(Attributes.FOLLOW_RANGE, 24);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

					&& !this.isAggressive()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("animation.stalkerJuvenile_walk"));
			}
			if (this.isAggressive() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("animation.stalkerJuvenile_aggressive"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.stalkerJuvenile_idle"));
		}
		return PlayState.STOP;
	}

	private PlayState attackingPredicate(AnimationState event) {
		double d1 = this.getX() - this.xOld;
		double d0 = this.getZ() - this.zOld;
		float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
		if (getAttackAnim(event.getPartialTick()) > 0f && !this.swinging) {
			this.swinging = true;
			this.lastSwing = level().getGameTime();
		}
		if (this.swinging && this.lastSwing + 7L <= level().getGameTime()) {
			this.swinging = false;
		}
		if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().forceAnimationReset();
			return event.setAndContinue(RawAnimation.begin().thenPlay("animation.stalkerJuvenile_attack"));
		}
		return PlayState.CONTINUE;
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
		if (this.deathTime == 20) {
			this.remove(StalkerJuvenileEntity.RemovalReason.KILLED);
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
		data.add(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
