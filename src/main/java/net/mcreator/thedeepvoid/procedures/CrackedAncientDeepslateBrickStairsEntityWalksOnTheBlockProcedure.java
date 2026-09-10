package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class CrackedAncientDeepslateBrickStairsEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.destroyBlock(BlockPos.containing(x, y, z), false);
		if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
			{
				Entity _ent = entity;
				_ent.teleportTo((x + 0.5), (y - 1), (z + 0.5));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((x + 0.5), (y - 1), (z + 0.5), _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
