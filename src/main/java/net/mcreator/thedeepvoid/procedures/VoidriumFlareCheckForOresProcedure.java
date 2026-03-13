package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.XrayEntity;

public class VoidriumFlareCheckForOresProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double fx = 0;
		double fy = 0;
		double fz = 0;
		sx = -13;
		for (int index0 = 0; index0 < 26; index0++) {
			sy = -13;
			for (int index1 = 0; index1 < 26; index1++) {
				sz = -13;
				for (int index2 = 0; index2 < 26; index2++) {
					if (((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("forge:ores")))
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("c:ores")))
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("the_deep_void:ores"))))
							&& !(!world.getEntitiesOfClass(XrayEntity.class, AABB.ofSize(new Vec3((x + sx), (y + sy), (z + sz)), 0.5, 0.5, 0.5), e -> true).isEmpty())) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.XRAY.get().spawn(_level, BlockPos.containing(x + sx, y + sy, z + sz), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
