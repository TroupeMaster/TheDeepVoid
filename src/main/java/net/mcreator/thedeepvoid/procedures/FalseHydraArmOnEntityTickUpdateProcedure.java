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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.entity.FalseHydraArmEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class FalseHydraArmOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 13, 13, 13), e -> true).isEmpty()) {
			if ((entity instanceof FalseHydraArmEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraArmEntity.DATA_attackChance) : 0) >= 40
					&& (entity instanceof FalseHydraArmEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraArmEntity.DATA_despawn) : 0) < 200 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
				if (entity instanceof FalseHydraArmEntity _datEntSetI)
					_datEntSetI.getEntityData().set(FalseHydraArmEntity.DATA_attackChance, 0);
				if (entity instanceof FalseHydraArmEntity) {
					((FalseHydraArmEntity) entity).setAnimation("animation.arm_attack");
				}
				TheDeepVoidMod.queueServerWork(15, () -> {
					if ((entity instanceof FalseHydraArmEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraArmEntity.DATA_despawn) : 0) < 200 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
						{
							final Vec3 _center = new Vec3(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos()
											.getX()),
									(entity.getY() + 0.6), (entity.level()
											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.8)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("the_deep_void:boss")))) {
									if ((entityiterator instanceof LivingEntity _entUseItem15 ? _entUseItem15.getUseItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
										if (entityiterator instanceof Player _player)
											_player.getCooldowns().addCooldown((entityiterator instanceof LivingEntity _entUseItem17 ? _entUseItem17.getUseItem() : ItemStack.EMPTY).getItem(), 100);
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
														SoundSource.PLAYERS, 1, 1);
											} else {
												_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, 1,
														1, false);
											}
										}
										if (entityiterator instanceof LivingEntity _entity)
											_entity.stopUsingItem();
									} else {
										entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_ATTACK), entity),
												(float) ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue());
										if ((entity instanceof FalseHydraArmEntity _datEntL27 && _datEntL27.getEntityData().get(FalseHydraArmEntity.DATA_knockback)) == true
												&& !world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
											if (entity instanceof FalseHydraArmEntity _datEntSetI)
												_datEntSetI.getEntityData().set(FalseHydraArmEntity.DATA_despawn, 200);
											entityiterator.setDeltaMovement(new Vec3(((((Entity) world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() - entityiterator.getX()) * 0.5),
													((((Entity) world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY() - entityiterator.getY()) * 0.5),
													((((Entity) world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ() - entityiterator.getZ()) * 0.5)));
										}
									}
								}
							}
						}
					}
				});
			} else {
				if (entity instanceof FalseHydraArmEntity _datEntSetI)
					_datEntSetI.getEntityData().set(FalseHydraArmEntity.DATA_attackChance, (int) ((entity instanceof FalseHydraArmEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraArmEntity.DATA_attackChance) : 0) + 1));
			}
		}
		if ((entity instanceof FalseHydraArmEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraArmEntity.DATA_despawn) : 0) >= 200) {
			if ((entity instanceof FalseHydraArmEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraArmEntity.DATA_despawn) : 0) == 200) {
				if (entity instanceof FalseHydraArmEntity) {
					((FalseHydraArmEntity) entity).setAnimation("animation.arm_despawn");
				}
			}
			if ((entity instanceof FalseHydraArmEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraArmEntity.DATA_despawn) : 0) == 230) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if (entity instanceof FalseHydraArmEntity _datEntSetI)
			_datEntSetI.getEntityData().set(FalseHydraArmEntity.DATA_despawn, (int) ((entity instanceof FalseHydraArmEntity _datEntI ? _datEntI.getEntityData().get(FalseHydraArmEntity.DATA_despawn) : 0) + 1));
	}
}
