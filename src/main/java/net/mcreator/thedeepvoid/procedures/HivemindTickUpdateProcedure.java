package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.SkullSmasherEntity;
import net.mcreator.thedeepvoid.entity.SawThrowerEntity;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;
import net.mcreator.thedeepvoid.entity.HivemindTentaclesEntity;
import net.mcreator.thedeepvoid.entity.BoneSawEntity;
import net.mcreator.thedeepvoid.entity.BloodSpitEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class HivemindTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, 0, 0));
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof MisanthropicHivemindEntity _datEntL3 && _datEntL3.getEntityData().get(MisanthropicHivemindEntity.DATA_attacking)) == false
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_attackChance, (int) ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_attackChance) : 0) + 1));
		}
		if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_attackChance) : 0) == 40) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, 1, false);
				}
			}
			HivemindFangsCrossProcedure.execute(world, entity);
		}
		if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_attackChance) : 0) == 120) {
			if (entity instanceof MisanthropicHivemindEntity) {
				((MisanthropicHivemindEntity) entity).setAnimation("animation.hivemind_projectile");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, 1, false);
				}
			}
			if (entity instanceof MisanthropicHivemindEntity _datEntSetL)
				_datEntSetL.getEntityData().set(MisanthropicHivemindEntity.DATA_attacking, true);
			if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_attackChance, 121);
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
					_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_bloodSpit, 30);
			});
		}
		if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_attackChance) : 0) == 200) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, 1, false);
				}
			}
			HivemindFangsDiagonalProcedure.execute(world, entity);
		}
		if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_attackChance) : 0) == 300
				&& !(!world.getEntitiesOfClass(SawThrowerEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(SkullSmasherEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty())) {
			if (entity instanceof MisanthropicHivemindEntity _datEntSetL)
				_datEntSetL.getEntityData().set(MisanthropicHivemindEntity.DATA_attacking, true);
			if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_attackChance, 301);
			if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_sucking, 100);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_suck")), SoundSource.HOSTILE, (float) 2.5, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_suck")), SoundSource.HOSTILE, (float) 2.5, 1, false);
				}
			}
		} else if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_attackChance) : 0) == 300
				&& (!world.getEntitiesOfClass(SawThrowerEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()
						|| !world.getEntitiesOfClass(SkullSmasherEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty())) {
			if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_attackChance, 320);
		}
		if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_attackChance) : 0) == 320) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, 1, false);
				}
			}
			HivemindSurroundWithFangsProcedure.execute(world, entity);
			if ((entity instanceof MisanthropicHivemindEntity _datEntL46 && _datEntL46.getEntityData().get(MisanthropicHivemindEntity.DATA_digesting)) == true) {
				if (entity instanceof MisanthropicHivemindEntity _datEntSetL)
					_datEntSetL.getEntityData().set(MisanthropicHivemindEntity.DATA_digesting, false);
			}
		}
		if ((entity instanceof MisanthropicHivemindEntity _datEntI ? _datEntI.getEntityData().get(MisanthropicHivemindEntity.DATA_attackChance) : 0) >= 400) {
			if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_attackChance, 0);
		}
		HivemindSpitBloodProcedure.execute(world, x, y, z, entity);
		HivemindSuckingProcedure.execute(world, x, y, z, entity);
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2
				&& (entity instanceof MisanthropicHivemindEntity _datEntL52 && _datEntL52.getEntityData().get(MisanthropicHivemindEntity.DATA_summonedMinions)) == false
				&& (entity instanceof MisanthropicHivemindEntity _datEntL53 && _datEntL53.getEntityData().get(MisanthropicHivemindEntity.DATA_skipSummons)) == false) {
			if (entity instanceof MisanthropicHivemindEntity _datEntSetL)
				_datEntSetL.getEntityData().set(MisanthropicHivemindEntity.DATA_summonedMinions, true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, (float) 1.2);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, (float) 1.2, false);
				}
			}
			HivemindSummonMinionsProcedure.execute(world, entity);
		}
		if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()) && DeepVoidConfigConfiguration.BOSSIDLES.get() == true) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_BRAIN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof SawThrowerEntity || entityiterator instanceof BoneSawEntity || entityiterator instanceof SkullSmasherEntity || entityiterator instanceof HivemindTentaclesEntity
							|| entityiterator instanceof BloodSpitEntity) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"stopsound @a record the_deep_void:pitch_black");
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a record the_deep_void:pitch_black");
			});
		}
		WeaverBossMusicProcedure.execute(world, x, y, z, entity);
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.WEAVER_CURSE.get(), 5, 0, false, false));
					}
				}
			}
		}
		if ((!world.getEntitiesOfClass(SawThrowerEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty() || !world.getEntitiesOfClass(SkullSmasherEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(HivemindTentaclesEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVEMIND_TENTACLES.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}
