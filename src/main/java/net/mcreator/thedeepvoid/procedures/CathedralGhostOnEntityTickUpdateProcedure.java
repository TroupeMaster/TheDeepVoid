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

public class CathedralGhostOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("deep_void:ring") >= 200) {
			entity.getPersistentData().putDouble("deep_void:ring", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bell.resonate")), SoundSource.NEUTRAL, 4, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bell.resonate")), SoundSource.NEUTRAL, 4, (float) 0.8, false);
				}
			}
		} else {
			entity.getPersistentData().putDouble("deep_void:ring", (entity.getPersistentData().getDouble("deep_void:ring") + 1));
		}
		if (entity.getPersistentData().getDouble("deep_void:ghost") >= 100) {
			entity.getPersistentData().putDouble("deep_void:ghost", 0);
			if (Math.random() < 0.5) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.GHOST.get().spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -8, 8), y, z + Mth.nextInt(RandomSource.create(), -8, 8)), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		} else {
			entity.getPersistentData().putDouble("deep_void:ghost", (entity.getPersistentData().getDouble("deep_void:ghost") + 1));
		}
	}
}
