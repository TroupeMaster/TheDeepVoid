package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayBossMusicProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicLock) {
			{
				double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicTick + 1;
				entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MusicTick = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicPlay).equals("darkmare")) {
				PlayMusicDarkmareProcedure.execute(world, x, y, z, entity);
			} else if (((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicPlay).equals("chainsaw")) {
				PlayMusicChainsawProcedure.execute(world, x, y, z, entity);
			} else if (((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicPlay).equals("pitch_black")) {
				PlayMusicPitchBlackProcedure.execute(world, x, y, z, entity);
			} else if (((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicPlay).equals("the_haunt")) {
				PlayMusicTheHauntProcedure.execute(world, x, y, z, entity);
			} else if (((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicPlay).equals("monsters_lair")) {
				PlayMusicMonstersLairProcedure.execute(world, x, y, z, entity);
			} else if (((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).MusicPlay).equals("slaughter")) {
				PlayMusicSlaughterProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
