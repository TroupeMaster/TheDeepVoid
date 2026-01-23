package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class HiveWatcherHiveFangsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 2,
						(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 2,
						(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
			}
		}
		entity.getPersistentData().putDouble("fangsX", (entity.getX()));
		entity.getPersistentData().putDouble("fangsY", (entity.getY()));
		entity.getPersistentData().putDouble("fangsZ", (entity.getZ()));
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX") + 2, entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ")), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX") - 2, entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ")), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX"), entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ") + 2), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX"), entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ") - 2), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(40, () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX") + 4, entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ")), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX") - 4, entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ")), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX"), entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ") + 4), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX"), entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ") - 4), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(60, () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX") + 6, entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ")), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX") - 6, entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ")), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX"), entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ") + 6), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HIVE_FANGS.get().spawn(_level,
						BlockPos.containing(entity.getPersistentData().getDouble("fangsX"), entity.getPersistentData().getDouble("fangsY"), entity.getPersistentData().getDouble("fangsZ") - 6), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		});
	}
}
