package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.SawThrowerEntity;
import net.mcreator.thedeepvoid.entity.MisanthropicHivemindEntity;

public class HivemindSummonSawThrowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randomX = 0;
		double randomZ = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, (float) 0.8);
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:hivemind_scream")), SoundSource.HOSTILE, 2, (float) 0.8, false);
			}
		}
		if (entity instanceof MisanthropicHivemindEntity) {
			((MisanthropicHivemindEntity) entity).setAnimation("animation.hivemind_scream");
		}
		for (int index0 = 0; index0 < 2; index0++) {
			randomX = entity.getX() + Mth.nextInt(RandomSource.create(), -4, 4);
			randomZ = entity.getZ() + Mth.nextInt(RandomSource.create(), -4, 4);
			if (!(!world.getEntitiesOfClass(SawThrowerEntity.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty())) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.BLOOD.get()), randomX, (entity.getY()), randomZ, 18, 0.01, 0.2, 0.01, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.LICKER_TONGUE.get()), randomX, (entity.getY()), randomZ, 6, 0.01, 0, 0.01, 0);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = TheDeepVoidModEntities.SAW_THROWER.get().spawn(_level, BlockPos.containing(randomX, entity.getY(), randomZ), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(randomX, entity.getY(), randomZ), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh")), SoundSource.HOSTILE, 2, 1);
					} else {
						_level.playLocalSound(randomX, (entity.getY()), randomZ, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:flesh")), SoundSource.HOSTILE, 2, 1, false);
					}
				}
			}
		}
		if (Math.random() < 0.1) {
			if (entity instanceof MisanthropicHivemindEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MisanthropicHivemindEntity.DATA_attackChance, 0);
		}
	}
}
