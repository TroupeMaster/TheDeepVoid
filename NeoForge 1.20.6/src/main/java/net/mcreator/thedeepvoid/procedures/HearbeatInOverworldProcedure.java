package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HearbeatInOverworldProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (DeepVoidConfigConfiguration.STALKED.get() == true) {
			if ((entity.level().dimension()) == Level.OVERWORLD) {
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount == Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 40) / 100) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0
						&& y > 0 && (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING)) == false) {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.StalkerCount = Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 40) / 100) + 1;
						_vars.syncPlayerVariables(entity);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6, false);
						}
					}
				}
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount == Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 75) / 100) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0
						&& y > 0 && (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING)) == false) {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.StalkerCount = Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 75) / 100) + 1;
						_vars.syncPlayerVariables(entity);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6, false);
						}
					}
				}
			}
		}
	}
}
