package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

public class BlueFireEntityCollidesInTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.igniteForSeconds(10);
	}
}
