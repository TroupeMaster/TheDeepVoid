package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.VoidbornEntity;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class VoidbornOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
			{
				Entity _ent = entity;
				_ent.teleportTo(x, (y + 1), z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
			}
		}
		VoidbornCrouchProcedure.execute(world, entity);
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			TheDeepVoidMod.queueServerWork(400, () -> {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			});
		}
		if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.INVISIBILITY))) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
		if (!(world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 0)) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 10));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.isInWall()) {
			{
				Entity _ent = entity;
				_ent.teleportTo(
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
								.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
										(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(10)),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
								.getBlockPos().getX()),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
						((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
								.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
										(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(10)),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
								.getBlockPos().getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
									.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
											(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(10)),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
									.getBlockPos().getX()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).level()
									.clip(new ClipContext((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f),
											(entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getEyePosition(1f).add((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getViewVector(1f).scale(10)),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)))
									.getBlockPos().getZ()),
							_ent.getYRot(), _ent.getXRot());
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			VoidbornHeartbeatProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_spawnTentacles) : 0) >= 200) {
			if (entity instanceof VoidbornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(VoidbornEntity.DATA_spawnTentacles, 0);
			VoidbornSpawnTentaclesProcedure.execute(world, entity);
		} else {
			if (entity instanceof VoidbornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(VoidbornEntity.DATA_spawnTentacles, (int) ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_spawnTentacles) : 0) + 1));
		}
		if ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_hitCooldown) : 0) > 0) {
			if (entity instanceof VoidbornEntity _datEntSetI)
				_datEntSetI.getEntityData().set(VoidbornEntity.DATA_hitCooldown, (int) ((entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_hitCooldown) : 0) - 1));
		}
		if (world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 0
				&& !world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()
				&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()
				&& !(entity instanceof LivingEntity _livEnt43 && _livEnt43.hasEffect(MobEffects.INVISIBILITY)) && (entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_hit) : 0) < 12) {
			TheDeepVoidMod.queueServerWork(25, () -> {
				if (world.getMaxLocalRawBrightness(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())) > 0
						&& !world.getEntitiesOfClass(LightEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()
						&& !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty()
						&& !(entity instanceof LivingEntity _livEnt57 && _livEnt57.hasEffect(MobEffects.INVISIBILITY)) && (entity instanceof VoidbornEntity _datEntI ? _datEntI.getEntityData().get(VoidbornEntity.DATA_hit) : 0) < 12) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SQUID_INK, x, (y + 4), z, 25, 0, (-1), 0, 0.2);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SQUID_INK, x, (y + 2), z, 25, 0, (-1), 0, 0.2);
					if (!entity.level().isClientSide())
						entity.discard();
				}
			});
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.HEAVY.get(), 5, 0, false, false));
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 15, 15, 15), e -> true).isEmpty()) {
			if (world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0) {
				if (entity instanceof VoidbornEntity) {
					((VoidbornEntity) entity).setAnimation("animation.caveNightmare_walkClose");
				}
				if ((entity instanceof VoidbornEntity _datEntL70 && _datEntL70.getEntityData().get(VoidbornEntity.DATA_cancelClose)) == false) {
					if (entity instanceof VoidbornEntity _datEntSetL)
						_datEntSetL.getEntityData().set(VoidbornEntity.DATA_cancelClose, true);
				}
			} else {
				if ((entity instanceof VoidbornEntity _datEntL72 && _datEntL72.getEntityData().get(VoidbornEntity.DATA_cancelClose)) == true) {
					TheDeepVoidMod.queueServerWork(6, () -> {
						if (entity instanceof VoidbornEntity) {
							((VoidbornEntity) entity).setAnimation("empty");
						}
						if (entity instanceof VoidbornEntity _datEntSetL)
							_datEntSetL.getEntityData().set(VoidbornEntity.DATA_cancelClose, false);
					});
				}
			}
		}
	}
}
