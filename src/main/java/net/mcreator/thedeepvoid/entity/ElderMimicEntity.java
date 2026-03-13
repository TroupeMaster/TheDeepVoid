
package net.mcreator.thedeepvoid.entity;

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
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.thedeepvoid.procedures.MimicEntityIsHurtProcedure;
import net.mcreator.thedeepvoid.procedures.ElderMimicTickProcedure;
import net.mcreator.thedeepvoid.procedures.ElderMimicPlayerCountProcedure;
import net.mcreator.thedeepvoid.procedures.ElderMimicDiesProcedure;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;

import javax.annotation.Nullable;

public class ElderMimicEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_attackChance = SynchedEntityData.defineId(ElderMimicEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_playerCount = SynchedEntityData.defineId(ElderMimicEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_baseHealth = SynchedEntityData.defineId(ElderMimicEntity.class, EntityDataSerializers.INT);

	public ElderMimicEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TheDeepVoidModEntities.ELDER_MIMIC.get(), world);
	}

	public ElderMimicEntity(EntityType<ElderMimicEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 45;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_attackChance, 0);
		this.entityData.define(DATA_playerCount, 0);
		this.entityData.define(DATA_baseHealth, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 7.5076;
			}
		});
		this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, (float) 0.3));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, (float) 30));
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
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();
		if (!MimicEntityIsHurtProcedure.execute(world, x, y, z, entity, sourceentity))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		ElderMimicDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		ElderMimicPlayerCountProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("DataattackChance", this.entityData.get(DATA_attackChance));
		compound.putInt("DataplayerCount", this.entityData.get(DATA_playerCount));
		compound.putInt("DatabaseHealth", this.entityData.get(DATA_baseHealth));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataattackChance"))
			this.entityData.set(DATA_attackChance, compound.getInt("DataattackChance"));
		if (compound.contains("DataplayerCount"))
			this.entityData.set(DATA_playerCount, compound.getInt("DataplayerCount"));
		if (compound.contains("DatabaseHealth"))
			this.entityData.set(DATA_baseHealth, compound.getInt("DatabaseHealth"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		ElderMimicTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 140);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 2);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}
}
