package net.mcreator.thedeepvoid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thedeepvoid.init.TheDeepVoidModItems;
import net.mcreator.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.mcreator.thedeepvoid.TheDeepVoidMod;

import java.util.UUID;

public class RottenTongueLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 5
				&& !(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.hasModifier((new AttributeModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4"), "rottenTongue_low", ((double) DeepVoidConfigConfiguration.ROTTENTONGUEDAMAGE.get()), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).addTransientModifier(
						(new AttributeModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4"), "rottenTongue_low", ((double) DeepVoidConfigConfiguration.ROTTENTONGUEDAMAGE.get()), AttributeModifier.Operation.ADDITION)));
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 5
				&& ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4"));
		}
		TheDeepVoidMod.queueServerWork(20, () -> {
			if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ROT_TONGUE.get())
					&& ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4")) != null) {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4"));
			}
		});
	}
}
