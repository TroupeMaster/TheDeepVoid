package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AmbientSoundProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getY(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double y, Entity entity) {
		execute(null, world, y, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
			if (y >= 20) {
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).ForgottenValleyAmbientSound >= 12000) {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.ForgottenValleyAmbientSound = 0;
						_vars.syncPlayerVariables(entity);
					}
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.StalkerAmbientRandom = Mth.nextInt(RandomSource.create(), 1, 3);
						_vars.syncPlayerVariables(entity);
					}
					if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerAmbientRandom == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:distant_growl")), SoundSource.NEUTRAL, 10, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:distant_growl")), SoundSource.NEUTRAL, 10, 1, false);
							}
						}
					} else if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerAmbientRandom == 2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:distant_stalker")), SoundSource.NEUTRAL, 10, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:distant_stalker")), SoundSource.NEUTRAL, 10, 1, false);
							}
						}
					} else if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).StalkerAmbientRandom == 3) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:distant_stalker2")), SoundSource.NEUTRAL, 10, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:distant_stalker2")), SoundSource.NEUTRAL, 10, 1, false);
							}
						}
					}
				} else {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.ForgottenValleyAmbientSound = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).ForgottenValleyAmbientSound + 1;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
			if (y < 20) {
				if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).VoidCaveAmbientSound >= 10000) {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.VoidCaveAmbientSound = 0;
						_vars.syncPlayerVariables(entity);
					}
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.CaveAmbientRandom = Mth.nextInt(RandomSource.create(), 1, 3);
						_vars.syncPlayerVariables(entity);
					}
					if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).CaveAmbientRandom == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:void_cave_ambient")), SoundSource.NEUTRAL, 6, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:void_cave_ambient")), SoundSource.NEUTRAL, 6, 1, false);
							}
						}
					} else if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).CaveAmbientRandom == 2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:void_cave_ambient_2")), SoundSource.NEUTRAL, 6, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:void_cave_ambient_2")), SoundSource.NEUTRAL, 6, 1, false);
							}
						}
					} else if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).CaveAmbientRandom == 3) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:void_cave_ambient_3")), SoundSource.NEUTRAL, 6, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:void_cave_ambient_3")), SoundSource.NEUTRAL, 6, 1, false);
							}
						}
					}
				} else {
					{
						TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
						_vars.VoidCaveAmbientSound = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).VoidCaveAmbientSound + 1;
						_vars.syncPlayerVariables(entity);
					}
				}
			}
		}
	}
}
