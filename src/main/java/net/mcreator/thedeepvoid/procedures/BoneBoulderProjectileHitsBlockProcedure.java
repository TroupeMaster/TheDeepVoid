package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class BoneBoulderProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, (y + 1), z, 3, Level.ExplosionInteraction.NONE);
	}
}
