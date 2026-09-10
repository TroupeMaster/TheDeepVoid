package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.HarbingerOfCataclysmEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class HarbingerGroundPoundProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
			_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attacking, true);
		if (entity instanceof HarbingerOfCataclysmEntity) {
			((HarbingerOfCataclysmEntity) entity).setAnimation("empty");
		}
		if (entity instanceof HarbingerOfCataclysmEntity) {
			((HarbingerOfCataclysmEntity) entity).setAnimation("animation.harbinger_groundPound");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 99, false, false));
		TheDeepVoidMod.queueServerWork(16, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.HOSTILE, 1, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.HOSTILE, 1, (float) 0.8, false);
				}
			}
			int horizontalRadiusSphere = (int) 7 - 1;
			int verticalRadiusSphere = (int) 3 - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)).canOcclude()) {
								world.levelEvent(2001, BlockPos.containing(x + xi, y + i + 1, z + zi), Block.getId((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi)))));
							}
						}
					}
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss"))) && entityiterator.onGround()) {
						entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) * (-0.25)), 0.8, ((entity.getZ() - entityiterator.getZ()) * (-0.25))));
						entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity), 18);
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(25, () -> {
			if (Math.random() < 0.4 && (entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_repeat) : 0) < 4) {
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attacking, false);
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attackChance, 50);
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetI)
					_datEntSetI.getEntityData().set(HarbingerOfCataclysmEntity.DATA_repeat, (int) ((entity instanceof HarbingerOfCataclysmEntity _datEntI ? _datEntI.getEntityData().get(HarbingerOfCataclysmEntity.DATA_repeat) : 0) + 1));
			} else {
				if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
					_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attacking, false);
			}
		});
	}
}
