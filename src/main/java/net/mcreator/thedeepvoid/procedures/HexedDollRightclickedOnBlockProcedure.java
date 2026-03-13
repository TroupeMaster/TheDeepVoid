package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.WeaverOfSoulsEntity;
import net.mcreator.thedeepvoid.entity.ChainedWeaverEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class HexedDollRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TheDeepVoidModBlocks.SOUL_CONTAINER.get()) {
			if (!(!world.getEntitiesOfClass(WeaverOfSoulsEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())
					&& !(!world.getEntitiesOfClass(ChainedWeaverEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 600);
				itemstack.shrink(1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SCULK_SOUL, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 10, 0, 0.6, 0, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 10, 0, 0.6, 0, 0.1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2,
								(float) Mth.nextDouble(RandomSource.create(), 0.95, 1));
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1), false);
					}
				}
				TheDeepVoidMod.queueServerWork(30, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SCULK_SOUL, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 10, 0, 0.6, 0, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.95, 1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1), false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(60, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SCULK_SOUL, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 10, 0, 0.6, 0, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.95, 1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1), false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(90, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SCULK_SOUL, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 10, 0, 0.6, 0, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.95, 1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1), false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(120, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SCULK_SOUL, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 10, 0, 0.6, 0, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.95, 1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:abductor_ambient")), SoundSource.HOSTILE, 2, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1), false);
						}
					}
				});
				TheDeepVoidMod.queueServerWork(150, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SCULK_SOUL, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 10, 0, 0.6, 0, 0.1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (y + 1), (z + 0.5 + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 10, 0, 0.6, 0, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_scream")), SoundSource.HOSTILE, 2, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:weaver_scream")), SoundSource.HOSTILE, 2, 1, false);
						}
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = TheDeepVoidModEntities.WEAVER_OF_SOULS.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				});
			} else {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 10);
			}
		}
	}
}
