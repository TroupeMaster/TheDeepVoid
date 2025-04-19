package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;
import net.mcreator.thedeepvoid.entity.SoulOrbEntity;

import java.util.List;
import java.util.Comparator;

public class SoulOrbPillarOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if ((entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TheDeepVoidModVariables.PlayerVariables())).hasSoulOrb == true) {
				if (!world.getEntitiesOfClass(SoulOrbEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY() + 2.5), (entity.getZ())), 2, 2, 2), e -> true).isEmpty()) {
					{
						boolean _setval = false;
						entity.getCapability(TheDeepVoidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hasSoulOrb = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY() + 2.5), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof SoulOrbEntity) {
								if (!entityiterator.level().isClientSide())
									entityiterator.discard();
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SCULK_SOUL, x, (y + 1), z, 15, (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.1, (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.1);
								for (int index0 = 0; index0 < 10; index0++) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y + 1, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.BLOCKS, 2,
													(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
										} else {
											_level.playLocalSound(x, (y + 1), z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.BLOCKS, 2, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2),
													false);
										}
									}
								}
							}
						}
					}
					if (!world.getEntitiesOfClass(WeaverOfSoulsEntity.class, AABB.ofSize(new Vec3(x, y, z), 80, 80, 80), e -> true).isEmpty()) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(80 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof WeaverOfSoulsEntity) {
									entityiterator.getPersistentData().putBoolean("deep_void:stunned", true);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.SCULK_SOUL, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 25, (Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.4,
												(Mth.nextDouble(RandomSource.create(), -0.1, 0.1)), 0.1);
									for (int index1 = 0; index1 < 15; index1++) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")),
														SoundSource.HOSTILE, 4, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
											} else {
												_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.HOSTILE,
														4, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
											}
										}
									}
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.stunned")),
													SoundSource.HOSTILE, 4, (float) 0.8);
										} else {
											_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ravager.stunned")), SoundSource.HOSTILE,
													4, (float) 0.8, false);
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
}
