package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.entity.StalkerEntity;

public class CallOfTheVoidEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(StalkerEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 350, 350, 350), e -> true).isEmpty()) {
			{
				boolean _setval = true;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.playerCallOfTheVoid = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putDouble("deep_void:xDig", (entity.getX()));
			entity.getPersistentData().putDouble("deep_void:yDig", (entity.getY()));
			entity.getPersistentData().putDouble("deep_void:zDig", (entity.getZ()));
		}
	}
}
