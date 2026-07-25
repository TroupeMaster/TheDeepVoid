package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import java.util.UUID;

public class AdaptedEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).hasModifier((new AttributeModifier(UUID.fromString("1391819b-b9bf-4411-962d-6467ffc0d952"), "adaptedAttack",
					((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ADAPTED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ADAPTED.get()).getAmplifier() : 0) / 2), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
						.addTransientModifier((new AttributeModifier(UUID.fromString("1391819b-b9bf-4411-962d-6467ffc0d952"), "adaptedAttack",
								((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ADAPTED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ADAPTED.get()).getAmplifier() : 0) / 2),
								AttributeModifier.Operation.ADDITION)));
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).hasModifier((new AttributeModifier(UUID.fromString("04216f37-84d0-49cb-8a00-a6449067cbe4"), "adaptedAttackSpeed",
					((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ADAPTED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ADAPTED.get()).getAmplifier() : 0) / 10), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("04216f37-84d0-49cb-8a00-a6449067cbe4"), "adaptedAttackSpeed",
								((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ADAPTED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ADAPTED.get()).getAmplifier() : 0) / 10),
								AttributeModifier.Operation.ADDITION)));
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("3ba7ef6a-16bb-4071-8921-925675742209"), "adaptedSpeed",
							((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ADAPTED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ADAPTED.get()).getAmplifier() : 0) / 5),
							AttributeModifier.Operation.MULTIPLY_TOTAL)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("3ba7ef6a-16bb-4071-8921-925675742209"), "adaptedSpeed",
								((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ADAPTED.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ADAPTED.get()).getAmplifier() : 0) / 5),
								AttributeModifier.Operation.MULTIPLY_TOTAL)));
		}
	}
}
