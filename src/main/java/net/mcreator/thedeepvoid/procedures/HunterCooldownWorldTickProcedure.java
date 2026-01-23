package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HunterCooldownWorldTickProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (TheDeepVoidModVariables.MapVariables.get(world).hunterSpawnCooldown > 0) {
			TheDeepVoidModVariables.MapVariables.get(world).hunterSpawnCooldown = TheDeepVoidModVariables.MapVariables.get(world).hunterSpawnCooldown - 1;
			TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
