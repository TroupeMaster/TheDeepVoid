package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.thedeepvoid.init.TheDeepVoidModParticleTypes;
import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.entity.ApostleBossEntity;

import java.util.List;
import java.util.Comparator;

public class ChainedOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double T = 0;
		double Zo = 0;
		double Yo = 0;
		double Xo = 0;
		double Za = 0;
		double Ya = 0;
		double Xa = 0;
		if (entity instanceof Player) {
			if (!world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.CHAINED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.CHAINED.get()).getAmplifier() : 0) == 0) {
					entity.setDeltaMovement(new Vec3(0, 0, 0));
				} else {
					entity.setDeltaMovement(new Vec3(((((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() - entity.getX()) * 0.1),
							((((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY() - entity.getY()) * 0.1),
							((((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ() - entity.getZ()) * 0.1)));
				}
				Xo = entity.getX() - ((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX();
				Yo = entity.getY() - (((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY() + 1.8);
				Zo = entity.getZ() - ((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ();
				if (Math.floor(entity.getX()) <= Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX())) {
					if (Math.floor(entity.getX()) == Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX())) {
						if (Math.floor(entity.getY()) == Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY())) {
							if (Math.floor(entity.getZ()) <= Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ())) {
								Za = Math.floor(entity.getZ()) + 0.2;
								while (Za <= Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ())) {
									T = (Za - entity.getZ()) / Zo;
									Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
									Xa = entity.getX() + Xo * T;
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
									Za = 0.2 + Za;
								}
							} else {
								Za = Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()) + 0.2;
								while (Za <= Math.floor(entity.getZ())) {
									T = (Za - entity.getZ()) / Zo;
									Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
									Xa = entity.getX() + Xo * T;
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
									Za = 0.2 + Za;
								}
							}
						} else {
							if (Math.floor(entity.getY()) <= Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY())) {
								Ya = Math.floor(entity.getY()) + 0.2;
								while (Ya <= Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY())) {
									T = (Ya - entity.getY()) / Yo;
									Xa = entity.getX() + Xo * T;
									Za = entity.getZ() + Zo * T;
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
									Ya = 0.2 + Ya;
								}
							} else {
								Ya = Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()) + 0.2;
								while (Ya <= Math.floor(entity.getY())) {
									T = (Ya - entity.getY()) / Yo;
									Xa = entity.getX() + Xo * T;
									Za = entity.getZ() + Zo * T;
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
									Ya = 0.2 + Ya;
								}
							}
						}
					} else {
						Xa = Math.floor(entity.getX()) + 0.2;
						while (Xa <= Math.floor(((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX())) {
							T = (Xa - entity.getX()) / Xo;
							Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
							Za = entity.getZ() + Zo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
							Xa = 0.2 + Xa;
						}
					}
				} else {
					Xa = ((Entity) world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX() + 0.2;
					while (Xa < Math.floor(entity.getX())) {
						T = (Xa - entity.getX()) / Xo;
						Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
						Za = entity.getZ() + Zo * T;
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
						Xa = 0.2 + Xa;
					}
				}
			} else if (!world.getEntitiesOfClass(ApostleBossEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(TheDeepVoidModMobEffects.CHAINED.get());
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CHAIN_GAUNTLET.get()
								|| (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ADAPTIVE_CLAW.get()) && !(entityiterator == entity)) {
							entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.1), ((entityiterator.getY() - entity.getY()) * 0.1), ((entityiterator.getZ() - entity.getZ()) * 0.1)));
							Xo = entity.getX() - entityiterator.getX();
							Yo = (entity.getY() + entity.getEyeHeight() / 1.4) - (entityiterator.getY() + 1.4);
							Zo = entity.getZ() - entityiterator.getZ();
							if (Math.floor(entity.getX()) <= Math.floor(entityiterator.getX())) {
								if (Math.floor(entity.getX()) == Math.floor(entityiterator.getX())) {
									if (Math.floor(entity.getY()) == Math.floor(entityiterator.getY())) {
										if (Math.floor(entity.getZ()) <= Math.floor(entityiterator.getZ())) {
											Za = Math.floor(entity.getZ()) + 0.2;
											while (Za <= Math.floor(entityiterator.getZ())) {
												T = (Za - entity.getZ()) / Zo;
												Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
												Xa = entity.getX() + Xo * T;
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
												Za = 0.2 + Za;
											}
										} else {
											Za = Math.floor(entityiterator.getZ()) + 0.2;
											while (Za <= Math.floor(entity.getZ())) {
												T = (Za - entity.getZ()) / Zo;
												Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
												Xa = entity.getX() + Xo * T;
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
												Za = 0.2 + Za;
											}
										}
									} else {
										if (Math.floor(entity.getY()) <= Math.floor(entityiterator.getY())) {
											Ya = Math.floor(entity.getY()) + 0.2;
											while (Ya <= Math.floor(entityiterator.getY())) {
												T = (Ya - entity.getY()) / Yo;
												Xa = entity.getX() + Xo * T;
												Za = entity.getZ() + Zo * T;
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
												Ya = 0.2 + Ya;
											}
										} else {
											Ya = Math.floor(entityiterator.getY()) + 0.2;
											while (Ya <= Math.floor(entity.getY())) {
												T = (Ya - entity.getY()) / Yo;
												Xa = entity.getX() + Xo * T;
												Za = entity.getZ() + Zo * T;
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
												Ya = 0.2 + Ya;
											}
										}
									}
								} else {
									Xa = Math.floor(entity.getX()) + 0.2;
									while (Xa <= Math.floor(entityiterator.getX())) {
										T = (Xa - entity.getX()) / Xo;
										Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
										Za = entity.getZ() + Zo * T;
										if (world instanceof ServerLevel _level)
											_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
										Xa = 0.2 + Xa;
									}
								}
							} else {
								Xa = entityiterator.getX() + 0.2;
								while (Xa < Math.floor(entity.getX())) {
									T = (Xa - entity.getX()) / Xo;
									Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
									Za = entity.getZ() + Zo * T;
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
									Xa = 0.2 + Xa;
								}
							}
						}
					}
				}
			}
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.CHAIN_GAUNTLET.get()
							|| (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ADAPTIVE_CLAW.get()) && !(entityiterator == entity)) {
						entity.setDeltaMovement(new Vec3(((entityiterator.getX() - entity.getX()) * 0.1), ((entityiterator.getY() - entity.getY()) * 0.1), ((entityiterator.getZ() - entity.getZ()) * 0.1)));
						Xo = entity.getX() - entityiterator.getX();
						Yo = (entity.getY() + entity.getEyeHeight() / 1.4) - (entityiterator.getY() + 1.4);
						Zo = entity.getZ() - entityiterator.getZ();
						if (Math.floor(entity.getX()) <= Math.floor(entityiterator.getX())) {
							if (Math.floor(entity.getX()) == Math.floor(entityiterator.getX())) {
								if (Math.floor(entity.getY()) == Math.floor(entityiterator.getY())) {
									if (Math.floor(entity.getZ()) <= Math.floor(entityiterator.getZ())) {
										Za = Math.floor(entity.getZ()) + 0.2;
										while (Za <= Math.floor(entityiterator.getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
											Za = 0.2 + Za;
										}
									} else {
										Za = Math.floor(entityiterator.getZ()) + 0.2;
										while (Za <= Math.floor(entity.getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
											Za = 0.2 + Za;
										}
									}
								} else {
									if (Math.floor(entity.getY()) <= Math.floor(entityiterator.getY())) {
										Ya = Math.floor(entity.getY()) + 0.2;
										while (Ya <= Math.floor(entityiterator.getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
											Ya = 0.2 + Ya;
										}
									} else {
										Ya = Math.floor(entityiterator.getY()) + 0.2;
										while (Ya <= Math.floor(entity.getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
											Ya = 0.2 + Ya;
										}
									}
								}
							} else {
								Xa = Math.floor(entity.getX()) + 0.2;
								while (Xa <= Math.floor(entityiterator.getX())) {
									T = (Xa - entity.getX()) / Xo;
									Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
									Za = entity.getZ() + Zo * T;
									if (world instanceof ServerLevel _level)
										_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
									Xa = 0.2 + Xa;
								}
							}
						} else {
							Xa = entityiterator.getX() + 0.2;
							while (Xa < Math.floor(entity.getX())) {
								T = (Xa - entity.getX()) / Xo;
								Ya = entity.getBbHeight() / 1.4 + entity.getY() + Yo * T;
								Za = entity.getZ() + Zo * T;
								if (world instanceof ServerLevel _level)
									_level.sendParticles((SimpleParticleType) (TheDeepVoidModParticleTypes.CHAIN.get()), Xa, Ya, Za, 1, 0, 0, 0, 0);
								Xa = 0.2 + Xa;
							}
						}
					}
				}
			}
		}
	}
}
