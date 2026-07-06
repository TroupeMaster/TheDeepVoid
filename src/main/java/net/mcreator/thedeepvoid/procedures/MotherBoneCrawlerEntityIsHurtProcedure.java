package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.MotherBoneCrawlerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class MotherBoneCrawlerEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (Math.random() < 0.5) {
				if (entity instanceof MotherBoneCrawlerEntity) {
					((MotherBoneCrawlerEntity) entity).setAnimation("animation.motherCrawler_hatch");
				}
				TheDeepVoidMod.queueServerWork(5, () -> {
					world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), Block.getId(TheDeepVoidModBlocks.BONE_CRAWLER_EGG.get().defaultBlockState()));
					for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 4); index0++) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.BABY_BONE_CRAWLER.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				});
			}
		}
	}
}
