package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.thedeepvoid.entity.FleshWormEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class FleshWormTailProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FleshWormEntity _datEntSetL)
			_datEntSetL.getEntityData().set(FleshWormEntity.DATA_attacking, true);
		if (entity instanceof FleshWormEntity) {
			((FleshWormEntity) entity).setAnimation("empty");
		}
		if (entity instanceof FleshWormEntity) {
			((FleshWormEntity) entity).setAnimation("animation.fleshWorm_tail");
		}
		TheDeepVoidMod.queueServerWork(40, () -> {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), y, ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX() + entity.getLookAngle().x * 9, entity.getY(), entity.getZ() + entity.getLookAngle().z * 9),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 4, (float) 0.8);
				} else {
					_level.playLocalSound(entity.getX() + entity.getLookAngle().x * 9, (entity.getY()), entity.getZ() + entity.getLookAngle().z * 9,
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 4, (float) 0.8, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX() + entity.getLookAngle().x * 9, entity.getY(), entity.getZ() + entity.getLookAngle().z * 9), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundSource.HOSTILE, 2, (float) 0.8);
				} else {
					_level.playLocalSound(entity.getX() + entity.getLookAngle().x * 9, (entity.getY()), entity.getZ() + entity.getLookAngle().z * 9, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.HOSTILE,
							2, (float) 0.8, false);
				}
			}
			{
				final Vec3 _center = new Vec3(entity.getX() + entity.getLookAngle().x * 11, (entity.getY()), entity.getZ() + entity.getLookAngle().z * 11);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 20);
					}
				}
			}
			for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 4, 8); index0++) {
				world.levelEvent(2001, BlockPos.containing(entity.getX() + entity.getLookAngle().x * 10 + Mth.nextInt(RandomSource.create(), -3, 3) + 0.5, entity.getY() + Mth.nextInt(RandomSource.create(), 0, 1),
						entity.getZ() + entity.getLookAngle().z * 10 + Mth.nextInt(RandomSource.create(), -3, 3) + 0.5), Block.getId((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())))));
			}
		});
		TheDeepVoidMod.queueServerWork(50, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 4, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:primordial_crawler_impact")), SoundSource.HOSTILE, 4, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 15);
						for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 4, 8); index1++) {
							world.levelEvent(2001, BlockPos.containing(entityiterator.getX() + Mth.nextInt(RandomSource.create(), -3, 3) + 0.5, entityiterator.getY() + Mth.nextInt(RandomSource.create(), 0, 1),
									entityiterator.getZ() + Mth.nextInt(RandomSource.create(), -3, 3) + 0.5), Block.getId((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())))));
						}
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(70, () -> {
			if (entity instanceof FleshWormEntity _datEntSetL)
				_datEntSetL.getEntityData().set(FleshWormEntity.DATA_attacking, false);
		});
	}
}
