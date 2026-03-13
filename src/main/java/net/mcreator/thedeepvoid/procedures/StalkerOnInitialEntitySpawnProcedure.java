package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.StalkerEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class StalkerOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isInWall()) {
			if ((entity instanceof StalkerEntity _datEntI ? _datEntI.getEntityData().get(StalkerEntity.DATA_spawned) : 0) > 0) {
				{
					Entity _ent = entity;
					_ent.teleportTo(x, (y + 2), z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, (y + 2), z, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
		if ((entity instanceof StalkerEntity _datEntI ? _datEntI.getEntityData().get(StalkerEntity.DATA_spawned) : 0) > 0) {
			if (entity instanceof StalkerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StalkerEntity.DATA_spawned, (int) ((entity instanceof StalkerEntity _datEntI ? _datEntI.getEntityData().get(StalkerEntity.DATA_spawned) : 0) - 1));
		}
		if ((entity instanceof StalkerEntity _datEntI ? _datEntI.getEntityData().get(StalkerEntity.DATA_heartbeat) : 0) == 45) {
			if (entity instanceof StalkerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StalkerEntity.DATA_heartbeat, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 3, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 3, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.HOSTILE, 3, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.HOSTILE, 3, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(65 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 1, false, false));
					}
				}
			}
		} else {
			if (entity instanceof StalkerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(StalkerEntity.DATA_heartbeat, (int) ((entity instanceof StalkerEntity _datEntI ? _datEntI.getEntityData().get(StalkerEntity.DATA_heartbeat) : 0) + 1));
		}
		if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.GLOWING)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.GLOWING);
		}
		if (entity.isPassenger()) {
			entity.stopRiding();
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get() || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.MOSSY_BONE_PILE.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == TheDeepVoidModBlocks.BLOCK_OF_SKULL_PILE.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 0, false, false));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof StalkerEntity _datEntI ? _datEntI.getEntityData().get(StalkerEntity.DATA_voidCallCooldown) : 0) >= 500) {
				if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()
						&& ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(TheDeepVoidModMobEffects.CALL_OF_THE_VOID.get())) == false) {
					if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.CALL_OF_THE_VOID.get(), 420, 0));
				}
			} else {
				if (entity instanceof StalkerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(StalkerEntity.DATA_voidCallCooldown, (int) ((entity instanceof StalkerEntity _datEntI ? _datEntI.getEntityData().get(StalkerEntity.DATA_voidCallCooldown) : 0) + 1));
			}
		}
		if (!world.getBlockState(
				BlockPos.containing(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
						entity.getY(), entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
				.canOcclude()
				&& !world
						.getBlockState(
								BlockPos.containing(
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
										entity.getY() + 1,
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()))
						.canOcclude()
				&& world.getBlockState(
						BlockPos.containing(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), entity
										.getY() + 2,
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
						.canOcclude()
				|| !world
						.getBlockState(
								BlockPos.containing(
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
										entity.getY(),
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()))
						.canOcclude()
						&& !world
								.getBlockState(BlockPos.containing(
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
										entity.getY() + 1,
										entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()))
								.canOcclude()
						&& !world.getBlockState(BlockPos.containing(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.getY() + 2,
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
								.canOcclude()
						&& world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ())).canOcclude()
				|| !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).canOcclude() && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ())).canOcclude()
						&& world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ())).canOcclude()) {
			if (entity instanceof StalkerEntity) {
				((StalkerEntity) entity).setAnimation("animation.stalker_crouchFast");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 1, false, false));
			if ((entity instanceof StalkerEntity _datEntL84 && _datEntL84.getEntityData().get(StalkerEntity.DATA_crouching)) == false) {
				if (entity instanceof StalkerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(StalkerEntity.DATA_crouching, true);
			}
		} else {
			if ((entity instanceof StalkerEntity _datEntL86 && _datEntL86.getEntityData().get(StalkerEntity.DATA_crouching)) == true) {
				TheDeepVoidMod.queueServerWork(15, () -> {
					if (entity instanceof StalkerEntity _datEntSetL)
						_datEntSetL.getEntityData().set(StalkerEntity.DATA_crouching, false);
				});
			}
		}
		if ((entity instanceof StalkerEntity _datEntL89 && _datEntL89.getEntityData().get(StalkerEntity.DATA_crouching)) == true && !world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ())).canOcclude()) {
			if (entity instanceof StalkerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(StalkerEntity.DATA_crouching, false);
		}
		TheDeepVoidMod.queueServerWork((int) (double) DeepVoidConfigConfiguration.STALKERDESPAWNTIMER.get(), () -> {
			if (entity instanceof StalkerEntity) {
				((StalkerEntity) entity).setAnimation("animation.stalker_hide");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 99, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 99, false, false));
			TheDeepVoidMod.queueServerWork(35, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
				TheDeepVoidModVariables.MapVariables.get(world).StalkerDespawned = true;
				TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
			});
		});
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (world
					.getBiome(BlockPos.containing((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX(), (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY(),
							(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()))
					.is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:stalker_safe"))) && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() >= 40) {
				if (entity instanceof StalkerEntity) {
					((StalkerEntity) entity).setAnimation("animation.stalker_hide");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 99, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 99, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 99, false, false));
				if ((entity instanceof StalkerEntity _datEntL118 && _datEntL118.getEntityData().get(StalkerEntity.DATA_soundAngry)) == false) {
					if (entity instanceof StalkerEntity _datEntSetL)
						_datEntSetL.getEntityData().set(StalkerEntity.DATA_soundAngry, true);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.HOSTILE, 8, (float) 0.6);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.HOSTILE, 8, (float) 0.6, false);
						}
					}
				}
				TheDeepVoidMod.queueServerWork(35, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
					TheDeepVoidModVariables.MapVariables.get(world).StalkerDespawned = true;
					TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
				});
			}
		}
	}
}
