package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.HiveWatcherEntity;
import net.mcreator.thedeepvoid.entity.AmbrosiaSpitEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class HiveWatcherSpinProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HiveWatcherEntity) {
			((HiveWatcherEntity) entity).setAnimation("animation.hiveWatcher_spin");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 99, true, true));
		TheDeepVoidMod.queueServerWork(5, () -> {
			for (int index0 = 0; index0 < 5; index0++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new AmbrosiaSpitEntity(TheDeepVoidModEntities.AMBROSIA_SPIT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIT.get(), 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 4), (entity.getZ()));
					_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1, (Mth.nextDouble(RandomSource.create(), -1, 1)), 1, 10);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(10, () -> {
			for (int index1 = 0; index1 < 5; index1++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new AmbrosiaSpitEntity(TheDeepVoidModEntities.AMBROSIA_SPIT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIT.get(), 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 4), (entity.getZ()));
					_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1, (Mth.nextDouble(RandomSource.create(), -1, 1)), 1, 10);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(15, () -> {
			for (int index2 = 0; index2 < 5; index2++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new AmbrosiaSpitEntity(TheDeepVoidModEntities.AMBROSIA_SPIT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIT.get(), 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 4), (entity.getZ()));
					_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1, (Mth.nextDouble(RandomSource.create(), -1, 1)), 1, 10);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(20, () -> {
			for (int index3 = 0; index3 < 5; index3++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new AmbrosiaSpitEntity(TheDeepVoidModEntities.AMBROSIA_SPIT.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, (float) (double) DeepVoidConfigConfiguration.HIVEWATCHERSPIT.get(), 0);
					_entityToSpawn.setPos((entity.getX()), (entity.getY() + 4), (entity.getZ()));
					_entityToSpawn.shoot((Mth.nextDouble(RandomSource.create(), -1, 1)), 0.1, (Mth.nextDouble(RandomSource.create(), -1, 1)), 1, 10);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_spit")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
				}
			}
		});
	}
}
