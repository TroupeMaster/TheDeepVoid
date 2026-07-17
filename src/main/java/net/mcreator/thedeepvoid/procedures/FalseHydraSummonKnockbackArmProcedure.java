package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.FalseHydraEntity;
import net.mcreator.thedeepvoid.entity.FalseHydraArmEntity;

import java.util.List;
import java.util.Comparator;

public class FalseHydraSummonKnockbackArmProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty() && !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty())) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player && !(!world.getEntitiesOfClass(FalseHydraEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 32, 32, 32), e -> true).isEmpty())
							&& !(!world.getEntitiesOfClass(FalseHydraArmEntity.class, AABB.ofSize(new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())), 9, 9, 9), e -> true).isEmpty())) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entityinstance = TheDeepVoidModEntities.FALSE_HYDRA_ARM.get().create(_serverLevel, null, null, BlockPos.containing(
									entityiterator.level()
											.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale((-2))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE,
													entityiterator))
											.getBlockPos().getX(),
									entityiterator.getY(),
									entityiterator.level().clip(
											new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale((-2))), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entityiterator))
											.getBlockPos().getZ()),
									MobSpawnType.MOB_SUMMONED, false, false);
							if (entityinstance != null) {
								entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
								if (entityinstance instanceof FalseHydraArmEntity _datEntSetL)
									_datEntSetL.getEntityData().set(FalseHydraArmEntity.DATA_knockback, true);
								_serverLevel.addFreshEntity(entityinstance);
							}
						}
					}
				}
			}
		}
	}
}
