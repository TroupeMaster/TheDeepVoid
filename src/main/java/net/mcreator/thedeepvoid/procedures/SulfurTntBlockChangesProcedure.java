package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;

public class SulfurTntBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.FIRE
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.FIRE
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.FIRE || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.FIRE
				|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.SOUL_FIRE || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.SOUL_FIRE
				|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.SOUL_FIRE || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.SOUL_FIRE
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.SOUL_FIRE || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SOUL_FIRE) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.SULFUR_TNT_ENTITY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement((Mth.nextInt(RandomSource.create(), (int) (-0.5), (int) 0.5)), 0.2, (Mth.nextInt(RandomSource.create(), (int) (-0.5), (int) 0.5)));
				}
			}
		}
	}
}
