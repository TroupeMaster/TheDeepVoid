package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class HexedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, (y + 0.8), z, 2, 0.1, 0.2, 0.1, 0.1);
		entity.getPersistentData().putDouble("deep_void:hexedBuildUp", (entity.getPersistentData().getDouble("deep_void:hexedBuildUp") + 0.5 + (amplifier == 0 ? 0 : amplifier / 2)));
	}
}
