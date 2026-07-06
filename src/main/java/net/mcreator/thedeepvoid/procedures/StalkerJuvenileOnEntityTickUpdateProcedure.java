package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;
import net.mcreator.thedeepvoid.entity.StalkerJuvenileEntity;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

public class StalkerJuvenileOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if ((entity instanceof StalkerJuvenileEntity _datEntI ? _datEntI.getEntityData().get(StalkerJuvenileEntity.DATA_jump) : 0) <= 0
					&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 10) {
				if (entity instanceof StalkerJuvenileEntity _datEntSetI)
					_datEntSetI.getEntityData().set(StalkerJuvenileEntity.DATA_jump, 200);
				if (entity instanceof StalkerJuvenileEntity) {
					((StalkerJuvenileEntity) entity).setAnimation("empty");
				}
				if (entity instanceof StalkerJuvenileEntity) {
					((StalkerJuvenileEntity) entity).setAnimation("animation.stalkerJuvenile_pounce");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 99, false, false));
				TheDeepVoidMod.queueServerWork(25, () -> {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.25), 0.35,
								(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.25)));
					}
				});
			} else {
				if (entity instanceof StalkerJuvenileEntity _datEntSetI)
					_datEntSetI.getEntityData().set(StalkerJuvenileEntity.DATA_jump, (int) ((entity instanceof StalkerJuvenileEntity _datEntI ? _datEntI.getEntityData().get(StalkerJuvenileEntity.DATA_jump) : 0) - 1));
			}
			if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt
					? _livEnt.getHealth()
					: -1) <= ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 3.5
					&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 10) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5, 0, false, false));
				if ((entity instanceof StalkerJuvenileEntity _datEntI ? _datEntI.getEntityData().get(StalkerJuvenileEntity.DATA_jump) : 0) > 0) {
					if (entity instanceof StalkerJuvenileEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StalkerJuvenileEntity.DATA_jump, (int) ((entity instanceof StalkerJuvenileEntity _datEntI ? _datEntI.getEntityData().get(StalkerJuvenileEntity.DATA_jump) : 0) - 1));
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 10 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 1) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 0.1));
		}
		if (entity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(TheDeepVoidModMobEffects.DECOMPOSITION.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TheDeepVoidModMobEffects.DECOMPOSITION.get());
		}
	}
}
