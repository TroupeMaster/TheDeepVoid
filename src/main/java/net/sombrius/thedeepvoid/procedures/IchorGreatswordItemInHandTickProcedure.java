package net.sombrius.thedeepvoid.procedures;

import net.sombrius.thedeepvoid.init.TheDeepVoidModItems;
import net.sombrius.thedeepvoid.configuration.DeepVoidConfigConfiguration;
import net.sombrius.thedeepvoid.TheDeepVoidMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class IchorGreatswordItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("block") == 1) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("b1079042-106a-4a8f-b930-8ee4313ca118"), "ichorgreatsword_speed", (-0.3), AttributeModifier.Operation.MULTIPLY_TOTAL)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("b1079042-106a-4a8f-b930-8ee4313ca118"), "ichorgreatsword_speed", (-0.3), AttributeModifier.Operation.MULTIPLY_TOTAL)));
		} else if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getModifier(UUID.fromString("b1079042-106a-4a8f-b930-8ee4313ca118")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).removeModifier(UUID.fromString("b1079042-106a-4a8f-b930-8ee4313ca118"));
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 6
				&& !(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("1d2f1ec2-2ca0-4064-8370-f6792a310918")) != null)) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.hasModifier((new AttributeModifier(UUID.fromString("1d2f1ec2-2ca0-4064-8370-f6792a310918"), "ichorgreatsword_low", ((double) DeepVoidConfigConfiguration.ROTTENTONGUEDAMAGE.get() * 1.2), AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).addTransientModifier(
						(new AttributeModifier(UUID.fromString("1d2f1ec2-2ca0-4064-8370-f6792a310918"), "ichorgreatsword_low", ((double) DeepVoidConfigConfiguration.ROTTENTONGUEDAMAGE.get() * 1.2), AttributeModifier.Operation.ADDITION)));
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 6
				&& ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("1d2f1ec2-2ca0-4064-8370-f6792a310918")) != null) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("1d2f1ec2-2ca0-4064-8370-f6792a310918"));
		}
		if (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("2b844396-8d38-433c-a9a3-15b2ff4183f4")) != null) {
			TheDeepVoidMod.queueServerWork(20, () -> {
				if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TheDeepVoidModItems.ICHOR_GREATSWORD.get())
						&& ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getModifier(UUID.fromString("1d2f1ec2-2ca0-4064-8370-f6792a310918")) != null) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).removeModifier(UUID.fromString("1d2f1ec2-2ca0-4064-8370-f6792a310918"));
				}
			});
		}
	}
}
