package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class HallucinationOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		TheDeepVoidMod.queueServerWork(540, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).isEmpty()
				|| world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() == true && world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude() == true) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (Math.random() < 0.25) {
			entity.getPersistentData().putBoolean("deep_void:shy", true);
		} else if (Math.random() < 0.25) {
			entity.getPersistentData().putBoolean("deep_void:agressive", true);
		} else if (Math.random() < 0.25) {
			entity.getPersistentData().putBoolean("deep_void:dont_look", true);
		}
	}
}
