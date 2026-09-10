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
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("parry") > 0) {
			itemstack.getOrCreateTag().putDouble("parry", (itemstack.getOrCreateTag().getDouble("parry") - 1));
		}
		if (itemstack.getOrCreateTag().getDouble("block") == 1) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("fc5078cc-59fd-4dba-8fa6-4617649b3c1d"), "rottenTongue_speed", (-0.4), AttributeModifier.Operation.MULTIPLY_TOTAL)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("fc5078cc-59fd-4dba-8fa6-4617649b3c1d"), "rottenTongue_speed", (-0.4), AttributeModifier.Operation.MULTIPLY_TOTAL)));
		} else if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getModifier(UUID.fromString("fc5078cc-59fd-4dba-8fa6-4617649b3c1d")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removeModifier(UUID.fromString("fc5078cc-59fd-4dba-8fa6-4617649b3c1d"));
		}
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
		if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4")) != null) {
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ROT_TONGUE.get())
						&& ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4")) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4"));
				}
			});
		}
	}
}
