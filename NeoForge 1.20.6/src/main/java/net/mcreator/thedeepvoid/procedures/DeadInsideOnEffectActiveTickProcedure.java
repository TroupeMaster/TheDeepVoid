package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

public class DeadInsideOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean stop = false;
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount != 300 && entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCountFinish == false && entity instanceof Player) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.StalkerCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount + 2;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (world.getBlockState(BlockPos.containing(x, y, z)).getLightEmission(world, BlockPos.containing(x, y, z)) > 0) {
			world.destroyBlock(BlockPos.containing(x, y, z), false);
		}
	}
}
