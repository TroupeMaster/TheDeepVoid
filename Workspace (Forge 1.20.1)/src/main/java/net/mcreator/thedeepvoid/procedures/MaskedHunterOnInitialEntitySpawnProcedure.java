package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class MaskedHunterOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double posX = 0;
		double posZ = 0;
		if (DeepVoidConfigConfiguration.SPAWNBONECAGES.get() == true) {
			for (int index0 = 0; index0 < 2; index0++) {
				posX = entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30);
				posZ = entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30);
				if (!world.getBlockState(BlockPos.containing(posX, entity.getY(), posZ)).canOcclude() && world.getBlockState(BlockPos.containing(posX, entity.getY() - 1, posZ)).canOcclude()) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.BONE_CAGE.get().spawn(_level, BlockPos.containing(posX, entity.getY(), posZ), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
	}
}
