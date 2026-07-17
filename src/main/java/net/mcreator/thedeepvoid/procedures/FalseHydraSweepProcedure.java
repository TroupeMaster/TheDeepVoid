package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class FalseHydraSweepProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		if (entity instanceof FalseHydraEntity) {
			((FalseHydraEntity) entity).setAnimation("empty");
		}
		if (entity instanceof FalseHydraEntity) {
			((FalseHydraEntity) entity).setAnimation("animation.falseHydra_sweep");
		}
		for (int index0 = 0; index0 < 5; index0++) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_prepare_slash")), SoundSource.HOSTILE, 3,
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_prepare_slash")), SoundSource.HOSTILE, 3,
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
				}
			}
		}
		TheDeepVoidMod.queueServerWork(18, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.HYDRA_SWEEP.get()), entity.getX() + entity.getLookAngle().x * 5, (entity.getY() + 3), entity.getZ() + entity.getLookAngle().z * 5, 1, 0, 0, 0, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_seeker_slash")), SoundSource.HOSTILE, 2, (float) 0.8);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:soul_seeker_slash")), SoundSource.HOSTILE, 2, (float) 0.8, false);
				}
			}
		});
		TheDeepVoidMod.queueServerWork(20, () -> {
			{
				final Vec3 _center = new Vec3(
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
						(entity.getY()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss"))) && !(entityiterator == entity)) {
						if ((entityiterator instanceof LivingEntity _entUseItem22 ? _entUseItem22.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
							if (entityiterator instanceof Player _player)
								_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem24 ? _entUseItem24.getUseItem() : ItemStack.EMPTY).getItem(), 100);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
											SoundSource.PLAYERS, 1, 1);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1, 1, false);
								}
							}
							if (entityiterator instanceof LivingEntity _entity)
								_entity.stopUsingItem();
						} else {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity),
									(float) ((double) DeepVoidConfigConfiguration.HYDRASWEEP.get()
											+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0)));
						}
					}
				}
			}
		});
	}
}
