package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.entity.BoneBoulderEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class FalseHydraThrowBoulderProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FalseHydraEntity) {
			((FalseHydraEntity) entity).setAnimation("empty");
		}
		if (entity instanceof FalseHydraEntity) {
			((FalseHydraEntity) entity).setAnimation("animation.falseHydra_shoot");
		}
		for (int index0 = 0; index0 < 5; index0++) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_prepare_slash")), SoundSource.HOSTILE, 3,
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_prepare_slash")), SoundSource.HOSTILE, 3, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
				}
			}
		}
		TheDeepVoidMod.queueServerWork(15, () -> {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.getPersistentData().putDouble("playerX", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
				entity.getPersistentData().putDouble("playerY", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 1.6));
				entity.getPersistentData().putDouble("playerZ", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("playerX")), y, (entity.getPersistentData().getDouble("playerZ"))));
			}
		});
		TheDeepVoidMod.queueServerWork(25, () -> {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("playerX")), y, (entity.getPersistentData().getDouble("playerZ"))));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:rot_knight_swing_strong")), SoundSource.HOSTILE, 3, (float) 0.6);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:rot_knight_swing_strong")), SoundSource.HOSTILE, 3, (float) 0.6, false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(28, () -> {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entity.getPersistentData().getDouble("playerX")), (entity.getPersistentData().getDouble("playerY")), (entity.getPersistentData().getDouble("playerZ"))));
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new BoneBoulderEntity(TheDeepVoidModEntities.BONE_BOULDER.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) (double) DeepVoidConfigConfiguration.HYDRABOULDER.get(), (int) 0.25);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 4);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.snowball.throw")), SoundSource.HOSTILE, 3, (float) 0.5);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.snowball.throw")), SoundSource.HOSTILE, 3, (float) 0.5, false);
				}
			}
			for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 4, 8); index1++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.FALLING_CORPSE.get().spawn(_level, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -3, 3) + entity.getX() + entity.getLookAngle().x * 1, entity.getY() + 1,
							entity.getZ() + Mth.nextInt(RandomSource.create(), -3, 3) + entity.getZ() + entity.getLookAngle().z * 1), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot((float) Math.random());
						entityToSpawn.setYBodyRot((float) Math.random());
						entityToSpawn.setYHeadRot((float) Math.random());
						entityToSpawn.setXRot((float) Math.random());
						entityToSpawn.setDeltaMovement((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.25), 0.2, (Math.cos(Math.toRadians(entity.getYRot())) * 0.25));
					}
				}
			}
		});
	}
}
