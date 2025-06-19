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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerInGloomyDeathgroundsProcedure {
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
		double pos = 0;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).deathgrounds_ambience >= 700) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.deathgrounds_ambience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -50, 50), y, z + Mth.nextInt(RandomSource.create(), -50, 50)),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:distant_monster")), SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -50, 50)), y, (z + Mth.nextInt(RandomSource.create(), -50, 50)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:distant_monster")),
								SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).deathgrounds_ambience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.deathgrounds_ambience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (!(entity instanceof ServerPlayer _plr5 && _plr5.level() instanceof ServerLevel
					&& _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:does_it_hate"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:does_it_hate"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gathering_grounds"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).gatheringAmbience >= 400) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gatheringAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (Math.random() < 0.4) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y + 1.5, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_passing_by")), SoundSource.AMBIENT, 10,
									Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1));
						} else {
							_level.playLocalSound(x, (y + 1.5), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_passing_by")), SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1),
									false);
						}
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).gatheringAmbience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gatheringAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:drifting_monoliths"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).monolithAmbience >= 700) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.monolithAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stone_dragging")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stone_dragging")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
						}
					}
				} else if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stone_impact")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stone_impact")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
						}
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).monolithAmbience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.monolithAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:crawler_nest"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).nestAmbience >= 300) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.nestAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:insect_cry_1_loud")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:insect_cry_1_loud")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1), false);
						}
					}
				} else if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:insect_cry_2_loud")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:insect_cry_2_loud")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1), false);
						}
					}
				} else if (true) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.silverfish.ambient")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.silverfish.ambient")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1), false);
						}
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).nestAmbience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.nestAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:staring_hills"))) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).breathingHillsAmbience >= 700) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.breathingHillsAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -50, 50), y, z + Mth.nextInt(RandomSource.create(), -50, 50)),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:giant_creature_angry")), SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -50, 50)), y, (z + Mth.nextInt(RandomSource.create(), -50, 50)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:giant_creature_angry")),
								SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).breathingHillsAmbience + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.breathingHillsAmbience = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).breathingHillsHeart >= 15) {
				{
					double _setval = 0;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.breathingHillsHeart = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 0.6, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:heartbeat_ambient")), SoundSource.AMBIENT, (float) 0.4,
								1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY() + 0.6), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:heartbeat_ambient")), SoundSource.AMBIENT, (float) 0.4, 1, false);
					}
				}
			} else {
				{
					double _setval = (entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).breathingHillsHeart + 1;
					entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.breathingHillsHeart = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (!(entity instanceof ServerPlayer _plr41 && _plr41.level() instanceof ServerLevel
					&& _plr41.getAdvancements().getOrStartProgress(_plr41.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:does_it_hate"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_deep_void:does_it_hate"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}
