package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.IchorSpitEntity;
import net.mcreator.thedeepvoid.entity.FleshWormEntity;

public class FleshWormOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		if (entity.isInWall() && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			{
				Entity _ent = entity;
				_ent.teleportTo((entity.getX()), (entity.getY() + 1), (entity.getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 1), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty())
				&& (entity instanceof FleshWormEntity _datEntL9 && _datEntL9.getEntityData().get(FleshWormEntity.DATA_teleporting)) == false
				&& (entity instanceof FleshWormEntity _datEntL10 && _datEntL10.getEntityData().get(FleshWormEntity.DATA_spawning)) == false
				&& (entity instanceof FleshWormEntity _datEntL11 && _datEntL11.getEntityData().get(FleshWormEntity.DATA_attacking)) == false && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			FleshWormTeleportProcedure.execute(world, entity);
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof FleshWormEntity _datEntL15 && _datEntL15.getEntityData().get(FleshWormEntity.DATA_spawning)) == false
				&& (entity instanceof FleshWormEntity _datEntL16 && _datEntL16.getEntityData().get(FleshWormEntity.DATA_attacking)) == false && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity instanceof FleshWormEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FleshWormEntity.DATA_attackChance, (int) ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_attackChance) : 0) + 1));
		}
		if ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_attackChance) : 0) >= 80 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (entity instanceof FleshWormEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FleshWormEntity.DATA_attackChance, 0);
			rnd = Mth.nextInt(RandomSource.create(), 1, 6);
			if (rnd == 1) {
				FleshWormSwipeProcedure.execute(world, x, y, z, entity);
			} else if (rnd == 2) {
				FleshWormTailProcedure.execute(world, x, y, z, entity);
			} else if (rnd == 3) {
				FleshWormEatProcedure.execute(world, x, y, z, entity);
			} else if (rnd == 4) {
				FleshWormDigProcedure.execute(world, entity);
			} else if (rnd == 5) {
				FleshWormAirProcedure.execute(world, entity);
			} else if (rnd == 6) {
				FleshWormSpikesProcedure.execute(world, entity);
			}
		}
		if ((entity instanceof FleshWormEntity _datEntL24 && _datEntL24.getEntityData().get(FleshWormEntity.DATA_spit)) == true) {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("xLook")), y, (entity.getPersistentData().getDouble("zLook"))));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 1,
							(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 1,
							(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
				}
			}
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new IchorSpitEntity(TheDeepVoidModEntities.ICHOR_SPIT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 5, 0);
					_entityToSpawn.setPos(entity.getX() + entity.getLookAngle().x * (Mth.nextInt(RandomSource.create(), 0, 3)), (entity.getY() - 0.4), entity.getZ() + entity.getLookAngle().z * (Mth.nextInt(RandomSource.create(), 0, 3)));
					_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), (-1), (Mth.nextDouble(RandomSource.create(), -0.2, 0.2)), 1, 15);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
		if ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_sound) : 0) >= 400) {
			if (entity instanceof FleshWormEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FleshWormEntity.DATA_sound, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_worm_scream")), SoundSource.HOSTILE, 10,
							(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh_worm_scream")), SoundSource.HOSTILE, 10,
							(float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
				}
			}
		} else {
			if (entity instanceof FleshWormEntity _datEntSetI)
				_datEntSetI.getEntityData().set(FleshWormEntity.DATA_sound, (int) ((entity instanceof FleshWormEntity _datEntI ? _datEntI.getEntityData().get(FleshWormEntity.DATA_sound) : 0) + 1));
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null || (entity instanceof FleshWormEntity _datEntL54 && _datEntL54.getEntityData().get(FleshWormEntity.DATA_spawning)) == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
		WeaverBossMusicProcedure.execute(world, x, y, z, entity);
	}
}
