package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.init.TheDeepVoidModBlocks;
import net.mcreator.thedeepvoid.entity.WandererEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class WandererOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Mob _entity)
			_entity.getNavigation().moveTo(0, y, 0, 1);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof WandererEntity && !(entityiterator == entity) && entity.getPersistentData().getBoolean("encounter") == false) {
					entity.getPersistentData().putBoolean("encounter", true);
					if (entity instanceof WandererEntity) {
						((WandererEntity) entity).setAnimation("animation.wanderer_die");
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 99, false, false));
					TheDeepVoidMod.queueServerWork(20, () -> {
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get().defaultBlockState()));
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(TheDeepVoidModBlocks.ROTTEN_BONE_BLOCK.get().defaultBlockState()));
					});
					TheDeepVoidMod.queueServerWork(40, () -> {
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get().defaultBlockState()));
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(TheDeepVoidModBlocks.ROTTEN_BONE_BLOCK.get().defaultBlockState()));
					});
					TheDeepVoidMod.queueServerWork(60, () -> {
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get().defaultBlockState()));
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(TheDeepVoidModBlocks.ROTTEN_BONE_BLOCK.get().defaultBlockState()));
					});
					TheDeepVoidMod.queueServerWork(80, () -> {
						if (!entity.level().isClientSide())
							entity.discard();
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 2, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("particle.soul_escape")), SoundSource.NEUTRAL, 2, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SOUL, (entity.getX()), (entity.getY()), (entity.getZ()), 10, 1, 2, 1, 0.1);
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Block.getId(TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get().defaultBlockState()));
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), Block.getId(TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get().defaultBlockState()));
						world.levelEvent(2001, BlockPos.containing(entity.getX(), entity.getY() + 1.5, entity.getZ()), Block.getId(TheDeepVoidModBlocks.BLOCK_OF_BONE_PILE.get().defaultBlockState()));
						if (entity.getPersistentData().getBoolean("dropped_moss") == false) {
							entity.getPersistentData().putBoolean("dropped_moss", true);
							for (int index0 = 0; index0 < (int) Mth.nextDouble(RandomSource.create(), 1, 3); index0++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TheDeepVoidModItems.BLACK_MOSS.get()));
									entityToSpawn.setPickUpDelay(10);
									entityToSpawn.setUnlimitedLifetime();
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					});
				}
			}
		}
		if (entity.isVehicle()) {
			if ((entity.getFirstPassenger()) instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.VOID_BLESSING, 5, 0, false, false));
		}
	}
}
