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
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class MarrowRootsSpawnOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.CRIT, x, y, z, 4, 0, 0.1, 0, 0.1);
		if (Math.random() < 0.25) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.mangrove_roots.break")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.mangrove_roots.break")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1), false);
				}
			}
		}
		TheDeepVoidMod.queueServerWork(60, () -> {
			entity.getPersistentData().putBoolean("spawn", true);
		});
		if (entity.getPersistentData().getBoolean("spawn") == true) {
			entity.getPersistentData().putBoolean("spawn", false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.mangrove_roots.place")), SoundSource.HOSTILE, 1,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 0.85));
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.mangrove_roots.place")), SoundSource.HOSTILE, 1,
							(float) Mth.nextDouble(RandomSource.create(), 0.8, 0.85), false);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.MARROW_ROOTS.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
