package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class SoulSeekerHitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		SoulSeekerAoeDamageProcedure.execute(world, entity, sourceentity);
		if (itemstack.getOrCreateTag().getDouble("value") < 2) {
			itemstack.getOrCreateTag().putDouble("value", (itemstack.getOrCreateTag().getDouble("value") + 0.1));
		}
	}
}
