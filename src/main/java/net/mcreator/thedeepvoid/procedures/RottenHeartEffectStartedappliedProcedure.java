package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.init.TheDeepVoidModMobEffects;

import java.util.UUID;

public class RottenHeartEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
				.hasModifier((new AttributeModifier(UUID.fromString("92b763d9-4eaf-423a-b147-1f7ea4ce6867"), "rottenHeartSpeed",
						(0.2 * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ROTTEN_HEART.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ROTTEN_HEART.get()).getAmplifier() : 0)),
						AttributeModifier.Operation.MULTIPLY_TOTAL)))))
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.addTransientModifier((new AttributeModifier(UUID.fromString("92b763d9-4eaf-423a-b147-1f7ea4ce6867"), "rottenHeartSpeed",
							(0.2 * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheDeepVoidModMobEffects.ROTTEN_HEART.get()) ? _livEnt.getEffect(TheDeepVoidModMobEffects.ROTTEN_HEART.get()).getAmplifier() : 0)),
							AttributeModifier.Operation.MULTIPLY_TOTAL)));
	}
}
