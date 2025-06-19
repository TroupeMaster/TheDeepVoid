package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerIsInDeepVoidProcedure {
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
		//These are some functions that activate every tick for the player, which have general uses
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {//When under y=1, give the player Hallucinate
			if (DeepVoidConfigConfiguration.PLAYERHALLUCINATES.get() == true) {
				if (entity.getY() <= 1 && (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.HALLUCINATE) ? _livEnt.getEffect(TheDeepVoidModMobEffects.HALLUCINATE).getDuration() : 0) <= 8) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.HALLUCINATE, 140, 0, false, false));
				}
			} //If higher than y=0, decrease the Nightmare Count
			if (y > 0) {
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).NightmareCount >= 10) {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.NightmareCount = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).NightmareCount - 10;
						_vars.syncPlayerVariables(entity);
					}
				}
			} //When under y=20, increase the chance of a ''Cave Tremble'' to happen. Reset to 0 if not successful
			if (y <= 20) {
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).cave_tremble >= 10000) {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.cave_tremble = 0;
						_vars.syncPlayerVariables(entity);
					}
					if (Math.random() < 0.4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.TREMBLE, 200, 0, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:deep_rumble")), SoundSource.AMBIENT, 15, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:deep_rumble")), SoundSource.AMBIENT, 15, 1, false);
							}
						}
					}
				} else {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.cave_tremble = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).cave_tremble + 1;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		} //If the player is outside the Deep Void, set the ''StalkerSpawn'' variable to false
		if (((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) == false) {
			if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerSpawn == true) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.StalkerSpawn = false;
					_vars.syncPlayerVariables(entity);
				}
			}
		} //When higher than y=20, randomly spawn a falling corpse if the biome can spawn those
		if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("the_deep_void:falling_corpse_spawn"))) && y >= 40) {
			if (DeepVoidConfigConfiguration.SPAWNFALLINGCORPSE.get() == true) {
				if ((entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(TheDeepVoidModMobEffects.LURKER_HEAD_NEAR)) == false) {
					if (Math.random() < 0.005) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TheDeepVoidModEntities.FALLING_CORPSE.get().spawn(_level,
									BlockPos.containing(entity.getX() + Mth.nextDouble(RandomSource.create(), -20, 20), entity.getY() + 25, entity.getZ() + Mth.nextDouble(RandomSource.create(), -20, 20)), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
			}
		} //Reset all Stalker Variables if the Stalker despawns (StalkerDespawned=true)
		if (TheDeepVoidModVariables.MapVariables.get(world).StalkerDespawned == true) {
			TheDeepVoidModVariables.MapVariables.get(world).StalkerDespawned = false;
			TheDeepVoidModVariables.MapVariables.get(world).syncData(world);
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.StalkerSpawn = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.StalkerCountFinish = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
				_vars.StalkerCount = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
