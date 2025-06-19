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
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.NightmareCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).NightmareCount + 100;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			entity.getPersistentData().putDouble("deep_void:terrified_count", (entity.getPersistentData().getDouble("deep_void:terrified_count") + 1));
		}
	}
}
