package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HearbeatInOverworldProcedure {
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
		if (DeepVoidConfigConfiguration.STALKED.get() == true) {
			if ((entity.level().dimension()) == Level.OVERWORLD) {
				if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount == Math
						.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 40) / 100) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0 && y > 0
						&& (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get())) == false) {
					{
						double _setval = Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 40) / 100) + 1;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.StalkerCount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6, false);
						}
					}
				}
				if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerCount == Math
						.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 75) / 100) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0 && y > 0
						&& (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING.get())) == false) {
					{
						double _setval = Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 75) / 100) + 1;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.StalkerCount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6, false);
						}
					}
				}
			}
		}
	}
}
