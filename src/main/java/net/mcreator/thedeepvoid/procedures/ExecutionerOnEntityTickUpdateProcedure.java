package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.thedeepvoid.entity.ExecutionerEntity;

public class ExecutionerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		double rnd = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0
				&& (entity instanceof ExecutionerEntity _datEntL3 && _datEntL3.getEntityData().get(ExecutionerEntity.DATA_attacking)) == false
				&& (entity instanceof ExecutionerEntity _datEntL4 && _datEntL4.getEntityData().get(ExecutionerEntity.DATA_stunned)) == false) {
			if (entity instanceof ExecutionerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ExecutionerEntity.DATA_attackChance, (int) ((entity instanceof ExecutionerEntity _datEntI ? _datEntI.getEntityData().get(ExecutionerEntity.DATA_attackChance) : 0) + 1));
		}
		if ((entity instanceof ExecutionerEntity _datEntI
				? _datEntI.getEntityData().get(ExecutionerEntity.DATA_attackChance)
				: 0) >= ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 ? 40 : 60)) {
			if (entity instanceof ExecutionerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ExecutionerEntity.DATA_attackChance, 0);
			rnd = Mth.nextInt(RandomSource.create(), 1, 3);
			if (rnd == 1) {
				ExecutionerSlashProcedure.execute(world, x, z, entity);
			} else if (rnd == 2) {
				ExecutionerBashProcedure.execute(world, x, z, entity);
			} else if (rnd == 3) {
				ExecutionerGrabProcedure.execute(world, entity);
			}
		}
		if ((entity instanceof ExecutionerEntity _datEntI ? _datEntI.getEntityData().get(ExecutionerEntity.DATA_stunCooldown) : 0) > 0) {
			if (entity instanceof ExecutionerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ExecutionerEntity.DATA_stunCooldown, (int) ((entity instanceof ExecutionerEntity _datEntI ? _datEntI.getEntityData().get(ExecutionerEntity.DATA_stunCooldown) : 0) - 1));
		}
		if ((entity instanceof ExecutionerEntity _datEntL15 && _datEntL15.getEntityData().get(ExecutionerEntity.DATA_stunned)) == true) {
			if ((entity instanceof ExecutionerEntity _datEntI ? _datEntI.getEntityData().get(ExecutionerEntity.DATA_stunCooldown) : 0) <= 220) {
				if (entity instanceof ExecutionerEntity _datEntSetL)
					_datEntSetL.getEntityData().set(ExecutionerEntity.DATA_stunned, false);
				if (entity instanceof ExecutionerEntity) {
					((ExecutionerEntity) entity).setAnimation("empty");
				}
				if (entity instanceof ExecutionerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ExecutionerEntity.DATA_attackChance,
							(int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2 ? 35 : 55));
			} else {
				if (entity instanceof ExecutionerEntity) {
					((ExecutionerEntity) entity).setAnimation("animation.executioner_stunned");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 99));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 5, 99));
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 0, false, false));
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && (entity instanceof ExecutionerEntity _datEntL30 && _datEntL30.getEntityData().get(ExecutionerEntity.DATA_asleep)) == true) {
			if (entity instanceof ExecutionerEntity _datEntSetL)
				_datEntSetL.getEntityData().set(ExecutionerEntity.DATA_asleep, false);
			if (entity instanceof ExecutionerEntity) {
				((ExecutionerEntity) entity).setAnimation("empty");
			}
		}
	}
}
