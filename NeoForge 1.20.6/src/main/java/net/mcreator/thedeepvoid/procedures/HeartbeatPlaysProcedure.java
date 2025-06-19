package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HeartbeatPlaysProcedure {
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
		//The first heartbeat
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount == Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 40) / 100) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0 && y > 0
				&& (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING)) == false && (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(TheDeepVoidModMobEffects.WEAVER_CURSE)) == false) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.StalkerCount = Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 40) / 100) + 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.heartbeatIndicator = 1;
				_vars.syncPlayerVariables(entity);
			}
			TheDeepVoidMod.queueServerWork(4, () -> {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.heartbeatIndicator = 2;
					_vars.syncPlayerVariables(entity);
				}
			});
			TheDeepVoidMod.queueServerWork(10, () -> {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.heartbeatIndicator = 0;
					_vars.syncPlayerVariables(entity);
				}
			});
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.HOSTILE, 4, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.HOSTILE, 4, (float) 0.8, false);
				}
			}
		} //The second heartbeat
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount == Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 75) / 100) && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) == 0 && y > 0
				&& (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(TheDeepVoidModMobEffects.VOID_BLESSING)) == false
				&& (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(TheDeepVoidModMobEffects.WEAVER_CURSE)) == false) {
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.StalkerCount = Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 75) / 100) + 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.heartbeatIndicator = 1;
				_vars.syncPlayerVariables(entity);
			}
			TheDeepVoidMod.queueServerWork(4, () -> {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.heartbeatIndicator = 2;
					_vars.syncPlayerVariables(entity);
				}
			});
			TheDeepVoidMod.queueServerWork(10, () -> {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.heartbeatIndicator = 0;
					_vars.syncPlayerVariables(entity);
				}
			});
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.warden.heartbeat")), SoundSource.HOSTILE, 4, (float) 0.6, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.HOSTILE, 4, (float) 0.6);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stalker_ambient")), SoundSource.HOSTILE, 4, (float) 0.6, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.HOSTILE, 4, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.HOSTILE, 4, (float) 0.8, false);
				}
			}
		} //Inflict paranoia when the Stalker is close to spawning (Seek Light warning)
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount >= Math.floor(((double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get() * 92) / 100)
				&& entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerCount < (double) DeepVoidConfigConfiguration.STALKERSPAWNTIMER.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.PARANOIA, 5, 0, false, false));
		}
	}
}
