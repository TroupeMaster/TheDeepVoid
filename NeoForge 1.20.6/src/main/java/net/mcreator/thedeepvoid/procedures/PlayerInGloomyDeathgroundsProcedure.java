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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerInGloomyDeathgroundsProcedure {
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
		double pos = 0;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gloomy_deathgrounds"))) {
			if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).deathgrounds_ambience >= 700) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.deathgrounds_ambience = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -50, 50), y, z + Mth.nextInt(RandomSource.create(), -50, 50)),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:distant_monster")), SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -50, 50)), y, (z + Mth.nextInt(RandomSource.create(), -50, 50)), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:distant_monster")),
								SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
					}
				}
			} else {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.deathgrounds_ambience = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).deathgrounds_ambience + 1;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (!(entity instanceof ServerPlayer _plr5 && _plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().get(new ResourceLocation("the_deep_void:does_it_hate"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("the_deep_void:does_it_hate"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:gathering_grounds"))) {
			if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).gatheringAmbience >= 400) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.gatheringAmbience = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (Math.random() < 0.4) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y + 1.5, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:soul_passing_by")), SoundSource.AMBIENT, 10,
									Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1));
						} else {
							_level.playLocalSound(x, (y + 1.5), z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:soul_passing_by")), SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1), false);
						}
					}
				}
			} else {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.gatheringAmbience = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).gatheringAmbience + 1;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:drifting_monoliths"))) {
			if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).monolithAmbience >= 700) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.monolithAmbience = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stone_dragging")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stone_dragging")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
						}
					}
				} else if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stone_impact")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:stone_impact")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
						}
					}
				}
			} else {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.monolithAmbience = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).monolithAmbience + 1;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:crawler_nest"))) {
			if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).nestAmbience >= 300) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.nestAmbience = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:insect_cry_1_loud")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:insect_cry_1_loud")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1), false);
						}
					}
				} else if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:insect_cry_2_loud")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:insect_cry_2_loud")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1), false);
						}
					}
				} else if (true) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -30, 30), y, z + Mth.nextInt(RandomSource.create(), -30, 30)),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.silverfish.ambient")), SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1));
						} else {
							_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -30, 30)), y, (z + Mth.nextInt(RandomSource.create(), -30, 30)), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.silverfish.ambient")),
									SoundSource.AMBIENT, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.1), false);
						}
					}
				}
			} else {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.nestAmbience = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).nestAmbience + 1;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("the_deep_void:staring_hills"))) {
			if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).breathingHillsAmbience >= 700) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.breathingHillsAmbience = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -50, 50), y, z + Mth.nextInt(RandomSource.create(), -50, 50)),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:giant_creature_angry")), SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -50, 50)), y, (z + Mth.nextInt(RandomSource.create(), -50, 50)), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:giant_creature_angry")),
								SoundSource.AMBIENT, 10, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
					}
				}
			} else {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.breathingHillsAmbience = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).breathingHillsAmbience + 1;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).breathingHillsHeart >= 15) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.breathingHillsHeart = 0;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY() + 0.6, entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:heartbeat_ambient")), SoundSource.AMBIENT, (float) 0.4, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY() + 0.6), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:heartbeat_ambient")), SoundSource.AMBIENT, (float) 0.4, 1, false);
					}
				}
			} else {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.breathingHillsHeart = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).breathingHillsHeart + 1;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (!(entity instanceof ServerPlayer _plr41 && _plr41.level() instanceof ServerLevel && _plr41.getAdvancements().getOrStartProgress(_plr41.server.getAdvancements().get(new ResourceLocation("the_deep_void:does_it_hate"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(new ResourceLocation("the_deep_void:does_it_hate"));
					if (_adv != null) {
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
}
