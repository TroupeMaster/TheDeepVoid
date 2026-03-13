package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.PrisonerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class PrisonerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty() && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) && (entity instanceof PrisonerEntity _datEntI ? _datEntI.getEntityData().get(PrisonerEntity.DATA_attackChance) : 0) <= 0) {
				if (entity instanceof PrisonerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PrisonerEntity.DATA_attackChance, 100);
				if (Math.random() < 0.5) {
					if (entity instanceof PrisonerEntity) {
						((PrisonerEntity) entity).setAnimation("animation.prisoner_attack");
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 99, false, false));
					TheDeepVoidMod.queueServerWork(15, () -> {
						entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.8), 0.2, (Math.cos(Math.toRadians(entity.getYRot())) * 0.8)));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.7, 1));
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.HOSTILE, 1, (float) Mth.nextDouble(RandomSource.create(), 0.7, 1), false);
							}
						}
					});
					TheDeepVoidMod.queueServerWork(25, () -> {
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
									if ((entityiterator instanceof LivingEntity _entUseItem21 ? _entUseItem21.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
										if (entityiterator instanceof Player _player)
											_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem23 ? _entUseItem23.getUseItem() : ItemStack.EMPTY).getItem(), 10);
										{
											ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem25 ? _entUseItem25.getUseItem() : ItemStack.EMPTY);
											if (_ist.hurt(8, RandomSource.create(), null)) {
												_ist.shrink(1);
												_ist.setDamageValue(0);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1, false);
											}
										}
									} else {
										entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 8);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1, false, false));
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 0, false, false));
									}
								}
							}
						}
					});
				} else {
					if (entity instanceof PrisonerEntity) {
						((PrisonerEntity) entity).setAnimation("animation.prisoner_ram");
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 99, false, false));
					TheDeepVoidMod.queueServerWork(15, () -> {
						if (entity instanceof PrisonerEntity _datEntSetL)
							_datEntSetL.getEntityData().set(PrisonerEntity.DATA_ram, true);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25, 3, false, false));
						if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().moveTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), 1);
						}
					});
					TheDeepVoidMod.queueServerWork(40, () -> {
						if (entity instanceof PrisonerEntity _datEntSetL)
							_datEntSetL.getEntityData().set(PrisonerEntity.DATA_ram, false);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 99, false, false));
						{
							final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
									if ((entityiterator instanceof LivingEntity _entUseItem55 ? _entUseItem55.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
										if (entityiterator instanceof Player _player)
											_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem57 ? _entUseItem57.getUseItem() : ItemStack.EMPTY).getItem(), 10);
										{
											ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem59 ? _entUseItem59.getUseItem() : ItemStack.EMPTY);
											if (_ist.hurt(10, RandomSource.create(), null)) {
												_ist.shrink(1);
												_ist.setDamageValue(0);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1, false);
											}
										}
									} else {
										entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 10);
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1, false, false));
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 0, false, false));
									}
								}
							}
						}
					});
				}
			}
		}
		if ((entity instanceof PrisonerEntity _datEntI ? _datEntI.getEntityData().get(PrisonerEntity.DATA_attackChance) : 0) > 0) {
			if (entity instanceof PrisonerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PrisonerEntity.DATA_attackChance, (int) ((entity instanceof PrisonerEntity _datEntI ? _datEntI.getEntityData().get(PrisonerEntity.DATA_attackChance) : 0) - 1));
		}
		if ((entity instanceof PrisonerEntity _datEntL71 && _datEntL71.getEntityData().get(PrisonerEntity.DATA_ram)) == true) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity && !(entityiterator == entity)) {
						if ((entityiterator instanceof LivingEntity _entUseItem77 ? _entUseItem77.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
							if (entityiterator instanceof Player _player)
								_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem79 ? _entUseItem79.getUseItem() : ItemStack.EMPTY).getItem(), 10);
							{
								ItemStack _ist = (entityiterator instanceof LivingEntity _entUseItem81 ? _entUseItem81.getUseItem() : ItemStack.EMPTY);
								if (_ist.hurt(8, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.block")), SoundSource.PLAYERS, 1, 1, false);
								}
							}
						} else {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity), 8);
							if (!(entityiterator instanceof LivingEntity _livEnt86 && _livEnt86.hasEffect(TheDeepVoidModMobEffects.BROKEN_ARMOR.get()))) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.BROKEN_ARMOR.get(), 140, 0, false, false));
							}
						}
					}
				}
			}
		}
	}
}
