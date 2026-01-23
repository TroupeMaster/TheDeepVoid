package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.thedeepvoid.entity.BlackFlyEntity;

public class BlackFlyOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && Math.random() < 0.05) {
			entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.1),
					(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() - entity.getY()) * 0.1), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.1)));
		}
		if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())).canOcclude() && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.1, (entity.getDeltaMovement().z())));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.getPersistentData().getBoolean("noAgro") == true) {
			entity.getPersistentData().putBoolean("noAgro", false);
			if (entity instanceof BlackFlyEntity) {
				((BlackFlyEntity) entity).setAnimation("empty");
			}
		}
		if (!world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.2, entity.getZ())).canOcclude() && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null
				&& entity.getPersistentData().getBoolean("stopAnimation") == false) {
			entity.getPersistentData().putBoolean("stopAnimation", true);
			if (entity instanceof BlackFlyEntity) {
				((BlackFlyEntity) entity).setAnimation("empty");
			}
		}
		if (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.2, entity.getZ())).canOcclude() && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			if (entity instanceof BlackFlyEntity) {
				((BlackFlyEntity) entity).setAnimation("animation.voidFly_land");
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 99, false, false));
			if (entity.getPersistentData().getBoolean("noAgro") == false) {
				entity.getPersistentData().putBoolean("noAgro", true);
			}
			if (entity.getPersistentData().getBoolean("stopAnimation") == true) {
				entity.getPersistentData().putBoolean("stopAnimation", false);
			}
		}
	}
}
