package net.mcreator.thedeepvoid.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HallucinationSoundEffectsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).hallucinating == true) {
			if (Math.random() < 0.0005) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
					} else {
						_level.playLocalSound(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
					}
				}
				TheDeepVoidMod.queueServerWork(20, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(40, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(30, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(40, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
			} else if (Math.random() < 0.0005) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:lurker_ambient")), SoundSource.NEUTRAL, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1));
					} else {
						_level.playLocalSound(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("the_deep_void:lurker_ambient")), SoundSource.NEUTRAL, 2, Mth.nextInt(RandomSource.create(), (int) 0.8, 1), false);
					}
				}
			} else if (Math.random() < 0.0005) {
				for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(
											entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-0.2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.getY(),
											entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-0.2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 2, Mth.nextInt(RandomSource.create(), (int) 0.7, 1));
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-0.2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-0.2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 2, Mth.nextInt(RandomSource.create(), (int) 0.7, 1), false);
						}
					}
				}
			} else if (Math.random() < 0.0005) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
					} else {
						_level.playLocalSound(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
					}
				}
				TheDeepVoidMod.queueServerWork(5, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(10, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(15, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(20, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9);
						} else {
							_level.playLocalSound(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-1))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.deepslate.step")), SoundSource.NEUTRAL, 2, (float) 0.9, false);
						}
					}
				});
			} else if (Math.random() < 0.0005) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(
								null, BlockPos
										.containing(
												entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
																ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX(),
												entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3), entity.level().clip(new ClipContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1);
					} else {
						_level.playLocalSound(
								(entity.level()
										.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
												entity))
										.getBlockPos().getX()),
								(entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3)),
								(entity.level().clip(
										new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getZ()),
								BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1, false);
					}
				}
				TheDeepVoidMod.queueServerWork(8, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(
											entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
															ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3), entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound(
									(entity.level()
											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entity))
											.getBlockPos().getX()),
									(entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3)), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(16, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(
											entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
															ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3), entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound(
									(entity.level()
											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entity))
											.getBlockPos().getX()),
									(entity.getY() + Mth.nextInt(RandomSource.create(), -3, 3)), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((Mth.nextInt(RandomSource.create(), -4, 4)))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.hit")), SoundSource.NEUTRAL, 2, 1, false);
						}
					}
				});
			} else if (Math.random() < 0.0005) {
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.soundHallX = entity.getX() + Mth.nextInt(RandomSource.create(), -15, 15);
					_vars.syncPlayerVariables(entity);
				}
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.soundHallY = entity.getY() + Mth.nextInt(RandomSource.create(), -2, 2);
					_vars.syncPlayerVariables(entity);
				}
				{
					TheDeepVoidModVariables.PlayerVariables _vars = entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES);
					_vars.soundHallZ = entity.getZ() + Mth.nextInt(RandomSource.create(), -15, 15);
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallY,
								entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallZ), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1);
					} else {
						_level.playLocalSound(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallY,
								entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallZ, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1, false);
					}
				}
				TheDeepVoidMod.queueServerWork(25, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallX, entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallY + 1,
									entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallZ), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallX, (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallY + 1),
									entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallZ, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1, false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(50, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallX + Mth.nextInt(RandomSource.create(), 0, 1), entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallY,
											entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallZ + Mth.nextInt(RandomSource.create(), 0, 1)),
									BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound((entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallX + Mth.nextInt(RandomSource.create(), 0, 1)), entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallY,
									(entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).soundHallZ + Mth.nextInt(RandomSource.create(), 0, 1)), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.stone.break")), SoundSource.NEUTRAL,
									2, 1, false);
						}
					}
				});
			}
		}
	}
}
