package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class AdaptedEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("1391819b-b9bf-4411-962d-6467ffc0d952"));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED).removeModifier(UUID.fromString("04216f37-84d0-49cb-8a00-a6449067cbe4"));
		((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removeModifier(UUID.fromString("3ba7ef6a-16bb-4071-8921-925675742209"));
	}
}
