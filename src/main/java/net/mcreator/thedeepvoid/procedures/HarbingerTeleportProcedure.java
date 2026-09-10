package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.init.TheDeepVoidModEntities;
import net.mcreator.thedeepvoid.entity.HarbingerOfCataclysmEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class HarbingerTeleportProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
			_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_attacking, true);
		if (entity instanceof HarbingerOfCataclysmEntity) {
			((HarbingerOfCataclysmEntity) entity).setAnimation("empty");
		}
		if (entity instanceof HarbingerOfCataclysmEntity) {
			((HarbingerOfCataclysmEntity) entity).setAnimation("animation.harbinger_teleport");
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 99, false, false));
		for (int index0 = 0; index0 < 3; index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = TheDeepVoidModEntities.HARBINGER_CLONE.get().spawn(_level,
						BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -1, 1), entity.getY(), entity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		TheDeepVoidMod.queueServerWork(15, () -> {
			if (entity instanceof HarbingerOfCataclysmEntity _datEntSetL)
				_datEntSetL.getEntityData().set(HarbingerOfCataclysmEntity.DATA_teleport, true);
		});
	}
}
