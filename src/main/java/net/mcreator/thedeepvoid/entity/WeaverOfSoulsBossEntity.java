
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
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
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
import net.minecraft.world.entity.AreaEffectCloud;
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

import net.mcreator.thedeepvoid.procedures.WeaverOfSoulsPlayerCountProcedure;
import net.mcreator.thedeepvoid.procedures.WeaverOfSoulsOnEntityTickUpdateProcedure;
import net.mcreator.thedeepvoid.procedures.WeaverOfSoulsEntityDiesProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;

import javax.annotation.Nullable;

public class WeaverOfSoulsBossEntity extends Monster implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Boolean> DATA_stunned = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_locate = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_scream = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_giantHand = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_murmurs = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_dying = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_stunCount = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_playerCount = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_baseHealth = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_blockade = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_handsCooldown = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_handWall = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_randomNumber = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_screamPlayed = SynchedEntityData.defineId(WeaverOfSoulsBossEntity.class, EntityDataSerializers.BOOLEAN);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.BLUE, ServerBossEvent.BossBarOverlay.NOTCHED_6);

	public WeaverOfSoulsBossEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheDeepVoidModEntities.WEAVER_OF_SOULS_BOSS.get(), world);
	}

	public WeaverOfSoulsBossEntity(EntityType<WeaverOfSoulsBossEntity> type, Level world) {
		super(type, world);
		xpReward = 250;
		setNoAi(false);
		setMaxUpStep(1f);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "fallenweaver");
		this.entityData.define(DATA_stunned, false);
		this.entityData.define(DATA_locate, 0);
		this.entityData.define(DATA_scream, 0);
		this.entityData.define(DATA_giantHand, 0);
		this.entityData.define(DATA_murmurs, 0);
		this.entityData.define(DATA_dying, false);
		this.entityData.define(DATA_stunCount, 0);
		this.entityData.define(DATA_playerCount, 0);
		this.entityData.define(DATA_baseHealth, 0);
		this.entityData.define(DATA_blockade, false);
		this.entityData.define(DATA_handsCooldown, 0);
		this.entityData.define(DATA_handWall, 0);
		this.entityData.define(DATA_randomNumber, 0);
		this.entityData.define(DATA_screamPlayed, false);
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
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.655, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 8.1225;
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, Player.class, true, false));
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
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_scream"));
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
		if (source.is(DamageTypes.FALLING_ANVIL))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		WeaverOfSoulsEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		WeaverOfSoulsPlayerCountProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putBoolean("Datastunned", this.entityData.get(DATA_stunned));
		compound.putInt("Datalocate", this.entityData.get(DATA_locate));
		compound.putInt("Datascream", this.entityData.get(DATA_scream));
		compound.putInt("DatagiantHand", this.entityData.get(DATA_giantHand));
		compound.putInt("Datamurmurs", this.entityData.get(DATA_murmurs));
		compound.putBoolean("Datadying", this.entityData.get(DATA_dying));
		compound.putInt("DatastunCount", this.entityData.get(DATA_stunCount));
		compound.putInt("DataplayerCount", this.entityData.get(DATA_playerCount));
		compound.putInt("DatabaseHealth", this.entityData.get(DATA_baseHealth));
		compound.putBoolean("Datablockade", this.entityData.get(DATA_blockade));
		compound.putInt("DatahandsCooldown", this.entityData.get(DATA_handsCooldown));
		compound.putInt("DatahandWall", this.entityData.get(DATA_handWall));
		compound.putInt("DatarandomNumber", this.entityData.get(DATA_randomNumber));
		compound.putBoolean("DatascreamPlayed", this.entityData.get(DATA_screamPlayed));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("Datastunned"))
			this.entityData.set(DATA_stunned, compound.getBoolean("Datastunned"));
		if (compound.contains("Datalocate"))
			this.entityData.set(DATA_locate, compound.getInt("Datalocate"));
		if (compound.contains("Datascream"))
			this.entityData.set(DATA_scream, compound.getInt("Datascream"));
		if (compound.contains("DatagiantHand"))
			this.entityData.set(DATA_giantHand, compound.getInt("DatagiantHand"));
		if (compound.contains("Datamurmurs"))
			this.entityData.set(DATA_murmurs, compound.getInt("Datamurmurs"));
		if (compound.contains("Datadying"))
			this.entityData.set(DATA_dying, compound.getBoolean("Datadying"));
		if (compound.contains("DatastunCount"))
			this.entityData.set(DATA_stunCount, compound.getInt("DatastunCount"));
		if (compound.contains("DataplayerCount"))
			this.entityData.set(DATA_playerCount, compound.getInt("DataplayerCount"));
		if (compound.contains("DatabaseHealth"))
			this.entityData.set(DATA_baseHealth, compound.getInt("DatabaseHealth"));
		if (compound.contains("Datablockade"))
			this.entityData.set(DATA_blockade, compound.getBoolean("Datablockade"));
		if (compound.contains("DatahandsCooldown"))
			this.entityData.set(DATA_handsCooldown, compound.getInt("DatahandsCooldown"));
		if (compound.contains("DatahandWall"))
			this.entityData.set(DATA_handWall, compound.getInt("DatahandWall"));
		if (compound.contains("DatarandomNumber"))
			this.entityData.set(DATA_randomNumber, compound.getInt("DatarandomNumber"));
		if (compound.contains("DatascreamPlayed"))
			this.entityData.set(DATA_screamPlayed, compound.getBoolean("DatascreamPlayed"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		WeaverOfSoulsOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
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
		builder = builder.add(Attributes.MAX_HEALTH, 500);
		builder = builder.add(Attributes.ARMOR, 8);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 12);
		builder = builder.add(Attributes.FOLLOW_RANGE, 47);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 999);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 4);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

					&& !this.isAggressive()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("animation.fallenWeaver_walk"));
			}
			if (this.isDeadOrDying()) {
				return event.setAndContinue(RawAnimation.begin().thenPlay("animation.fallenWeaver_death"));
			}
			if (this.isAggressive() && event.isMoving()) {
				return event.setAndContinue(RawAnimation.begin().thenLoop("animation.fallenWeaver_aggressive"));
			}
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.fallenWeaver_idle"));
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
		if (this.deathTime == 73) {
			this.remove(WeaverOfSoulsBossEntity.RemovalReason.KILLED);
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
