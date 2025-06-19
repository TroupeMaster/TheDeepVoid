package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AmbientSoundProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getY(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double y, Entity entity) {
		execute(null, world, y, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
			if (y >= 20) {
				if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).ForgottenValleyAmbientSound >= 12000) {
					{
						double _setval = 0;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ForgottenValleyAmbientSound = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Mth.nextInt(RandomSource.create(), 1, 3);
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.StalkerAmbientRandom = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerAmbientRandom == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:distant_growl")), SoundSource.NEUTRAL, 10, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:distant_growl")), SoundSource.NEUTRAL, 10, 1, false);
							}
						}
					} else if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerAmbientRandom == 2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:distant_stalker")), SoundSource.NEUTRAL, 10, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:distant_stalker")), SoundSource.NEUTRAL, 10, 1, false);
							}
						}
					} else if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).StalkerAmbientRandom == 3) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:distant_stalker2")), SoundSource.NEUTRAL, 10, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:distant_stalker2")), SoundSource.NEUTRAL, 10, 1, false);
							}
						}
					}
				} else {
					{
						double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).ForgottenValleyAmbientSound + 1;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ForgottenValleyAmbientSound = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_deep_void:deep_void"))) {
			if (y < 20) {
				if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).VoidCaveAmbientSound >= 10000) {
					{
						double _setval = 0;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.VoidCaveAmbientSound = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Mth.nextInt(RandomSource.create(), 1, 3);
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CaveAmbientRandom = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).CaveAmbientRandom == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:void_cave_ambient")), SoundSource.NEUTRAL, 6, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:void_cave_ambient")), SoundSource.NEUTRAL, 6, 1, false);
							}
						}
					} else if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).CaveAmbientRandom == 2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:void_cave_ambient_2")), SoundSource.NEUTRAL, 6, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:void_cave_ambient_2")), SoundSource.NEUTRAL, 6, 1, false);
							}
						}
					} else if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).CaveAmbientRandom == 3) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:void_cave_ambient_3")), SoundSource.NEUTRAL, 6, 1);
							} else {
								_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -30, 30)), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -30, 30)),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:void_cave_ambient_3")), SoundSource.NEUTRAL, 6, 1, false);
							}
						}
					}
				} else {
					{
						double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).VoidCaveAmbientSound + 1;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.VoidCaveAmbientSound = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
