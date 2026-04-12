package net.mcreator.thedeepvoid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class BloodyChainsawRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			itemstack.getOrCreateTag().putBoolean("used", true);
			entity.getPersistentData().putDouble("sentientChainsawUse", 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_loop")), SoundSource.PLAYERS, (float) 0.6, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_loop")), SoundSource.PLAYERS, (float) 0.6, 1, false);
				}
			}
			if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(
					new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY() + 1.4),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
					1.5, 1.5, 1.5), e -> true).isEmpty()) {
				if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(
						new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.getY() + 1.4),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
						1.5, 1.5, 1.5), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.getY() + 1.4),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
						.findFirst().orElse(null)) == entity)) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(
									null, BlockPos
											.containing(
													((Entity) world.getEntitiesOfClass(LivingEntity.class,
															AABB.ofSize(new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.getY() + 1.4),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
																	1.5, 1.5, 1.5),
															e -> true).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																}
															}.compareDistOf(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.getY() + 1.4),
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getZ())))
															.findFirst().orElse(null)).getX(),
													((Entity) world.getEntitiesOfClass(LivingEntity.class,
															AABB.ofSize(new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.getY() + 1.4),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
																	1.5, 1.5, 1.5),
															e -> true).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																}
															}.compareDistOf(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.getY() + 1.4),
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getZ())))
															.findFirst().orElse(null)).getY(),
													((Entity) world.getEntitiesOfClass(LivingEntity.class,
															AABB.ofSize(new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.getY() + 1.4),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
																	1.5, 1.5, 1.5),
															e -> true).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																}
															}.compareDistOf(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.getY() + 1.4),
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getZ())))
															.findFirst().orElse(null)).getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_impact")), SoundSource.PLAYERS, (float) 0.6, 1);
						} else {
							_level.playLocalSound(
									(((Entity) world
											.getEntitiesOfClass(LivingEntity.class,
													AABB.ofSize(
															new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.getY() + 1.4),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
															1.5, 1.5, 1.5),
													e -> true)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
															entity))
													.getBlockPos().getX()), (entity.getY() + 1.4),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ())))
											.findFirst().orElse(null)).getX()),
									(((Entity) world
											.getEntitiesOfClass(LivingEntity.class,
													AABB.ofSize(
															new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.getY() + 1.4),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
															1.5, 1.5, 1.5),
													e -> true)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf((entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
															entity))
													.getBlockPos().getX()), (entity.getY() + 1.4),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ())))
											.findFirst().orElse(null)).getY()),
									(((Entity) world
											.getEntitiesOfClass(LivingEntity.class,
													AABB.ofSize(
															new Vec3(
																	(entity.level()
																			.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
																					entity))
																			.getBlockPos().getX()),
																	(entity.getY() + 1.4),
																	(entity.level().clip(
																			new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())),
															1.5, 1.5, 1.5),
													e -> true)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf(
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.getY() + 1.4),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ())))
											.findFirst().orElse(null)).getZ()),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_deep_void:sentient_chainsaw_impact")), SoundSource.PLAYERS, (float) 0.6, 1, false);
						}
					}
				}
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.getY() + 1.4),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1.5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity && !(entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) && !(entityiterator == entity)
								&& !(entityiterator == (entity.getVehicle()))) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK), entity),
									(float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * 1.5));
						}
					}
				}
			}
		} else if ((entity instanceof LivingEntity _entUseItem47 ? _entUseItem47.getUseItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (entity instanceof LivingEntity _entity)
				_entity.stopUsingItem();
		}
	}
}
