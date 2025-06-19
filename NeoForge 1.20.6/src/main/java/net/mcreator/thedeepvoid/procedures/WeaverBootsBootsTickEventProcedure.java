package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.network.TheDeepVoidModVariables;

public class WeaverBootsBootsTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
			if (entity.getData(TheDeepVoidModVariables.PLAYER_VARIABLES).noGravity == true) {
				if (entity.isNoGravity() == false) {
					entity.setNoGravity(true);
				}
			} else {
				if (entity.isNoGravity() == true) {
					entity.setNoGravity(false);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 180, 0, false, false));
				}
			}
		}
	}
}
