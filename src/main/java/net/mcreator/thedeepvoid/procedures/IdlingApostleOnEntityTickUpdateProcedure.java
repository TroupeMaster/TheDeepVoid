package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.IdlingApostleEntity;

import java.util.List;
import java.util.Comparator;

public class IdlingApostleOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3(0, 0, 0));
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 150, 150, 150), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(150 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(TheDeepVoidModMobEffects.WEAVER_CURSE.get(), 5, 0, false, false));
					}
				}
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 50, 50, 50), e -> true).isEmpty()) {
			if ((entity instanceof IdlingApostleEntity _datEntL6 && _datEntL6.getEntityData().get(IdlingApostleEntity.DATA_talking)) == false) {
				if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) >= 940) {
					if (entity instanceof IdlingApostleEntity _datEntSetI)
						_datEntSetI.getEntityData().set(IdlingApostleEntity.DATA_psalmCount, 0);
				} else {
					if (entity instanceof IdlingApostleEntity _datEntSetI)
						_datEntSetI.getEntityData().set(IdlingApostleEntity.DATA_psalmCount, (int) ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) + 1));
				}
				if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 20) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm1").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 70) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm2").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 120) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm3").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 170) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm4").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 220) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm5").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 270) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm6").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 320) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm7").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 370) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm8").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 420) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm9").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 470) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm10").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 520) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm11").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 570) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm12").getString())), false);
							}
						}
					}
				} else if ((entity instanceof IdlingApostleEntity _datEntI ? _datEntI.getEntityData().get(IdlingApostleEntity.DATA_psalmCount) : 0) == 620) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (entityiterator instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal((Component.translatable("text.the_deep_void.apostle.psalm13").getString())), false);
							}
						}
					}
				}
			}
		}
	}
}
