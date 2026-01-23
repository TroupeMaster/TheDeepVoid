package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.thedeepvoid.entity.ShankPrisonerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class ShankPrisonerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			if (!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)))) && !(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null))))) {
				if (entity.getPersistentData().getDouble("flurry") >= 100) {
					if (Math.random() < 0.4) {
						entity.getPersistentData().putDouble("flurry", 0);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 2, false, false));
						if (entity instanceof ShankPrisonerEntity) {
							((ShankPrisonerEntity) entity).setAnimation("empty");
						}
						if (entity instanceof ShankPrisonerEntity) {
							((ShankPrisonerEntity) entity).setAnimation("animation.shankPrisoner_attack");
						}
						{
							final Vec3 _center = new Vec3(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
									if (!((entityiterator instanceof LivingEntity _entUseItem16 ? _entUseItem16.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
										entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 5);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 7, false, false));
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
														SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
											} else {
												_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")), SoundSource.NEUTRAL,
														(float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
											}
										}
									} else {
										{
											ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem26 ? _entUseItem26.getUseItem() : ItemStack.EMPTY);
											if (_ist.hurt(1, RandomSource.create(), null)) {
												_ist.shrink(1);
												_ist.setDamageValue(0);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
														SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
											} else {
												_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.NEUTRAL,
														(float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
											}
										}
									}
								}
							}
						}
						TheDeepVoidMod.queueServerWork(7, () -> {
							if (entity instanceof ShankPrisonerEntity) {
								((ShankPrisonerEntity) entity).setAnimation("empty");
							}
							if (entity instanceof ShankPrisonerEntity) {
								((ShankPrisonerEntity) entity).setAnimation("animation.shankPrisoner_attack");
							}
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
										if (!((entityiterator instanceof LivingEntity _entUseItem41 ? _entUseItem41.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
											entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 5);
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 7, false, false));
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
												}
											}
										} else {
											{
												ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem51 ? _entUseItem51.getUseItem() : ItemStack.EMPTY);
												if (_ist.hurt(1, RandomSource.create(), null)) {
													_ist.shrink(1);
													_ist.setDamageValue(0);
												}
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
												}
											}
										}
									}
								}
							}
						});
						TheDeepVoidMod.queueServerWork(14, () -> {
							if (entity instanceof ShankPrisonerEntity) {
								((ShankPrisonerEntity) entity).setAnimation("empty");
							}
							if (entity instanceof ShankPrisonerEntity) {
								((ShankPrisonerEntity) entity).setAnimation("animation.shankPrisoner_attack");
							}
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
										if (!((entityiterator instanceof LivingEntity _entUseItem67 ? _entUseItem67.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
											entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 5);
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 7, false, false));
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
												}
											}
										} else {
											{
												ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem77 ? _entUseItem77.getUseItem() : ItemStack.EMPTY);
												if (_ist.hurt(1, RandomSource.create(), null)) {
													_ist.shrink(1);
													_ist.setDamageValue(0);
												}
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
												}
											}
										}
									}
								}
							}
						});
						TheDeepVoidMod.queueServerWork(22, () -> {
							if (entity instanceof ShankPrisonerEntity) {
								((ShankPrisonerEntity) entity).setAnimation("empty");
							}
							if (entity instanceof ShankPrisonerEntity) {
								((ShankPrisonerEntity) entity).setAnimation("animation.shankPrisoner_attack");
							}
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
										if (!((entityiterator instanceof LivingEntity _entUseItem93 ? _entUseItem93.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
											entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 5);
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 7, false, false));
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
												}
											}
										} else {
											{
												ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem103 ? _entUseItem103.getUseItem() : ItemStack.EMPTY);
												if (_ist.hurt(1, RandomSource.create(), null)) {
													_ist.shrink(1);
													_ist.setDamageValue(0);
												}
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
												}
											}
										}
									}
								}
							}
						});
						TheDeepVoidMod.queueServerWork(31, () -> {
							if (entity instanceof ShankPrisonerEntity) {
								((ShankPrisonerEntity) entity).setAnimation("empty");
							}
							if (entity instanceof ShankPrisonerEntity) {
								((ShankPrisonerEntity) entity).setAnimation("animation.shankPrisoner_attack");
							}
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
										if (!((entityiterator instanceof LivingEntity _entUseItem119 ? _entUseItem119.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
											entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK)), 5);
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 7, false, false));
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:stab")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
												}
											}
										} else {
											{
												ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem129 ? _entUseItem129.getUseItem() : ItemStack.EMPTY);
												if (_ist.hurt(1, RandomSource.create(), null)) {
													_ist.shrink(1);
													_ist.setDamageValue(0);
												}
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
												} else {
													_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")),
															SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
												}
											}
										}
									}
								}
							}
						});
					}
				} else {
					entity.getPersistentData().putDouble("flurry", (entity.getPersistentData().getDouble("flurry") + 1));
				}
			}
		}
	}
}
