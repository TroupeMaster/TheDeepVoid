package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

public class UndertakerCommandProcedure {
	public static void execute(LevelAccessor world) {
		TheDeepVoidModVariables.MapVariables.get(world).undertakerSpawn = 0;
		TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
	}
}
