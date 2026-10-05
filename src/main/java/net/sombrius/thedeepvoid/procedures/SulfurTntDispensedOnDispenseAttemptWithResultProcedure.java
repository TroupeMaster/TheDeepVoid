package net.sombrius.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SulfurTntDispensedOnDispenseAttemptWithResultProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SulfurTntProcedureDispenseProcedure.execute(world, x, y, z);
	}
}
