package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.entity.LightEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;

public class LightBreakInDarknessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (DeepVoidConfigConfiguration.OLDLIGHTSYSTEM.get() == false) {
			if (entity instanceof LightEntity) {
				if (DeepVoidConfigConfiguration.DESTROYLIGHTSOURCES.get() == true) {
					if (DeepVoidConfigConfiguration.ALLOWSOULLIGHT.get() == true) {
						if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getLightEmission(world, BlockPos.containing(x, y - 1, z)) > 0 && y >= 0
								&& !(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:safe_lights")))
								&& !(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:soul_lights")))) {
							if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())
									&& !(!world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), (x + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), y, (z + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 2,
											(Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (-0.05), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.1);
								if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getLightEmission(world, BlockPos.containing(x, y - 1, z)) > 0) {
									if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
										if (entity.getPersistentData().getDouble("deep_void:breakStart") >= 140) {
											if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())
													&& !(!world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
												entity.getPersistentData().putDouble("deep_void:breakStart", 0);
												world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.BLOCKS, (float) 1.4, 1);
													} else {
														_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.BLOCKS, (float) 1.4, 1, false);
													}
												}
											} else {
												entity.getPersistentData().putDouble("deep_void:breakStart", 0);
											}
										} else {
											entity.getPersistentData().putDouble("deep_void:breakStart", (entity.getPersistentData().getDouble("deep_void:breakStart") + 1));
										}
									} else {
										entity.getPersistentData().putDouble("deep_void:breakStart", 0);
									}
								}
							}
						}
					} else {
						if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getLightEmission(world, BlockPos.containing(x, y - 1, z)) > 0 && y >= 0
								&& !(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("the_deep_void:safe_lights")))) {
							if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())
									&& !(!world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.DARK_TEAR.get()), (x + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), y, (z + Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 4,
											(Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), (-0.05), (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.1);
								if (world.getBlockState(BlockPos.containing(x, y - 1, z)).getLightEmission(world, BlockPos.containing(x, y - 1, z)) > 0) {
									if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())
											&& !(!world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
										if (entity.getPersistentData().getDouble("deep_void:breakStart") >= 140) {
											if (!(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())
													&& !(!world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty())) {
												entity.getPersistentData().putDouble("deep_void:breakStart", 0);
												world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.BLOCKS, (float) 1.4, 1);
													} else {
														_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.BLOCKS, (float) 1.4, 1, false);
													}
												}
											} else {
												entity.getPersistentData().putDouble("deep_void:breakStart", 0);
											}
										} else {
											entity.getPersistentData().putDouble("deep_void:breakStart", (entity.getPersistentData().getDouble("deep_void:breakStart") + 1));
										}
									} else {
										entity.getPersistentData().putDouble("deep_void:breakStart", 0);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
