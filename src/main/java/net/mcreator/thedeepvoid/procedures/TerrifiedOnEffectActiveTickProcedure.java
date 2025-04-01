package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

public class TerrifiedOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double yOffset = 0;
		double distance = 0;
		double count = 0;
		if (entity.getPersistentData().getDouble("deep_void:terrified_count") >= 10) {
			entity.getPersistentData().putDouble("deep_void:terrified_count", 0);
			{
				double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).NightmareCount + 100;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NightmareCount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			entity.getPersistentData().putDouble("deep_void:terrified_count", (entity.getPersistentData().getDouble("deep_void:terrified_count") + 1));
		}
	}
}
