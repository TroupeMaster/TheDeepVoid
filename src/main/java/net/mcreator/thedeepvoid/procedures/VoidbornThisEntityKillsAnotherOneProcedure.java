package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class VoidbornThisEntityKillsAnotherOneProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Player) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SQUID_INK, (sourceentity.getX()), (sourceentity.getY() + 4), (sourceentity.getZ()), 25, 0, (-1), 0, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SQUID_INK, (sourceentity.getX()), (sourceentity.getY() + 2), (sourceentity.getZ()), 25, 0, (-1), 0, 0.2);
			if (!sourceentity.level().isClientSide())
				sourceentity.discard();
		}
	}
}
