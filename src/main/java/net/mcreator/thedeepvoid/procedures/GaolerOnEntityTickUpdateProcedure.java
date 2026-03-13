package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.PlayerCageEntity;
import net.mcreator.thedeepvoid.entity.GaolerEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.List;
import java.util.Comparator;

public class GaolerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) && (entity instanceof GaolerEntity _datEntI ? _datEntI.getEntityData().get(GaolerEntity.DATA_attackChance) : 0) <= 0) {
					if (!(!world.getEntitiesOfClass(PlayerCageEntity.class, AABB.ofSize(new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())), 4, 4, 4), e -> true).isEmpty())) {
						if (entity instanceof GaolerEntity _datEntSetI)
							_datEntSetI.getEntityData().set(GaolerEntity.DATA_attackChance, 200);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 99, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 99, false, false));
						if (entity instanceof GaolerEntity) {
							((GaolerEntity) entity).setAnimation("animation.gaoler_attackCage");
						}
						TheDeepVoidMod.queueServerWork(30, () -> {
							if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
											if (world instanceof ServerLevel _level) {
												Entity entityToSpawn = TheDeepVoidModEntities.PLAYER_CAGE.get().spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
												if (entityToSpawn != null) {
													entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
												}
											}
										}
									}
								}
							}
						});
					}
				} else if ((entity instanceof GaolerEntity _datEntI ? _datEntI.getEntityData().get(GaolerEntity.DATA_attackChance) : 0) > 0) {
					if (entity instanceof GaolerEntity _datEntSetI)
						_datEntSetI.getEntityData().set(GaolerEntity.DATA_attackChance, (int) ((entity instanceof GaolerEntity _datEntI ? _datEntI.getEntityData().get(GaolerEntity.DATA_attackChance) : 0) - 1));
				}
			}
		}
	}
}
