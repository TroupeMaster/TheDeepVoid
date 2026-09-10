package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

public class RoamerAttackPlayerConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt
					? _livEnt.getHealth()
					: -1) <= ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2.5
					|| ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 6
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MobEffects.WEAKNESS)
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.DIG_SLOWDOWN)
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(TheDeepVoidModMobEffects.BROKEN_ARMOR.get())
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MobEffects.BLINDNESS)
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(TheDeepVoidModMobEffects.ROOT_BLIND.get())
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.DARKNESS)
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MobEffects.CONFUSION)
					|| (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(MobEffects.HUNGER)) {
				return true;
			}
		}
		return false;
	}
}
