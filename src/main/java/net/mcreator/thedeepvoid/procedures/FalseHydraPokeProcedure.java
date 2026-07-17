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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class FalseHydraPokeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FalseHydraEntity) {
			((FalseHydraEntity) entity).setAnimation("empty");
		}
		if (entity instanceof FalseHydraEntity) {
			((FalseHydraEntity) entity).setAnimation("animation.falseHydra_poke");
		}
		for (int index0 = 0; index0 < 5; index0++) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_prepare_bite")), SoundSource.HOSTILE, 3,
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_prepare_bite")), SoundSource.HOSTILE, 3,
							(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
				}
			}
		}
		TheDeepVoidMod.queueServerWork(20, () -> {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_bite")), SoundSource.HOSTILE, 2,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_bite")), SoundSource.HOSTILE, 2,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
							if ((entityiterator instanceof LivingEntity _entUseItem18 ? _entUseItem18.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
								if (entityiterator instanceof Player _player)
									_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem20 ? _entUseItem20.getUseItem() : ItemStack.EMPTY).getItem(), 100);
								{
									ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem22 ? _entUseItem22.getUseItem() : ItemStack.EMPTY);
									if (_ist.hurt(8, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
												SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1,
												false);
									}
								}
							} else {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity),
										(float) ((double) DeepVoidConfigConfiguration.HYDRAMULTIHIT.get()
												+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0)));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_maw_bite")),
												SoundSource.HOSTILE, 1, (float) 1.4);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_maw_bite")), SoundSource.HOSTILE,
												1, (float) 1.4, false);
									}
								}
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 10));
							}
							entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) * 0.2), ((entity.getY() - entityiterator.getY()) * 0.2), ((entity.getZ() - entityiterator.getZ()) * 0.2)));
						}
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(25, () -> {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_bite")), SoundSource.HOSTILE, 2,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_bite")), SoundSource.HOSTILE, 2,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
							if ((entityiterator instanceof LivingEntity _entUseItem58 ? _entUseItem58.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
								if (entityiterator instanceof Player _player)
									_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem60 ? _entUseItem60.getUseItem() : ItemStack.EMPTY).getItem(), 100);
								{
									ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem62 ? _entUseItem62.getUseItem() : ItemStack.EMPTY);
									if (_ist.hurt(8, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
												SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1,
												false);
									}
								}
							} else {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity),
										(float) ((double) DeepVoidConfigConfiguration.HYDRAMULTIHIT.get()
												+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0)));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_maw_bite")),
												SoundSource.HOSTILE, 1, (float) 1.4);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_maw_bite")), SoundSource.HOSTILE,
												1, (float) 1.4, false);
									}
								}
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 10));
							}
							entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) * 0.2), ((entity.getY() - entityiterator.getY()) * 0.2), ((entity.getZ() - entityiterator.getZ()) * 0.2)));
						}
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(30, () -> {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				for (int index1 = 0; index1 < 2; index1++) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_bite")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_bite")), SoundSource.HOSTILE, 2,
									(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
				}
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
							if ((entityiterator instanceof LivingEntity _entUseItem98 ? _entUseItem98.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
								if (entityiterator instanceof Player _player)
									_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem100 ? _entUseItem100.getUseItem() : ItemStack.EMPTY).getItem(), 100);
								{
									ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem102 ? _entUseItem102.getUseItem() : ItemStack.EMPTY);
									if (_ist.hurt(8, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
												SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1,
												false);
									}
								}
							} else {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity),
										(float) ((double) DeepVoidConfigConfiguration.HYDRAMULTIHIT.get()
												+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0)));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_maw_bite")),
												SoundSource.HOSTILE, 1, (float) 1.4);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_maw_bite")), SoundSource.HOSTILE,
												1, (float) 1.4, false);
									}
								}
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 10));
							}
							entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) * 0.2), ((entity.getY() - entityiterator.getY()) * 0.2), ((entity.getZ() - entityiterator.getZ()) * 0.2)));
						}
					}
				}
			}
		});
		TheDeepVoidMod.queueServerWork(35, () -> {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_bite")), SoundSource.HOSTILE, 2,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:false_hydra_bite")), SoundSource.HOSTILE, 2,
								(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
							if ((entityiterator instanceof LivingEntity _entUseItem138 ? _entUseItem138.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
								if (entityiterator instanceof Player _player)
									_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem140 ? _entUseItem140.getUseItem() : ItemStack.EMPTY).getItem(), 100);
								{
									ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem142 ? _entUseItem142.getUseItem() : ItemStack.EMPTY);
									if (_ist.hurt(8, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
												SoundSource.PLAYERS, 1, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1,
												false);
									}
								}
							} else {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("the_deep_void:boss_attack"))), entity),
										(float) ((double) DeepVoidConfigConfiguration.HYDRAMULTIHIT.get()
												+ (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0)));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_maw_bite")),
												SoundSource.HOSTILE, 1, (float) 1.4);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:death_maw_bite")), SoundSource.HOSTILE,
												1, (float) 1.4, false);
									}
								}
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 10));
							}
							entityiterator.setDeltaMovement(new Vec3(((entity.getX() - entityiterator.getX()) * 0.2), ((entity.getY() - entityiterator.getY()) * 0.2), ((entity.getZ() - entityiterator.getZ()) * 0.2)));
						}
					}
				}
			}
		});
	}
}
